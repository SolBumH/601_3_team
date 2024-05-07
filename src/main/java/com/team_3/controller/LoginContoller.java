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

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginPost")
	public String login(UserDTO user) {
		return "redirect:/index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("list", loginService.list());
		return "test";
	}
	
	
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProc(UserDTO userDTO) {
		userDTO.setLogin_id(userDTO.getUsername());
		System.out.println(userDTO.toString());
		loginService.joinProcess(userDTO);
		return "redirect:/login";
	}
}
