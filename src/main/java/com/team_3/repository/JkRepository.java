package com.team_3.repository;

import java.util.List;
import java.util.Map;

import com.team_3.dto.JkDTO;

public interface JkRepository {

	int getJkList(JkDTO dto);

	List<JkDTO> searchList(JkDTO dto);

	List<JkDTO> getSchedule(String date);

}
