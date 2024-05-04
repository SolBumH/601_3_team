package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.UserDTO;
import com.team_3.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public UserDTO list() {
		return loginRepository.list();
	}

}
