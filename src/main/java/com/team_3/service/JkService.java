package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.repository.JkRepository;

@Service
public class JkService {
	
	@Autowired
	private JkRepository jkRepository;

}
