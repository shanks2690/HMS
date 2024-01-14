package org.hms.doctormicroservice.feigncalls;

import org.hms.doctormicroservice.dto.PrescriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "PRESCRIPTION")
public interface PrscFeign {
    @PostMapping("prsc/add")
    public ResponseEntity<?> add(@RequestBody PrescriptionDto pDto);
    @PostMapping("prsc/form")
    public ResponseEntity<?> show(@RequestBody PrescriptionDto pDto);
}
