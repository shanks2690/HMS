package org.hms.doctormicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.doctormicroservice.entity.enums.BranchCode;
import org.hms.doctormicroservice.entity.enums.Department;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doc_tb")
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int docId;
    private String email;
    private String regNo;
    private LocalDate dateOfReg;
    private Boolean availability;

    @Enumerated(EnumType.STRING)
    private BranchCode branchCode;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String Qualification;
    private LocalDate dateOfSpl;
    private String firstName;
    private String lastName;

}
