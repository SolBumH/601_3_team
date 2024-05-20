package com.team_3.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CounselingDTO;
import com.team_3.dto.CounselingFormDTO;

@Repository
public class CounselingRepositoryImpl implements CounselingRepository {

    private SqlSession sqlSession;

    @Autowired
    public CounselingRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public void saveForm(CounselingDTO formDTO) {
		sqlSession.insert("jcCounselingForm.insertCounselingForm", formDTO);		
	}
	
	@Override
	public String findStudentNumber(String username) {
		return sqlSession.selectOne("jcCounselingForm.findByStud_no", username);
	}
	
	//집단상담
	@Override
    public List<BoardDTO> getGroupData() {
		    return sqlSession.selectList("jcCounselingForm.selectGroupData");
    }

	@Override
	public List<Map<String, Object>> getSchedule() {
		return sqlSession.selectList("jcCounselingForm.getSchedule");
	}
	
	@Override
	public BoardDTO getDetail(int no) {
		return sqlSession.selectOne("jcCounselingForm.getDetail", no);
	}
	
	@Override
	public BoardDTO getResult(int no) {
		return sqlSession.selectOne("jcCounselingForm.getResult", no);
	}
	
	@Override
	public int saveFormJM(CounselingFormDTO formDTO) {
		return sqlSession.insert("jcCounselingForm.saveFormJM", formDTO);
	}

	//지도교수상담
	@Override
	public int saveAdvisorCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("jcCounselingForm.saveAdvisorCounselingForm", formDTO);
	}

	//전문상담
	@Override
	public int saveExpertCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("jcCounselingForm.saveExpertCounselingForm", formDTO);
	}

	//심리상담
	@Override
	public int savePsychologicalCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("jcCounselingForm.savePsychologicalCounselingForm", formDTO);
	}
	
	//취업상담
	@Override
	public int saveEmploymentCounselingForm(CounselingFormDTO formDTO) {
		return sqlSession.insert("jcCounselingForm.saveEmploymentCounselingForm", formDTO);
	}


	
	
}
