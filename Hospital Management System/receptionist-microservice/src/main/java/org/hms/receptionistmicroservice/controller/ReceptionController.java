package org.hms.receptionistmicroservice.controller;

import com.netflix.discovery.converters.Auto;
import org.hms.receptionistmicroservice.dto.*;
import org.hms.receptionistmicroservice.entity.ReceptionistInfo;
import org.hms.receptionistmicroservice.feigncalls.ApntFeign;
import org.hms.receptionistmicroservice.feigncalls.DocFeign;
import org.hms.receptionistmicroservice.feigncalls.RoomFeign;
import org.hms.receptionistmicroservice.kafka.Sender;
import org.hms.receptionistmicroservice.mapper.PatCredMapper;
import org.hms.receptionistmicroservice.service.ReceptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("rec")

public class ReceptionController {
    @Autowired
    Sender sender;
    @Autowired
    ApntFeign apntFeign;
@Autowired
    ReceptionServices receptionServices;
    @Autowired
    RoomFeign roomFeign;

    @Autowired
    DocFeign docFeign;

    @PostMapping("register")
    public ResponseEntity<String> registerPatient(@RequestBody PatientInfoDto patientInfo) {
        CredentialsDto userCred = PatCredMapper.PatToCred(patientInfo);
        sender.regRequest(PatCredMapper.dtoToToken(userCred));

        return ResponseEntity.ok("Registration Request for %s %s sent to Admin".formatted(patientInfo.getFirstname(), patientInfo.getLastname()));
    }

    @PostMapping("bookroom")
    public ResponseEntity<?> bookRoom(@RequestHeader("loggedInUser") String email, @RequestBody RoomAllocDto roomAllocDto)
    {  roomAllocDto.setReceptionistId(receptionServices.myInfo(email).getReceptionistId());
        return roomFeign.bookRoom(roomAllocDto);
    }

    @GetMapping("myinfo")
    public ResponseEntity<?> showMyInfo(@RequestHeader("loggedInUser") String email) {

       return ResponseEntity.ok(receptionServices.myInfo(email));
    }
    @PutMapping("updateinfo")
    public ResponseEntity<?> updateMyInfo(@RequestBody ReceptionistInfo recInfo, @RequestHeader("loggedInUser") String userName) {
        return ResponseEntity.ok(receptionServices.updateInfo(recInfo, userName));
    }

    @PostMapping("add") //with admin only
    public ResponseEntity<?> addRec(@RequestBody RecCredDto recCredDto) {
        return ResponseEntity.ok(receptionServices.addNewRec(recCredDto));
    }

    @PostMapping("regapnt")
    public ResponseEntity<?> reqApnt(@RequestHeader("loggedInUser") String email,@RequestBody AppointmentInfoDto appointmentInfoDto) {
        return apntFeign.addApnt(appointmentInfoDto);
    }
    @GetMapping("alldocs")
    public ResponseEntity<?> getAllDocs()
    {
        return docFeign.getAllDocs();
    }
    @DeleteMapping("del")  // with admin only
    public ResponseEntity<String> delRec( @RequestBody String email) {

        return ResponseEntity.ok(receptionServices.delRec(email));
    }

    @PostMapping("showslots")
    public ResponseEntity<?> mySlots(@RequestBody String docId)
    {
      return apntFeign.showSlots(docId);
    }
}

