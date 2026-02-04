package com.nishakar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VehicleParkingServiceApplication {

	static void main(String[] args) {
		SpringApplication.run(VehicleParkingServiceApplication.class, args);
	}

}
