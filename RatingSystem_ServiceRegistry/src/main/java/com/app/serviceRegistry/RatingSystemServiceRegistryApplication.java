package com.app.serviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RatingSystemServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingSystemServiceRegistryApplication.class, args);
	}

}
