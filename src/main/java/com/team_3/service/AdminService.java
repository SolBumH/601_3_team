package com.team_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_3.dto.BoardDTO;
import com.team_3.repository.AdminRepository;
@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<BoardDTO> AdminBoard() {
		return adminRepository.AdminBoard();
	}

}
