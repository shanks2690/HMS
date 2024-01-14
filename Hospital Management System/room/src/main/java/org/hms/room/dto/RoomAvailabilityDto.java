package org.hms.room.dto;

import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.*;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;


@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedStoredProcedureQuery(
        name = "SPRoomAvailabilityByBranchCode",
        procedureName = "SPRoomAvailabilityByBranchCode",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_branch_code", type = String.class),
        },
        resultClasses = RoomAvailabilityDto.class
)
public class RoomAvailabilityDto {

    private int roomId;

    private RoomCode roomCode;

    private BranchCode branchCode;

    private long availableRooms;


    public RoomAvailabilityDto(int roomId, RoomCode roomCode, BranchCode branchCode, long availableRooms) {
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.branchCode = branchCode;
        this.availableRooms = availableRooms;
    }
}
