package org.hms.billing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hms.billing.entity.enums.RoomCode;

@Entity
@Table(name = "bills_room_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomCharges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rcId;

    @Enumerated(EnumType.STRING)
    private RoomCode roomCode;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double price;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private double emergencyPrice;
}
