package com.app.ratingSyatem.hotelService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ratingSyatem.hotelService.entites.Hotel;
import com.app.ratingSyatem.hotelService.service.IHotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	@Autowired
	private IHotelService hotelService;
	
	@PostMapping("/addNewHotel")
	public ResponseEntity<Hotel> createNewHotel(@RequestBody Hotel hotel){
		Hotel h=hotelService.createNewHotel(hotel);
		return new ResponseEntity<Hotel>(h,HttpStatus.CREATED);
	}
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Optional<Hotel>> getSingleHotel(@PathVariable String hotelId){
		Optional<Hotel> h=hotelService.getSingleHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(h);
	}
	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotelList(){
		List<Hotel> list=hotelService.getAllHotelList();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@DeleteMapping("/deleteHotel/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
		String h=hotelService.deleteHotelData(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(h);
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
}
