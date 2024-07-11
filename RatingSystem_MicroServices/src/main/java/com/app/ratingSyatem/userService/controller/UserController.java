package com.app.ratingSyatem.userService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ratingSyatem.userService.entities.User;
import com.app.ratingSyatem.userService.exception.ResourseNotFoundException;
import com.app.ratingSyatem.userService.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/createNewUser")
	public ResponseEntity<User> createNewUser(@RequestBody User user){
		System.out.println("its controller");
		User newNser=userService.saveUser(user);
		return new ResponseEntity<User>(newNser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{user}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable String user) throws ResourseNotFoundException{
		Optional<User> us=userService.getUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		String msg=userService.deleteUserById(userId);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> listUser=userService.getAllUser();
		return new ResponseEntity<List<User>>(listUser,HttpStatus.OK);
	}
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUserDetails(@RequestBody User user){
		String msg=userService.updateUser(user);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
}
