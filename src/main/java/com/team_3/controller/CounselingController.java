package com.team_3.controller;

import org.springframework.stereotype.Controller;
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
		return "groupsangdam";
	}
	
	@GetMapping("/groupDetail.html")
	public String groupDetail() {
		return "groupDetail.html";
	}
	
	@GetMapping("/jcCounseling")
	public String jcCounseling() {
		return "sangdam";
	}
}
