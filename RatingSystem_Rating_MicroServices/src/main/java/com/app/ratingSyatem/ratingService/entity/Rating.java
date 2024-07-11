package com.app.ratingSyatem.ratingService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_rating")
public class Rating {

	@Id
	private String ratingId;
	@Column(length = 50)
	private String userID;
	@Column(length = 50)
	private String hotelID;
	
	private int rating;
	@Column(length = 50)
	private String feedback;
	
	public Rating(String ratingId, String userID, String hotelID, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userID = userID;
		this.hotelID = hotelID;
		this.rating = rating;
		this.feedback = feedback;
	}

	public Rating() {
		super();
	}

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
}
