package com.project.covidhandong.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	@Override
	public List<BoardVO> getFoundList(String toFind) {
		return boardDAO.getFoundList(toFind);
	}

	@Override
	public List<BoardVO> getOrderedList(String orderColumn) {
		return boardDAO.getOrderedList(orderColumn);
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		return boardDAO.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}
	
	@Override
	public int deleteBoard(int id) {
		return boardDAO.deleteBoard(id);
	}

}