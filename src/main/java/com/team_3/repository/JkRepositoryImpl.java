package com.team_3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.CounselingFormDTO;
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

	@Override
	public List<JkDTO> getSchedule(String date) {
		return sqlSession.selectList("JkCounseling.getSchedule", date);
	}

	@Override
	public String findStudentNumber(String userId) {
		return sqlSession.selectOne("JkCounseling.findByStudno", userId);
	}

	@Override
	public int saveAdvisorCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("JkCounseling.saveAdvisorCounselingForm", formDTO);
	}

	@Override
	public int saveExpertCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("JkCounseling.saveExpertCounselingForm", formDTO);
	}

	@Override
	public int savePsychologicalCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("JkCounseling.savePsychologicalCounselingForm", formDTO);
	}

	@Override
	public int saveEmploymentCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("JkCounseling.saveEmploymentCounselingForm", formDTO);
	}
	
	
}
