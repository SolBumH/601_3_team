package com.team_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team_3.dto.UserDTO;

public interface LoginRepository extends JpaRepository<UserDTO, Integer>{

	List<UserDTO> findByLoginidAndPw(String loginid, String pw);

	Long countByLoginid(String loginid);

	Long countByLoginid(UserDTO user);
}
