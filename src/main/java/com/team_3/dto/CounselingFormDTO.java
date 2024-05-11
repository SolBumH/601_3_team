package com.team_3.dto;

import lombok.Data;

@Data
public class CounselingFormDTO {
	
	private Long id;
    private String name;
    private String studentId;
    private String email;
    private String phoneNumber;
    private String counselingType;
	
}
