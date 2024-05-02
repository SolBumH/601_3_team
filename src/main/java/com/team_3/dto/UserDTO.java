package com.team_3.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class UserDTO {
	@Id // 회원번호, PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userNo;
	
	@Column(name = "login_id") // 로그인 아이디
	private String loginId;
	
	@Column(name = "pw") // 비밀번호
	private String pw;

	@Column(name = "fir_yn") // 계정 잠금 여부
	private String firYN;
	
	@Column(name ="pw_err_cnt") // 비밀번호 오류 수
	private int pwErrCnt;
	
	@Column(name = "rct_acc_dt") // 최근 접속일
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime rctAccDt;
	
	@Column(name = "admin_yn") // 관리자 여부
	private String adminYN;
}
