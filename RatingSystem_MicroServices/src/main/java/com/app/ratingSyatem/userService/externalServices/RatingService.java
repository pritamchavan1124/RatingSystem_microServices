package com.app.ratingSyatem.userService.externalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.app.ratingSyatem.userService.entities.Rating;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	//get rating
	@GetMapping("/api/rating/getAllRating")
	public List<Rating> getAllRating(String ratingId);
	
	//post rating
	@PostMapping("/api/rating/createRating")
	public Rating createRating(@RequestBody Rating rating);
	
	//put rating
	@PutMapping("/api/rating/updateRating")
	public Rating updateRating(Rating rating);
	
	//delete rating
	@DeleteMapping("/api/rating/deleteRating")
	public String deleteRating(String ratingId);
}
