package com.app.ratingSyatem.userService.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;

@Entity
@Table(name="micro_users")
@Builder
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private String userId;
	
	@Column(name="fName",length=20)
	private String firstName;
	
	@Column(name="lName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	private int age;
	
	@Transient
	private List<Rating> ratings;

	public User(String userId, String firstName, String lastName, String email, int age, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.ratings = ratings;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	
}
