package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.CsVO;

public interface CsService {

	CsVO getCs(CsVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<CsVO> getCsList(SearchVO searchVO);
	CsVO insertCs(CsVO cs);
	int deleteCs(CsVO cs);
	int updateCs(CsVO cs);
	void updateCsCount(CsVO cs);

}