package com.team_3.repository;

import java.util.List;
import java.util.Map;

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

	public List<CounselingFormDTO> getJKSangdamList() {
		return sqlSession.selectList("admin.getJKSangdamList");
	}

	public List<CodeDTO> getCodeList(CodeDTO codeDTO) {
		return sqlSession.selectList("admin.getCodeList",codeDTO);
	}
	
	public int changeJMSRSVT(CounselingFormDTO dto) {
		return sqlSession.update("admin.changeJMSRSVT", dto);
	}
	
	public int changeSRSRSVT(CounselingFormDTO dto) {
		return sqlSession.update("admin.changeSRSRSVT", dto);
	}
	
	public int changeJCSRSVT(CounselingFormDTO dto) {
		return sqlSession.update("admin.changeJCSRSVT", dto);
	}
	
	public int changeJKSRSVT(CounselingFormDTO dto) {
		return sqlSession.update("admin.changeJKSRSVT", dto);
	}
	
	public int JMSCancel(CounselingFormDTO dto) {
		return sqlSession.update("admin.JMSCancel",dto);
	}
	
	public int SRSCancel(CounselingFormDTO dto) {
		return sqlSession.update("admin.SRSCancel",dto);
	}
	
	public int JCSCancel(CounselingFormDTO dto) {
		return sqlSession.update("admin.JCSCancel",dto);
	}
	
	public int JKSCancel(CounselingFormDTO dto) {
		return sqlSession.update("admin.JKSCancel",dto);
	}

	public int JMSUpdateDateAndTime(CounselingFormDTO dto) {
		return sqlSession.update("admin.JMSUpdateDateAndTime",dto);
	}

	public int SRSUpdateDateAndTime(CounselingFormDTO dto) {
		return sqlSession.update("admin.SRSUpdateDateAndTime",dto);
	}

	public int JCSUpdateDateAndTime(CounselingFormDTO dto) {
		return sqlSession.update("admin.JCSUpdateDateAndTime",dto);
	}
	public int JKSUpdateDateAndTime(CounselingFormDTO dto) {
		return sqlSession.update("admin.JKSUpdateDateAndTime",dto);
	}

	public int JMSfinishedSangdam(CounselingFormDTO dto) {
		return sqlSession.update("admin.JMSfinishedSangdam",dto);
	}

	public int SRSfinishedSangdam(CounselingFormDTO dto) {
		return sqlSession.update("admin.SRSfinishedSangdam",dto);
	}
	
	public int JCSfinishedSangdam(CounselingFormDTO dto) {
		return sqlSession.update("admin.JCSfinishedSangdam",dto);
	}
	public int JKSfinishedSangdam(CounselingFormDTO dto) {
		return sqlSession.update("admin.JKSfinishedSangdam",dto);
	}
	
	public List<Map<String, Object>> chart() {
		return sqlSession.selectList("admin.chart");
	}

	public int saveGroup(GroupDTO groupDTO) {
		return sqlSession.insert("admin.saveGroup", groupDTO);
	}

	public List<GroupDTO> groupList() {
		return sqlSession.selectList("admin.groupList");
	}


}
