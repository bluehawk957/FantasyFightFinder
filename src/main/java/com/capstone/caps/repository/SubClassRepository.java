package com.capstone.caps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.SubClass;
import com.capstone.caps.entity.SubRace;

public interface SubClassRepository extends JpaRepository<SubClass, String>
{
	SubClass findByName(String name);
	@Query("FROM SubClass WHERE id=?1")
	List<SubClass> findById(int id);
}