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
import com.team_3.service.MypageService;
import com.team_3.util.UserUtil;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private MypageService mypageService;

	@GetMapping({"", "/"})
	public String mypage(Model model) {
		UserDTO user = userUtil.getUserData();
		model.addAttribute("user", user);
		
		return "mypage/mypage";
	}
	
	@GetMapping("/board")
	public String mypageBoard(Model model) {
		UserDTO user = userUtil.getUserData();
		model.addAttribute("user", user);
		return "mypage/mypageBoard";
	}
	
	// 글 목록 가져오기
	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> mypageBoardList() {
		UserDTO user = userUtil.getUserData();
		List<BoardDTO> list = mypageService.mypageBoardList(user);
		return list;
	}
	
	@PostMapping("/boardDelete")
	@ResponseBody
	public int boardDelete(@RequestParam(name="board_no") int board_no) {
		int result = mypageService.boardDelete(board_no);
		
		return result;
	}
	
	@GetMapping("/mysangdam")
	public String mypageSangdam(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		return "mypage/mypageSangdam";
	}
}
