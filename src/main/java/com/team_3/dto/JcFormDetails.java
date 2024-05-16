package com.team_3.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JcFormDetails implements UserDetails {

	private UserDTO userDTO;

	public JcFormDetails(UserDTO user) {
		this.userDTO = user;
	}
	
	private CounselingFormDTO CounselingFormDTO;

	public JcFormDetails(CounselingFormDTO counselingFormDTO) {
		this.CounselingFormDTO = CounselingFormDTO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collection = new ArrayList<>();

		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {

				return userDTO.getRole();
			}
		});

		return collection;
	}

	@Override
	public String getPassword() {
		return userDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return userDTO.getUsername();
	}
	
	public String getName() {
		return userDTO.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getStudentNumber() { //신청폼 학번
	    if (this.CounselingFormDTO != null) {
	        return this.CounselingFormDTO.getSTUD_NO();
	    } else {
	        return null; 
	    }
	}
}
