package com.cg.apps.hotelbooking.hotelms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.apps.hotelbooking.hotelms.dao.IHotelRepository;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.exceptions.HotelNotFoundException;

@Service
public class HotelServiceImpl implements IHotelService{
	
	@Autowired
	IHotelRepository hotelRepo;

	@Override
	public Hotel findById(Long hotelId) {
		Optional<Hotel> optional = hotelRepo.findById(hotelId);
		if(!optional.isPresent()) {
			throw new HotelNotFoundException("Hotel with id = "+hotelId+" not found");
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Hotel addHotel(String hostelName, String address) {
		Hotel hotel = new Hotel(hostelName, address);
		hotelRepo.save(hotel);
		return hotel;
	}
	
	

}
