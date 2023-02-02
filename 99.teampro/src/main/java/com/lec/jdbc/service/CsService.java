package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.PageInfo;

public interface CsService {

	CsVO getCsitem(CsVO cs);
	
	List<CsVO> getCsitemList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	int insertCsitem(CsVO cs);
	int updateCsitem(CsVO cs);
	int deleteCsitem(CsVO cs);
	
//	int detailCs(CsVO cs);	
//	
	List<CsVO> getCsitemList(SearchVO searchVO);
	int getTotalRowCount(SearchVO searchVO);
	
}
