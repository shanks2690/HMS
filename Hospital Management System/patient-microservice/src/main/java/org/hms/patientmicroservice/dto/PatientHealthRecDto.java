package org.hms.patientmicroservice.dto;


import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientHealthRecDto {
    private int patientId;
    private String email;
    private String healthDesc;
    private LocalDate dateOfEntry;
    private int docId;
}
