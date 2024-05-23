package com.team_3.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.CustomUserDetails;
import com.team_3.dto.GroupDTO;
import com.team_3.dto.UserDTO;
import com.team_3.service.CounselingService;
import com.team_3.service.CustomUserDetailService;
import com.team_3.util.UserUtil;

@Controller
public class CounselingController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private CounselingService counselingService;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@GetMapping("/srconsulting")
	public String sd(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		List<Map<String, Object>> schedule = counselingService.getSchedule();
		model.addAttribute("schedule", schedule);
		return "srconsulting";
	}	
	
	@GetMapping("srCounseling")
	public String srCounseling(Model model) {
		model.addAttribute("counselingTitle", "심리 상담 안내");
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "srCounseling";
	}
	
	@GetMapping("/jmCounseling")
	public String jmCounseling(Model model) {
		model.addAttribute("counselingTitle", "전문 상담 안내");
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jmsangdam";
	}
	
	@GetMapping("/jdCounseling")
	public String jdCounseling(Model model) {
		model.addAttribute("counselingTitle", "집단 상담 안내");
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jdCounseling";
	}
	
	//집단상담 목록
	@GetMapping("/groupsangdam") //집단상담 프로그램 목록
	public String groupSangdam(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		List<GroupDTO> groupDataList = new ArrayList<>(); // 초기화
		groupDataList = counselingService.getGroupData();
		  
		model.addAttribute("groupDataList", groupDataList);
		return "groupsangdam";
	}

	// 집단상담 상세페이지
	@GetMapping("/groupDetail")
	public String groupDetail(Model model, @RequestParam(name = "no") int no) {
		UserDTO user = userUtil.getUserData();
		GroupDTO detail = counselingService.getDetail(no);
		
		// System.out.println(detail);

		model.addAttribute("detail", detail);
		model.addAttribute("user", user);

		return "groupDetail";
		}
	
	// 집단상담 신청 결과페이지
	@GetMapping("/groupResult")
	public String groupResult(Model model,@RequestParam(name = "no") int no, Principal principal) {
		UserDTO user = userUtil.getUserData();
		GroupDTO detail = counselingService.getResult(no);
		
        String name = principal.getName();
        
        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(name);
        String username = customUserDetails.getName();
        String id = customUserDetails.getUsername();
        
        System.out.println(detail);
        System.out.println("=============");
		System.out.println(username);
		System.out.println(id);
		
		String studentNumber = counselingService.findStudentNumber(id);
		model.addAttribute("studentNumber", studentNumber);
		model.addAttribute("studentName", username);
		model.addAttribute("detail", detail);
		model.addAttribute("user", user);
		model.addAttribute("id", id);
		model.addAttribute("userNameAndRole", userUtil.getUserNameAndRole());
		model.addAttribute("JMS_CS_TIME", detail.getJMS_CS_TIME());
		
		return "groupResult";
	}
	
	//집단상담 DB저장
	@PostMapping("/saveGroupResult")
	@ResponseBody
	public int savaeGroupResult(@RequestParam(name = "programName") String programName,
								   @RequestParam(name = "JD_NO") int JD_NO,
								   @RequestParam(name = "studentNo") String studentNo) {
		System.out.println("saveGroupResult 들어옴");
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setJD_NO(JD_NO);
		groupDTO.setPG_NAME(programName);
		groupDTO.setSTUD_NO(studentNo);
		System.out.println(groupDTO);
		int result = counselingService.saveGroupResult(groupDTO);
		return result;
	}
	
	
	@GetMapping("/jcCounseling")
	public String jcCounseling(Model model) {
		model.addAttribute("counselingTitle", "취업·진로 상담 안내");	
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jcCounseling";
	}
	
	@GetMapping("/jkCounseling")
	public String jkCounseling(Model model) {
		model.addAttribute("counselingTitle", "교수 상담 안내");
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jkCounseling";
	}
}
