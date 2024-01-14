package org.hms.doctormicroservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hms.doctormicroservice.entity.enums.BranchCode;
import org.hms.doctormicroservice.entity.enums.Department;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AppointmentSlotDto {

    private int docId;
    private Department department;
    private BranchCode branchCode;
    private LocalDate date;
    private Time  slotFrom;
    private Time slotTo;
    private Boolean isAvaiable;
    private String docFname;
    private String docLname;
}
