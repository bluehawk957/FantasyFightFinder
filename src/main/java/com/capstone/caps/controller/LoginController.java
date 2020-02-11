package com.capstone.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.caps.entity.User;
import com.capstone.caps.repository.UserRepository;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController
{
	private UserRepository userRepository;
	
	@Autowired
	public LoginController(UserRepository userRepository)
	{
		super();
		this.userRepository = userRepository;
	}

	@ModelAttribute("user")
	User user()
	{
		return new User();
	}
	
	
	///////////////////////REGISTER//////////////////////////
	@GetMapping("thankyou")
	public String thankyou(Model model)
	{
		model.addAttribute("msg", "Thank you for Registering!");
		return "thankyou";
	}

	
	@PostMapping("register")
	public String register(@ModelAttribute User user, RedirectAttributes model) {

		userRepository.save(user);
	    model.addFlashAttribute("success", "User "+user.getfName()+" saved");
	    return "redirect:/thankyou";
	}
	
///////////////////////LOGINS//////////////////////////
	@GetMapping("login")
	public String login(Model model)
	{
		model.addAttribute("action", "register");
		return "login";
	}
	
	@PostMapping("login")
	public String signIn(@RequestParam String email, @RequestParam String password,  WebRequest request, Model model )
	{
		User user=userRepository.findByEmail(email);
	
		if(user !=null && password.equals(user.getPassword()))
		{
			model.addAttribute("msg", "Welcome "+email);
			model.addAttribute("loggedInUser", user);
			request.setAttribute("loggedInUser", user, WebRequest.SCOPE_SESSION);
			
		}
		else
		{
			model.addAttribute("error", "Invalid credentials");
			return "login";
		}
		return "index";
	}	

	
	///////////////////////DELETE//////////////////////////
	@GetMapping("delete")
	public String deleteUser(@RequestParam long id, RedirectAttributes redirect)
	{
		userRepository.deleteById(id);
		redirect.addFlashAttribute("success", "Delete Success");
		return "redirect:/index";
	}
	
	///////////////////////UPDATE//////////////////////////
	@GetMapping("update")
	public String updateUser(@RequestParam long id, Model model)
	{
		userRepository.findById(id);
		model.addAttribute("msg", "Updated");
		model.addAttribute("user", userRepository.findById(id));
		model.addAttribute("action", "updateUser");
		return "register";
	}
	
	@PostMapping("updateUser")
	public String update(@ModelAttribute User user, RedirectAttributes model) 
	{
		User usr = userRepository.findByEmail(user.getEmail());
		usr.setfName(user.getfName());
		usr.setlName(user.getlName());
		userRepository.save(usr);
	    model.addFlashAttribute("success", "User "+user.getfName()+" is updated");
	    return "redirect:/index";
	}
	
	///////////////////////SEARCH//////////////////////////
	@PostMapping("search")
	public String search(@RequestParam String name, Model model)
	{
		
		model.addAttribute("msg", userRepository.findByName(name).size() + " users found");
		model.addAttribute("user", userRepository.findByName(name));
		return "index";
	}
	
	
///////////////////////LOG OUTS//////////////////////////
	@GetMapping("logout")
	public String logout(Model model, WebRequest request, 
	SessionStatus status, RedirectAttributes redirect) 
	{
		status.setComplete();
		request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
		redirect.addFlashAttribute("msg", "You have been signed out");
		return "redirect:/index";
	}
	
	
///////////////////////LOGIN Profile//////////////////////////
	@GetMapping("profile")
	public String profile(Model model)
	{
		model.addAttribute("msg", "Welcome Back");
		return "profile";
	}
	
///////////////////////USERS//////////////////////////
	@GetMapping("users")
	public String users(Model model)
	{
		model.addAttribute("msg", "The users page");
		model.addAttribute("users", (userRepository.findAll()));
		return "users";
	}

	
	@GetMapping("services")
	public String services(Model model)
	{
		model.addAttribute("first", "<h1>We have services</h1>");

	
		return "services";
	}
	

}
