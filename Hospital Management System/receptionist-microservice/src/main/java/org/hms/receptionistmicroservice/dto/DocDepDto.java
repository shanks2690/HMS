package org.hms.receptionistmicroservice.dto;


import lombok.*;
import org.hms.receptionistmicroservice.entity.enums.BranchCode;
import org.hms.receptionistmicroservice.entity.enums.Department;


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
