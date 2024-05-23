package com.team_3.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.GroupDTO;
import com.team_3.dto.UserDTO;
import com.team_3.repository.AdminRepository;
import com.team_3.util.UserUtil;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserUtil userUtil;

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
				list = adminRepository.getJKSangdamList();
				break;
			} case "20": {
				list = adminRepository.getJMSangdamList();
				break;
			} case "30": {
				list = adminRepository.getSRSangdamList();
				break;
			} case "40": {
				list = adminRepository.getJCSangdamList();
				break;
			} case "50": {
				break;
			}
		}
		return list;
	}

	public int changeRSVT(String sangdamNo, int no, String yn) {
		int result = 0;
		CounselingFormDTO dto = new CounselingFormDTO();
		dto.setRSVT_YN(yn);
		
		switch (sangdamNo) {
			case "10":
				dto.setJKS_NO(no);
				result = adminRepository.changeJKSRSVT(dto);
				break;
			case "20":
				dto.setJMS_NO(no);
				result = adminRepository.changeJMSRSVT(dto);
				break;
			case "30":
				break;
			case "40":
				break;
		}
		
		return result;
	}

	public int approval(String sangdamNo, int no, String yn, String rs_date, String rs_time) throws ParseException {
		int result = 0;
		CounselingFormDTO dto = new CounselingFormDTO();
		dto.setRSVT_YN(yn);
		dto.setRS_CF(rs_date);
		dto.setRS_CF_TIME(rs_time);
		dto.setST_NO(userUtil.getUserData().getUser_no());
		System.out.println(dto.getST_NO());
		
		switch (sangdamNo) {
			// 교수
			case "10":
				dto.setJKS_NO(no);
				result = adminRepository.changeJKSRSVT(dto);
				break;
			// 전문
			case "20":
				dto.setJMS_NO(no);
				result = adminRepository.changeJMSRSVT(dto);
				break;
			// 심리
			case "30":
				dto.setSR_NO(no);
				result = adminRepository.changeSRSRSVT(dto);
				break;
			// 취업
			case "40":
				dto.setJC_NO(no);
				result = adminRepository.changeJCSRSVT(dto);
				break;
		}
		
		return result;
	}

	public int cancel(String sangdamNo, int no, String yn) {
		int result = 0;
		CounselingFormDTO dto = new CounselingFormDTO();
		dto.setRSVT_YN(yn);
		
		switch (sangdamNo) {
			case "10":
				dto.setJKS_NO(no);
				result = adminRepository.JKSCancel(dto);
				break;
			case "20":
				dto.setJMS_NO(no);
				result = adminRepository.JMSCancel(dto);
				break;
			case "30":
				dto.setSR_NO(no);
				result = adminRepository.SRSCancel(dto);
				break;
			case "40":
				dto.setJC_NO(no);
				result = adminRepository.JCSCancel(dto);
				break;
		}
		
		return result;
	}

	public int updateDateAndTime(String sangdamNo, int no, String rs_cf, String rs_cf_time) {
		int result = 0;
		CounselingFormDTO dto = new CounselingFormDTO();
		dto.setRS_CF(rs_cf);
		dto.setRS_CF_TIME(rs_cf_time);
		
		switch (sangdamNo) {
			case "10":
				dto.setJKS_NO(no);
				result = adminRepository.JKSUpdateDateAndTime(dto);
				break;
			case "20":
				dto.setJMS_NO(no);
				result = adminRepository.JMSUpdateDateAndTime(dto);
				break;
			case "30":
				dto.setSR_NO(no);
				result = adminRepository.SRSUpdateDateAndTime(dto);
				break;
			case "40":
				dto.setJC_NO(no);
				result = adminRepository.JCSUpdateDateAndTime(dto);
				break;
			case "50":
				break;
		}
		
		return result;
	}

	public int finishedSangdam(String sangdamNo, int no, String rs_cf, String rs_cf_time, String content) {
		int result = 0;
		
		CounselingFormDTO dto = new CounselingFormDTO();
		dto.setRS_CF(rs_cf);
		dto.setRS_CF_TIME(rs_cf_time);
		dto.setCONTENT(content);
		
		switch (sangdamNo) {
			case "10":
				dto.setJKS_NO(no);
				result = adminRepository.JKSfinishedSangdam(dto);
				break;
			case "20":
				dto.setJMS_NO(no);
				result = adminRepository.JMSfinishedSangdam(dto);
				break;
			case "30":
				dto.setSR_NO(no);
				result = adminRepository.SRSfinishedSangdam(dto);
				break;
			case "40":
				dto.setJC_NO(no);
				result = adminRepository.JCSfinishedSangdam(dto);
				break;
			case "50":
				break;
		}
		
		return result;
	}
	
	public List<Map<String, Object>> chart() {
		return adminRepository.chart();
	}

	public int save(GroupDTO groupDTO) {
		return adminRepository.saveGroup(groupDTO);
	}

	public List<GroupDTO> AdminGroup() {
		return adminRepository.groupList();
	}
}
