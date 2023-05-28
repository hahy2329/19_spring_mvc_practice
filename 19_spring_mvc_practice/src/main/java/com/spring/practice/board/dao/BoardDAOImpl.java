package com.spring.practice.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice.board.dto.BoardDTO;


@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
			
		sqlSession.insert("boardMappers.insertBoard", boardDTO);

	}

	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = sqlSession.selectList("boardMappers.getBoardList");
		
		return boardList;
	}

	@Override
	public BoardDTO getBoardDTO(long boardId) {
		
		BoardDTO boardDTO = sqlSession.selectOne("boardMappers.getBoardDTO", boardId);
		return boardDTO;
	}
	
	public void readCntIncrese(long boardId) {
		
		sqlSession.update("boardMappers.updateReadCnt", boardId);
		
	}
	
	public String encodedPassword(long boardId) {
		
		String encodePassword = sqlSession.selectOne("boardMappers.getEncodePassword", boardId);
		
		return encodePassword;
		
	}
	
	public void updateBoard(BoardDTO boardDTO) {
		
		sqlSession.update("boardMappers.updateBoard", boardDTO);
		
		
	}
	
	public void removeBoard(BoardDTO boardDTO) {
		
		sqlSession.delete("boardMappers.removeBoard", boardDTO);
	}
	
	
}
