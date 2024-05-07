package com.team_3.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
	private Integer user_no;
	private String login_id;
	private String pw;
	private String fir_yn;
	private Integer pw_err_cnt;
	private LocalDateTime rct_acc_dt;
	private String admin_yn;
}
