package org.hms.pharmacist.mapper;


import org.hms.pharmacist.dto.CredentialsDto;
import org.hms.pharmacist.entity.Pharma;
import org.hms.pharmacist.repository.PharmaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PharCredMapper {
@Autowired
PharmaRepository pharmaRepository;

     public static Pharma credToPhar (CredentialsDto cred)
    {
        Pharma phar = new Pharma();

        phar.setPharEmail(cred.getEmail());
        phar.setPharFirstName(cred.getFirstname());
        phar.setPharFirstName(cred.getLastname());
        return phar;
    }
}
