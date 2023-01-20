package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.PageInfo;

public interface CsService {

	CsVO getCs(CsVO cs);
	
	List<CsVO> getCsList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	int insertCs(CsVO cs);
	int updateCs(CsVO cs);
	int deleteCs(CsVO cs);
	
//	int detailCs(CsVO cs);	
//	
	List<CsVO> getCsList(SearchVO searchVO);
	int getTotalRowCount(SearchVO searchVO);
	
}
