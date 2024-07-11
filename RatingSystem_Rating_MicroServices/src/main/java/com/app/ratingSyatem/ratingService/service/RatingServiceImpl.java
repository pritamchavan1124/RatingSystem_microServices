package com.app.ratingSyatem.ratingService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ratingSyatem.ratingService.entity.Rating;
import com.app.ratingSyatem.ratingService.exception.RatingResourceNotFound;
import com.app.ratingSyatem.ratingService.repository.RatingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RatingServiceImpl implements IRatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating createNewRating(Rating rating) {
		String randomId=UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		//Rating rating=ratingRepo.findById(userId).orElseThrow(()-> new RatingResourceNotFound("Rating Resource Not Found..."));
		List<Rating> listRating=ratingRepo.findByUserID(userId);
		return listRating;
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelId) {
		
		return ratingRepo.findByHotelID(hotelId);
	}

	@Override
	public String deleteRatingByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
