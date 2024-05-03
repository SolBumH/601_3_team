package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team_3.dto.UserDTO;

@Controller
public class LoginContoller {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	// public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw) {
	public String login(UserDTO user) {
		System.out.println("id : " + user.getLoginId());
		System.out.println("pw : " + user.getPw());
		return "redirect:/login";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
