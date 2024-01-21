package com.example.demo.bean;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class contact {
 
	private String fullname;
	@jakarta.persistence.Id
	private String emailaddress;
	
	private String contactno;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	
	
	
}
