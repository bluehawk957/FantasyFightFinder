package com.capstone.caps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="race")
public class Race
{
	@Id
	@Column(name="name")
	private String name;
	@Column(name="asi")
	private String asi;
	@Column(name="size")
	private String size;
	@Column(name="speed")
	private String speed;
	@Column(name="sub_id")
	private int subId;
	@Column(name="languages")
	private String languages;
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
	public String getSize()
	{
		return size;
	}
	public void setSize(String size)
	{
		this.size = size;
	}
	public String getSpeed()
	{
		return speed;
	}
	public void setSpeed(String speed)
	{
		this.speed = speed;
	}
	public int getSubId()
	{
		return subId;
	}
	public void setSubId(int subId)
	{
		this.subId = subId;
	}
	public String getLanguages()
	{
		return languages;
	}
	public void setLanguages(String languages)
	{
		this.languages = languages;
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

	
	public String[] raceParse(String traits)
	{
		String[] parsedLine = traits.split("%");
		
		return parsedLine;		
	}

}
