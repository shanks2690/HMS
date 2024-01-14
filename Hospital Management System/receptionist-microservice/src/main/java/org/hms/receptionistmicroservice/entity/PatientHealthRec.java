package org.hms.receptionistmicroservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health_rec")
public class PatientHealthRec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recId;
    private String email;
    private int patientId;
    private String healthDesc;
    private LocalDate dateOfEntry;
    private int docId;
}
