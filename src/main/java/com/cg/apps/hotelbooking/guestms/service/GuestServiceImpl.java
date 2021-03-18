package com.cg.apps.hotelbooking.guestms.service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.hotelbooking.guestms.dao.IGuestRepository;
import com.cg.apps.hotelbooking.guestms.dao.IGuestTransactionRepository;
import com.cg.apps.hotelbooking.guestms.entities.Guest;
import com.cg.apps.hotelbooking.guestms.entities.GuestTransaction;
import com.cg.apps.hotelbooking.guestms.exceptions.GuestNotFoundException;
import com.cg.apps.hotelbooking.guestms.exceptions.RoomNotAvailableException;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.dao.IRoomRepository;
import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.roomms.service.IRoomService;


@Service
public class GuestServiceImpl implements IGuestService{
	
	@Autowired
	private IGuestRepository guestRepo;
	
	@Autowired 
	private IRoomService roomService;
	
	@Autowired
	private IRoomRepository roomRepo;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IGuestTransactionRepository guestTransactionRepo; 

	@Override
	public Guest findById(Long guestId) {
		Optional<Guest> optional = guestRepo.findById(guestId);
		if(!optional.isPresent()) {
			throw new GuestNotFoundException("Guest with id "+ guestId +" not found");
		}
		return optional.get();
	}

	@Override
	public Guest allotRoom(String aadharId, String guestName, Long hotelId, int roomNumber, int floorNumber,
			double rent) {
		Guest guest = new Guest();
		guest.setAadharId(aadharId);
		guest.setName(guestName);
		guest.setRentedDateTime(LocalDateTime.now());
		Room room = roomService.findRoom(hotelId, floorNumber, roomNumber);
		if(room.isAvailable()) {
			
			room.setAvailable(false);
			guest.setRoom(room);
			guest = guestRepo.save(guest);
			room = roomRepo.save(room);
			GuestTransaction transaction = new GuestTransaction();
			transaction.setAmount(rent);
			transaction.setDateTime(LocalDateTime.now());
			transaction.setGuest(guest);
			guestTransactionRepo.save(transaction);
			guest.setRecentTransaction(transaction);
			guest.setRoom(room);
			List<GuestTransaction> transactionList = guest.getTransactions();
			if(transactionList == null) {
				transactionList = new ArrayList<>();
				guest.setTransactions(transactionList);
			}
			transactionList.add(transaction);
			guest.setTransactions(transactionList);
			guest = guestRepo.save(guest);
			
		}
		else {
			throw new RoomNotAvailableException("Sorry! Room is not available");
		}
		
		return guest;
	}

	@Override
	public List<GuestTransaction> transactionHistory(Long guestId) {
		Guest guest = findById(guestId);
		List<GuestTransaction> transactionList = guest.getTransactions();
		
		return transactionList;
	}

	@Override
	public Guest checkout(Long guestId, Long hotelId, int roomNumber, int floorNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
