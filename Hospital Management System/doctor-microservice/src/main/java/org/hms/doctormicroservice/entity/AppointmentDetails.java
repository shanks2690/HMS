package org.hms.doctormicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Data
//@Table(name="appointment_record_tb")
public class AppointmentDetails {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appointmentId;
    private int docId;
    private String patientName;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;
    private LocalDate date;
    private Boolean  approval;
}
