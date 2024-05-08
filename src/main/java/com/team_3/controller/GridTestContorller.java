package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GridTestContorller {
	@GetMapping("gridtest")
	public String grid() {
		return "gridtest";
	}
}
