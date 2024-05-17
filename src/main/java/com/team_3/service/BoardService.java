package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	public int write(BoardDTO board) {
		return boardRepository.write(board);
	}

	public List<BoardDTO> getBoardList() {
		return boardRepository.boardList();
	}

	public BoardDTO getDetail(int no) {
		return boardRepository.getDetail(no);
	}

	public int deleteBoard(String board_no) {
		return boardRepository.deleteBoard(board_no);
	}

	public BoardDTO getAnswerContent(int board_ans_no) {
		return boardRepository.getAnswerContent(board_ans_no);
	}
}
