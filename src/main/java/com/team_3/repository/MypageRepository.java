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

	public int cancelSangdam(int no);

	public String findStudentNumber(String username);

	public String findStud_dept(String username);

	public String findPhone(String username);

}
