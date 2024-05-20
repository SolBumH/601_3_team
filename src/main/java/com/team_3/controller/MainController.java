package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team_3.util.UserUtil;

@Controller
public class MainController {
	
	@Autowired
	private UserUtil userUtil;

	@GetMapping({"/index", "/"})
	public String index(Model model) {
//		model.addAttribute("id", userUtil.getUsername());
//		model.addAttribute("role", userUtil.getUserRole());
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "index";
	}
	
	@GetMapping("departmentsInfo")
	public String info(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		return "departments";
	}
}
