package org.hms.pharmacist.entity.emum;


public enum MedicineTypeCode {

    Tablets("Tablets"),

    Drops("Drops"),

    Injection("Injection"),

    Liquid("Liquid"),

    Capsules("Capsules"),

    Inhalers("Inhalers"),

    Injections("Injections"),

    Implants("Implants");


    String medType;

    MedicineTypeCode(String medType){this.medType=medType;}


}
