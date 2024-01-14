package org.hms.billing.service;

import org.hms.billing.entity.DoctorCharges;
import org.hms.billing.entity.enums.Department;
import org.hms.billing.repository.DoctorChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class DoctorChargesService implements DoctorChargesServiceI {

    @Autowired
    DoctorChargesRepository repository;

    // Get all Room Charges
    public List<DoctorCharges> allDoctorCharges() {

        try {
            return repository.findAll();

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // Get all Room Charges by Code
    public DoctorCharges getDoctorChargesByDepCode(String depCode) {
        try {
            return repository.findByDeptCode(Department.valueOf(depCode));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // add new RoomCharges
    public DoctorCharges addDoctorCharges(DoctorCharges doctorCharges) {
        try {
            return repository.save(doctorCharges);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // update RoomCharges
    public DoctorCharges updateDoctorCharges(DoctorCharges doctorCharges) {
        try {
            DoctorCharges fetchCharges = repository.findById(doctorCharges.getDcId()).orElseThrow(RuntimeException::new);

            doctorCharges.setDcId(fetchCharges.getDcId());
            doctorCharges.setDeptCode(doctorCharges.getDeptCode() == null ? fetchCharges.getDeptCode() : doctorCharges.getDeptCode());
            doctorCharges.setPrice(doctorCharges.getPrice() == 0.0 ? fetchCharges.getPrice() : doctorCharges.getPrice());
            doctorCharges.setEmergencyPrice(doctorCharges.getEmergencyPrice() == 0.0 ? fetchCharges.getEmergencyPrice() : doctorCharges.getEmergencyPrice());
            return repository.save(doctorCharges);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // delete RoomCharges
    public String deleteDoctorCharges(int dcId) {
        try {
            repository.deleteById(dcId);
            return "Deleted";
        } catch (Exception e) {
            return "Error deleting";

        }
    }

}
