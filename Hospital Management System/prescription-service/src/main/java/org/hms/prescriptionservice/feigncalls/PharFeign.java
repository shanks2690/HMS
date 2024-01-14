package org.hms.prescriptionservice.feigncalls;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="PHARMA")
public interface PharFeign {

    @PostMapping("apnt/setStatus")
     void  setStatus(int apntId);

    
}
