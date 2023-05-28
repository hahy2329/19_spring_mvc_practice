package com.spring.practice.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice.board.dao.BoardDAO;
import com.spring.practice.board.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		
		
		boardDTO.setPasswd(bCryptPasswordEncoder.encode(boardDTO.getPasswd()));
		
		boardDAO.insertBoard(boardDTO);
		
		
		
	}




	@Override
	public List<BoardDTO> getBoardList() {
		
		
		
		List<BoardDTO> boardList = boardDAO.getBoardList();
		
		return boardList;
	}




	@Override
	public BoardDTO getBoardDTO(long boardId, boolean inCrese) {
		
		if(inCrese) {
			boardDAO.readCntIncrese(boardId);
			
		}
		
		BoardDTO boardDTO = boardDAO.getBoardDTO(boardId);
		
		return boardDTO;
	}




	@Override
	public boolean updateBoard(BoardDTO boardDTO) {
		
		boolean isUpdate = false;
		
		if(bCryptPasswordEncoder.matches(boardDTO.getPasswd(), boardDAO.encodedPassword(boardDTO.getBoardId()))) {
			
			boardDAO.updateBoard(boardDTO);
			isUpdate = true;
			
		}
		
		return isUpdate;
		
		
		
	}




	@Override
	public boolean removeBoard(BoardDTO boardDTO) {
		
		boolean isRemove = false;
		
		if(bCryptPasswordEncoder.matches(boardDTO.getPasswd(), boardDAO.encodedPassword(boardDTO.getBoardId()))) {
			boardDAO.removeBoard(boardDTO);
			isRemove = true;
		}
		
		return isRemove;
	}

}
