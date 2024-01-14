package org.hms.prescriptionservice.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.prescriptionservice.entity.Medications;
import org.hms.prescriptionservice.entity.PhysicalDetails;
import org.hms.prescriptionservice.entity.enums.BranchCode;
import org.hms.prescriptionservice.entity.enums.Department;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor


public class PrescriptionDto {

    private int appointmentId;
    private int patientId;
    private int docId;
    private String docName;
    private String patientName;
    private String docQual;
    private String docRegdNo;
    private BranchCode branchCode;
    private LocalDate prescriptionDate;
    private String diagnosis;
    private List<String> complaints;
    private List<String> findings;
    private List<Medications> medications;
    private PhysicalDetails physicalDetails;
    private List<String> advice;
    private Boolean admission;
    private Boolean emergency;
    private Department department;
}


