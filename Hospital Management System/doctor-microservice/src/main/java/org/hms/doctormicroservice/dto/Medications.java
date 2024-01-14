package org.hms.doctormicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medications
{
    private String name;
    private int dosage;
    private String frequency;
    private int duration;
}
