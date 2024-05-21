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
	
	public String findStudentNumber(String username) {
		return mypageRepository.findStudentNumber(username);
	}

	public String findStud_dept(String username) {
		return mypageRepository.findStud_dept(username);
	}

	public String findPhone(String username) {
		return  mypageRepository.findPhone(username);
	}
}
