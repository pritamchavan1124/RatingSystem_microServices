package com.app.ratingSyatem.ratingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingSystemRatingMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingSystemRatingMicroServicesApplication.class, args);
	}

}
