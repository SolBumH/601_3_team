package com.team_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SrController {
	
	@PostMapping("/SrController")
	@ResponseBody
	public String arg(@RequestParam(name = "start") String start) {
		//System.out.println(start);
		return "srcunsulting";
	}
	
	@PostMapping("/scmenu")
	@ResponseBody
	public String scmenu(@RequestParam(name = "moda") String moda) {
		System.out.println(moda + " : 날짜");
	
		return "scmenu";
	}
}
