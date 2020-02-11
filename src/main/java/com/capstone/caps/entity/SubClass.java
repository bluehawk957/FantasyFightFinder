package com.capstone.caps.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="sub_class")
public class SubClass
{
	@Id
	@Column(name="name")
	private String name;
	@Column(name="class_id")
	private int id;
	@Column(name="traits")
	private String traits;
	@Column(name="ref_book")
	private String refBook;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTraits()
	{
		return traits;
	}
	public void setTraits(String traits)
	{
		this.traits = traits;
	}
	public String getRefBook()
	{
		return refBook;
	}
	public void setRefBook(String refBook)
	{
		this.refBook = refBook;
	}
	
	public List<String> parseByComma(String traits)
	{
		String[] parsedLine = traits.split(",");		
		return Arrays.asList(parsedLine);		
	}
}