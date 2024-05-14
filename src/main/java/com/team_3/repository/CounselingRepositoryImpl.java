package com.team_3.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingFormDTO;

@Repository
public class CounselingRepositoryImpl implements CounselingRepository {

    private SqlSession sqlSession;

    @Autowired
    public CounselingRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public void saveForm(CounselingFormDTO formDTO) {
		sqlSession.insert("jcCounselingForm.insertCounselingForm", formDTO);		
	}

	@Override
	public String findByJcNo(String str) {
		return sqlSession.selectOne("jcCounselingForm.findByJcNo", str);
	}

	@Override
	public String findBySTUD_NO(String str2) {
		return sqlSession.selectOne("jcCounselingForm.findBySTUD_NO", str2);
	}
}
