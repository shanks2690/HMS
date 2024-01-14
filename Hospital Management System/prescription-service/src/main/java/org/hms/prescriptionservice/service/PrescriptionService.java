package org.hms.prescriptionservice.service;

import org.hms.prescriptionservice.dto.PrescriptionDto;
import org.hms.prescriptionservice.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> forPatient(int patientId);
    List<Prescription> byDoc(int docId);

    Prescription addPrsc(PrescriptionDto prsc);
    Prescription viewPrsc(int prscId);

}
