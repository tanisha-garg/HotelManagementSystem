package com.cg.apps.hotelbooking.hotelms.service;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;

public interface IHotelService {
	
	Hotel findById(Long hotelId);
	
	Hotel addHotel(String hotelName, String address);

}
