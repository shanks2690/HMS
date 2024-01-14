package org.hms.patientmicroservice.feigncalls;

import org.hms.patientmicroservice.dto.AppointmentInfoDto;
import org.hms.patientmicroservice.dto.DocDepDto;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name="APPOINTMENT")
public interface ApntFeign {

    @PostMapping("apnt/addapnt")
     ResponseEntity<?> addApnt(AppointmentInfoDto apntDto);

    
}
