package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GridTestController {
	@GetMapping("/gridtest")
	
	public String grid(Model model) {
		return "gridtest";
	}
	
}
