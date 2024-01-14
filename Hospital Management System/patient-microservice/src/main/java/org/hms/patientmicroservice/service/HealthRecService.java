package org.hms.patientmicroservice.service;


import org.hms.patientmicroservice.dto.PatCredDto;
import org.hms.patientmicroservice.entity.PatientHealthRec;
import org.hms.patientmicroservice.entity.PatientInfo;

import java.util.List;

public interface HealthRecService {
    List<PatientHealthRec>  getHealthRec(String email);
    PatientHealthRec addHealthRec(PatientHealthRec rec);
    PatientInfo updateMyInfo(PatientInfo uPat, String userName);

    Boolean addNewPat(PatCredDto patCredDto);

    public String delPat(String email);
}
