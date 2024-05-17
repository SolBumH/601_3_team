package com.team_3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.JkDTO;
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
	public String JkControll(@RequestParam(name = "start") String start,Model model) {
		System.out.println(start);
		return "admin/adminJkCounseling";
	}
	
	@PostMapping("/jkselect")
	public String jkselect(@RequestParam(name = "jkselectdate") String jkselectdate,
							@RequestParam(name = "jkoption") String jkoption, Model model, JkDTO dto) {
		System.out.println(jkselectdate);
		System.out.println(jkoption);
		//List<Map<String, Object>> list = jkService.getJkList(jkselectdate);
		//model.addAttribute("list",list);
		return "redirect:/admin/adminJkCounseling";
	}
}
