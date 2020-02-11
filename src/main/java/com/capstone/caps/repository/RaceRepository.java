package com.capstone.caps.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.Race;

public interface RaceRepository extends JpaRepository<Race, String>
{
	Race findByName(String name);
	
	Race findBySubId(int subId);	
	
	@Query("FROM Race WHERE id=?1")
	List<Race> findById(int id);
	
	

	List<Race> findByNameContains(String name);
}
