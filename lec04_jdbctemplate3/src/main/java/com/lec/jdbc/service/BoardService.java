package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.BoardVO;

public interface BoardService {

	BoardVO getBoard(BoardVO vo);
	
	int getTotalRowCount(SearchVO searchVO);
	List<BoardVO> getBoardList(SearchVO searchVO);
	BoardVO insertBoard(BoardVO board);
	BoardVO insertServiceBoard(BoardVO board);
	int deleteBoard(BoardVO board);
	int updateBoard(BoardVO board);

	//	조회수증가
	void updateBoardCount(BoardVO board);

	//	내가쓴글목록
	List<BoardVO> getMyBoardList(String Writer);
	
}