package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.repository.CounselingRepository;

public class counselingService {

	  @Autowired
	    private CounselingRepository counselingRepository;

	    public void saveForm(CounselingFormDTO form) {
	        counselingRepository.save(form);
	    }
		
	}
