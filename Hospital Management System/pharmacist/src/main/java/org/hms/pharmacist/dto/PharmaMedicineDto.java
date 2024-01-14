package org.hms.pharmacist.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hms.pharmacist.entity.emum.MedicineTypeCode;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmaMedicineDto {

    private int pharMedId;

    private String pharMedName;
    private int pharMedQty;

}
