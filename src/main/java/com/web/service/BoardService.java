package com.web.service;

import java.util.List;
import java.util.Map;

import com.web.dto.BoardDTO;
import com.web.repository.BoardRepository;

public class BoardService {

	private BoardRepository boardRepo = new BoardRepository();
	
	public List<BoardDTO> getBoards(Map<String,String> param){
		return boardRepo.selectBoards(param);
	}
	
	public BoardDTO getBoard(int biNum) {
		return boardRepo.selectBoard(biNum);
	}
	
	public int addBoard(BoardDTO board) {
		return boardRepo.insertBoard(board);
	}
	
	public int modifyBoard(BoardDTO board) {
		return boardRepo.updateBoard(board);
	}
	
	public int removeBoard(int biNum) {
		return boardRepo.deleteBoard(biNum);
	}
}
