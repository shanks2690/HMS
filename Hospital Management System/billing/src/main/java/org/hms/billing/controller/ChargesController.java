package org.hms.billing.controller;

import org.hms.billing.entity.DoctorCharges;
import org.hms.billing.entity.RoomCharges;
import org.hms.billing.service.DoctorChargesServiceI;
import org.hms.billing.service.RoomChargesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charges")
public class ChargesController {

    @Autowired
    private DoctorChargesServiceI doctorChargesServiceI;

    @Autowired
    private RoomChargesServiceI roomChargesServiceI;

    // get doctor charges
    @GetMapping("/docchrg")
    public ResponseEntity<List<DoctorCharges>> getdoctorcharges() {

        return new ResponseEntity<>(doctorChargesServiceI.allDoctorCharges(), HttpStatus.OK);
    }

    // add
    @PostMapping("/adddocchrg")
    public ResponseEntity<DoctorCharges> addDoctorCharges(@RequestBody DoctorCharges doctorCharges) {

        return new ResponseEntity<>(doctorChargesServiceI.addDoctorCharges(doctorCharges), HttpStatus.OK);
    }

    // update
    @PutMapping("/updocchrg")
    public ResponseEntity<DoctorCharges> updateDoctorCharges(@RequestBody DoctorCharges doctorCharges) {
        return new ResponseEntity<>(doctorChargesServiceI.updateDoctorCharges(doctorCharges), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/deldocchrg")
    public ResponseEntity<String> deleteDoctorCharges(@RequestBody Integer dcId) {
        return new ResponseEntity<>(doctorChargesServiceI.deleteDoctorCharges(dcId), HttpStatus.OK);
    }

    // get room charges
    @GetMapping("/roomchrg")
    public ResponseEntity<List<RoomCharges>> getroomcharges() {

        return new ResponseEntity<>(roomChargesServiceI.allRoomCharges(), HttpStatus.OK);

    }

    // add room charges
    @PostMapping("/addroomchrg")
    public ResponseEntity<RoomCharges> addRoomCharges(@RequestBody RoomCharges roomCharges) {

        return new ResponseEntity<>(roomChargesServiceI.addRoomCharges(roomCharges), HttpStatus.OK);
    }

    // update room charges
    @PutMapping("/uproomchrg")
    public ResponseEntity<RoomCharges> updateRoomCharges(@RequestBody RoomCharges roomCharges) {
        return new ResponseEntity<>(roomChargesServiceI.updateRoomCharges(roomCharges), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/delroomchrg")
    public ResponseEntity<String> deleteRoomCharges(@RequestBody Integer dcId) {
        return new ResponseEntity<>(roomChargesServiceI.deleteRoomCharges(dcId), HttpStatus.OK);
    }

}
