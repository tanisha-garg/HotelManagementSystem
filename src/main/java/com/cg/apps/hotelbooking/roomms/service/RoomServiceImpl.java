package com.cg.apps.hotelbooking.roomms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.dao.IRoomDao;
import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidRoomIdException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidRoomNoException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidfloorNoException;

@Service
public class RoomServiceImpl implements IRoomService{
	
	@Autowired
	private IRoomDao roomDao;
	
	@Autowired
	private IHotelService hotelService;

	/*@Override
	public Room addroom(Long hotelId, int floorNo, int roomNo) {
		Hotel hotel =hotelService.findById(hotelId);
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		Room room = new Room();
		return null;
	}*/

	@Override
	public Room findById(Long roomId) {
		validateId(roomId);
		return roomDao.findById(roomId);
	}

	@Override
	public Room findRoom(int floorNo, int roomNo) {
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		return roomDao.findRoom(floorNo, roomNo);
	}
	
	public void validateId(Long roomId) {
		if(roomId<0) {
			throw new InvalidRoomIdException("Room id is not correct ! Please check");
		}
	}
	public void validateFloorNo(int floorNo) {
		if(floorNo<0) {
			throw new InvalidfloorNoException("Room id is not correct ! Please check");
		}
	}
	public void validateRoomNo(int roomNo) {
		if(roomNo<0) {
			throw new InvalidRoomNoException("Room id is not correct ! Please check");
		}
	}

}
