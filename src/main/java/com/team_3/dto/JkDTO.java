package com.team_3.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class JkDTO {
	
	private int JKS_NO; //심리 상담번호
	private int STUD_NO; // 학번
	private int ST_NO; // 교직원 번호
	private int SR_BF_NO; // 이전 상담 번호
	private LocalDateTime RSVT_YMD; // 예약 일자
	private String RSVT_TM; // 예약 시간 코드
	private String RSVT_YN; // 예약 승인 여부
	private String DSCSN_CN; // 상담 내용
	private LocalDateTime DSCSN_YMD; // 상담 일자
	private String DSCSN_TM; // 상담 시간 코드

}