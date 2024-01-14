package org.hms.adminservice.dto;

import lombok.*;

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
