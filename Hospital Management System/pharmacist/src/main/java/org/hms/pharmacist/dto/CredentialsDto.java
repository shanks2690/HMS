package org.hms.pharmacist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDto {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
}
