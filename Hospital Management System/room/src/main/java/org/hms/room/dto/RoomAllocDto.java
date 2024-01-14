package org.hms.room.dto;

import lombok.*;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RoomAllocDto {

    private int roomTypeId;

    private int patientId;

    private int receptionistId;

    private LocalDate startDate;

    private RoomCode roomCode;

    private BranchCode branchCode;

}
