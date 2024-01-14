package org.hms.patientmicroservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDto {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
}
