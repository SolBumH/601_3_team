package com.team_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team_3.dto.CustomUserDetails;
import com.team_3.dto.UserDTO;
import com.team_3.repository.LoginRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO user = loginRepository.findByUsername(username);
		
		if (user != null) {
			System.out.println("CustomUserDetailService : " + user.toString());
			return new CustomUserDetails(user);
		}
		System.out.println("없는 회원");
		return null;
	}
	
}
