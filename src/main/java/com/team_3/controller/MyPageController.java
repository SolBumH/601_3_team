package com.team_3.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.CustomUserDetails;
import com.team_3.dto.UserDTO;
import com.team_3.service.CustomUserDetailService;
import com.team_3.service.MypageService;
import com.team_3.util.UserUtil;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private MypageService mypageService;

	@Autowired
	private CustomUserDetailService customUserDetailService;
	

	@GetMapping("")
	public  String jcCounselingForm(Model model, Principal principal) {
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

        // 사용자 이름으로 학생 번호 가져오기
        String studentNumber = mypageService.findStudentNumber(username);
        String studentDept = mypageService.findStud_dept(username);
        String studentPhone = mypageService.findPhone(username);
        // System.out.println(studentNumber); // 학번 확인하기
         System.out.println(studentDept); // 학번 확인하기
         System.out.println(studentPhone); // 학번 확인하기

        // 모델에 이름, 학번 추가
        model.addAttribute("name", name);
        model.addAttribute("studentName", username);
        model.addAttribute("studentNumber", studentNumber);
        model.addAttribute("studentDept", studentDept);
        model.addAttribute("studentPhone", studentPhone);

        // 다른 필요한 데이터들을 모델에 추가
        model.addAttribute("user", userUtil.getUserNameAndRole());

        return "mypage/mypage";
	}
	
	@GetMapping("/board")
	public String mypageBoard(Model model) {
		UserDTO user = userUtil.getUserData();
		model.addAttribute("user", user);
		return "mypage/mypageBoard";
	}
	
	// 글 목록 가져오기
	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> mypageBoardList() {
		UserDTO user = userUtil.getUserData();
		List<BoardDTO> list = mypageService.mypageBoardList(user);
		return list;
	}
	
	@PostMapping("/boardDelete")
	@ResponseBody
	public int boardDelete(@RequestParam(name="board_no") int board_no) {
		int result = mypageService.boardDelete(board_no);
		
		return result;
	}
	
	@GetMapping("/mysangdam")
	public String mypageSangdam(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		
		return "mypage/mypageSangdam";
	}
	
	// 현재 내 상담 리스트 가져오기
	@PostMapping("/sangdamList")
	@ResponseBody
	public List<CounselingFormDTO> sangdamList(@RequestParam(name = "sangdamNo") String no) {
		List<CounselingFormDTO> list;
		UserDTO user = userUtil.getUserData();
		list = mypageService.sangdamList(user, no);
		
		return list;
	}
	
	// 상담 취소하기
	@PostMapping("/cancelSangdam")
	@ResponseBody
	public int cancelSangdam(@RequestParam(name = "sangdamNo") String sangdamNo,
							@RequestParam(name = "no") int no) {
		int result = mypageService.cancelSangdam(sangdamNo, no);
		
		return result;
	}
}
