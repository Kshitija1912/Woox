package com.example.demo.bean;



import jakarta.persistence.Entity;

@Entity
public class images {
  
	
	@jakarta.persistence.Id 
	private String image;
	private String imagename;
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
	
}
