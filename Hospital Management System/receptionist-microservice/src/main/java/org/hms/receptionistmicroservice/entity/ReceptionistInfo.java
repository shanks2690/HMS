package org.hms.receptionistmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hms.receptionistmicroservice.entity.enums.BranchCode;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receptionist_tb")
public class ReceptionistInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int receptionistId;
    private BranchCode branchCode;
    private String firstName;
    private String lastName;
    private String email;
}

