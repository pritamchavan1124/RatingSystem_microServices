package com.app.ratingSyatem.userService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.ratingSyatem.userService.entities.Hotel;
import com.app.ratingSyatem.userService.entities.Rating;
import com.app.ratingSyatem.userService.entities.User;
import com.app.ratingSyatem.userService.exception.ResourseNotFoundException;
import com.app.ratingSyatem.userService.externalServices.HotelService;
import com.app.ratingSyatem.userService.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUser(String userId) throws ResourseNotFoundException {
		//get user from database with the help of user repository
		Optional<User> user=Optional.ofNullable(userRepo.findById(userId).orElseThrow(()->new ResourseNotFoundException("User with given id is not found !!:-"+userId)));
		//fetch rating of the above user from rating service
		Rating[] ratingsOfUser=restTemplate.getForObject("http://RATING-SERVICE/api/rating/getAllUserRating/"+user.get().getUserId(),Rating [].class);
		List<Rating> list = Arrays.stream(ratingsOfUser).toList();
		if(user.isPresent()) {
			User u=user.get();
			u.setRatings(list);
		}
		//api call to hotel service to get the hotel
		list.stream().map(rating -> {
			//ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/getHotel/"+rating.getHotelID(),Hotel.class);
			//Hotel hotel=forEntity.getBody();
			//above two lines are also working but i have tried feigin client also
			Hotel hotel=hotelService.getHotel(rating.getHotelID());
			rating.setHotel(hotel);
			return new Rating();
		}).collect(Collectors.toList());
		return user;
	}

	@Override
	public String deleteUserById(String userId) {
		Optional<User> user=Optional.ofNullable(userRepo.findById(userId).get());
		if(user !=null) {
			userRepo.deleteById(userId);
			return "User delete successfully !!";
		}
		return "User Not found....Please try again";
	}

	@Override
	public String updateUser(User user) {
		Optional<User> updateduser=userRepo.findById(user.getUserId());
		if(updateduser!=null) {
			user.setAge(user.getAge());
			user.setEmail(user.getEmail());
			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			userRepo.save(user);
			return "User details updated...";
		}
		return "Error !!! user not found with userId"+user.getEmail();
	}

}
