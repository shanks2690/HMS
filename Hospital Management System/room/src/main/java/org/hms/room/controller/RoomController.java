package org.hms.room.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.hms.room.dto.RoomAllocDto;
import org.hms.room.dto.RoomAvailabilityDto;
import org.hms.room.entity.RoomAllocation;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.enums.RoomCode;
import org.hms.room.service.RoomAllocationServiceI;
import org.hms.room.service.RoomTypeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomTypeServiceI roomTypeService;
    @Autowired
    RoomAllocationServiceI roomAllocationService;

    @GetMapping("all")
    public ResponseEntity<List<RoomType>> getAllRooms() {
        return roomTypeService.getAllRoomType();
    }

    @PostMapping("bytype")
//    @Operation(summary = "Get RoomsType by RoomCode")
    public ResponseEntity<List<RoomType>> getRoomsTypeByRoomCode(@RequestBody String code) {
        return roomTypeService.getAllRoomsTypeByRoomCode(RoomCode.valueOf(code));
    }


    @PostMapping("byid")
    public ResponseEntity<Optional<RoomType>> getRoomsTypeById(@RequestBody Integer roomId) {
        return roomTypeService.getRoomTypeByRoomId(roomId);
    }

    // get all Rooms in allocation table
    @GetMapping("allalloc")

    public ResponseEntity<?> getAllAllocations() {
        return roomAllocationService.getAllRoomAllocations();
    }


    // get  Room by Patient Id and Occupation true
    @PostMapping("/patroomhist")

    public RoomAllocation getPastAllocations(@RequestBody Integer patientId) {
        return roomAllocationService.getActiveRoomAllocationsByPatientId(patientId, false);
    }

    // for Receptionist & Admin
    @PostMapping("/avroombcode")

    public ResponseEntity<List<RoomAvailabilityDto>> getAllAvailableRoomsCountByBranchCode(@RequestBody String branchCode) {
        return roomTypeService.getAvailableRoomCountBYBranchCode(branchCode);
    }

    // for Receptionist & Admin
    @GetMapping("/allavroom")
    public ResponseEntity<List<RoomAvailabilityDto>> getAllRoomsInAllBranch() {
        return roomTypeService.getAvailableAllRoomInAllBranches();
    }

    // for Receptionist to book the room
    @PostMapping("/book")

    public ResponseEntity<?> bookRoom(@RequestBody RoomAllocDto roomAllocDto) {
        return roomAllocationService.addRoomAllocation(roomAllocDto);
    }

    @GetMapping("form")
    public ResponseEntity<?> getBookingForm() {
        return ResponseEntity.ok(new RoomAllocDto());
    }

    // for Billing module to update status of Room Allocation
    @PutMapping("/endroombooking")

    public Boolean endRoomOccupancy(@Parameter(description = "Update Room Allocation Status", required = true) @RequestBody Integer patientId) {
        return roomAllocationService.endOccupancy(patientId);
    }

    // add room Type
    @PostMapping("/addroomtype")

    public ResponseEntity<?> addRoomType(@Parameter(description = "Allot Room", required = true) @RequestBody RoomType roomType) {
        return roomTypeService.addRoomType(roomType);
    }

    // update room Type inventory
    @PutMapping("/uproominv")

    public ResponseEntity<?> updateRoomType(@Parameter(description = "Update Room Type", required = true) @RequestBody RoomType roomType) {
        return roomTypeService.updateRoomTypeInventory(roomType);
    }

    @DeleteMapping("/delroomtype")

    public ResponseEntity<?> deleteRoomType(@Parameter(description = "Delete Room Type", required = true) @RequestBody String id) {
        return roomTypeService.deleteRoomTypeInventory(Integer.parseInt(id));
    }

    // get  Room by Patient Id and Occupation true
    @PostMapping("/patroomact")

    public RoomAllocation getActiveAllocations(@RequestBody Integer patientId) {
        return roomAllocationService.getActiveRoomAllocationsByPatientId(patientId, true);
    }
}
