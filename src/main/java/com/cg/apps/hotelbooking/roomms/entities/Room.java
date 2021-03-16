package com.cg.apps.hotelbooking.roomms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cg.apps.hotelbooking.hotelms.entities.Hotel;

@Entity
public class Room {
	
	@GeneratedValue
	@Id
	private Long roomId;
	private Integer floorNumber,roomNumber;
	private Boolean available;
	private double cost;
	
	@ManyToOne
	private Hotel hotel;
	
	public Room() {
		
	}
	
	public Room(Integer floorNumber, Integer roomNumber, Boolean available, double cost, Hotel hotel) {
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.available = true;
		this.cost = cost;
		this.hotel = hotel;
	}
	
	public Long getId() {
		return roomId;
	}
	
	public void setId(Long id) {
		roomId = id;
	}
	
	public Integer getFloorNo() {
		return floorNumber;
	}
	
	public void setFloorNo(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public Integer getRoomNo() {
		return roomNumber;
	}
	
	public void setRoomNo(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
	
}
