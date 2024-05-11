package com.team_3.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.team_3.dto.CounselingFormDTO;

@Mapper
public interface CounselingMapper {

	void insertCounselingForm(CounselingFormDTO form);

}
