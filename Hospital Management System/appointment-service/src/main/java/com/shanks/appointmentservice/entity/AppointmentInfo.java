package com.shanks.appointmentservice.entity;

import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointment_info")
public class AppointmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;
    private String pEmail;
	private int patientId;
    private String patFname;
    private String patLname;
    private int docId;
    private String docFname;
    private String docLname;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private BranchCode branchCode;

    private Long slotId;
	private Boolean approval;
    private Boolean emergency;
    private LocalDate date;
    private Boolean Status;
}
