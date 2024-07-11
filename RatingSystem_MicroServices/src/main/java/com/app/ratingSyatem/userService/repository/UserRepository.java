package com.app.ratingSyatem.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ratingSyatem.userService.entities.User;

public interface UserRepository extends JpaRepository<User,String>{

}
