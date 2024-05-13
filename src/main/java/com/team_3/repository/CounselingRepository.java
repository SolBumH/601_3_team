package com.team_3.repository;

import com.team_3.dto.CounselingFormDTO;

public interface CounselingRepository {
	 void saveForm(CounselingFormDTO formDTO);
	 
	 String findByJcNo(String str);

	 String findBySTUD_NO(String str2);
}
