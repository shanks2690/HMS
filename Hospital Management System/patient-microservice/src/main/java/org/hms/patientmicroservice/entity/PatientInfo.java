package org.hms.patientmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_info")
public class PatientInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int patientId;
    private String email;
    private String contactNo;
    private String emContactNo;
    private String nok;
    private LocalDate dob;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String pincode;
}

