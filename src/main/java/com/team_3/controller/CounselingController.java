package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.service.CounselingService;
import com.team_3.util.UserUtil;

@Controller
public class CounselingController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private CounselingService counselingService;
	
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
	
	@GetMapping("/groupsangdam")
	public String groupSangdam(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
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
	
	@GetMapping("/jcCounselingForm")
	public String jcCounselingForm(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		model.addAttribute("test", counselingService.test());
		model.addAttribute("findBySTUD_NO", counselingService.findBySTUD_NO());
		//System.out.println(counselingService.test());
	
		return "jcCounselingForm";
	}

	  @PostMapping("/saveCounselingForm") 
	    public String saveCounselingForm(                                    
	                                     @RequestParam("email") String email,	   
	                                     @RequestParam("counselingContent") String counselingContent) {
	       
		  CounselingFormDTO formDTO = new CounselingFormDTO();       
	        formDTO.setEmail(email);
	        formDTO.setCounselingContent(counselingContent);

	        counselingService.saveForm(formDTO); // 서비스를 통해 데이터 저장

	        return "redirect:/JcFromsuccessPage"; // 성공 페이지로 리다이렉트
	    }
	  
		@GetMapping("/JcFromsuccessPage")
		public String JcFromsuccessPage(Model model) {
			model.addAttribute("user", userUtil.getUserNameAndRole());
			return "JcFromsuccessPage";
		}
	
	
	@GetMapping("/jkCounseling")
	public String jkCounseling(Model model) {
		model.addAttribute("counselingTitle", "교수 상담 안내");
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "jkCounseling";
	}
}
