package org.hms.pharmacist.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="phar_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description ="Pharma Class")
public class Pharma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pharId;

    @Column
    @Schema(description = "This is String Value for Phar email", example = "abc@xyz.com")
    private String pharEmail;

    private String pharFirstName;

    private String pharLastName;

    private Boolean status;
}
