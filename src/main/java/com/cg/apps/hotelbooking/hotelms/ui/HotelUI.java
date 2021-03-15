package com.cg.apps.hotelbooking.hotelms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;

@Component
public class HotelUI {
	
	@Autowired
	IHotelService hotelService;
	
	public void start() {
		
		Hotel mariott = hotelService.addHotel("JW Mariott", "Chandigarh");
		Hotel radisson = hotelService.addHotel("Radisson Blu", "Delhi");
		Hotel trident = hotelService.addHotel("Trident", "Mumbai");
		
		displayHotel(mariott);
		displayHotel(radisson);
		displayHotel(trident);
		
		System.out.println("******************************");
		System.out.println("Finding a Hotel by Id");
		Long mariottId = mariott.getHotelId();
		mariott = hotelService.findById(mariottId);
		displayHotel(mariott);
		
	}
	
	public void displayHotel(Hotel hotel) {
		System.out.println("Hotel: "+hotel.getHotelId()+
							"\nHotel Name: "+hotel.getHotelName()+
							"\nLocation: "+hotel.getAddress());
		System.out.println();
	}

}
