package org.hms.receptionistmicroservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialsDto {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
}
