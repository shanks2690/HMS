package org.hms.pharmacist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="phar_distributor_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmaDistributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pharDistId;

    @Column
    private String pharDistFirstName;

    private String pharDistLastName;

    private int pharDistAge;

    private String pharDistEmail;

    private String pharDistCity;

    private String pharDistMobile;

    private String pharDistPincode;

    private String pharDistAddress;

    private LocalDate pharDistRegistrationDate;

    private int pharId;

    private Boolean status;
}
