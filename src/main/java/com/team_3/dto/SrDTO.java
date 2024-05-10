package com.team_3.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SrDTO {
	private int SR_NO; //심리 상담번호
	private int STUD_NO; // 학번
	private int ST_NO; // 교직원 번호
	private int SR_BF_NO; // 이전 상담 번호
	private LocalDateTime SR_RS_DATE; // 예약 일자
	private String SR_RS_TIME; // 예약 시간 코드
	private String RS_YN; // 예약 승인 여부
	private String RS_CF; // 예약 확정 일자
	private String RS_CF_CD; // 예약 확정 시간 코드
	private String SR_CS_TEXT; // 상담 내용
	private LocalDateTime SR_CS_DATE; // 상담 일자
	private String SR_CS_TIME; // 상담 시간 코드
	
	
}
