package com.team_3.repository;

import java.util.List;

import com.team_3.dto.JkDTO;

public interface JkRepository {

	int getJkList(JkDTO dto);

	List<JkDTO> searchList(JkDTO dto);

}
