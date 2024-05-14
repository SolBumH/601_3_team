package com.team_3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.repository.CounselingRepository;

@Service
public class CounselingService {
	
	@Autowired
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
	
	public List<BoardDTO> getGroupData() {
		List<BoardDTO> groupDataList = counselingRepository.getGroupData();
		return groupDataList;
	}

	public List<Map<String, Object>> getSchedule() {
		return counselingRepository.getSchedule();
	}
}
