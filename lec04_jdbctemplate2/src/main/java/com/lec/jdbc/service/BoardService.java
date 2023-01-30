<<<<<<< HEAD
package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.BoardVO;

public interface BoardService {

	BoardVO getBoard(BoardVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<BoardVO> getBoardList(SearchVO searchVO);
	BoardVO insertBoard(BoardVO board);
	int deleteBoard(BoardVO board);
	int updateBoard(BoardVO board);
	void updateCount(BoardVO board);
}
=======
package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.BoardVO;

public interface BoardService {

	BoardVO getBoard(BoardVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<BoardVO> getBoardList(SearchVO searchVO);
	BoardVO insertBoard(BoardVO board);
	int deleteBoard(BoardVO board);
	int updateBoard(BoardVO board);
	void updateCount(BoardVO board);
}
>>>>>>> d64295aecd8792d0b76d453b25173965f5a1ce4d
