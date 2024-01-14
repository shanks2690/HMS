package org.hms.prescriptionservice.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Department {

    CARDIOLOGY("CARDIO"),
    GYNAECOLOGY("GNY"),
    PAEDIATRICS("PED"),
    NEUROLOGY("NEURO"),
    DERMATOLOGY("DERMA"),
    DENTAL("DNT"),
    ENT("ENT"),
    PHYSIOTHERAPY("PHYSIO"),
    GASTROENTEROLOGY("GASTRO"),
    MEDICINE("MED");

    String code;

}
