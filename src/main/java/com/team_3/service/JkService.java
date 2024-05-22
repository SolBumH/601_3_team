package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.JkDTO;
import com.team_3.repository.JkRepository;

@Service
public class JkService {
	
	@Autowired
	private JkRepository jkRepository;

	public int getJkList(JkDTO dto) {
		return jkRepository.getJkList(dto);
	}

	public List<JkDTO> searchList(JkDTO dto) {
		return jkRepository.searchList(dto);
	}

	public List<JkDTO> getSchedule(String date) {
		return jkRepository.getSchedule(date);
	}

	public String findStudentNumber(String userId) {
		return jkRepository.findStudentNumber(userId);
	}

	public int saveAdvisorCounselingForm(CounselingFormDTO formDTO) {
		return jkRepository.saveAdvisorCounselingForm(formDTO);
	}

	public int saveExpertCounselingForm(CounselingFormDTO formDTO) {
		return jkRepository.saveExpertCounselingForm(formDTO);
	}

	public int savePsychologicalCounselingForm(CounselingFormDTO formDTO) {
		return jkRepository.savePsychologicalCounselingForm(formDTO);
	}

	public int saveEmploymentCounselingForm(CounselingFormDTO formDTO) {
		return jkRepository.saveEmploymentCounselingForm(formDTO);
	}
}
