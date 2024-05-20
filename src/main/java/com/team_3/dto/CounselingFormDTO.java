package com.team_3.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CounselingFormDTO {

	private int JMS_NO; 		//전문상담번호
	private int JMS_BF; 		//이전상담번호
	private int ST_NO;  		//교직원번호
//	private int STUD_NO // 학번
	private Date JMS_RS_DATE;	//예약일자
	private String JMS_RS_TIME; //예약시간코드
	private Date JMS_CS_DATE;	//상담일자
	private String JMS_CS_TIME; //상담시간코드
	private String JMS_RS_TEXT; //상담내용
	private String RSVT_YN;		//예약승인여부
	private String JMS_LIST;	//주제
	private String SC_SN;		//스케줄번호
	
	//취업 상담
	private int JC_NO; //취업상담번호
	private String NAME; //학생 이름
	private String username; //학생 아이디
	private String STUD_NO; //학번
	private String email; //이메일
	private String selectedType; //상담 종류
	private String SC_NO; //스케줄번호
	private String JC_RSVT_NO; //예약일자
	private String JC_RSVT_TM; //예약시간
	private String JC_DSCSN_YMD; //상담일자
	private String JC_DSCSN_TM; //상담시간
	private String JC_DSCSN_CN; //상담내용
	
}



