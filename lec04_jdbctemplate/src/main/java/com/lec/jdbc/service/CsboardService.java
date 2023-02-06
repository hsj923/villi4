package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.CsBoardVO;

public interface CsboardService {

	CsBoardVO getCsBoard(CsBoardVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<CsBoardVO> getCsBoardList(SearchVO searchVO);
	CsBoardVO insertCsBoard(CsBoardVO csboard);
	int deleteCsBoard(CsBoardVO csboard);
	int updateCsBoard(CsBoardVO csboard);
	void updateCsCount(CsBoardVO csboard);
}
