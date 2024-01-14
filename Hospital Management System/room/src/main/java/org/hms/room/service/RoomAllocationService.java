package org.hms.room.service;

import org.hms.room.dto.RoomAllocDto;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.RoomAllocation;
import org.hms.room.exception.NoRecordsFound;
import org.hms.room.repository.RoomAllocationRepository;
import org.hms.room.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomAllocationService implements RoomAllocationServiceI {

    @Autowired
    private RoomAllocationRepository roomAllocationRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    // all the rooms Allocation Occupied / Vacant
    public ResponseEntity<List<RoomAllocation>> getAllRoomAllocations() {
        try {
            return new ResponseEntity<>(roomAllocationRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new NoRecordsFound("No record in database!");
        }
    }

    // all the room Allocation by Patient Id Occupied / Vacant
// all the room Allocation by Patient Id Occupied / Vacant
    public RoomAllocation getActiveRoomAllocationsByPatientId(int patientId, boolean occupation) {
        try {
            return roomAllocationRepository.findByPatientIdAndOccupation(patientId, occupation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // add room allocation

    public ResponseEntity<RoomAllocDto> addRoomAllocation(RoomAllocDto roomAllocDto) {

        try {

            RoomAllocation roomReq = new RoomAllocation();
            RoomType room = new RoomType(); // to set room id from RoomAllocDto
            room.setRoomId(roomAllocDto.getRoomTypeId());

            //set room id
            roomReq.setRoomId(room);
            // set patient id
            roomReq.setPatientId(roomAllocDto.getPatientId());
            // set receptionist id
            roomReq.setReceptionistId(roomAllocDto.getReceptionistId());
            // set start date
            roomReq.setStartDate(roomAllocDto.getStartDate());
            // room booking status
            roomReq.setOccupation(true);
            roomAllocationRepository.save(roomReq);

            return new ResponseEntity<>(roomAllocDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // end Occupancy on bill is paid
// end Occupancy on bill is paid
    public Boolean endOccupancy(int patientId) {
        try {
            roomAllocationRepository.updateOccupation(false, LocalDate.now(), patientId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
