package com.team_3.repository;

import java.util.List;
import java.util.Map;

import com.team_3.dto.CounselingDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.GroupDTO;

public interface CounselingRepository {
	
	 void saveForm(CounselingDTO formDTO);
	 
	List<GroupDTO> getGroupData();

	GroupDTO getDetail(int no);

	GroupDTO getResult(int no);

	List<Map<String, Object>> getSchedule();

	int saveFormJM(CounselingFormDTO formDTO);

	int saveAdvisorCounselingForm(CounselingFormDTO formDTO);

	int saveExpertCounselingForm(CounselingFormDTO formDTO);

	int savePsychologicalCounselingForm(CounselingFormDTO formDTO);

	int saveEmploymentCounselingForm(CounselingFormDTO formDTO);

	String findStudentNumber(String id);

	int saveGroupResult(GroupDTO groupDTO);


}
