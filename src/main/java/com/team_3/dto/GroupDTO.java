package com.team_3.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class GroupDTO {

	private int JD_NO; //집단상담번호
	private String PG_NAME; //프로그램명
	private String PG_EXPLAIN; //프로그램 설명
	private Date EN_DATE; //마감일
	private String EN_NO; //마감여부
	private Date JMS_CS_DATE; //상담일자
	private int TO_NO; //총 인원수
	private int AP_NO; //신청인원수
	private int PA_NO; //참여인원수
	
}
