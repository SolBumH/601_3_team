package com.team_3.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CounselingFormDTO {
	// 공통
	private int ST_NO; // 교직원 번호
	private String NAME; // 이름
	private String STUD_NO; // 학번
	private String email; //이메일
	private Date RS_DATE;	//예약일자
	private String RS_TIME; //예약시간코드
	private Date RS_CF; // 예약 확정된 일자
	private String RS_CF_TIME; // 예약 확정된 시간 코드
	private Date CS_DATE;	//상담일자
	private String CS_TIME; //상담시간코드
	private String CS_TEXT; //상담내용
	private String RSVT_YN;		//예약승인여부
	private String SC_SN;		//스케줄번호
	
	// 전문 상담
	private int JMS_NO; 		//전문상담번호
	private int JMS_BF_NO; 		//이전상담번호
//	private String JMS_LIST;	//주제
	
	//취업 상담
	private int JC_NO; //취업상담번호
	private String username; //학생 아이디
	private String selectedType; //상담 종류

	
}



