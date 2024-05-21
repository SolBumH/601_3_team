package com.team_3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/jkselect")
	@ResponseBody
	public List<JkDTO> jkselect(@RequestParam(name = "jkselectdate") String jkselectdate,
							Model model, JkDTO dto) {
		
		dto.setUSER_NO(userUtil.getUserData().getUser_no());
		dto.setPLAN_YMD(jkselectdate);
		
		List<JkDTO> list = jkService.searchList(dto);
		//System.out.println(list);
		return list;
	}
/*	
	@PostMapping("/jkselect")
	@ResponseBody
	public String jkselect(@RequestParam(name = "jkselectdate") String jkselectdate,
							@RequestParam(name = "jkoption") String jkoption, Model model, JkDTO dto) {
		System.out.println(jkselectdate);
		System.out.println(jkoption);
		
		dto.setUSER_NO(userUtil.getUserData().getUser_no());
		dto.setRSVT_YMD(jkselectdate);
		dto.setRSVT_TM(jkoption);
		//List<Map<String, Object>> list = jkService.searchList(dto.getRSVT_YMD());
		jkService.getJkList(dto);
		return "redirect:/admin/adminJkCounseling";
	}
*/
}
