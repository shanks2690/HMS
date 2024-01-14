package com.shanks.appointmentservice.controller;


import com.shanks.appointmentservice.dto.AppointmentInfoDto;
import com.shanks.appointmentservice.dto.AppointmentSlotDto;
import com.shanks.appointmentservice.dto.DocDepDto;
import com.shanks.appointmentservice.entity.AppointmentInfo;
import com.shanks.appointmentservice.entity.AppointmentSlot;
import com.shanks.appointmentservice.entity.SimpleMail;
import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;
import com.shanks.appointmentservice.feign.DocFeign;
import com.shanks.appointmentservice.feign.EmailFeign;
import com.shanks.appointmentservice.mapper.ApntMapper;
import com.shanks.appointmentservice.mapper.MapDepDoc;
import com.shanks.appointmentservice.repository.Appointment;
import com.shanks.appointmentservice.service.AppointmentServices;
import com.shanks.appointmentservice.service.SlotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("apnt")
public class AppointmentController {

    @Autowired
    DocFeign docFeign;
    @Autowired
    SlotServices slotServices;
    @Autowired
    AppointmentServices appointmentServices;
    @Autowired
    Appointment appointment;
    @Autowired
    EmailFeign emailFeign;

    @GetMapping("departments")
    public ResponseEntity<Department[]> showDeparments() {
//        System.out.println(email);

        return ResponseEntity.ok(Department.values());
    }

    @GetMapping("hmsorg")
    public ResponseEntity<Map<BranchCode, Map<Department, List<DocDepDto>>>> showOrg() {
        return ResponseEntity.ok(MapDepDoc.depMapDoc(docFeign.getAllDocs()));
    }

    @GetMapping("form")
    public ResponseEntity<?> showForm() {
        return ResponseEntity.ok(new AppointmentInfoDto());
    }

    @PostMapping("showapnt")
    public ResponseEntity<List<AppointmentInfo>> showApnt(@RequestBody String docId) {
        System.out.println("Searching for appointments for " + docId);
        return ResponseEntity.ok(appointmentServices.getAllAppointments(Integer.parseInt(docId)));
    }


    @PostMapping("byapntid")
    public ResponseEntity<AppointmentInfoDto> getApnt(@RequestBody Integer apntId) {
        AppointmentInfoDto dto = ApntMapper.mapToDto(appointment.findById(apntId).orElse(null));
        return ResponseEntity.ok(dto);
    }

    @PostMapping("addapnt")
    public ResponseEntity<?> addApnt(@RequestBody AppointmentInfoDto apntDto) {
        AppointmentInfo apnt = ApntMapper.mapToApnt(apntDto);
        apnt = appointmentServices.addAppointment(apnt);
        slotServices.updateSlot(apnt.getSlotId(), false);
        return ResponseEntity.ok(apnt);
    }

    @DeleteMapping("cancelapnt") //to be accessed by doc and receptionist
    public ResponseEntity<?> delApnt(@RequestBody String apntId) {
        try {
            SimpleMail mail = new SimpleMail();

            AppointmentInfo apnt = appointment.findById(Integer.parseInt(apntId)).orElse(null);
            mail.setTo(apnt.getPEmail());
            mail.setFrom("shashankk.mtoc@gmail.com");
            mail.setSub("Appointment Cancellation");
            mail.setBody("""
                    Mr %s %s. You appointment with doctor %s %s on %s has been cancelled. Please reach out to reception for information. 
                    We regret the incovinience caused
                    
                    Regards,
                    Team HMS""".formatted(apnt.getPatFname()
                    , apnt.getPatLname(), apnt.getDocFname(), apnt.getDocLname(), apnt.getDate()));
            emailFeign.sendMail(mail);
            slotServices.updateSlot(apnt.getSlotId(), true);

            appointmentServices.delAppointment(Integer.parseInt(apntId));

            return ResponseEntity.ok("Appointment cancelled");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("setStatus")
    void setStatus(@RequestBody Integer apntId) {
        System.out.println("I have come here");
        appointmentServices.setCompleted(apntId);
    }

    @PostMapping("addslot")
    public ResponseEntity<?> addSlot(@RequestBody AppointmentSlotDto slot) {
        AppointmentSlot apnt = ApntMapper.mapToSlot(slot);
        return ResponseEntity.ok(slotServices.addSlot(apnt));
    }

    @DeleteMapping("delslot")
    public ResponseEntity<String> delSlot(@RequestBody Long slotId) {

        return ResponseEntity.ok(slotServices.deleteSlot(slotId));
    }

    @PostMapping("showslots")
    public ResponseEntity<?> showSlots(@RequestBody String docId) {
        int id = Integer.parseInt(docId);
        return ResponseEntity.ok(slotServices.viewSlots(id));
    }
}
