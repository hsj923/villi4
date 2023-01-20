package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.PageInfo;

public interface BoardService {

	BoardVO getBoard(BoardVO board);
	List<BoardVO> getBoardList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	int insertBoard(BoardVO board);
	int deleteBoard(BoardVO board);
	int updateBoard(BoardVO board);
	
	List<BoardVO> getBoardList(SearchVO searchVO);
	int getTotalRowCount(SearchVO searchVO);	
	
}
