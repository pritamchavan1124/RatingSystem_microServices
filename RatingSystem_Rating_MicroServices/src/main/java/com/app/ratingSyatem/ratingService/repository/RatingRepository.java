package com.app.ratingSyatem.ratingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ratingSyatem.ratingService.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String>{

	//custom finder methods
	List<Rating> findByUserID(String userId);
	
	List<Rating> findByHotelID(String hotelId);
}
