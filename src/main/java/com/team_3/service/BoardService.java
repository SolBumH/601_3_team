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

	public List<BoardDTO> boardList() {
		return boardRepository.boardList();
	}
}
