package com.shanks.appointmentservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "appointment_slot")
public class AppointmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long slotId;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private BranchCode branchCode;
    private String docFname;
    private String docLname;
    private int docId;
    private LocalDate date;
    private Time slotFrom;
    private Time slotTo;
    private Boolean isAvaiable;
}
