package com.cg.apps.hotelbooking.roomms.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.roomms.exceptions.RoomNotFoundException;

public class RoomDaoImpl implements IRoomDao{
	
	private EntityManager entityManager;

	/*@Override
	public Room addroom(Hotel hotel, int floorNo, int roomNo) {
		
		
		return null;
	}*/

	@Override
	public Room findById(Long roomId) {
		Room room = entityManager.find(Room.class, roomId);
		if(room == null) {
			throw new RoomNotFoundException("Room not found for id"+roomId);
		}
		return room;
	}

	@Override
	public Room findRoom(int floorNo, int roomNo) {
		String ql = "from Room where floorNo:=floorNo and roomNo:=roomNo";
		TypedQuery<Room> query=entityManager.createQuery(ql,Room.class);
		Room room = query.getSingleResult();
		return room;
	}

}
