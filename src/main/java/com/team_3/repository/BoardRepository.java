package com.team_3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team_3.dto.BoardDTO;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> boardList() {
		return sqlSession.selectList("board.boardList");
	}
	
	public int write(BoardDTO board) {
		return sqlSession.insert("board.boardInsert", board);
	}

	public BoardDTO getDetail(int no) {
		return sqlSession.selectOne("board.detail", no);
	}
}
