package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.LostDAO;
import com.lec.jdbc.service.LostService;
import com.lec.jdbc.vo.LostVO;

@Service("lostService")
public class LostServiceImpl implements LostService {

	@Autowired
	LostDAO lostDAO;
	
//	public LostServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public LostVO getLost(LostVO vo) {
		return lostDAO.getLost(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return lostDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<LostVO> getLostList(SearchVO searchVO) {
		return lostDAO.getLostList(searchVO);
	}

	@Override
	public LostVO insertLost(LostVO lost) {
		return lostDAO.insertLost(lost);
	}
	
	@Override
	public int deleteLost(LostVO lost) {
		return lostDAO.deleteLost(lost);
	}

	@Override
	public int updateLost(LostVO lost) {
		return lostDAO.updateLost(lost);
	}
	
	@Override
	public void updateLostCount(LostVO lost) {
		lostDAO.updateLostCount(lost);
	}

	
}