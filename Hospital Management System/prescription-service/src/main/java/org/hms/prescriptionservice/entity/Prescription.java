package org.hms.prescriptionservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.prescriptionservice.entity.enums.BranchCode;
import org.hms.prescriptionservice.entity.enums.Department;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Document (collection = "prescription")
public class Prescription {

    @Id
    private int prescriptionId;
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




