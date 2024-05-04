package com.team_3.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
	private Integer userno;
	private String loginid;
	private String pw;
	private String firyn;
	private Integer pwerrcnt;
	private LocalDateTime rctaccdate;
	private String adminyn;
}
