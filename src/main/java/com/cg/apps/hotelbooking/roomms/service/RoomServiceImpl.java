package com.cg.apps.hotelbooking.roomms.service;

import java.util.*;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.hotelms.dao.IHotelRepository;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.dao.*;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidCostException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidRoomNoException;
import com.cg.apps.hotelbooking.roomms.exceptions.InvalidfloorNoException;
import com.cg.apps.hotelbooking.roomms.exceptions.RoomNotFoundException;

@Service
public class RoomServiceImpl implements IRoomService{
	
	@Autowired
	private IRoomRepository roomRepo;
	
	@Autowired
	private IHotelRepository hotelRepo;
	
	@Autowired
	private IHotelService hotelService;

	@Transactional
	@Override
	public Room addroom(Long hotelId, int floorNo, int roomNo, double cost) {
		validateCost(cost);
		Hotel hotel =hotelService.findById(hotelId);
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		Room room = new Room(floorNo, roomNo, false, cost, hotel);
		room = roomRepo.save(room);
		List<Room> roomsList = hotel.getRoomList();
		roomsList.add(room);
		hotelRepo.save(hotel);
		return room;
	}

	@Override
	public Room findById(Long roomId) {
		Optional<Room> optional = roomRepo.findById(roomId);
		if(!optional.isPresent()) {
			throw new RoomNotFoundException("Room with id "+roomId+" not found");
		}
		return optional.get();
	}

	@Override
	public Room findRoom(Long hotelId, int floorNo, int roomNo) {
		validateFloorNo(floorNo);
		validateRoomNo(roomNo);
		Hotel hotel = hotelService.findById(hotelId);
		List<Room> roomsList = hotel.getRoomList();
		for(Room room : roomsList) {
			if(room.getFloorNo() == floorNo && room.getRoomNo() == roomNo) {
				return room;
			}
		}
		throw new RoomNotFoundException("Room not found in hotel "+hotelId);
		
	}
	
	@Override
	public List<Room> ListfindAllRoomsInHotel(Long hotelId) {
		Hotel hotel = hotelService.findById(hotelId);
		List<Room> roomsList = hotel.getRoomList();
		return roomsList;
	}
	
	@Override
	public List<Room> ListavailableRoomsInHotel(Long hotelId) {
		Hotel hotel = hotelService.findById(hotelId);
		List<Room> availableRooms = new ArrayList<>();
		List<Room> roomsList = hotel.getRoomList();
		for(Room room : roomsList) {
			if(room.isAvailable()) {
				availableRooms.add(room);
			}
		}
		
		return availableRooms;
	}
	
	public void validateCost(double cost) {
		if(cost < 0) {
			throw new InvalidCostException("The cost can't be less than 0");
		}
	}
	public void validateFloorNo(int floorNo) {
		if(floorNo<0) {
			throw new InvalidfloorNoException("Floor number can't be less than 0");
		}
	}
	public void validateRoomNo(int roomNo) {
		if(roomNo<0) {
			throw new InvalidRoomNoException("Room number can't be less than 0");
		}
	}



}
