package com.capstone.caps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.Race;
import com.capstone.caps.entity.SubRace;

public interface SubRaceRepository extends JpaRepository<SubRace, String>
{
	SubRace findByName(String name);
	
	@Query("FROM SubRace WHERE id=?1")
	List<SubRace> findById(int id);
}