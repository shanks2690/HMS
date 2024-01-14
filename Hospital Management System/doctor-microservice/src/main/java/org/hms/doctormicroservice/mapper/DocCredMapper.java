package org.hms.doctormicroservice.mapper;

import org.hms.doctormicroservice.dto.CredentialsDto;
import org.hms.doctormicroservice.dto.DocCredDto;
import org.hms.doctormicroservice.dto.DocDepDto;
import org.hms.doctormicroservice.entity.DoctorInfo;


public class DocCredMapper {

    public static DocCredDto credToDocCred (CredentialsDto cred)
    {
        DocCredDto dto= new DocCredDto();
        dto.setEmail(dto.getEmail());
        dto.setFirstname(dto.getFirstname());
        dto.setLastname(dto.getLastname());

        return dto;
    }


    public static DocDepDto infoMap (DoctorInfo doc)
    {
        DocDepDto dto= new DocDepDto();
        System.out.println(doc.getDocId());
       dto.setDocId(doc.getDocId());
        dto.setEmail(doc.getEmail());
        dto.setFirstname(doc.getFirstName());
        dto.setLastname(doc.getLastName());
        dto.setAvailability(doc.getAvailability());
        dto.setDepartment(doc.getDepartment());
        dto.setQualification(doc.getQualification());
        dto.setRegNo(doc.getRegNo());
        dto.setBranchCode(doc.getBranchCode());
        System.out.println(dto);

        return dto;
    }
}
