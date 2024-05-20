package com.team_3.repository;

import java.util.List;
import java.util.Map;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingDTO;

public interface CounselingRepository {
	
	 void saveForm(CounselingDTO formDTO);
	 
	 List<BoardDTO> getGroupData();

	 BoardDTO getDetail(int no);

	String findStudentNumber(String username);

	List<Map<String, Object>> getSchedule();
}
