package org.hms.patientmicroservice.mapper;


import org.hms.patientmicroservice.dto.CredentialsDto;
import org.hms.patientmicroservice.dto.PatCredDto;

public class DocCredMaker {

    public static PatCredDto credToDocCred (CredentialsDto cred)
    {
        PatCredDto dto= new PatCredDto();
        dto.setEmail(dto.getEmail());
        dto.setFirstname(dto.getFirstname());
        dto.setLastname(dto.getLastname());
        return dto;
    }
}
