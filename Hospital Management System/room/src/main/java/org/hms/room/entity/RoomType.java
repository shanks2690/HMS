package org.hms.room.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;

@Entity
@Table(name="roomtype_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description ="Room Class")
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
