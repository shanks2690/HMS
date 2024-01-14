package org.hms.receptionistmicroservice.mapper;

import org.hms.CredToken;
import org.hms.receptionistmicroservice.dto.CredentialsDto;
import org.hms.receptionistmicroservice.dto.PatientInfoDto;

public class PatCredMapper {

    public static CredentialsDto PatToCred(PatientInfoDto patientInfoDto) {
    CredentialsDto patCred = new CredentialsDto();
    patCred.setEmail(patientInfoDto.getEmail());
    patCred.setLastname(patientInfoDto.getLastname());
    patCred.setFirstname(patientInfoDto.getFirstname());
    patCred.setRole("Patient");
    return patCred;
    }

    public static CredToken dtoToToken(CredentialsDto cdto) {
        CredToken ctoken = new CredToken();
        System.out.println(cdto);
        ctoken.setEmail(cdto.getEmail());
        ctoken.setRole(cdto.getRole());
        ctoken.setLastname(cdto.getLastname());
        ctoken.setFirstname(cdto.getFirstname());
        System.out.println(ctoken);
        return ctoken;
    }
}
