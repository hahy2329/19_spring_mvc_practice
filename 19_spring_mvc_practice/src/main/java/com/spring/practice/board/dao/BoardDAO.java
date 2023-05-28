package com.spring.practice.board.dao;

import java.util.List;

import com.spring.practice.board.dto.BoardDTO;

public interface BoardDAO {
	
	public void insertBoard(BoardDTO boardDTO); 
	
	public List<BoardDTO> getBoardList();
	
	public void readCntIncrese(long boardId);
	public BoardDTO getBoardDTO(long boardId);
	
	public String encodedPassword(long boardId);
	public void updateBoard(BoardDTO boardDTO);
	
	public void removeBoard(BoardDTO boardDTO);
}
