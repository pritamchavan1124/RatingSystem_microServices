package com.app.ratingSyatem.ratingService.service;

import java.util.List;

import com.app.ratingSyatem.ratingService.entity.Rating;

public interface IRatingService {

	//create rating
	public Rating createNewRating(Rating rating);
	
	//get all rating
	public List<Rating> getAllRatings();
	
	//get user rating
	public List<Rating> getRatingByUserId(String userId);
	
	//getRating
	public List<Rating> getRatingByHotel(String hotelId);
	
	//delete rating
	public String deleteRatingByUser(String userId);
}
