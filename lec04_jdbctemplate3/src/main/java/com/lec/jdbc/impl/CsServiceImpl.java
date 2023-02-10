package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.CsDAO;
import com.lec.jdbc.service.CsService;
import com.lec.jdbc.vo.CsVO;

@Service("csService")
public class CsServiceImpl implements CsService {

	@Autowired
	CsDAO csDAO;
	
//	public CsServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public CsVO getCs(CsVO vo) {
		return csDAO.getCs(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return csDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<CsVO> getCsList(SearchVO searchVO) {
		return csDAO.getCsList(searchVO);
	}

	@Override
	public CsVO insertCs(CsVO cs) {
		return csDAO.insertCs(cs);
	}
	
	@Override
	public int deleteCs(CsVO cs) {
		return csDAO.deleteCs(cs);
	}

	@Override
	public int updateCs(CsVO cs) {
		return csDAO.updateCs(cs);
	}
	
	@Override
	public void updateCsCount(CsVO cs) {
		csDAO.updateCsCount(cs);
	}


	
}