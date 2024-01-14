package org.hms.billing.entity.enums;

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


    String depCode;

    Department(String depCode){this.depCode=depCode;}
}
