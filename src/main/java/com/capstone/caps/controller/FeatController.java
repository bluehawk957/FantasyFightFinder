package com.capstone.caps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.capstone.caps.entity.Feat;
import com.capstone.caps.entity.Race;
import com.capstone.caps.entity.User;
import com.capstone.caps.repository.FeatRepository;
import com.capstone.caps.repository.RaceRepository;
import com.capstone.caps.repository.UserRepository;

@Controller
@SessionAttributes("loggedInUser")
public class FeatController
{
	private FeatRepository featRepository;
	private UserRepository userRepository;
	
	@Autowired
	public FeatController(FeatRepository featRepository, UserRepository userRepository)
	{
		super();
		this.featRepository = featRepository;
		this.userRepository = userRepository;
	}
	
	@ModelAttribute("feat")
	Feat feat()
	{
		return new Feat();
	}
		
///////////////////////FeatsPage//////////////////////////
	@GetMapping("featsPage")
	public String featsPage(Model model)
	{
		model.addAttribute("feats", (featRepository.findAll()));
		return "featsPage";
	}
	
///////////////////////FeatSelector//////////////////////////
	@GetMapping("featSelector")
	public String featSelector(@RequestParam String feat, Model model)
	{
		System.out.println(feat);
	featsPage(model);
	model.addAttribute("currentObject", featRepository.findByName(feat));
	return "featsPage";
	}
	
///////////////////////FeatSearch//////////////////////////
	@GetMapping("featSearch")
	String featSearch(@RequestParam String input, Model model)
	{
		featsPage(model);
		Feat object = featRepository.findByName(input);
		model.addAttribute("currentObject", object);
		return "featsPage";
	}

///////////////////////Add Favorite//////////////////////////
	@GetMapping("addFavFeat")
	public String addFavFeat(@SessionAttribute User loggedInUser, @RequestParam String item, Model model)
	{
		loggedInUser.setFavFeats(loggedInUser.concatFeat(item));
		userRepository.save(loggedInUser);
		featsPage(model);
		return "featsPage";
	}

	@RequestMapping(value="/nameAutoCompleteF")
	@ResponseBody
	public List<String> nameAutoCompleteF (@RequestParam(value="term", required=false, defaultValue="") String term)
	{
		List<String> suggestions = new ArrayList<String>();
		List<Feat> all = featRepository.findByNameContains(term);
		
		for(Feat feat : all)
			suggestions.add(feat.getName());
		
		return suggestions;
	}
}
