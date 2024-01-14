package com.shanks.appointmentservice.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

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
