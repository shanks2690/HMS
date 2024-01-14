package org.hms.receptionistmicroservice.feigncalls;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="DOCTOR")
public interface DocFeign {
    @GetMapping("doc/alldocs")
    public ResponseEntity<?> getAllDocs();

}
