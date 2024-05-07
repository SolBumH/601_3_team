package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team_3.dto.UserDTO;
import com.team_3.service.LoginService;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/loginPage")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginPost")
	// public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw) {
	public String login(UserDTO user) {
		System.out.println("id : " + user.getLogin_id());
		System.out.println("pw : " + user.getPassword());
		return "redirect:/index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("list", loginService.list());
		return "test";
	}
}
