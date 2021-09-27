package com.app.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersdoctor")
public class UserDoctor {
	
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
	    
	    @Column(name = "qualification_name", nullable = false, length = 100)
	    private String qualification;
	    
	    @Column(name = "specialization_name", nullable = false, length = 100)
	    private String specialization;
	    
	    @Column(name = "Experience", nullable = false, length = 100)
	    private String experience;
	    
	    @Column(name = "Charges", nullable = false, length = 100)
	    private String charges;
	    
	    public UserDoctor(){
	 
	    }
	    
	    
	    
		



		public UserDoctor(Long id, String email, String password, String firstName, String lastName, String contact,
				String qualification, String specialization, String experience, String charges) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.contact = contact;
			this.qualification = qualification;
			this.specialization = specialization;
			this.experience = experience;
			this.charges = charges;
		}







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

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}







		public String getExperience() {
			return experience;
		}







		public void setExperience(String experience) {
			this.experience = experience;
		}







		public String getCharges() {
			return charges;
		}







		public void setCharges(String charges) {
			this.charges = charges;
		}

	
		
	    

}
