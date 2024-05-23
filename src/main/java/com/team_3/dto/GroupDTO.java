package com.team_3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class GroupDTO {

	private int JD_NO; //집단상담번호
	private String PG_NAME; //프로그램명
	private String PG_EXPLAIN; //프로그램 설명
	private Date EN_DATE; //마감일
	private String EN_NO; //마감여부
	private Date JMS_CS_DATE; //상담일자
	private String JMS_CS_TIME; //상담시간
	private int TO_NO; //총 인원수
	private int AP_NO; //신청인원수
	private int PA_NO; //참여인원수
	
	private String STUD_NO; //학번
	private int ST_NO; //교직원번호
	private String PA_YN; //참여여부   1.미참여 / 2.참여
	
}
