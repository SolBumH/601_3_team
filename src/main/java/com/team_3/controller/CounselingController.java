package com.team_3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team_3.dto.BoardDTO;
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
	
	@GetMapping("/groupsangdam") //집단상담 프로그램 목록
	public String groupSangdam(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		List<BoardDTO> groupDataList = new ArrayList<>(); // 초기화
		groupDataList = counselingService.getGroupData();
		
		System.out.println(groupDataList);
		  
		model.addAttribute("groupDataList", groupDataList);
		  
		
		return "groupsangdam";
	}
	
	@GetMapping("/groupDetail")
	public String groupDetail(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "groupDetail";
	}
	
	@GetMapping("/groupResult")
	public String groupRequest(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "groupResult";
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
