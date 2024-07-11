package com.app.ratingSyatem.hotelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingSystemHotelMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingSystemHotelMicroServicesApplication.class, args);
	}

}
