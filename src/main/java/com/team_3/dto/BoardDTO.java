package com.team_3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int	board_no; // 글 번호
	private int board_bf_no; // 글 이전 번호
	private int board_ans_no; // 답변한 글 번호
	private int board_user; // 유저 번호
	private String name; // 글쓴이 아이디
	private String board_title; // 제목
	private String board_content; // 내용
	private Date board_date; // 작성일
	private String del_yn; // 삭제 여부 ( 1:미삭제, 2:삭제 )
	private String ans_yn; // 답변 여부 ( 1:미답변, 2:답변완료 )
	private String file_no; // 파일 번호
}
