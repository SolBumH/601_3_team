package com.team_3.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team_3.dto.CodeDTO;
import com.team_3.repository.AdminRepository;

@Component
public class CodeUtil {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<CodeDTO> getCode() {
		CodeDTO codeDTO = new CodeDTO();
		List<CodeDTO> codeList = adminRepository.getCodeList(codeDTO);
		return codeList;
	}
}
