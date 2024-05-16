package com.team_3.repository;

import java.util.List;
import java.util.Map;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;

public interface CounselingRepository {
	 void saveForm(CounselingFormDTO formDTO);
	 
	 List<BoardDTO> getGroupData();

	 BoardDTO getDetail(int no);

	String findStudentNumber(String name);

	List<Map<String, Object>> getSchedule();
}
