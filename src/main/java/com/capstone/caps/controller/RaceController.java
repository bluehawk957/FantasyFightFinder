package com.capstone.caps.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capstone.caps.entity.Race;
import com.capstone.caps.entity.SubRace;
import com.capstone.caps.entity.User;
import com.capstone.caps.repository.RaceRepository;
import com.capstone.caps.repository.SubRaceRepository;
import com.capstone.caps.repository.UserRepository;

@Controller
public class RaceController
{
	private RaceRepository raceRepository;
	private SubRaceRepository subRaceRepository;
	private UserRepository userRepository;
	
	@Autowired
	public RaceController(RaceRepository raceRepository, SubRaceRepository subRaceRepository, UserRepository userRepository)
	{
		super();
		this.raceRepository = raceRepository;
		this.subRaceRepository = subRaceRepository;
		this.userRepository = userRepository;
	}
	
	@ModelAttribute("race")
	Race race()
	{
		return new Race();
	}	
	
///////////////////////RacePage//////////////////////////
	@GetMapping("racePage")
	public String racePage(Model model)
	{
		model.addAttribute("race", (raceRepository.findAll()));
		return "racePage";
	}

///////////////////////RaceSelector//////////////////////////
	@GetMapping("raceSelector")
	String raceSelector(@RequestParam String race, Model model)
	{
		racePage(model);
		Race object = raceRepository.findByName(race);
		model.addAttribute("currentRace", object);
		model.addAttribute("currentSubraces", subRaceRepository.findById(object.getSubId()));
		return "racePage";
	}
	
///////////////////////SubRaceSelector//////////////////////////
	@GetMapping("subRaceSelector")
	String subRaceSelector(@RequestParam String subRace, Model model)
	{	
		SubRace object = subRaceRepository.findByName(subRace);
		raceSelector(raceRepository.findBySubId(object.getId()).getName(), model);	
		
		model.addAttribute("currentSubRace", object);
		return "racePage";
	}
	
///////////////////////AutoComplete//////////////////////////
	@RequestMapping(value="/nameAutoCompleteR")
	@ResponseBody
	public List<String> nameAutoCompleteR (@RequestParam(value="term", required=false, defaultValue="") String term)
	{
		List<String> suggestions = new ArrayList<String>();
		List<Race> all = raceRepository.findByNameContains(term);
		
		for(Race race : all)
			suggestions.add(race.getName());
		
		return suggestions;
	}
	
///////////////////////RaceSearch//////////////////////////
	@GetMapping("raceSearch")
	String raceSearch(@RequestParam String input, Model model)
	{
		racePage(model);
		Race object = raceRepository.findByName(input);
		model.addAttribute("currentRace", object);
		model.addAttribute("currentSubraces", subRaceRepository.findById(object.getSubId()));
		return "racePage";
	}
	
///////////////////////Add Favorite//////////////////////////
	@GetMapping("addFavRace")
	public String addFavRace(@SessionAttribute User loggedInUser, @RequestParam String item, Model model)
	{
		loggedInUser.setFavRaces(loggedInUser.concatRace(item));
		userRepository.save(loggedInUser);
		racePage(model);
		return "racePage";
	}

}
