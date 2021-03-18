package com.cg.apps.hotelbooking.hotelms.ui;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.hotelbooking.guestms.entities.Guest;
import com.cg.apps.hotelbooking.guestms.entities.GuestTransaction;
import com.cg.apps.hotelbooking.guestms.service.IGuestService;
import com.cg.apps.hotelbooking.hotelms.entities.Hotel;
import com.cg.apps.hotelbooking.hotelms.service.IHotelService;
import com.cg.apps.hotelbooking.roomms.entities.Room;
import com.cg.apps.hotelbooking.roomms.service.IRoomService;

@Component
public class HotelUI {
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IRoomService roomService;
	
	@Autowired
	private IGuestService guestService;
	
	public void start() {
		
		List<Room> mariottRooms = new ArrayList<>();
		List<Room> radissonRooms = new ArrayList<>();
		List<Room> tridentRooms = new ArrayList<>();
		
		Hotel mariott = hotelService.addHotel("JW Mariott", "Chandigarh", mariottRooms);
		Hotel radisson = hotelService.addHotel("Radisson Blu", "Delhi", radissonRooms);
		Hotel trident = hotelService.addHotel("Trident", "Mumbai", tridentRooms);
		
		displayHotel(mariott);
		displayHotel(radisson);
		displayHotel(trident);
		
		System.out.println("******************************");
		System.out.println("Finding a Hotel by Id");
		Long mariottId = mariott.getHotelId();
		mariott = hotelService.findById(mariottId);
		displayHotel(mariott);
		
		System.out.println("******************************");
		Room mariott101 = roomService.addroom(mariott.getHotelId(), 1, 101, 4000);
		Room radisson101 = roomService.addroom(radisson.getHotelId(), 1, 101, 4500);
		Room mariott201 = roomService.addroom(mariott.getHotelId(), 2, 201, 5000);
		Room radisson201 = roomService.addroom(radisson.getHotelId(), 2, 201, 5500);
		
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
		int floorNumber = mariott201.getFloorNo();
		int roomNumber = mariott201.getRoomNo();
		Long hotelId = mariott.getHotelId();
		Room findroom = roomService.findRoom(hotelId,floorNumber, roomNumber);
		displayRoom(findroom);
		
		System.out.println("******************************");
		System.out.println("Displaying all the rooms present in a Hotel");
		hotelId = radisson.getHotelId();
		List<Room> roomsList = roomService.ListfindAllRoomsInHotel(hotelId);
		for(Room room : roomsList) {
			displayRoom(room);
		}
		
		System.out.println("******************************");
		System.out.println("Displaying all available rooms present in a Hotel");
		hotelId = mariott.getHotelId();
		List<Room> availableRooms = roomService.ListavailableRoomsInHotel(hotelId);
		for(Room room : availableRooms) {
			displayRoom(room);
		}
		
		System.out.println("******************************");
		System.out.println("Alloting a room to a guest");
		
		hotelId = mariott.getHotelId();
		floorNumber = mariott101.getFloorNo();
		roomNumber = mariott101.getRoomNo();
		double rent = mariott101.getCost();
		Guest tanisha = guestService.allotRoom("986357853", "Tanisha", hotelId, roomNumber, floorNumber, rent);
		displayGuest(tanisha);
		
		floorNumber = mariott201.getFloorNo();
		roomNumber = mariott201.getRoomNo();
		rent = mariott201.getCost();
		hotelId = mariott.getHotelId();
		Guest pallavi = guestService.allotRoom("765487944", "Pallavi", hotelId, roomNumber, floorNumber, rent);
		displayGuest(pallavi);
		
		floorNumber = radisson101.getFloorNo();
		roomNumber = radisson101.getRoomNo();
		rent = radisson101.getCost();
		hotelId = radisson.getHotelId();
		tanisha = guestService.allotRoom("9845377634", "Tanisha", hotelId, roomNumber, floorNumber, rent);
		displayGuest(tanisha);
		

		System.out.println("******************************");
		System.out.println("Finding a guest by Id");
		Long guestId = tanisha.getId();
		Guest findTanisha = guestService.findById(guestId);
		displayGuest(findTanisha);
		
		System.out.println("******************************");
		System.out.println("List Transaction History");
		guestId = tanisha.getId();
		List<GuestTransaction> transactionList = guestService.transactionHistory(guestId);
		for(GuestTransaction transaction : transactionList) {
			displayGuestTransaction(transaction);
		}
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
	
	public void displayGuest(Guest guest) {
		
		System.out.println("Guest "+guest.getId()+
						   "\n Name: "+guest.getName()+
						   "\n Aadhar Id: "+guest.getAadharId()+
						   "\n Room Number: "+guest.getRoom().getRoomNo()+
						   "\n Checkout: "+guest.getCheckoutDateTime()+
						   "\n Hotel: "+guest.getRoom().getHotel().getHotelId()+
						   "\n Hotel Name: "+guest.getRoom().getHotel().getHotelName());
		System.out.println();
	}
	
	public void displayGuestTransaction(GuestTransaction transaction) {
		System.out.println("Guest Transaction Id: "+transaction.getId()+
						   "\n Amount: "+transaction.getAmount()+
						   "\n Time: "+transaction.getDateTime()+
						   "\n Guest: "+transaction.getGuest().getName()+
						   "\n Hotel: "+transaction.getGuest().getRoom().getHotel().getHotelName());
	}

}
