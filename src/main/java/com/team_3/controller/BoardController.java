package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
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
		model.addAttribute("user", userUtil.getUserNameAndRole());
		// 게시글 목록 불러오기
		model.addAttribute("list", boardService.boardList());
		return "board";	
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "write";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO board) {
		// 로그인이 안 된 사용자면 /board로 보내기
		if (userUtil.getUsername().equals("anonymousUser")) {
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
		return "1";
	}
}
