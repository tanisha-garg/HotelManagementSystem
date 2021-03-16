package com.cg.apps.hotelbooking.hotelms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.roomms.service.IRoomService;

@Component
public class HotelUI {
	
	@Autowired
	IHotelService hotelService;
	
	@Autowired
	IRoomService roomService;
	
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
		
		System.out.println("******************************");
		Room mariott101 = roomService.addroom(mariott.getHotelId(), 1, 101);
		Room radisson101 = roomService.addroom(radisson.getHotelId(), 1, 101);
		Room mariott201 = roomService.addroom(mariott.getHotelId(), 2, 201);
		Room radisson201 = roomService.addroom(radisson.getHotelId(), 2, 201);
		
		displayRoom(mariott101);
		displayRoom(radisson101);
		displayRoom(mariott201);
		displayRoom(radisson201);
		
		System.out.println("******************************");
		System.out.println("Finding a Room by Id");
		Long mariott101Id = mariott101.getId();
		mariott101 = roomService.findById(mariott101Id);
		displayRoom(mariott101);
		
		System.out.println("******************************");
		System.out.println("Finding a Room with floor number and room number as input");
		Room room = roomService.findRoom(mariott101.getFloorNo(), mariott101.getRoomNo());
		displayRoom(room);
	}
	
	public void displayHotel(Hotel hotel) {
		
		System.out.println("Hotel: "+hotel.getHotelId()+
							"\nHotel Name: "+hotel.getHotelName()+
							"\nLocation: "+hotel.getAddress());
		System.out.println();
		
	}
	
	public void displayRoom(Room room) {

		System.out.println("Room: "+room.getId()+
					   "\n Floor: "+room.getFloorNo()+
					   "\n Room Number: "+room.getRoomNo()+
					   "\n Avalability: "+room.isAvailable()+
					   "\n Cost: "+ room.getCost()+
					   "\nHotel Name: "+room.getHotel().getHotelName());
		System.out.println();		
		

	}

}
