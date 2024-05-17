package com.team_3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.repository.JkRepository;

@Service
public class JkService {
	
	@Autowired
	private JkRepository jkRepository;

	public List<Map<String, Object>> getJkList(String jkselectdate) {
		
		return jkRepository.getJkList(jkselectdate);
	}

}
