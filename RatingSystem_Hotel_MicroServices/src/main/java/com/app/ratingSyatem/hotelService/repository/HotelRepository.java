package com.app.ratingSyatem.hotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ratingSyatem.hotelService.entites.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>{

}
