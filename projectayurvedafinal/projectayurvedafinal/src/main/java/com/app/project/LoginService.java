package com.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repodoc;
  
  public UserDoctor login(String email, String password) {
	  UserDoctor doctor = repodoc.findByEmailAndPassword(email, password);
  	return doctor;
  }
}
