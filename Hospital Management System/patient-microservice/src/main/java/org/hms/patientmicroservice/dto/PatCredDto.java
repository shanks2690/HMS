package org.hms.patientmicroservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatCredDto {
    private String firstname;
    private String lastname;
    private String email;

}
