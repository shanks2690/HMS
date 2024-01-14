package org.hms.patientmicroservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientHealthRecDto {
    private int patientId;
    private String email;
    private String healthDesc;
    private LocalDate dateOfEntry;
    private int docId;
}
