package org.hms.doctormicroservice.feigncalls;

import org.hms.doctormicroservice.dto.AppointmentInfoDto;
import org.hms.doctormicroservice.dto.AppointmentSlotDto;
import org.hms.doctormicroservice.dto.DocDepDto;
import org.hms.doctormicroservice.dto.PatientHealthRecDto;
import org.hms.doctormicroservice.entity.enums.BranchCode;
import org.hms.doctormicroservice.entity.enums.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name= "APPOINTMENT")
public interface AppointmentFeign {
    @PostMapping("apnt/updatehealth")
    public ResponseEntity<?> addHealthRec(@RequestBody PatientHealthRecDto healthRecDto);
    @PostMapping("apnt/showapnt")
    public ResponseEntity <List<AppointmentInfoDto>> showApnt(@RequestBody String docId);

    @PostMapping("apnt/addslot")
    public ResponseEntity<?> addSlot( @RequestBody AppointmentSlotDto slot);
    @GetMapping("apnt/hmsorg")
    public ResponseEntity <Map<BranchCode, Map<Department, List<DocDepDto>>>> showOrg();
    @PostMapping("apnt/byapntid")
    public ResponseEntity<AppointmentInfoDto> getApnt(@RequestBody Integer apntId);
    @PostMapping("apnt/showslots")
    public ResponseEntity<?> showSlots(@RequestBody String docId);

    @DeleteMapping("apnt/delslot")
     ResponseEntity<String> delSlot(  Long slotId);
}
