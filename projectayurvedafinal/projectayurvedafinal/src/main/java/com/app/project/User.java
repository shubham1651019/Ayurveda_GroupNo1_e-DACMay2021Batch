package com.app.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     
	    @Column(nullable = false, unique = true, length = 100)
	    private String email;
	     
	    @Column(nullable = false, length = 64)
	    private String password;
	     
	    @Column(name = "first_name", nullable = false, length = 100)
	    private String firstName;
	     
	    @Column(name = "last_name", nullable = false, length = 100)
	    private String lastName;
	    
	    @Column(name = "contact_name", nullable = false, length = 100)
	    private String contact;
	    
	    @Column(name = "city_name", nullable = false, length = 100)
	    private String city;
	    
	    @Column(name = "age_name", nullable = false, length = 100)
	    private String age;
	    
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
		
		
	    

}
