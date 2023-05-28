package com.spring.practice.board.service;

import java.util.List;

import com.spring.practice.board.dto.BoardDTO;

public interface BoardService {
	
	public void insertBoard(BoardDTO boardDTO);
	
	public List<BoardDTO> getBoardList();
	
	public BoardDTO getBoardDTO(long boardId, boolean inCrese);
	
	
	public boolean updateBoard(BoardDTO boardDTO);
	public boolean removeBoard(BoardDTO boardDTO);
}
