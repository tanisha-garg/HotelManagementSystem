package com.cg.apps.hotelbooking.hotelms.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.apps.hotelbooking.hotelms.dao.IHotelRepository;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.exceptions.HotelNotFoundException;
import com.cg.apps.hotelbooking.hotelms.exceptions.InvalidAddressException;
import com.cg.apps.hotelbooking.roomms.entities.Room;

@Service
public class HotelServiceImpl implements IHotelService{
	
	@Autowired
	private IHotelRepository hotelRepo;

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
	public Hotel addHotel(String hostelName, String address, List<Room> rooms) {
		validateHotelAddress(address);
		Hotel hotel = new Hotel(hostelName, address, rooms);
		hotelRepo.save(hotel);
		return hotel;
	}
	
	public void validateHotelAddress(String address) {
		if(address.isEmpty() || address == null) {
			throw new InvalidAddressException("Hotel address can't be empty or null");
		}
	}
	
	

}
