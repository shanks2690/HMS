package org.hms.prescriptionservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PhysicalDetails{

    private String height;
    private String weight;
    private String bp;
    private String pulse;
    private String bmi;
    }
