package org.hms.prescriptionservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AppointmentSlotDto {

    private String docFname;
    private String docLname;
    private int  docId;
    private LocalDate date;
    private LocalDateTime slotFrom;
    private LocalDateTime slotTo;
    private Boolean isAvaiable;
}
