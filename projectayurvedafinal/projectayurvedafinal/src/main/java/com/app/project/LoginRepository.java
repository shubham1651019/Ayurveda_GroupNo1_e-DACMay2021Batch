package com.app.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserDoctor, Long>{
	UserDoctor findByEmailAndPassword(String email, String password);
 
}