package com.app.ratingSyatem.ratingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ratingSyatem.ratingService.entity.Rating;
import com.app.ratingSyatem.ratingService.service.IRatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

	@Autowired
	private IRatingService ratingService;
	
	@PostMapping("/createRating")
	public ResponseEntity<Rating> createRating(Rating ratingObj){
		Rating rating=ratingService.createNewRating(ratingObj);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating);
	}
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> list=ratingService.getAllRatings();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	@GetMapping("/getAllHotelRating/{hotelId}")
	public ResponseEntity<List<Rating>> getAllHotelRating(@PathVariable String hotelId){
		List<Rating> list=ratingService.getRatingByHotel(hotelId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	@GetMapping("/getAllUserRating/{userId}")
	public ResponseEntity<List<Rating>> getAllUserRating(@PathVariable String userId){
		List<Rating> list=ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	
	
	
}
