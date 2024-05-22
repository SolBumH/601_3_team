package com.team_3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.UserDTO;

@Repository
@Mapper
public interface MypageRepository {
	
public List<BoardDTO> mypageBoardList(UserDTO user);
	
	public int boardDelete(int board_no);
	
	public List<CounselingFormDTO> jmSangdamList(UserDTO user);

	public List<CounselingFormDTO> srSangdamList(UserDTO user);
	
	public List<CounselingFormDTO> jkSangdamList(UserDTO user);
	
	public List<CounselingFormDTO> jcSangdamList(UserDTO user);

	public int cancelJKSangdam(int no);
	public int cancelJMSangdam(int no);
	public int cancelSRSangdam(int no);
	public int cancelJCSangdam(int no);
	
	public String findStudentNumber(String userId);
	
	public String findStud_dept(String userId);
	
	public String findPhone(String userId);
	

}
