package com.shanks.appointmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocCredDto {
    private String firstname;
    private String lastname;
    private String email;

}
