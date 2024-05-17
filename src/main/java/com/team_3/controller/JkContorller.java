package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.service.JkService;
import com.team_3.util.UserUtil;

@Controller
@RequestMapping("/admin")
public class JkContorller {
	
	@Autowired
	private JkService jkService;
	
	@Autowired
	private UserUtil userUtil;
	
	@PostMapping("/JkControll")
	@ResponseBody
	public String JkControll(@RequestParam(name = "start") String start) {
		System.out.println(start);
		return "admin/adminJkCounseling";
	}
	
	@PostMapping("/jkselect")
	public String jkselect(@RequestParam(name = "jkselectdate") String jkselectdate) {
		System.out.println(jkselectdate);
		return "redirect:/admin/jkCounseling";
	}
}
