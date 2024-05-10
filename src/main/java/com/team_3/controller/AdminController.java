package com.team_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.UserDTO;
import com.team_3.service.AdminService;
import com.team_3.util.UserUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminIndex";
	}
	
	@GetMapping("/board")
	public String board(Model model) {
		List<BoardDTO> list = adminService.AdminBoard();
		model.addAttribute("user", userUtil.getUserNameAndRole());
		model.addAttribute("list", list);
		return "admin/adminboard";
	}

	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = adminService.AdminBoard();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/user")
	public String member(Model model) {
		List<UserDTO> list = adminService.AdminUser();
		model.addAttribute("list", list);
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminuser";
	}
	
	@GetMapping("/userList")
	@ResponseBody
	public List<UserDTO> userList(Model model) {
		List<UserDTO> list = adminService.AdminUser();
		System.out.println(list);
		return list;
	}
}
