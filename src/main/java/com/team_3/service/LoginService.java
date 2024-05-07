package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.team_3.dto.UserDTO;
import com.team_3.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDTO list() {
		return loginRepository.list();
	}
	
	public void joinProcess(UserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		loginRepository.joinProcess(user);
	}
}
