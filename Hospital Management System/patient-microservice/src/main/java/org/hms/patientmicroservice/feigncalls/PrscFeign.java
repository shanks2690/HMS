package org.hms.patientmicroservice.feigncalls;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name= "PRESCRIPTION")
public interface PrscFeign {

    @PostMapping("prsc/forpat")
    public ResponseEntity<?> forPat(@RequestBody String patientID);

    @PostMapping("prsc/view")
    public ResponseEntity<?> viewPrsc(@RequestBody String prscId);


}
