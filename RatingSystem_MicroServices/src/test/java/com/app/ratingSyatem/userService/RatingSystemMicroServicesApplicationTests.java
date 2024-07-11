package com.app.ratingSyatem.userService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.ratingSyatem.userService.entities.Rating;
import com.app.ratingSyatem.userService.externalServices.RatingService;

@SpringBootTest
class RatingSystemMicroServicesApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRating() {
		Rating rating=new Rating("test123","testuser","testhotel",10,"this is good hotel");
		Rating savedRating=ratingService.createRating(rating);
		System.out.println("now rating is saved");
	}

}
