package org.hms.doctormicroservice;


import org.hms.doctormicroservice.feigncalls.PatientFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients

public class DoctorMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorMicroserviceApplication.class, args);
    }


}
