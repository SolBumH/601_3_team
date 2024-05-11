package com.team_3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.mapper.CounselingMapper;

@Repository
public class CounselingRepository {
    
    private CounselingMapper counselingMapper;

    @Autowired
    public CounselingRepository(CounselingMapper counselingMapper) {
        this.counselingMapper = counselingMapper;
    }

    public void insertCounselingForm(CounselingFormDTO form) {
        counselingMapper.insertCounselingForm(form);
    }
}
	



