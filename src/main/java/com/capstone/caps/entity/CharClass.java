package com.capstone.caps.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="char_class")
public class CharClass
{
	@Id
	@Column(name="name")
	private String name;
	@Column(name="hit_die")
	private String hitDie;
	@Column(name="weapon_prof")
	private String weaponProf;
	@Column(name="armor_prof")
	private String armorProf;
	@Column(name="saving_throws")
	private String saves;
	@Column(name="skills")
	private String skills;
	@Column(name="equipment")
	private String equipment;
	@Column(name="traits")
	private String traits;
	@Column(name="sub_classes")
	private String subClasses;
	@Column(name="id")
	private int classId;
	@Column(name="tools")
	private String tools;
	@Column(name="asi")
	private String asi;
	@Column(name="num_skills")
	private String skillAmount;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getHitDie()
	{
		return hitDie;
	}
	public void setHitDie(String hitDie)
	{
		this.hitDie = hitDie;
	}
	public String getWeaponProf()
	{
		return weaponProf;
	}
	public void setWeaponProf(String weaponProf)
	{
		this.weaponProf = weaponProf;
	}
	public String getArmorProf()
	{
		return armorProf;
	}
	public void setArmorProf(String armorProf)
	{
		this.armorProf = armorProf;
	}
	public String getSaves()
	{
		return saves;
	}
	public void setSaves(String saves)
	{
		this.saves = saves;
	}
	public String getSkills()
	{
		return skills;
	}
	public void setSkills(String skills)
	{
		this.skills = skills;
	}
	public String getEquipment()
	{
		return equipment;
	}
	public void setEquipment(String equipment)
	{
		this.equipment = equipment;
	}
	public String getSubClasses()
	{
		return subClasses;
	}
	public void setSubClasses(String subClasses)
	{
		this.subClasses = subClasses;
	}
	public int getId()
	{
		return classId;
	}
	public void setId(int id)
	{
		this.classId = id;
	}
	public String getTools()
	{
		return tools;
	}
	public void setTools(String tools)
	{
		this.tools = tools;
	}
	public String getAsi()
	{
		return asi;
	}
	public void setAsi(String asi)
	{
		this.asi = asi;
	}
	public String getSkillAmount()
	{
		return skillAmount;
	}
	public void setSkillAmount(String skillAmount)
	{
		this.skillAmount = skillAmount;
	}
	public String getTraits()
	{
		return traits;
	}
	public void setTraits(String traits)
	{
		this.traits = traits;
	}
	
	public List<String> subClassParse(String subClasses)
	{
		String[] parsedLine = subClasses.split(",");		
		return Arrays.asList(parsedLine);		
	}
	
	public List<String> traitsParse(String traits)
	{
		String[] parsedLine = traits.split(",");		
		return Arrays.asList(parsedLine);		
	}
	
	public List<String> parseByPercent(String traits)
	{
		String[] parsedLine = traits.split("%");		
		return Arrays.asList(parsedLine);		
	}
	
	public List<String> parseByComma(String traits)
	{
		String[] parsedLine = traits.split(",");		
		return Arrays.asList(parsedLine);		
	}
}