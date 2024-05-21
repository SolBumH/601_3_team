package com.team_3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.JkDTO;
import com.team_3.service.JkService;
import com.team_3.util.UserUtil;

@Controller
public class JkFormContorller {

	@Autowired
	private JkService jkService;

	@Autowired
	private UserUtil userUtil;

	@GetMapping("/jkconsulting")
	public String jkconsulting(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		//
		//model.addAttribute("schedule", schedule);
		return "jkconsulting";
	}
	
	@PostMapping("/jkconsult")
	@ResponseBody
	public List<JkDTO> jkconsult(@RequestParam(name = "date") String date, Model model) {
		List<JkDTO> schedule = jkService.getSchedule(date);
		return schedule;
	}
}
