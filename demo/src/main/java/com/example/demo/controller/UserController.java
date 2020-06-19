package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.SessionBag;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository urepo;

	// Style 1
	@GetMapping("/login")
	public String login(@ModelAttribute("user") User user,
			  HttpSession session) {
		user = new User();
		session.setAttribute("display", "FIRST VALUE");
		return "login";
	}

	@GetMapping("/save")
	public String save(@ModelAttribute("user") User user, Model model) {
		//if (user.getUserId()>0)
			urepo.save(user);
		List<User> users = urepo.findAll();
		model.addAttribute("users", users);
		return "userlist";
	}

	// Style 2
	@GetMapping("/login1")
	public String login1(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	// Style3
	@GetMapping("/login2")
	public String login2(Model model) {
		User user = (User) model.getAttribute("user");
		model.addAttribute("user", user);
		return "login";
	}

	// Style3
	@GetMapping("/about")
	public String about(@RequestParam("key") String key, HttpSession session) {
		String text = (String) session.getAttribute("display");
		System.out.println(text);
		return "about";
	}

	// Style3
	@GetMapping("/path/{id}")
	public String path(@PathVariable("id") String path) {
		System.out.println(path);
		return "about";
	}

}
