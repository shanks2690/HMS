package org.hms.receptionistmicroservice.feigncalls;


import org.hms.receptionistmicroservice.dto.AppointmentInfoDto;
import org.hms.receptionistmicroservice.dto.DocDepDto;

import org.hms.receptionistmicroservice.entity.enums.BranchCode;
import org.hms.receptionistmicroservice.entity.enums.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name="APPOINTMENT")
public interface ApntFeign {

    @PostMapping("apnt/addapnt")
     ResponseEntity<?> addApnt(AppointmentInfoDto apntDto);

    @GetMapping("apnt/hmsorg")
    public ResponseEntity <Map<BranchCode, Map<Department, List<DocDepDto>>>> showOrg();

    @PostMapping("apnt/showslots")
    public ResponseEntity<?> showSlots(@RequestBody String docId);
}
