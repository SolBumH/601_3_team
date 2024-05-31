package com.team_3.repository;

import java.util.List;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.JkDTO;

public interface JkRepository {

	int getJkList(JkDTO dto);

	List<JkDTO> searchList(JkDTO dto);

	List<JkDTO> getSchedule(String date);

	String findStudentNumber(String userId);

	int saveAdvisorCounselingForm(CounselingFormDTO formDTO);

	int saveExpertCounselingForm(CounselingFormDTO formDTO);

	int savePsychologicalCounselingForm(CounselingFormDTO formDTO);

	int saveEmploymentCounselingForm(CounselingFormDTO formDTO);

}
