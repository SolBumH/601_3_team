package com.team_3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;
import com.team_3.dto.CodeDTO;
import com.team_3.dto.CounselingFormDTO;
import com.team_3.dto.GroupDTO;
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

	public int updateBoardDel(BoardDTO board) {
		return sqlSession.update("admin.updateBoardDel", board);
	}

	public int userUpdate(UserDTO dto) {
		return sqlSession.update("admin.userUpdate", dto);
	}

	public String getAnswerContent(int board_no) {
		return sqlSession.selectOne("admin.getAnswerContent", board_no);
	}

	public String getAnsYn(BoardDTO board) {
		return sqlSession.selectOne("admin.getAnsYn", board);
	}

	public int answerPostInsert(BoardDTO board) {
		return sqlSession.insert("admin.answerPostInsert", board);
	}
	
	public int answerPostUpdate(BoardDTO board) {
		return sqlSession.update("admin.answerPostUpdate", board);
	}
	
	public int answerNumberUpdate(BoardDTO board) {
		return sqlSession.update("admin.answerNumberUpdate", board);
	}

	public List<CounselingFormDTO> getJMSangdamList() {
		return sqlSession.selectList("admin.getJMSangdamList");
	}

	public List<CounselingFormDTO> getSRSangdamList() {
		return sqlSession.selectList("admin.getSRSangdamList");
	}
	
	public List<CounselingFormDTO> getJCSangdamList() {
		return sqlSession.selectList("admin.getJCSangdamList");
	}

	public int changeJMSRSVT(CounselingFormDTO dto) {
		return sqlSession.update("admin.changeJMSRSVT", dto);
	}
	
	public List<CodeDTO> getCodeList(CodeDTO codeDTO) {
		return sqlSession.selectList("admin.getCodeList",codeDTO);
	}

	public int JMSCancel(CounselingFormDTO dto) {
		return sqlSession.update("admin.JMSCancel",dto);
	}

	public int JSMUpdateDateAndTime(CounselingFormDTO dto) {
		return sqlSession.update("admin.JSMUpdateDateAndTime",dto);
	}

	public int JSMfinishedSangdam(CounselingFormDTO dto) {
		return sqlSession.update("admin.JSMfinishedSangdam",dto);
	}
}
