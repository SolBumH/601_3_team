package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping({"/admin", "/admin/index"})
	public String index() {
		return "admin/adminIndex";
	}

}
