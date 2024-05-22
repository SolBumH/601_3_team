package com.team_3.controller;

import java.security.Principal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.CustomUserDetails;
import com.team_3.service.CounselingService;
import com.team_3.service.CustomUserDetailService;
import com.team_3.util.UserUtil;

@Controller
public class JcFormController {

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private CounselingService counselingService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @GetMapping("/jcCounselingForm")
    public String jcCounselingForm(Model model, Principal principal) {
        if (principal == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // Principal 객체에서 사용자의 이름 가져오기
        String name = principal.getName();

        // 사용자 이름으로 CustomUserDetails 객체 가져오기
        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(name);

        // CustomUserDetails 객체에서 사용자의 이름 가져오기
        String username = customUserDetails.getName();
        String userId = customUserDetails.getUsername();

     // 사용자 아이디를 기반으로 학번 가져오기
        String studentNumber = counselingService.findStudentNumber(userId);
        System.out.println(studentNumber);
        System.out.println(userId);
        // 모델에 이름, 학번 추가
        model.addAttribute("studentName", username);
        model.addAttribute("studentNumber", studentNumber);

        // 다른 필요한 데이터들을 모델에 추가
        model.addAttribute("user", userUtil.getUserNameAndRole());

        return "jcCounselingForm";
    }

    @GetMapping("/jcFormsuccessPage")
    public String successPage(Model model) {
        model.addAttribute("user", userUtil.getUserNameAndRole());
        return "jcFormsuccessPage";
    }

    @PostMapping("/saveCounselingForm")
    public String saveCounselingForm(@RequestParam(name = "email") String email,
                                     @RequestParam("counselingContent") String counselingContent,
                                     @RequestParam("selectedType") String selectedType,
                                     @RequestParam("date") Date date,
                                     @RequestParam("time") String time,
                                     @RequestParam("name") String name,
                                     @RequestParam("studentNumber") String studentNumber,
                                     RedirectAttributes redirectAttributes) {
    	
        CounselingFormDTO formDTO = new CounselingFormDTO();
        formDTO.setRS_DATE(date); // 예약일자
        formDTO.setRS_TIME(time); // 예약시간
        // formDTO.setNAME(name); // 학생 이름
        formDTO.setSTUD_NO(studentNumber); // 학번
        formDTO.setEmail(email); // 이메일 
        formDTO.setCS_TEXT(counselingContent); // 상담 내용
        formDTO.setSelectedType(selectedType); // 상담 종류

        // 상담 종류에 따라 다른 서비스 메서드 호출
        int jcNo = 0;
        switch (selectedType) {
            case "10": // 지도교수 상담
                jcNo = counselingService.saveAdvisorCounselingForm(formDTO);
                redirectAttributes.addFlashAttribute("selectedType", "지도교수 상담");
                break;
            case "20": // 전문 상담
                jcNo = counselingService.saveExpertCounselingForm(formDTO);
                redirectAttributes.addFlashAttribute("selectedType", "전문 상담");
                break;
            case "30": // 심리 상담
                jcNo = counselingService.savePsychologicalCounselingForm(formDTO);
                redirectAttributes.addFlashAttribute("selectedType", "심리 상담");
                break;
            case "40": // 취업 상담
                jcNo = counselingService.saveEmploymentCounselingForm(formDTO);
                redirectAttributes.addFlashAttribute("selectedType", "취업 · 진로 상담");
                break;
            default:
                // 상담 종류가 잘못되었을 경우 처리
                break;
        }

        System.out.println(jcNo);

        // RedirectAttributes를 사용하여 데이터를 전달합니다.
        // 다음 페이지로 값 넘기기
        redirectAttributes.addFlashAttribute("jcNo", jcNo);
        redirectAttributes.addFlashAttribute("date", date);
        redirectAttributes.addFlashAttribute("time", time);
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("studentNumber", studentNumber);

        return "redirect:/jcFormsuccessPage";
    }
}