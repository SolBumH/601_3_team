package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.UserDTO;
import com.team_3.repository.MypageRepository;

@Service
public class MypageService {
	
	@Autowired
	private MypageRepository mypageRepository;

	public List<BoardDTO> mypageBoardList(UserDTO user) {
		return mypageRepository.mypageBoardList(user);
	}

	public int boardDelete(int board_no) {
		return mypageRepository.boardDelete(board_no);
	}

	public List<CounselingFormDTO> sangdamList(UserDTO user) {
		return mypageRepository.sangdamList(user);
	}
}
