package com.capstone.caps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String email);
	@Query("FROM User WHERE lName=?1")
	List<User> findByName(String name);
	
}
