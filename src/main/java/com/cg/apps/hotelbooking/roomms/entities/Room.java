package com.cg.apps.hotelbooking.roomms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
@Entity
public class Room {

	@Id
	@GeneratedValue
	private long Id;
	private Integer floorNo,roomNo;
	private boolean available;
	private double cost;
	//private Hotel hotel;
	
	public Room() {}
	public Room(Integer floorNo, Integer roomNo, boolean available, double cost) {
		this.floorNo = floorNo;
		this.roomNo = roomNo;
		this.available = available;
		this.cost = cost;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Integer getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		return (int)Id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	
	
}
