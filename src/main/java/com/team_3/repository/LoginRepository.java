package com.team_3.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.UserDTO;

@Repository
public class LoginRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public UserDTO list() {
		return sqlSession.selectOne("test.test");
	}

}
