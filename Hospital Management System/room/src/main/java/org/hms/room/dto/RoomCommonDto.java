package org.hms.room.dto;

import lombok.*;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomCommonDto {

    RoomCode roomCode;

    int roomId;

    int patientId;

    boolean occupation;

    BranchCode branchCode;

    RoomType roomType;

}
