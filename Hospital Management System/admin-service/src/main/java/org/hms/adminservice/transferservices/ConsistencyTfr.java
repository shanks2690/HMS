package org.hms.adminservice.transferservices;

import lombok.AllArgsConstructor;
import org.hms.adminservice.dto.CredentialsDto;
import org.hms.adminservice.feigncalls.DocFeign;
import org.hms.adminservice.feigncalls.PatFeign;
import org.hms.adminservice.feigncalls.PharFeign;
import org.hms.adminservice.feigncalls.RecFeign;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsistencyTfr {
    DocFeign docFeign;
    PatFeign patFeign;
    RecFeign recFeign;
    PharFeign pharFeign;

    public Boolean saveUser(CredentialsDto userCred) {
        switch (userCred.getRole())
        {
            case "DOCTOR"-> docFeign.addDoc(userCred);
            case "PATIENT"-> patFeign.addPat(userCred);
            case "RECEPTIONIST"-> recFeign.addRec(userCred);
            case "PHARMACIST"-> {System.out.println("saving pharmacist");pharFeign.addPhar(userCred);}
        }
    return true;
    }
    public Boolean delUser(CredentialsDto userCred) {

        System.out.println("deleting"+ userCred +"from dept storage");
        switch (userCred.getRole())
        {
            case "DOCTOR"-> docFeign.delDoc(userCred.getEmail());
            case "PATIENT"-> patFeign.delPat(userCred.getEmail());
            case "RECEPTIONIST"->recFeign.delRec(userCred.getEmail());
            case "PHARMACIST"->pharFeign.delPhar(userCred.getEmail());
        }
        return true;
    }

}
