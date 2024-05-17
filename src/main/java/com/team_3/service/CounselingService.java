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

	public String findStudentNumber(String name) {
		return counselingRepository.findStudentNumber(name);
	}
	
	public List<BoardDTO> getGroupData() {
		List<BoardDTO> groupDataList = counselingRepository.getGroupData();
		return groupDataList;
	}

	public BoardDTO getDetail(int no) {
		return counselingRepository.getDetail(no);
	}

	public List<Map<String, Object>> getSchedule() {
		return counselingRepository.getSchedule();
	}
}
