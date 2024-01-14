package org.hms.patientmicroservice.mapper;


import org.hms.patientmicroservice.entity.PatientHealthRec;
import org.hms.patientmicroservice.dto.PatientHealthRecDto;

public class HealthMapper {

    public static PatientHealthRec dtoToHealth (PatientHealthRecDto dto, int patId)
    {
        PatientHealthRec phr = new PatientHealthRec();
        phr.setHealthDesc(dto.getHealthDesc());
        phr.setDocId(dto.getDocId());
        phr.setDateOfEntry(dto.getDateOfEntry());
        phr.setPatientId(patId);
        phr.setEmail(dto.getEmail());
        return phr;
    }
}
