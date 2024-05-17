package com.team_3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int	board_no; // 글 번호
	private int board_bf_no; // 답변 한 글 번호 => 답변 글에 업데이트 됨 
	private int board_ans_no; // 답변 글 번호 => 질문글에 업데이트 됨
	private int board_user; // 유저 번호
	private String name; // 글쓴이 아이디
	private String board_title; // 제목
	private String board_content; // 내용
	private Date board_date; // 작성일
	private String del_yn; // 삭제 여부 ( 1:미삭제, 2:삭제 )
	private String ans_yn; // 답변 여부 ( 1:미답변, 2:답변완료, 3:답변불필요 )
	private String file_no; // 파일 번호
	
	//집단상담
	private String PG_NAME; //프로그램명
	private Date EN_DATE;	// 끝나는 날짜
	private Date JMS_CS_DATE; //프로그램 실행날짜
	private int JD_NO; //집단상담 프로그램 번호
	private String PG_EXPLAIN; //집단상담 프로그램 설명
}
