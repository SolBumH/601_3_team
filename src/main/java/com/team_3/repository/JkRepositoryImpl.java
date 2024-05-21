package com.team_3.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.JkDTO;

@Repository
public class JkRepositoryImpl implements JkRepository{

	private SqlSession sqlSession;

    @Autowired
    public JkRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public int getJkList(JkDTO dto) {
		return sqlSession.insert("adminJkCounseling.getJkList", dto);
	}

	@Override
	public List<JkDTO> searchList(JkDTO dto) {
		return sqlSession.selectList("adminJkCounseling.searchList", dto);
	}
	
	
}
