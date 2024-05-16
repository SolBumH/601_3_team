package com.team_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping({"/index" , ""})
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

	// 게시글 관리의 글 가져오는 컨트롤러
	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = adminService.AdminBoard();
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
		//System.out.println(list);
		return list;
	}
	
	@GetMapping("/Group")
	public String adminGroup(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminGroup";
	}
	
	@GetMapping("/Counseling")
	public String counseling(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminCounseling";
	}
	
	@GetMapping("/charts")
	public String charts(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/admincharts";
	}
	
	// 관리자페이지 글 상태 변경 메소드
	@GetMapping("/updateBoardDel")
	@ResponseBody
	public String updateBoardDel(BoardDTO board) {
		System.out.println("no + " + board.getBoard_no() + " del : " + board.getDel_yn());
		int result = adminService.updateBoardDel(board);
		return String.valueOf(result);
	}
	
	@PostMapping("/userUpdate")
	@ResponseBody
	public int userUpdate(UserDTO dto) {
		int result = adminService.userUpdate(dto);
		System.out.println(result);
		return result;
	}
}
