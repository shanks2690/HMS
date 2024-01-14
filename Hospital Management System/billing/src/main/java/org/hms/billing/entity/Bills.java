package org.hms.billing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hms.billing.entity.enums.BranchCode;
import org.hms.billing.entity.enums.Department;
import org.hms.billing.entity.enums.RoomCode;
import java.time.LocalDate;

@Entity
@Table(name = "bills_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @NotBlank(message = "Please enter Patient id")
    private int patientId;

    private int ReceptionistId;

    private int appointmentId;

    @Column(columnDefinition = "Boolean default 0")
    private boolean isEmergency;

    @Column(columnDefinition = "Boolean default 0")
    private boolean isRoomAllocated;

    // enum
    @Enumerated(EnumType.STRING)
    private Department department;

    // enum
    @Enumerated(EnumType.STRING)
    private RoomCode roomCode;

    // enum
    @Enumerated(EnumType.STRING)
    private BranchCode branchCode;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double doctorCharges;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double medicineCharges;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double roomCharges;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double totalCharges;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate billingDate;

    @Column(columnDefinition = "Boolean default 0")
    private boolean billStatus;

}
