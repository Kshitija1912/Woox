package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class offers {
     @Id
	private String image;
	private String imagename;
	private String price;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
