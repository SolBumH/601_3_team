package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.repository.CounselingRepository;

@Service
public class CounselingService {

    private CounselingRepository counselingRepository;

    @Autowired
    public CounselingService(CounselingRepository counselingRepository) {
        this.counselingRepository = counselingRepository;
    }

    public void saveForm(CounselingFormDTO formDTO) {
        counselingRepository.saveForm(formDTO);
    }
    
    public String test() {
    	//System.out.println(counselingRepository.findByJcNo("1234567"));
		return counselingRepository.findByJcNo("1234567");
    }

	public Object findBySTUD_NO() {
		return counselingRepository.findBySTUD_NO("010-2345-6789");
	}
}
