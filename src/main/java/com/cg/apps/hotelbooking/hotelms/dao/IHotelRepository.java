package com.cg.apps.hotelbooking.hotelms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Long>{

}
