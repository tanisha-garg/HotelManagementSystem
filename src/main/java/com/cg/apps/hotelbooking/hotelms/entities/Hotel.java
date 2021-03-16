package com.cg.apps.hotelbooking.hotelms.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;
import com.cg.apps.hotelbooking.roomms.entities.*;

@Entity
public class Hotel {
	
	@GeneratedValue
	@Id
	private Long hotelId;
	private String hotelName;
	private String address;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Room> roomList;
	
	public Hotel() {
		
	}
	
	public Hotel(String hotelName, String address, List<Room> roomList) {
		this.hotelName = hotelName;
		this.address = address;
		this.roomList = roomList;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	
	

}
