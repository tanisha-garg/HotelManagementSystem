package com.cg.apps.hotelbooking.guestms.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class GuestTransaction {
	
	@GeneratedValue
	@Id
	private Long id;
	
	private double amount;
	private LocalDateTime dateTime;
	
	@ManyToOne
	private Guest guest;

	public GuestTransaction() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	
	
}
