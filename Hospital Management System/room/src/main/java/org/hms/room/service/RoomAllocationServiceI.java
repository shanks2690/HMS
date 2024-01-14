package org.hms.room.service;

import org.hms.room.dto.RoomAllocDto;
import org.hms.room.entity.RoomAllocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomAllocationServiceI {

    public ResponseEntity<List<RoomAllocation>> getAllRoomAllocations();

    public ResponseEntity<RoomAllocDto> addRoomAllocation(RoomAllocDto roomAllocDto);

    Boolean endOccupancy(int patientId);

    RoomAllocation getActiveRoomAllocationsByPatientId(int patientId,boolean occupation);

}
