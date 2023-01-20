package com.lec.jdbc.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.dao.BoardDAO;
import com.lec.jdbc.dao.BoardDAO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO BoardDAO;

	@Override
	public BoardVO getBoard(BoardVO board) {
		return BoardDAO.getBoard(board);
	}
	
	@Override
	public PageInfo getPageInfo(int currentPage, int perPage) {
		return BoardDAO.getPageInfo("Boards", currentPage, perPage);
	}

	@Override
	public List<BoardVO> getBoardList(int currentPage, int perPage) {
		return BoardDAO.getBoardList(currentPage, perPage);
	}

	@Override
	public int insertBoard(BoardVO board) {
		return BoardDAO.insertBoard(board);
	}

	@Override
	public int deleteBoard(BoardVO board) {
		return BoardDAO.deleteBoard(board);
	}
	
	@Override
	public int updateBoard(BoardVO board) {
		return BoardDAO.updateBoard(board);
	}

/* ------------------------------------------------------------------------------*/	
	@Override
	public List<BoardVO> getBoardList(SearchVO searchVO) {
		return BoardDAO.getBoardList(searchVO);
	}	
	
	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return BoardDAO.getTotalRowCount(searchVO);
	}

}