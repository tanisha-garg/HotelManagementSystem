package com.cg.apps.hotelbooking.roomms.service;

import java.util.List;

import com.cg.apps.hotelbooking.roomms.entities.Room;

public interface IRoomService {
	
	Room addroom(Long hotelId, int floorNo, int roomNo, double cost);

	Room findById(Long roomId);

	Room findRoom(Long hotelId, int floorNo, int roomNo);

	List<Room> ListfindAllRoomsInHotel(Long hotelId);

	List<Room> ListavailableRoomsInHotel(Long hotelId);

}
