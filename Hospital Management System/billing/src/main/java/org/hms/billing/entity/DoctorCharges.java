package org.hms.billing.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hms.billing.entity.enums.Department;


@Entity
@Table(name = "bills_dept_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorCharges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dcId;

    @Enumerated(EnumType.STRING)
    private Department deptCode;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double price;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double emergencyPrice;

}
