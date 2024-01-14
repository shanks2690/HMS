package org.hms.patientmicroservice.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@ToString
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
