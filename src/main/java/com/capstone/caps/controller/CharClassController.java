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

import com.capstone.caps.entity.CharClass;
import com.capstone.caps.entity.ClassTrait;
import com.capstone.caps.entity.Race;
import com.capstone.caps.entity.SubClass;
import com.capstone.caps.entity.SubRace;
import com.capstone.caps.entity.User;
import com.capstone.caps.repository.CharClassRepository;
import com.capstone.caps.repository.SubClassRepository;
import com.capstone.caps.repository.TraitsRepository;
import com.capstone.caps.repository.UserRepository;

@Controller
public class CharClassController
{
	private CharClassRepository charClassRepository;
	private SubClassRepository subClassRepository;
	private TraitsRepository traitsRepository;
	private UserRepository userRepository;
	
	@Autowired
	public CharClassController(CharClassRepository charClassRepository, SubClassRepository subClassRepository, TraitsRepository traitsRepository, UserRepository userRepository)
	{
		super();
		this.charClassRepository = charClassRepository;
		this.subClassRepository = subClassRepository;
		this.traitsRepository = traitsRepository;
		this.userRepository = userRepository;
	}
	
	@ModelAttribute("charClass")
	CharClass charClass()
	{
		return new CharClass();
	}	
	
///////////////////////ClassPage//////////////////////////
	@GetMapping("classPage")
	public String classPage(Model model)
	{
		model.addAttribute("charClass", (charClassRepository.findAll()));
		return "classPage";
	}
	
///////////////////////classSelector//////////////////////////
	@GetMapping("charClassSelector")
	String charClassSelector(@RequestParam String charClass, Model model)
	{
		classPage(model);
		CharClass object = charClassRepository.findByName(charClass); 
		List<ClassTrait> traits = new ArrayList<>();
		
		object.traitsParse(object.getTraits())
			.forEach(trait -> {
				if(trait != null) {
					ClassTrait something = traitsRepository.findByNameIgnoreCase(trait.trim());

					if(something != null)
						traits.add(something);
				}
				
			});
		System.out.print("test test size: "+traits.size()); 
		model.addAttribute("currentClass", object);
		model.addAttribute("currentSubClasses", object.subClassParse(object.getSubClasses()));
		model.addAttribute("currentTraits", traits);
		//need to call the repository to match the objects with the  names
		//model.addAttribute("currentSubClasses", subClassRepository.findById(object.getId()));
		return "classPage";
	}
	
///////////////////////SubClassSelector//////////////////////////
	@GetMapping("subClassSelector")
	String subClassSelector(@RequestParam String subClass, Model model)
	{	
		//charClassSelector(cHolder, model);	
		SubClass object = subClassRepository.findByName(subClass);
		charClassSelector(charClassRepository.findByClassId(object.getId()).getName(), model);
		List<ClassTrait> traits = new ArrayList<>();
		
		object.parseByComma(object.getTraits()).forEach(trait -> 
			{			
				if(trait != null) 
				{
					ClassTrait something = traitsRepository.findByNameIgnoreCase(trait.trim());

					if(something != null)
						traits.add(something);
				}

			});
		model.addAttribute("currentSubClass", object);
		model.addAttribute("currentSubTraits", traits);
		return "classPage";
	}
	
///////////////////////Add Favorite//////////////////////////
	@GetMapping("addFavClass")
	public String addFavClass(@SessionAttribute User loggedInUser, @RequestParam String item, Model model)
	{
		loggedInUser.setFavClasses(loggedInUser.concatClass(item));
		userRepository.save(loggedInUser);
		classPage(model);
		return "classPage";
	}
	
///////////////////////AutoComplete//////////////////////////
	@RequestMapping(value="/nameAutoCompleteC")
	@ResponseBody
	public List<String> nameAutoCompleteC (@RequestParam(value="term", required=false, defaultValue="") String term)
	{
		List<String> suggestions = new ArrayList<String>();
		List<CharClass> all = charClassRepository.findByNameContains(term);
		
		for(CharClass charClass : all)
		suggestions.add(charClass.getName());
		
		return suggestions;
	}
}
