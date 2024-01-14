package org.hms.adminservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationCredentials {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;

}
