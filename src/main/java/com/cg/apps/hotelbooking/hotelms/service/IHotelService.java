package com.cg.apps.hotelbooking.hotelms.service;

import java.util.List;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.roomms.entities.Room;

public interface IHotelService {
	
	Hotel findById(Long hotelId);
	
	Hotel addHotel(String hotelName, String address, List<Room> rooms);

}
