package org.hms.billing.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hms.billing.entity.enums.BranchCode;
import org.hms.billing.entity.enums.RoomCode;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Enumerated(EnumType.STRING)
    private RoomCode roomCode;

    @NotBlank(message = "Enter room inventory")
    private int roomInventory;

    @Enumerated(EnumType.STRING)
    private BranchCode branchCode;

}

