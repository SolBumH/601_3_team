package com.team_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
import com.team_3.service.AdminService;
import com.team_3.util.UserUtil;

@Controller
public class AdminController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping({"/admin", "/admin/index"})
	public String index(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminIndex";
	}
	
	@GetMapping({"/adminboard", "/admin/board"})
	public String board(Model model) {
		List<BoardDTO> list = adminService.AdminBoard();
		model.addAttribute("user", userUtil.getUserNameAndRole());
		model.addAttribute("list", list);
		return "admin/adminboard";
	}

	@GetMapping("/admin/boardList")
	@ResponseBody
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = adminService.AdminBoard();
		return list;
	}
}
