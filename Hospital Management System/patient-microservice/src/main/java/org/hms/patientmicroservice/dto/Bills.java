package org.hms.patientmicroservice.dto;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;


import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bills {


    private int billId;

    private int patientId;

    private int ReceptionistId;

    private int appointmentId;

    private boolean isEmergency;


    private boolean isRoomAllocated;


    private Department department;


    private BranchCode branchCode;

    private double doctorCharges;

    private double medicineCharges;


    private double roomCharges;


    private double totalCharges;


    private LocalDate billingDate;

    private boolean billStatus;

}
