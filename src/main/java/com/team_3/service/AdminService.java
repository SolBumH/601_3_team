package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.UserDTO;
import com.team_3.repository.AdminRepository;
@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<BoardDTO> AdminBoard() {
		return adminRepository.AdminBoard();
	}

	public List<UserDTO> AdminUser() {
		return adminRepository.AdminUser();
	}

	public int updateBoardDel(BoardDTO board) {
		return adminRepository.updateBoardDel(board);
	}

	public int userUpdate(UserDTO dto) {
		return adminRepository.userUpdate(dto);
	}

	public int answerPost(BoardDTO board) {
		board.setBoard_title("└ " + board.getBoard_no() + "번 글에 대한 답변입니다.");
		
		return adminRepository.answerPost(board);
	}

}
