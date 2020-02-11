package com.capstone.caps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity	
@Table(name="feats")
public class Feat
{
	@Id
	@Column(name="name")
	private String name;
	@Column(name="asi")
	private String asi;
	@Column(name="pre_req")
	private String preReqs;
	@Column(name="traits")
	private String traits;

	
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
	public String getPreReqs()
	{
		return preReqs;
	}
	public void setPreReqs(String preReqs)
	{
		this.preReqs = preReqs;
	}
	public String getTraits()
	{
		return traits;
	}
	public void setTraits(String traits)
	{
		this.traits = traits;
	}
	
	public String[] featParse(String traits)
	{
		String[] parsedLine = traits.split("%");
		
		return parsedLine;		
	}
}


	