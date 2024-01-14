package org.hms.billing.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.billing.entity.enums.BranchCode;
import org.hms.billing.entity.enums.Department;

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
    private Department department;
    private BranchCode branchCode;
    private LocalDate prescriptionDate;
    private String diagnosis;
    private List<String> complaints;
    private List<String> findings;
    private List<Medications> medications;
    private PhysicalDetails physicalDetails;
    private List<String> advice;
    private Boolean emergency;
    private Boolean admission;
}
