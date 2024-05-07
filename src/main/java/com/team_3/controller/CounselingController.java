package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounselingController {
	
	@GetMapping("srCounseling")
	public String srCounseling() {
		return "sangdam";
	}
	
	@GetMapping("/jmCounseling")
	public String jmCounseling() {
		return "sangdam";
	}
	
	@GetMapping("/jdCounseling")
	public String jdCounseling() {
		return "sangdam";
	}
	
	@GetMapping("/jcCounseling")
	public String jcCounseling(Model model) {
		model.addAttribute("counselingTitle", "취업·진로 상담 안내");
		return "sangdam";
	}
	
	@GetMapping("/jkCounseling")
	public String jkCounseling() {
		return "sangdam";
	}
}
