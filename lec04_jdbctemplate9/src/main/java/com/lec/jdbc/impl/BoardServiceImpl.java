package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.BoardDAO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
//	public BoardServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return boardDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<BoardVO> getBoardList(SearchVO searchVO) {
		return boardDAO.getBoardList(searchVO);
	}

	@Override
	public BoardVO insertBoard(BoardVO board) {
		return boardDAO.insertBoard(board);
	}
	
	@Override
	public BoardVO insertServiceBoard(BoardVO board) {
		return boardDAO.insertServiceBoard(board);
	}

	@Override
	public int deleteBoard(BoardVO board) {
		return boardDAO.deleteBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board) {
		return boardDAO.updateBoard(board);
	}

	@Override
	public void updateBoardCount(BoardVO board) {
		boardDAO.updateBoardCount(board);
	}
	
//	내가쓴글목록
	@Override
	public List<BoardVO> getMyBoardList(String writer) {
		return boardDAO.getMyBoardList(writer);
	}

	@Override
	public List<BoardVO> MyBoardList(String writer) {
		// TODO Auto-generated method stub
		return boardDAO.MyBoardList(writer);
	}
}