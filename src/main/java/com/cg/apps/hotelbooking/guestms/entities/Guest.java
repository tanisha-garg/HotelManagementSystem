package com.cg.apps.hotelbooking.guestms.entities;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import com.cg.apps.hotelbooking.roomms.entities.Room;

@Entity
public class Guest {
	
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	private String aadharId;
	
	@OneToOne
	private Room room;
	
	private LocalDateTime rentedDateTime;
	private LocalDateTime checkoutDateTime;
	
	@OneToMany
	private List<GuestTransaction> transactions;
	
	@OneToOne
	private GuestTransaction recentTransaction;
	
	public Guest() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDateTime getRentedDateTime() {
		return rentedDateTime;
	}

	public void setRentedDateTime(LocalDateTime rentedDateTime) {
		this.rentedDateTime = rentedDateTime;
	}

	public LocalDateTime getCheckoutDateTime() {
		return checkoutDateTime;
	}

	public void setCheckoutDateTime(LocalDateTime checkoutDateTime) {
		this.checkoutDateTime = checkoutDateTime;
	}

	public List<GuestTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<GuestTransaction> transactions) {
		this.transactions = transactions;
	}

	public GuestTransaction getRecentTransaction() {
		return recentTransaction;
	}

	public void setRecentTransaction(GuestTransaction recentTransaction) {
		this.recentTransaction = recentTransaction;
	}
	
	
	

}
