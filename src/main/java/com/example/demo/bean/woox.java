package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class woox {

	private String fullname;
	@Id
	private String emailaddress;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
