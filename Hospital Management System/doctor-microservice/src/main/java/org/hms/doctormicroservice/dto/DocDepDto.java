package org.hms.doctormicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.doctormicroservice.entity.enums.BranchCode;
import org.hms.doctormicroservice.entity.enums.Department;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDepDto {
    private int docId;
    private String firstname;
    private String lastname;
    private String email;
    private Department department;
    private String regNo;
    private String Qualification;
    private BranchCode branchCode;
    private Boolean availability;
}
