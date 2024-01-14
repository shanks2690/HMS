package org.hms.patientmicroservice.mapper;


import org.hms.patientmicroservice.dto.CredentialsDto;
import org.hms.patientmicroservice.entity.PatientInfo;
import org.hms.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatCredMapper {
@Autowired
    PatientRepository patientRepository;

     public static PatientInfo credToPat (CredentialsDto cred)
    {
        PatientInfo info = new PatientInfo();

        info.setEmail(cred.getEmail());
        info.setFirstName(cred.getFirstname());
        info.setLastName(cred.getLastname());
        return info;
    }
}
