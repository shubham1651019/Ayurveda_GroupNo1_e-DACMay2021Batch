package com.app.project;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginAdminRepository extends JpaRepository<Admin, Long>{
	Admin findByEmailAndPassword(String email, String password);

}