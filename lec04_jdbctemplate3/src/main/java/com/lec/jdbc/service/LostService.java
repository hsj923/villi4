package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.LostVO;

public interface LostService {

	LostVO getLost(LostVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<LostVO> getLostList(SearchVO searchVO);
	LostVO insertLost(LostVO lost);
	int deleteLost(LostVO lost);
	int updateLost(LostVO lost);
	void updateLostCount(LostVO lost);
}