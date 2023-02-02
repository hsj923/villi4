package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.CsBoardDAO;
import com.lec.jdbc.service.CsboardService;
import com.lec.jdbc.vo.CsBoardVO;

@Service("csboardService")
public class CsBoardServiceImpl implements CsboardService {

	@Autowired
	CsBoardDAO csboardDAO;
	
//	public BoardServiceImpl() {
//		System.out.println("Service °´Ã¼ »ý¼º!!!!");
//	}

	@Override
	public CsBoardVO getCsBoard(CsBoardVO vo) {
		return csboardDAO.getCsBoard(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return csboardDAO.getTotalRowCount(searchVO);
	}

	@Override
	public List<CsBoardVO> getCsBoardList(SearchVO searchVO) {
		return csboardDAO.getCsBoardList(searchVO);
	}

	@Override
	public CsBoardVO insertCsBoard(CsBoardVO csboard) {
		return csboardDAO.insertCsBoard(csboard);
	}

	@Override
	public int deleteCsBoard(CsBoardVO csboard) {
		return csboardDAO.deleteCsBoard(csboard);
	}

	@Override
	public int updateCsBoard(CsBoardVO csboard) {
		return csboardDAO.updateCsBoard(csboard);
	}

	@Override
	public void updateCsCount(CsBoardVO csboard) {
		csboardDAO.updateCsCount(csboard);
	}
}
