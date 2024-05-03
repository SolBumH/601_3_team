package com.team_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team_3.dto.UserDTO;
import com.team_3.service.LoginService;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	// public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw) {
	public String login(UserDTO user) {
		System.out.println("id : " + user.getLoginid());
		System.out.println("pw : " + user.getPw());
		List<UserDTO> dto = loginService.findByLoginid(user.getLoginid(), user.getPw());
		System.out.println(dto);
		System.out.println(dto.size());
		return "redirect:/login";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
