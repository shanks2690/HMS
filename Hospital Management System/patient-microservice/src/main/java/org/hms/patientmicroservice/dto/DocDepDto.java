package org.hms.patientmicroservice.dto;


import lombok.*;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocDepDto {
    private String firstname;
    private String lastname;
    private String email;
    private Department department;
    private String regNo;
    private String Qualification;
    private BranchCode branchCode;
    private Boolean availability;
}
