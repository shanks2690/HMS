package org.hms.billing.service;

import org.hms.billing.dto.BillDto;
import org.hms.billing.dto.PrescriptionDto;
import org.hms.billing.entity.Bills;
import org.hms.billing.entity.DoctorCharges;
import org.hms.billing.entity.enums.BranchCode;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BillisServiceI {
    // Get all Bills
    public List<Bills> allBills();

    // Get all Bills By Bill id
    public Optional<Bills> getBillsById(int billId);

    // get all bill by branch code
    public List<Bills> getBillByBranchCode(String branchCode);

    // Get all Pending/Generated Bills
    public List<Bills> getBillsByStatus(boolean status);

    // Get all Bills by PatientId
    public List<Bills> getBillsByPatientId(int patientId);

    // Get all Generated/Pending Bills by PatientId
    public List<Bills> getBillsByPatientId(int patientId,boolean status);

    // add new Bill
    public void addBill(PrescriptionDto prescriptionDto);

    // receptionist will send BillDto to billing microservice to generate bill
    public Bills generateBill(BillDto billDto);
}
