package com.cg.apps.hotelbooking.roomms.dao;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.roomms.entities.Room;

public interface IRoomDao {
	
	//Room addroom(Hotel hotel, int floorNo, int roomNo);

	Room findById(Long roomId);

	Room findRoom(int floorNo, int roomNo);

}
