package org.hms.pharmacist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hms.pharmacist.entity.emum.MedicineTypeCode;

import java.time.LocalDate;

@Entity
@Table(name="phar_medicine_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmaMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pharMedId;

    @Column
    private String pharMedName;

    @Enumerated(EnumType.STRING)
    private MedicineTypeCode pharMedType;

    private LocalDate pharMedMafDate;

    private LocalDate pharMedExpDate;

    private int pharMedQty;

    private double pharMedPrice;

    private int pharCompanyId;

    private int pharDistId;

    private LocalDate pharMedAdditionDate;

    private Boolean status;

}
