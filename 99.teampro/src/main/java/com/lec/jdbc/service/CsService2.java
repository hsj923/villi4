package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.CsVO2;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;

public interface CsService2 {

	CsVO2 getCsitem(CsVO2 csitem);
	
	List<CsVO2> getCsitemList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	int insertCsitem(CsVO2 csitem);
	int updateCsitem(CsVO2 csitem);
	int deleteCsitem(CsVO2 csitem);
	
	List<CsVO2> getCsitemList(SearchVO searchVO);
	int getTotalRowCount(SearchVO searchVO);
}
