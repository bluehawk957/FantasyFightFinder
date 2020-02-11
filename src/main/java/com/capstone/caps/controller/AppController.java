package com.capstone.caps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.capstone.caps.entity.CharClass;
import com.capstone.caps.entity.Feat;
import com.capstone.caps.entity.Race;
import com.capstone.caps.entity.User;
import com.capstone.caps.repository.CharClassRepository;
import com.capstone.caps.repository.FeatRepository;
import com.capstone.caps.repository.RaceRepository;
import com.capstone.caps.repository.SubClassRepository;
import com.capstone.caps.repository.SubRaceRepository;
import com.capstone.caps.repository.UserRepository;

@Controller
@SessionAttributes("loggedInUser")
public class AppController
{
	private UserRepository userRepository;
	private RaceRepository raceRepository;
	private FeatRepository featRepository;
	private CharClassRepository charClassRepository;
	private SubRaceRepository subRaceRepository;
	private SubClassRepository subClassRepository;
	
	@Autowired
	public AppController (UserRepository userRepository, CharClassRepository charClassRepository, SubRaceRepository subRaceRepository, RaceRepository raceRepository, FeatRepository featRepository)
	{
		super();
		this.featRepository = featRepository;
		this.charClassRepository = charClassRepository;
		this.raceRepository = raceRepository;
		this.userRepository = userRepository;
		this.subRaceRepository = subRaceRepository;
	}
	
	@ModelAttribute("race")
	Race race()
	{
		return new Race();
	}	
	
	@GetMapping("index")
	public String index(Model model) 
	{	
		model.addAttribute("msg", "Welcome to the thunderdome");
		model.addAttribute("users", (userRepository.findAll()));
		return "index";
	}
	
	@GetMapping("about")
	public String about(Model model)
	{
		model.addAttribute("first", "<h1>Hello There</h1>");
		model.addAttribute("second", "<h2>We like build code i guess</h2>");
	
		return "about";
	}
	
	@GetMapping("map")
	public String map(@SessionAttribute User loggedInUser, Model model)
	{
		model.addAttribute("users", (userRepository.findAll()));
		model.addAttribute("favRaces", loggedInUser.parseByComma(loggedInUser.getFavRaces()));
		model.addAttribute("favFeats", loggedInUser.parseByComma(loggedInUser.getFavFeats()));
		model.addAttribute("favClasses", loggedInUser.parseByComma(loggedInUser.getFavClasses()));
		
		return "map";
	}
	
	@GetMapping("storeMark")
	public String storeMark(@SessionAttribute User loggedInUser, @RequestParam String coords, Model model)
	{
		model.addAttribute("users", (userRepository.findAll()));
		//{
			System.out.println(coords);
			coords = coords.replace("(", "");
			coords = coords.replace(")", "");
			String[] parsedLine = coords.split(",");
			
			loggedInUser.setLat(Double.parseDouble(parsedLine[0]));
			loggedInUser.setLon(Double.parseDouble(parsedLine[1]));
			userRepository.save(loggedInUser);
		//}

		return "map";
		//return new ResponseEntity<String>("Succesfully added Marker", HttpStatus.OK); ResponseEntity<String>
	}
	
	@GetMapping("name")
	public String name(@RequestParam String id, Model model) 
	{	
		model.addAttribute("anything", id);
		return "index";
	}
	
	@GetMapping("spells")
	public String spells(Model model) 
	{	
		model.addAttribute("msg", "Spells coming soon to a webpage near you!");
		return "spells";
	}
	
	
///////////////////////Search//////////////////////////
	/*
	 * public List<String> search(String input) { ArrayList<String> last = new
	 * ArrayList<String>(); ArrayList<String> all = new ArrayList<String>();
	 * ArrayList<Race> temp1 = (ArrayList<Race>) raceRepository.findAll();
	 * ArrayList<Feat> temp2 = (ArrayList<Feat>) featRepository.findAll(); for(Race
	 * race : temp1) all.add(race.getName()); for(Feat feat : temp2)
	 * all.add(feat.getName());
	 * 
	 * for(int i=0;i<all.size();i++) if(all.get(i).equals(input)==true)
	 * last.add(all.get(i));
	 * 
	 * return last; }
	 */
	
///////////////////////AutoComplete//////////////////////////
	@RequestMapping(value="/nameAutoCompleteA")
	@ResponseBody
	public List<String> nameAutoCompleteA (@RequestParam(value="term", required=false, defaultValue="") String term)
	{
		List<String> suggestions = new ArrayList<String>();
		List<Race> allR = raceRepository.findByNameContains(term);
		List<CharClass> allC = charClassRepository.findByNameContains(term);
		List<Feat> allF = featRepository.findByNameContains(term);
		
		for(Race race : allR)
		suggestions.add(race.getName());
		
		for(CharClass charClass : allC)
		suggestions.add(charClass.getName());
		
		for(Feat feat : allF)
		suggestions.add(feat.getName());
		
		return suggestions;
	}	
	
///////////////////////AllSearch//////////////////////////
	@GetMapping("allSearch")
	String allSearch(@RequestParam String input, Model model)
	{
		Race objectR = raceRepository.findByName(input);
		Feat objectF = featRepository.findByName(input);
		CharClass objectC = charClassRepository.findByName(input);
		

		if(objectR != null)
		{
			model.addAttribute("currentRace", objectR);
			model.addAttribute("currentSubraces", subRaceRepository.findById(objectR.getSubId()));
			return "racePage";
		}
		
		if(objectF != null)
		{
			model.addAttribute("currentObject", objectF);
			return "featsPage";
		}
		
		if(objectC != null)
		{
			model.addAttribute("currentClass", objectC);
			model.addAttribute("currentSubClasses", objectC.subClassParse(objectC.getSubClasses()));
			return "classPage";
		}
		
		return "index";
	}	
	
}
