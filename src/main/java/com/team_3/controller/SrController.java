package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SrController {
	@GetMapping("/srconsulting")
	public String sd(Model model) {
		return "srconsulting";
	}
	
	@PostMapping("/SrController")
	@ResponseBody
	public String arg(@RequestBody String arg) {
		System.out.println(arg);
		return "srcunsulting";
	}
}
