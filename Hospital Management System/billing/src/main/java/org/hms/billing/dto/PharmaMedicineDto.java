package org.hms.billing.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hms.billing.entity.enums.MedicineTypeCode;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmaMedicineDto {

    private int pharMedId;

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
