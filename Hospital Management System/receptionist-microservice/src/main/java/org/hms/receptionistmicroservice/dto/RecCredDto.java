package org.hms.receptionistmicroservice.dto;

import lombok.*;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecCredDto {
    private String firstname;
    private String lastname;
    private String email;
}
