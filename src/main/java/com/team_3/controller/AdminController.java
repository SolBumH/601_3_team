package com.team_3.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.GroupDTO;
import com.team_3.dto.UserDTO;
import com.team_3.service.AdminService;
import com.team_3.util.UserUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private AdminService adminService;

	@GetMapping({"/index", "", "/"})
	public String index(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminIndex";
	}

	@GetMapping("/board")
	public String board(Model model) {
		List<BoardDTO> list = adminService.AdminBoard();
		model.addAttribute("user", userUtil.getUserNameAndRole());
		model.addAttribute("list", list);
		return "admin/adminboard";
	}

	// 게시글 관리의 글 가져오는 컨트롤러
	@GetMapping("/boardList")
	@ResponseBody
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = adminService.AdminBoard();
		return list;
	}

	@GetMapping("/user")
	public String member(Model model) {
		List<UserDTO> list = adminService.AdminUser();
		model.addAttribute("list", list);
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminuser";
	}

	@GetMapping("/userList")
	@ResponseBody
	public List<UserDTO> userList(Model model) {
		List<UserDTO> list = adminService.AdminUser();
		// System.out.println(list);
		return list;
	}

	@GetMapping("/Group")
	public String adminGroup(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminGroup";
	}
	
	@GetMapping("/GroupAp")
	public String adminGroupAp(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "/admin/adminGroupAp";
	}
	
	@PostMapping("/saveGroupForm")
	public String saveGroupForm(@RequestParam(name = "programName") String programName,
								@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
					            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
					            @RequestParam(name = "time") String time,
                                @RequestParam("programContent") String programContent,
                                @RequestParam("recruitmentNumber") int recruitmentNumber) {
							
		
		
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setPG_NAME(programName);
		groupDTO.setJMS_CS_DATE(date);
		groupDTO.setEN_DATE(endDate);
		groupDTO.setPG_EXPLAIN(programContent);
		groupDTO.setTO_NO(recruitmentNumber);
		
		adminService.save(groupDTO);
		return "redirect:/admin/Group";
	}
	
	@GetMapping("/Counseling")
	public String counseling(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/adminCounseling";
	}

	@GetMapping("/charts")
	public String charts(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "admin/admincharts";
	}

	// 관리자페이지 글 상태 변경 메소드
	@PostMapping("/updateBoardDel")
	@ResponseBody
	public String updateBoardDel(BoardDTO board) {
		// System.out.println("no : " + board.getBoard_no() + " del : " +
		// board.getDel_yn());
		int result = adminService.updateBoardDel(board);
		return String.valueOf(result);
	}

	// 게시글 답변 페이지 이동
	@GetMapping("/response")
	public String response(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "/admin/adminResponse";
	}

	@PostMapping("/userUpdate")
	@ResponseBody
	public int userUpdate(UserDTO dto) {
		int result = adminService.userUpdate(dto);
		System.out.println(result);
		return result;
	}

	@PostMapping("/answerPost")
	@ResponseBody
	public int answerPost(@RequestParam(name = "board_no") int board_no, @RequestParam(name = "answer") String answer) {
		BoardDTO board = new BoardDTO();
		board.setBoard_no(board_no);
		board.setBoard_content(answer);
		board.setName(userUtil.getUsername());
		int result = adminService.answerPost(board);
		System.out.println(board.toString());
		adminService.answerNumberUpdate(board);

		return result;
	}

	@PostMapping("/answerContent")
	@ResponseBody
	public String answerContent(@RequestParam(name = "board_no") int board_no) {
		String result = adminService.getAnswerContent(board_no);
		return result;
	}

	@GetMapping("/adminJkCounseling")
	public String adminJkCounseling(Model model) {
		model.addAttribute("user", userUtil.getUserNameAndRole());
		return "/admin/adminJkCounseling";
	}
	
	@PostMapping("/sangdamList")
	@ResponseBody
	public List<CounselingFormDTO> jmsangdamList(@RequestParam(name = "sangdamNo") String no) {
		List<CounselingFormDTO> list = adminService.getSangdamList(no);
		return list;
	}

	@PostMapping("/changeRSVT")
	@ResponseBody
	public int changeRSVT(@RequestParam(name = "rsvt_YN") String yn, @RequestParam(name = "no") int no,
			@RequestParam(name = "sangdamNo") String sangdamNo) {
		System.out.println(yn);
		System.out.println(no);
		System.out.println(sangdamNo);

		int result = adminService.changeRSVT(sangdamNo, no, yn);

		return result;
	}
	
	//상담내역 승인하기
	@PostMapping("/approval")
	@ResponseBody
	public int approval(@RequestParam(name = "rsvt_YN") String yn,
			@RequestParam(name = "no") int no,
			@RequestParam(name = "sangdamNo") String sangdamNo,
			@RequestParam(name = "RS_DATE") String rs_date,
			@RequestParam(name = "RS_TIME") String rs_time) throws ParseException {
		System.out.println(yn + "/" + no + "/" + sangdamNo + "/" + rs_date + "/" + rs_time);
		
		int result = adminService.approval(sangdamNo, no, yn, rs_date, rs_time);

		return result;
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public int cancel(@RequestParam(name = "rsvt_YN") String yn,
			@RequestParam(name = "no") int no,
			@RequestParam(name = "sangdamNo") String sangdamNo) {
		
		int result = adminService.cancel(sangdamNo, no, yn);

		return result;
	}
	
	@PostMapping("/updateDateAndTime")
	@ResponseBody
	public int updateDateAndTime(@RequestParam(name = "sangdamNo") String sangdamNo,
								@RequestParam(name = "no") int no,
								@RequestParam(name = "rs_cf") String rs_cf,
								@RequestParam(name = "rs_cf_time") String rs_cf_time) {
		System.out.println(sangdamNo + " : " + no + " : " + rs_cf + " : " + rs_cf_time);
		
		int result = adminService.updateDateAndTime(sangdamNo, no, rs_cf, rs_cf_time);
		return result;
	}
	
	@PostMapping("/finishedSangdam")
	@ResponseBody
	public int finishedSangdam(@RequestParam(name = "sangdamNo") String sangdamNo,
			@RequestParam(name = "no") int no,
			@RequestParam(name = "rs_cf") String rs_cf,
			@RequestParam(name = "rs_cf_time") String rs_cf_time,
		    @RequestParam(name = "content") String content) {
		
		int result = adminService.finishedSangdam(sangdamNo, no, rs_cf, rs_cf_time, content);
		return result;
	}
	
	@GetMapping("/chart")
	public String chart(Model model) {
		List<Map<String, Object>> list = adminService.chart();
		model.addAttribute("list", list);
		return "/admin/chart";
	}
}
