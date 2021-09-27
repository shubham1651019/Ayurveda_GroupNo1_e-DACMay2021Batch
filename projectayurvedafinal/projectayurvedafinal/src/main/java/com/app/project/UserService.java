package com.app.project;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	@Autowired
    private UserRepository repouser;

	public void delete(long id) {
		// TODO Auto-generated method stub
		repouser.deleteById(id);
	}
	
}