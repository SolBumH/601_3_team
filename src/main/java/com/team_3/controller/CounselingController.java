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
		return "sangdam";
	}
	
	@GetMapping("/jcCounseling")
	public String jcCounseling() {
		return "sangdam";
	}
	
	@GetMapping("/jkCounseling")
	public String jkCounseling() {
		return "sangdam";
	}
}
