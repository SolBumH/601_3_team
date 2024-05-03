package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SrController {
	@GetMapping("/srconsulting")
	public String sd(Model model) {
		return "srconsulting";
	}
}
