package org.hms.pharmacist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableFeignClients
@Configuration
@CrossOrigin
public class PharmacistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacistApplication.class, args);
	}

}
