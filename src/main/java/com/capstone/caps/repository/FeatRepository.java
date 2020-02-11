package com.capstone.caps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.caps.entity.CharClass;
import com.capstone.caps.entity.Feat;
import com.capstone.caps.entity.Race;

public interface FeatRepository extends JpaRepository<Feat, String>
{
	Feat findByName(String name);

	List<Feat> findByNameContains(String name);
}
