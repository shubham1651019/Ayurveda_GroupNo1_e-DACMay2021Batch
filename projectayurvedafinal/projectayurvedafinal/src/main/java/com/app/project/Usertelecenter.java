package com.app.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userstelecenter")
public class Usertelecenter {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 100)
    private String email;
     
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
     
    
    
    @Column(name = "state_name", nullable = false, length = 100)
    private String state;
    
    @Column(name = "city_name", nullable = false, length = 100)
    private String city;
    
    @Column(name = "address_name", nullable = false, length = 100)
    private String address;
    
    @Column(name = "contact_name", nullable = false, length = 100)
    private String contact;
    
    @Column(name = "medicine_name", nullable = false, length = 100)
    private String medicinename;
    
    @Column(name = "Quantity", nullable = false, length = 100)
    private String quantity;
    
    @Column(name = "Description", nullable = false, length = 100)
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
    

}







	 	
	    
	   
