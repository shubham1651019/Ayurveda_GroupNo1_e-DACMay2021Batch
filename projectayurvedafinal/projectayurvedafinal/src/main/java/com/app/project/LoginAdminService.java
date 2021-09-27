package com.app.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAdminService {
	@Autowired
	private LoginAdminRepository repodoc1;
  
  public Admin login(String email, String password) {
	  Admin admin = repodoc1.findByEmailAndPassword(email, password);
  	return admin;
  }
  
}