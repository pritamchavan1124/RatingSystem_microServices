package com.app.ratingSyatem.hotelService.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ratingSyatem.hotelService.entites.Hotel;
import com.app.ratingSyatem.hotelService.exceptions.ResourceNotFoundExceptuion;
import com.app.ratingSyatem.hotelService.repository.HotelRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private HotelRepository hotelRepo;
	
	@Override
	public Hotel createNewHotel(Hotel hotel) {
		String str=UUID.randomUUID().toString();
		hotel.setId(str);
		return hotelRepo.save(hotel);
	}

	@Override
	public Optional<Hotel> getSingleHotel(String id) {
		Optional<Hotel> h=Optional.ofNullable(hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundExceptuion("Hotel with given id not found !!")));
		return h;
	}

	@Override
	public List<Hotel> getAllHotelList() {
		List<Hotel> h=hotelRepo.findAll();
		return h;
	}

	@Override
	public Hotel updateHotelData(Hotel hotelObj) {
	  Optional<Hotel> h=hotelRepo.findById(hotelObj.getId());
		if(h!=null) {
			hotelObj.setName(hotelObj.getName());
			hotelObj.setAbout(hotelObj.getAbout());
			hotelObj.setLocation(hotelObj.getLocation());
			hotelObj.setHotelEmail(hotelObj.getHotelEmail());
			hotelRepo.save(hotelObj);
			return h.get();
		}
	  return null;
	}

	@Override
	public String deleteHotelData(String hotelId) {
		Hotel h=hotelRepo.findById(hotelId).get();
		if(h!=null) {
		hotelRepo.delete(h);
		return "Hotel is deleted!!!";
		}
		return "Some Thing wents wrong...Please try again..";
	}
	

}
