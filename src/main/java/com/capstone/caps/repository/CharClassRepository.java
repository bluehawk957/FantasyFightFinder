package com.capstone.caps.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.CharClass;
import com.capstone.caps.entity.Race;


public interface CharClassRepository extends JpaRepository<CharClass, String>
{
	CharClass findByName(String name);
	CharClass findByClassId(int classId);	
	
	@Query("FROM CharClass WHERE id=?1")
	List<CharClass> findById(int id);
	

	List<CharClass> findByNameContains(String name);
}
