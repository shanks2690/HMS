package org.hms.billing.service;

import org.hms.billing.entity.DoctorCharges;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface DoctorChargesServiceI {
    // Get all Doctor Charges
    public List<DoctorCharges> allDoctorCharges();

    // Get all Doctor Charges by Code
    public DoctorCharges getDoctorChargesByDepCode(String depCode);

    // add new Doctor Charges
    public DoctorCharges addDoctorCharges(DoctorCharges doctorCharges);

    // update Doctor Charges
    public DoctorCharges updateDoctorCharges(DoctorCharges doctorCharges);

    // delete Doctor Charges
    public String deleteDoctorCharges(int dcId);

}
