package com.team_3.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CounselingFormDTO {

	private int JMS_NO; 		//전문상담번호
	private int JMS_BF; 		//이전상담번호
	private int ST_NO;  		//교직원번호
	private int STUD_NO;		//학번
	private Date JMS_RS_DATE;	//예약일자
	private String JMS_RS_TIME; //예약시간코드
	private Date JMS_CS_DATE;	//상담일자
	private String JMS_CS_TIME; //상담시간코드
	private String JMS_RS_TEXT; //상담내용
	private String RSVT_YN;		//예약승인여부
	private String JMS_LIST;	//주제
	private String SC_SN;		//스케줄번호
	
}
