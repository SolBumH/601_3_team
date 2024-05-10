package com.team_3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.UserDTO;

@Repository
public class AdminRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> AdminBoard() {
		return sqlSession.selectList("admin.AdminBoard");
	}

	public List<UserDTO> AdminUser() {
		return sqlSession.selectList("admin.AdminUser");
	}

}
