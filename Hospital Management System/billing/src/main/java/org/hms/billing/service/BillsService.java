package org.hms.billing.service;

import org.hms.billing.dto.*;
import org.hms.billing.entity.Bills;
import org.hms.billing.entity.DoctorCharges;
import org.hms.billing.entity.RoomCharges;
import org.hms.billing.entity.enums.BranchCode;
import org.hms.billing.feigncalls.PharmaFeign;
import org.hms.billing.feigncalls.RoomFeign;
import org.hms.billing.repository.BillsRepository;
import org.hms.billing.repository.DoctorChargesRepository;
import org.hms.billing.repository.RoomChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class BillsService implements BillisServiceI {

    @Autowired
    BillsRepository repository;

    @Autowired
    DoctorChargesRepository docRepository;

    @Autowired
    RoomChargesRepository roomChargesRepository;

    @Autowired
    PharmaFeign pharmaFeign;

    @Autowired
    RoomFeign roomFeign;

    // Get all Bills
    public List<Bills> allBills() {

        try {
            return repository.findAll();

        } catch (Exception e) {
            // execption
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Get all Bills By Bill id
    public Optional<Bills> getBillsById(int billId) {

        try {
            return repository.findById(billId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // get all bill by branch code
    public List<Bills> getBillByBranchCode(String branchCode) {

        try {
            //convert BranchCode string to Enum Branch Code
            BranchCode branchCodeValue = BranchCode.valueOf(branchCode);

            return repository.findAllByBranchCode(branchCodeValue);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }


    // Get all Pending/Generated Bills
    public List<Bills> getBillsByStatus(boolean status) {
        try {
            return repository.findAllByBillStatus(status);

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Get all Bills by PatientId
    public List<Bills> getBillsByPatientId(int patientId) {
        try {
            return repository.findAllByPatientId(patientId);

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // Get all Generated/Pending Bills by PatientId
    public List<Bills> getBillsByPatientId(int patientId, boolean status) {
        try {
            return repository.findAllByPatientIdAndBillStatus(patientId, status);

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // Generate Bill
    public Bills generateBill(BillDto billDto) {

        try {

            Bills fetchBill = repository.findByAppointmentId(billDto.getAppointmentId());

            fetchBill.setBillStatus(true); // for ensuring bill is generated
            fetchBill.setBillingDate(LocalDate.now());
            fetchBill.setReceptionistId(billDto.getReceptionistId());

            if (fetchBill.isRoomAllocated()) {

                // get room by patientId
                RoomAllocation roomDto = roomFeign.getActiveAllocations(fetchBill.getPatientId());

                //Calculate No of days spent in the room and type of room based on room code
                // will fetch price of rooms based on if patient is emergency or not
                // check if start date is there

                if (roomDto != null) {
                    if (roomDto.getStartDate() != null) {

                        Period period = Period.between(roomDto.getStartDate(), LocalDate.now());
                        int days = period.getDays();

                        RoomCharges roomCharges = roomChargesRepository.findByRoomCode(roomDto.getRoomId().getRoomCode());
                        // Set the room code in Bill code
                        fetchBill.setRoomCode(roomDto.getRoomId().getRoomCode());
                        double roomChargesCalc = 0.00;
                        // this
                        if (fetchBill.isEmergency()) {
                            roomChargesCalc = ((days == 0 ? 1 : days) * roomCharges.getEmergencyPrice());
                            fetchBill.setRoomCharges(roomChargesCalc);

                            // if he is emergency patient he will be charged as per emergency charges
                            fetchBill.setTotalCharges(fetchBill.getTotalCharges() + roomChargesCalc);
                        } else {
                            roomChargesCalc = ((days == 0 ? 1 : days) * roomCharges.getPrice());
                            // for normal patient he will be charged as per normal charges
                            fetchBill.setTotalCharges(fetchBill.getTotalCharges() + roomChargesCalc);
                        }

                        // make feign call to Room service for ending room booking
                        roomFeign.endRoomOccupancy(fetchBill.getPatientId());
                    }
                }
            }
            //just save bill without calculation
            return repository.save(fetchBill);
        } catch (Exception e) {
            e.printStackTrace();
            return new Bills();
        }

    }


    // add Bill  with partial entries
    public void addBill(PrescriptionDto prescriptionDto) {

        try {
            // here we are fetching bill for given patient id
            Bills bills = new Bills();
            // repository.findByPatientId(prescriptionDto.getPatientId()).orElseThrow(RuntimeException::new);
            // no update in patent id
            bills.setPatientId(prescriptionDto.getPatientId());
            // appointment id
            bills.setAppointmentId(prescriptionDto.getAppointmentId() == 0 ? bills.getAppointmentId() : prescriptionDto.getAppointmentId());
            // is Emergency
            bills.setEmergency(prescriptionDto.getEmergency());
            // is RoomAllocated
            bills.setRoomAllocated(prescriptionDto.getAdmission());
            //departmentCode
            bills.setDepartment(prescriptionDto.getDepartment());
            // branch code
            bills.setBranchCode(prescriptionDto.getBranchCode());

            // calculation for doctor charges based on doctor department
            DoctorCharges doctorCharges = docRepository.findByDeptCode(prescriptionDto.getDepartment());
            // Set Doctor Charges
            double docCharges = prescriptionDto.getEmergency() ? doctorCharges.getEmergencyPrice() : doctorCharges.getPrice();
            bills.setDoctorCharges(docCharges);

            // Calculation for Medicine Charges
            List<Medications> medicationslist = prescriptionDto.getMedications();
            double totalMedCharges = 0.00;
            List<MedicineQtyDto> medicineQtyDtos = new ArrayList<>();
            // check list is not empty
            if (!medicationslist.isEmpty()) {
                String nameCollection = "";

                for (Medications n : medicationslist) {
                    nameCollection = nameCollection + n.getName() + ",";
                }
                List<PharmaMedicineDto> medicineDtoList = pharmaFeign.getMedicineByNameCollection(nameCollection);

                // now we got prices for all the medicines mentioned in prescription
                // Lets do the Medicine Amount calculation
                for (Medications n : medicationslist) {

                    // create new medicineQty dto
                    MedicineQtyDto qtyDto = new MedicineQtyDto();
                    // we need to have qty calculation
                    // we need to calculate price for each medication based on Dosage and Frequency
                    // and Price we will get from medicationDtoList
                    String nameofMedicine = n.getName();
                    int qty = n.getDosage() * (Objects.equals(n.getFrequency(), "BD") ? 2 : 1) * n.getDuration();

                    Optional<PharmaMedicineDto> med = medicineDtoList.stream()
                            .filter(medicineDto -> nameofMedicine.equals(medicineDto.getPharMedName()))
                            .findFirst();
                    //getting price of each medicine
                    double price = med.map(PharmaMedicineDto::getPharMedPrice).orElse(0.0);
                    int medId = med.map(PharmaMedicineDto::getPharMedId).orElse(0);
                    totalMedCharges = (totalMedCharges + (price * qty));

                    // need to update Pharma Stock Table for given medicine id
                    qtyDto.setMedId(medId);
                    qtyDto.setQtyConsumed(qty);
                    // adding consumed qty of medicine against medId
                    medicineQtyDtos.add(qtyDto);
                }
                // save medicine charges in record
                bills.setMedicineCharges(totalMedCharges);
            }
            // total of all services except room service
            bills.setTotalCharges(docCharges + totalMedCharges);

            // set Billing date
            bills.setBillingDate(LocalDate.now());

            /*set Bill Generation status
            here "false" represents bill has not been generated by receptionist
            its just auto entries done by prescription feign call*/
            bills.setBillStatus(false);

            repository.save(bills);

            // Now we have to update pharma stock table
            pharmaFeign.updateMedQty(medicineQtyDtos);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
