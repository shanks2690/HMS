package org.hms.prescriptionservice.feigncalls;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="APPOINTMENT")
public interface ApntFeign {

    @PostMapping("apnt/setStatus")
     void  setStatus(int apntId);

}
