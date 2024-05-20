package com.team_3.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CounselingDTO {

	private int S_NO; 			//상담번호
	private int S_BF_NO; 		//이전상담번호
	private int ST_NO;  		//교직원번호
	private int STUD_NO;		//학번
	private Date RS_DATE;		//예약일자
	private String RS_TIME; 	//예약시간코드
	private Date CS_DATE;		//상담일자
	private String CS_TIME; 	//상담시간코드
	private String RS_TEXT; 	//상담내용
	private String RSVT_YN;		//예약승인여부
	private String JMS_LIST;	//주제
	private int SC_SN;			//스케줄번호
	
}
