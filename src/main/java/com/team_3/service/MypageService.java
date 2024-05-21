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

	public List<CounselingFormDTO> sangdamList(UserDTO user, String no) {
		List<CounselingFormDTO> list = null;
		switch (no) {
		case "10":
			break;
		case "20":
			list = mypageRepository.jmSangdamList(user);
			break;
		case "30":
			break;
		case "40":
			break;
		case "50":
			break;
		}
		
		return list;
	}

	public int cancelSangdam(String sangdamNo, int no) {
		int result = 0;
		switch (sangdamNo) {
		case "10":
			break;
		case "20":
			result = mypageRepository.cancelSangdam(no);
			break;
		case "30":
			break;
		case "40":
			break;
		case "50":
			break;
		}
		
		return result;
	}
}
