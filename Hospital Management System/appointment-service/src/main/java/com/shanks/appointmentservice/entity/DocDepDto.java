package com.shanks.appointmentservice.entity;

import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

