package com.app.ratingSyatem.userService.entities;

import jakarta.persistence.Id;

public class Hotel {

	@Id
	private String id;
	
	private String name;
	
	private String location;
	
	private String about;
	
	private String hotelEmail;

	public Hotel(String id, String name, String location, String about, String hotelEmail) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.about = about;
		this.hotelEmail = hotelEmail;
	}

	public Hotel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}
	
}
