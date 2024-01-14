package org.hms.adminservice.mapper;

import org.hms.CredToken;
import org.hms.adminservice.document.RegDoc;
import org.hms.adminservice.dto.CredentialsDto;


public class PatCredMapper {

    public static RegDoc tokenToCred(CredToken ctoken) {
    RegDoc patCred = new RegDoc();
    patCred.setEmail(ctoken.getEmail());
    patCred.setLastname(ctoken.getLastname());
    patCred.setFirstname(ctoken.getFirstname());
    patCred.setRole("Patient");
    return patCred;
    }




}
