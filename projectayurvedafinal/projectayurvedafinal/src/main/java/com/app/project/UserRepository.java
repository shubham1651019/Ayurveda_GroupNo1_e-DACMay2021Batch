package com.app.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u from User u WHERE u.email = ?1")
	User findByEmail(String email);

	/*
	 * @Query("SELECT u from User u WHERE u.email = ?1") UserDoctor
	 * findByEmail(String email);
	 */

	

	void save(UserDoctor doctor);

	void save(Usertelecenter telecenter);
}
