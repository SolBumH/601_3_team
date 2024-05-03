package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.UserDTO;
import com.team_3.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public List<UserDTO> findByLoginid(String loginid, String pw) {
		return loginRepository.findByLoginidAndPw(loginid, pw);
	}

	public Long countByLoginid(String loginid) {
		return loginRepository.countByLoginid(loginid);
	}

	public Long countByLoginid(UserDTO user) {
		return loginRepository.countByLoginid(user);
	}
	
}
