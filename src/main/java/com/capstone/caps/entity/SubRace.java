package com.capstone.caps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="sub_race")
public class SubRace
{
	@Id
	@Column(name="name")
	private String name;
	@Column(name="asi")
	private String asi;
	@Column(name="languages")
	private String languages;
	@Column(name="race_id")
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
	public String getAsi()
	{
		return asi;
	}
	public void setAsi(String asi)
	{
		this.asi = asi;
	}
	public String getLanguages()
	{
		return languages;
	}
	public void setLanguages(String languages)
	{
		this.languages = languages;
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
	
	public String[] subRaceParse(String traits)
	{
		String[] parsedLine = traits.split("%");
		
		return parsedLine;		
	}
}