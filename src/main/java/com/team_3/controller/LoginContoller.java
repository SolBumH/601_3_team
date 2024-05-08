package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team_3.dto.UserDTO;
import com.team_3.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(UserDTO user) {
		return "redirect:/";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("list", loginService.list());
		return "test";
	}
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/";
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
