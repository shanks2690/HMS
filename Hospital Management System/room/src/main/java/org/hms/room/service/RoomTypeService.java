package org.hms.room.service;

import org.hms.room.dto.RoomAllocDto;
import org.hms.room.dto.RoomAvailabilityDto;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.RoomAllocation;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;
import org.hms.room.repository.RoomAllocationRepository;
import org.hms.room.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoomTypeService implements RoomTypeServiceI {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomAllocationRepository roomAllocationRepository;

    // find all room types
    public ResponseEntity<List<RoomType>> getAllRoomType() {
        try {
            return new ResponseEntity<>(roomTypeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // search by room Id
    public ResponseEntity<Optional<RoomType>> getRoomTypeByRoomId(int id) {
        try {
            return new ResponseEntity<>(roomTypeRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // search by room code
    public ResponseEntity<List<RoomType>> getAllRoomsTypeByRoomCode(RoomCode roomCode) {
        try {
            return new ResponseEntity<>(roomTypeRepository.findAllByRoomCode(roomCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // add room Inventory
    public ResponseEntity<RoomType> addRoomType(RoomType roomType) {
        try {
            return new ResponseEntity<>(roomTypeRepository.save(roomType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // update room Inventory
    public ResponseEntity<RoomType> updateRoomTypeInventory(RoomType roomType) {
        try {

            RoomType fetchRoom = roomTypeRepository.findById(roomType.getRoomId()).orElseThrow(RuntimeException::new);

            // only inventory can be updated
            roomType.setRoomInventory(roomType.getRoomInventory() == 0 ? fetchRoom.getRoomInventory() : roomType.getRoomInventory());

            return new ResponseEntity<>(roomTypeRepository.save(roomType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete RoomType
    public ResponseEntity<String> deleteRoomTypeInventory(int roomId) {
        try {
            roomTypeRepository.deleteById(roomId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Deleting", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Available room count as per Hospital Branch and Type of Room
    public ResponseEntity<RoomAllocDto> getAvailableRoomCount(BranchCode branchCode, RoomCode roomCode) {

        RoomAllocDto dto = new RoomAllocDto();
        try {
            // here we are getting room Id from RoomType Table
            RoomType roomType = roomTypeRepository.findByRoomCodeAndBranchCode(roomCode, branchCode);
            // here we have to check no. of rooms occupied in Allocation Table and return the value minus inventory value for availability of rooms
            int count = Math.max((roomType.getRoomInventory() - roomAllocationRepository.findByRoomIdAndOccupation(roomType, true).size()), 0);
            // adding values to dto
            //dto.setCount(count);
            dto.setRoomTypeId(roomType.getRoomId());
            return new ResponseEntity<>(dto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Transactional
    // Get count of Available rooms of all types as per Hospital Branch
    public ResponseEntity<List<RoomAvailabilityDto>> getAvailableRoomCountBYBranchCode(String branchCode) {

        try {
            List<RoomAvailabilityDto> listDto = new ArrayList<>();
            List<Object[]> list = roomTypeRepository.SPRoomAvailabilityByBranchCode(branchCode);
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {

                    //convert RoomCode string to Enum Room Code
                    RoomCode roomCodeValue = RoomCode.valueOf((String) list.get(i)[1]);
                    //convert BranchCode string to Enum Branch Code
                    BranchCode branchCodeValue = BranchCode.valueOf((String) list.get(i)[2]);
                    RoomAvailabilityDto dto = new RoomAvailabilityDto((Integer) list.get(i)[0], roomCodeValue, branchCodeValue, (Long) list.get(i)[3]);
                    // here we will add value to Room Availability DTO
                    listDto.add(dto);
                }
            }
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // Get count of Available rooms of all types as per Hospital Branch
    public ResponseEntity<List<RoomAvailabilityDto>> getAvailableAllRoomInAllBranches() {

        try {
            List<RoomAvailabilityDto> listDto = new ArrayList<>();
            List<Object[]> list = roomTypeRepository.GetAllRoomInAllBranches();
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {

                    //convert RoomCode string to Enum Room Code
                    RoomCode roomCodeValue = RoomCode.valueOf((String) list.get(i)[1]);
                    //convert BranchCode string to Enum Branch Code
                    BranchCode branchCodeValue = BranchCode.valueOf((String) list.get(i)[2]);
                    RoomAvailabilityDto dto = new RoomAvailabilityDto((Integer) list.get(i)[0], roomCodeValue, branchCodeValue, (Long) list.get(i)[3]);
                    // here we will add value to Room Availability DTO
                    listDto.add(dto);
                }
            }

            return new ResponseEntity<>(listDto, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}















