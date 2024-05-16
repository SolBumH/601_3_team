package com.team_3.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.service.CounselingService;
import com.team_3.service.CustomUserDetailService;
import com.team_3.util.UserUtil;

@Controller
public class JcFormController {

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private CounselingService counselingService;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@GetMapping("/jcCounselingForm")
	public String jcCounselingForm(Model model, Principal principal) {
		if (principal == null) {
			// 로그인되지 않은 경우 로그인 페이지로 리다이렉트
			return "redirect:/login";
		}

		// Principal을 이용하여 사용자 이름 가져오기
		String username = principal.getName();

		// 사용자 정보를 가져오기 위해 CustomUserDetailService를 사용합니다.
		UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

		// 사용자 이름 가져오기
		String name = userDetails.getUsername();

		// 사용자 이름으로 학생 번호 가져오기
		String studentNumber = counselingService.findStudentNumber(name);
		// System.out.println(studentNumber); //학번 확인하기
		// 모델에 이름, 학번 추가
		model.addAttribute("studentName", name);
		model.addAttribute("studentNumber", studentNumber);

		// 다른 필요한 데이터들을 모델에 추가
		model.addAttribute("user", userUtil.getUserNameAndRole());

		return "jcCounselingForm";
	}

	@GetMapping("/jcFormsuccessPage")
	public String successPage(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jcFormsuccessPage";
	}

	@PostMapping("/saveCounselingForm")
	public String saveCounselingForm(@RequestParam(name = "email") String email,
			@RequestParam("counselingContent") String counselingContent,
			@RequestParam("selectedType") String selectedType, 
			@RequestParam("date") String date,
			@RequestParam("time") String time, 
			@RequestParam("name") String name,
			@RequestParam("studentNumber") String studentNumber) {
	
		System.out.println("시간: " + time); System.out.println("학생이름: " + name);
		System.out.println("날짜: " + date); System.out.println("학번: " + studentNumber);
		
		CounselingFormDTO formDTO = new CounselingFormDTO();
		formDTO.setEmail(email);
		formDTO.setCounselingContent(counselingContent);
		formDTO.setSelectedType(selectedType);
		formDTO.setDate(date);
		formDTO.setTime(time);
		formDTO.setNAME(name);
		formDTO.setStudentNumber(studentNumber);
		
		System.out.println("컨트롤러 들어왔어요");
		
		// System.out.println(formData);
		counselingService.saveForm(formDTO);

		return "redirect:/jcFormsuccessPage"; 
	}
}
