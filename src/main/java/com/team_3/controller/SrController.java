package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.util.UserUtil;

@Controller
public class SrController {
	
	@Autowired
	private UserUtil userUtil;
	
	@GetMapping("/srconsulting")
	public String sd(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "srconsulting";
	}
	
	@PostMapping("/SrController")
	@ResponseBody
	public String arg(@RequestParam(name = "start") String start) {
		System.out.println(start);
		return "srcunsulting";
	}
}
