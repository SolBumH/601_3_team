package com.team_3.repository;

import java.util.List;
import java.util.Map;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingDTO;
import com.team_3.dto.CounselingFormDTO;

public interface CounselingRepository {
	
	 void saveForm(CounselingDTO formDTO);
	 
	List<BoardDTO> getGroupData();

	BoardDTO getDetail(int no);

	BoardDTO getResult(int no);

	List<Map<String, Object>> getSchedule();

	int saveFormJM(CounselingFormDTO formDTO);

	int saveAdvisorCounselingForm(CounselingFormDTO formDTO);

	int saveExpertCounselingForm(CounselingFormDTO formDTO);

	int savePsychologicalCounselingForm(CounselingFormDTO formDTO);

	int saveEmploymentCounselingForm(CounselingFormDTO formDTO);

	String findStudentNumber(String userId);



}
