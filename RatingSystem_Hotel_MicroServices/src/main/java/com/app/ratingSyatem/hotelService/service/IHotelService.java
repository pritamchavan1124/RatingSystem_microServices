package com.app.ratingSyatem.hotelService.service;

import java.util.List;
import java.util.Optional;

import com.app.ratingSyatem.hotelService.entites.Hotel;

public interface IHotelService {

	//create new hotel
	public Hotel createNewHotel(Hotel hotel);
	//get a single hotel from list
	public Optional<Hotel> getSingleHotel(String id);
	//get all hotel list
	public List<Hotel> getAllHotelList();
	//update hotel data
	public Hotel updateHotelData(Hotel hotelObj);
	//delete hotel
	public String deleteHotelData(String hotelId);
	
}
