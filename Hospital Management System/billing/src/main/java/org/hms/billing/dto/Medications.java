package org.hms.billing.dto;

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