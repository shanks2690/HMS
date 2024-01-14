package org.hms.room.service;

import org.hms.room.dto.RoomAllocDto;
import org.hms.room.dto.RoomAvailabilityDto;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RoomTypeServiceI {
    // find all room types
    public ResponseEntity<List<RoomType>> getAllRoomType();

    // search by room Id
    public ResponseEntity<Optional<RoomType>> getRoomTypeByRoomId(int id);

    // search by room code
    public ResponseEntity<List<RoomType>> getAllRoomsTypeByRoomCode(RoomCode roomCode);

    // add room Inventory
    public ResponseEntity<RoomType> addRoomType(RoomType roomType);

    // update room Inventory
    public ResponseEntity<RoomType> updateRoomTypeInventory(RoomType roomType);

    // delete RoomType
    public ResponseEntity<String> deleteRoomTypeInventory(int roomId);

    // Get Available room count as per Hospital Branch and Type of Room
    public ResponseEntity<RoomAllocDto> getAvailableRoomCount(BranchCode branchCode, RoomCode roomCode);

    // Get Availability of Rooms based on branch code
    public ResponseEntity<List<RoomAvailabilityDto>> getAvailableRoomCountBYBranchCode(String branchCode);

    public ResponseEntity<List<RoomAvailabilityDto>> getAvailableAllRoomInAllBranches();
}
