package com.team_3.service;

import java.util.List;

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
    
    //집단상담 프로그램 목록 띄우기
	public List<BoardDTO> getGroupData() {
		List<BoardDTO> groupDataList = counselingRepository.getGroupData();
		return groupDataList;
	}

    
}
