package com.app.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="appointment",schema = "ayudb")
@DynamicUpdate
public class appointment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Integer appointment_id;
	
	@Column(name="patientName", nullable = false, length = 50)
	private String patientName;
	
	@Column(name="doctor_name", nullable = false, length = 50)
	private String doctorName;
	
	@Column(name="appointment_date", nullable = false, length = 50)
	private String date;
	
	@Column(name="appointment_time", nullable = false, length = 50)
	private String time;

	

	@Column(name="prescription", nullable = false, length = 50)
	private String prescription;
	
	@Column(name="confirmed" , nullable = false, length = 50)
	private String confirmed;
	
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	

	@Override
	public String toString() {
		return "appointment [appointment_id=" + appointment_id + ", patientName=" + patientName + ", doctorName="
				+ doctorName + ", date=" + date + ", time=" + time + ", prescription=" + prescription + ", confirmed="
				+ confirmed + "]";
	}

	public appointment(Integer appointment_id, String patientName, String doctorName, String date,
			String prescription,String confirmed,String time) {
		super();
		this.appointment_id = appointment_id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.prescription = prescription;
		this.confirmed=confirmed;
		this.time=time;
	}

	public Integer getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}

	public appointment() {}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	
	

	
}
