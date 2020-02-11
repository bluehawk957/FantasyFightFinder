package com.capstone.caps.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name="user")
public class User
{
	@Column(name="l_name")
	private String lName;
	@Column(name="f_name")
	private String fName;
	@Id
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Transient
	private String repeatPass;
	@Column(name="dm")
	private boolean dm;
	@Column(name="lat")
	private double lat;
	@Column(name="lon")
	private double lon;
	@Column(name="fav_feat")
	private String favFeats;
	@Column(name="fav_class")
	private String favClasses;
	@Column(name="fav_race")
	private String favRaces;
	
	@Override
	public String toString()
	{
		return "User [lName=" + lName + ", fName=" + fName + ", email=" + email
				+ ", password=" + password + ", repeatPass=" + repeatPass + "]";
	}
	public String getlName()
	{
		return lName;
	}
	public void setlName(String lName)
	{
		this.lName = lName;
	}
	public String getfName()
	{
		return fName;
	}
	public void setfName(String fName)
	{
		this.fName = fName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getRepeatPass()
	{
		return repeatPass;
	}
	public void setRepeatPass(String repeatPass)
	{
		this.repeatPass = repeatPass;
	}
	public boolean isDm()
	{
		return dm;
	}
	public void setDm(boolean dm) {
		this.dm = dm;
	}
	public double getLat()
	{
		return lat;
	}
	public void setLat(double lat)
	{
		this.lat = lat;
	}
	public double getLon()
	{
		return lon;
	}
	public void setLon(double lon)
	{
		this.lon = lon;
	}
	public String getFavFeats()
	{
		return favFeats;
	}
	public void setFavFeats(String favFeats)
	{
		this.favFeats = favFeats;
	}
	public String getFavClasses()
	{
		return favClasses;
	}
	public void setFavClasses(String favClasses)
	{
		this.favClasses = favClasses;
	}
	public String getFavRaces()
	{
		return favRaces;
	}
	public void setFavRaces(String favRaces)
	{
		this.favRaces = favRaces;
	}
	
	public String checkDm()
	{
		if(this.dm==true)
			return "DM";
		return null;
	}
	
	public String concatFeat(String add)
	{
		if(this.favFeats==null)
			return add;
		
		this.favFeats += ","+add;
		
		return this.favFeats;
	}
	public String concatClass(String add)
	{
		if(this.favClasses==null)
			return add;
		
		this.favClasses += ","+add;
		
		return this.favClasses;
	}
	public String concatRace(String add)
	{
		if(this.favRaces==null)
			return add;
		
		this.favRaces += ","+add;
		
		return this.favRaces;
	}
	
	public List<String> parseByComma(String traits)
	{
		if(traits==null)
			return null;
			
		String[] parsedLine = traits.split(",");		
		return Arrays.asList(parsedLine);		
	}
	
}
