package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
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
		// 글 답변 여부 확인하기
		String ans_yn = adminRepository.getAnsYn(board);

		if (ans_yn.equals("1")) {
			board.setBoard_title(board.getBoard_no() + "번 글에 대한 답변입니다.");
			return adminRepository.answerPostInsert(board);
		} else {
			return adminRepository.answerPostUpdate(board);
		}
	}

	public int answerNumberUpdate(BoardDTO board) {
		if (board.getBoard_ans_no() == 0) {
			return 0;
		} else {
			return adminRepository.answerNumberUpdate(board);
		}
	}

	public String getAnswerContent(int board_no) {
		return adminRepository.getAnswerContent(board_no);
	}

	public List<CounselingFormDTO> getJMSangdamList() {
		return adminRepository.getJMSangdamList();
	}

	public List<CounselingFormDTO> getSangdamList(String no) {
		List<CounselingFormDTO> list = null;
		
		switch (no) {
			case "10": {
				break;
			} case "20": {
				list = adminRepository.getJMSangdamList();
				break;
			} case "30": {
				break;
			} case "40": {
				break;
			} case "50": {
				break;
			}
		}
		return list;
	}
}
