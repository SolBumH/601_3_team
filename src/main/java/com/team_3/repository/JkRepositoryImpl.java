package com.team_3.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class JkRepositoryImpl implements JkRepository{

	private SqlSession sqlSession;


	@Override
	public List<Map<String, Object>> getJkList(String jkselectdate) {
		return sqlSession.selectList("adminJkCounseling.getJkList", jkselectdate);
	}
	
	
}
