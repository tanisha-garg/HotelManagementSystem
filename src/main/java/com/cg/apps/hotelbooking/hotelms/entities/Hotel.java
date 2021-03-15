package com.cg.apps.hotelbooking.hotelms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {
	
	@GeneratedValue
	@Id
	private Long hotelId;
	private String hotelName;
	private String address;
	
	public Hotel() {
		
	}
	
	public Hotel(String hotelName, String address) {
		this.hotelName = hotelName;
		this.address = address;
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
	
	

}
