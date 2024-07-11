package com.app.ratingSyatem.userService.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.ratingSyatem.userService.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/getHotel/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);
}
