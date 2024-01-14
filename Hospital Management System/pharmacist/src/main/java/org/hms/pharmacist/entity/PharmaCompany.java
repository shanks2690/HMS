package org.hms.pharmacist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="phar_company_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmaCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pharCompanyId;

    @Column
    private String pharCompanyName;

    private String pharCompanyOrigin;

    private String pharId;

    private Boolean status;

}
