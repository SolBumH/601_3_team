package com.team_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.UserDTO;
import com.team_3.service.BoardService;
import com.team_3.util.UserUtil;

@Controller
public class BoardController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public String board(Model model) {
		UserDTO user = userUtil.getUserNameAndRole();
		model.addAttribute("user", user);
		return "board";	
	}
	
	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = boardService.getBoardList();
		return list;
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		UserDTO user = userUtil.getUserNameAndRole();
		model.addAttribute("user", user);
		if (user.getRole().equals("ROLE_ANONYMOUS")) {
			return "redirect:/login";
		} else {
			return "write";
		}
	}
	
	@PostMapping("/write")
	public String write(BoardDTO board) {
		// 로그인이 안 된 사용자면 /board로 보내기
		if (userUtil.getUserRole().equals("ROLE_ANONYMOUS")) {
			return "redirect:/board";
		}
		int result = boardService.write(board);
		if (result == 1) {
			return "redirect:/board";
		} else {
			// 에러 시 에러 페이지 이동시키기
			return "redirect:/board";
		}
	}
	
	@PostMapping("/writeComplete")
	@ResponseBody
	public String write2(BoardDTO board) {
		System.out.println(board.toString());
		System.out.println("title : " + board.getBoard_title());
		System.out.println("content : " + board.getBoard_content());
		String role = userUtil.getUserRole();
		if (role.equals("ROLE_ANONYMOUS")) {
			return "0";
		} else {
			return "1";
		}
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam(name = "no") int no) {
		UserDTO user = userUtil.getUserData();
		// 로그인 안한 사람은 못보게 막음
		// 'or' 연산 시 앞이 true면 뒤의 연산은 하지 않기 때문에 순서도 잘 지정해야 함
		// == null 을 뒤로 밀면 user가 null 일 경우 nullpoint 에러 발생하여 null 체크를 우선으로 진행
		if (user == null || user.getRole().equals("ROLE_ANONYMOUS")) {
			return "redirect:/board?error=2";
		}
		
		// 해당 글 정보를 가져옴
		BoardDTO detail = boardService.getDetail(no);
		
		// 로그인 한 사람이 학생이 아니면 => 관리자, 교직원임
		// or 로그인 한 사람과 작성자가 같으면 통과
		if (!user.getRole().equals("ROLE_STUD") || user.getUser_no() == detail.getBoard_user()) {
			model.addAttribute("detail", detail);
			model.addAttribute("user", user);
			return "detail";
		} else {
			return "redirect:/board?error=1";
		}
	}
	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public int deleteBoard(@RequestParam(name = "board_no") String board_no) {
		System.out.println("board_no : " + board_no);
		int result = boardService.deleteBoard(board_no);
		return result;
	}
}
