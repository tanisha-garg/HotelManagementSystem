package com.cg.apps.hotelbooking.roomms.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.dao.*;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidRoomIdException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidRoomNoException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidfloorNoException;
import com.cg.apps.hotelbooking.roomms.exceptions.RoomNotFoundException;

@Service
public class RoomServiceImpl implements IRoomService{
	
	@Autowired
	private IRoomRepository roomRepo;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public Room addroom(Long hotelId, int floorNo, int roomNo) {		
		Hotel hotel =hotelService.findById(hotelId);
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		Room room = new Room(floorNo, roomNo, false, 0.0, hotel);
		roomRepo.save(room);
		return room;
	}

	@Override
	public Room findById(Long roomId) {
		validateId(roomId);
		Optional<Room> optional = roomRepo.findById(roomId);
		if(!optional.isPresent()) {
			throw new RoomNotFoundException("Room with id "+roomId+" not found");
		}
		return optional.get();
	}

	@Override
	public Room findRoom(int floorNo, int roomNo) {
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		String ql = "from Room where floorNumber:= floorNo AND roomNumber:=roomNo";
		TypedQuery<Room> query=entityManager.createQuery(ql,Room.class);
		Room room = query.getSingleResult();
		return room;
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
