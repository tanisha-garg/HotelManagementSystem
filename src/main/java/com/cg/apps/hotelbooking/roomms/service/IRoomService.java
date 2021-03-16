package com.cg.apps.hotelbooking.roomms.service;

import com.cg.apps.hotelbooking.roomms.entities.Room;

public interface IRoomService {
	
	//Room addroom(Long hotelId, int floorNo, int roomNo);

	Room findById(Long roomId);

	Room findRoom(int floorNo, int roomNo);

	//ListfindAllRoomsInHotel(Long hotelId)

	//ListavailableRoomsInHotel(Long hotelId)

}
