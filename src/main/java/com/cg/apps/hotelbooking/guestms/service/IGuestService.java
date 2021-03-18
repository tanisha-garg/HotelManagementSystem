package com.cg.apps.hotelbooking.guestms.service;

import java.util.List;

import com.cg.apps.hotelbooking.guestms.entities.Guest;
import com.cg.apps.hotelbooking.guestms.entities.GuestTransaction;

public interface IGuestService {
	
	Guest findById(Long guestId);

	Guest allotRoom(String aadharId, String guestName, Long hotelId, int roomNumber, int floorNumber, double rent);

	List<GuestTransaction> transactionHistory(Long guestId);

	Guest checkout(Long guestId, Long hotelId, int roomNumber, int floorNumber);

}
