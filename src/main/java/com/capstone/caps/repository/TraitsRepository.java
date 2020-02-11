package com.capstone.caps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.caps.entity.ClassTrait;

public interface TraitsRepository extends JpaRepository<ClassTrait, String>
{
	ClassTrait findByName(String name);
	ClassTrait findByNameIgnoreCase(String name);
	List<ClassTrait> findByNameContains(String name);
}
