package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class reservation {

	private String Name;
	
	@Id
	private String phoneNumber;
	private int numofGuest;
	private int cheackindate;
	private String destination;
	private String Date;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getNumofGuest() {
		return numofGuest;
	}
	public void setNumofGuest(int numofGuest) {
		this.numofGuest = numofGuest;
	}
	public int getCheackindate() {
		return cheackindate;
	}
	public void setCheackindate(int cheackindate) {
		this.cheackindate = cheackindate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
}
