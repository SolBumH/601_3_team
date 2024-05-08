package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounselingController {
	
	@GetMapping("srCounseling")
	public String srCounseling(Model model) {
		model.addAttribute("counselingTitle", "심리 상담 안내");
		return "sangdam";
	}
	
	@GetMapping("/jmCounseling")
	public String jmCounseling(Model model) {
		model.addAttribute("counselingTitle", "전문 상담 안내");
		return "sangdam";
	}
	
	@GetMapping("/jdCounseling")
	public String jdCounseling() {
		return "groupsangdam";
	}
	
	@GetMapping("/groupDetail")
	public String groupDetail() {
		return "groupDetail";
	}
	
	@GetMapping("/groupRequest")
	public String groupRequest() {
		return "groupRequest";
	}
	
	@GetMapping("/jcCounseling")
	public String jcCounseling(Model model) {
		model.addAttribute("counselingTitle", "취업·진로 상담 안내");			
		return "jcCounseling";
	}
	
	@GetMapping("/jkCounseling")
	public String jkCounseling(Model model) {
		model.addAttribute("counselingTitle", "교수 상담 안내");
		return "jkCounseling";
	}
}
