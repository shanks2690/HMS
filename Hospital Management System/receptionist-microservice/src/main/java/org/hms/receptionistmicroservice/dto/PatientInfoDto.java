package org.hms.receptionistmicroservice.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfoDto {

    private int patientId;
    private String email;
    private String contactNo;
    private String emContactNo;
    private String nok;
    private LocalDate dob;
    private String firstname;
    private String lastname;

}

