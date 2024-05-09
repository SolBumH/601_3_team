package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team_3.util.UserUtil;

@Controller
public class BoardController {
	
	@Autowired
	private UserUtil userUtil;

	@GetMapping("/board")
	public String board(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		return "board";	
	}
}
