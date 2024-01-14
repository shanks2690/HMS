package org.hms.patientmicroservice.dto;


import lombok.*;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class AppointmentSlotDto {

    private String docFname;
    private String docLname;
    private Department department;
    private BranchCode branchCode;
    private int  docId;
    private LocalDate date;
    private Time slotFrom;
    private Time slotTo;
    private Boolean isAvaiable;
}
