package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.dao.CsDAO2;
import com.lec.jdbc.service.CsService2;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.CsVO2;
import com.lec.jdbc.vo.PageInfo;

@Service("csitemService")
public class CsServiceImpl2 implements CsService2{

	@Autowired
	private com.lec.jdbc.dao.CsDAO2 CsDAO2;
	
	@Override
	public CsVO2 getCsitem(CsVO2 csitem) {
		return CsDAO2.getCsitem(csitem);
	}

	@Override
	public List<CsVO2> getCsitemList(int currentPage, int perPage) {
		return CsDAO2.getCsitemList(currentPage, perPage);
	}

	@Override
	public PageInfo getPageInfo(int currentPage, int perPage) {
		return CsDAO2.getPageInfo("csitem", currentPage, perPage);
	}

	@Override
	public int insertCsitem(CsVO2 cs) {
		return CsDAO2.insertCsitem(cs);
	}

	@Override
	public int updateCsitem(CsVO2 cs) {
		return CsDAO2.updateCsitem(cs);
	}

	@Override
	public int deleteCsitem(CsVO2 cs) {
		return CsDAO2.deleteCsitem(cs);
	}

	@Override
	public List<CsVO2> getCsitemList(SearchVO searchVO) {
		return CsDAO2.getCsitemList(searchVO);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return CsDAO2.getTotalRowCount(searchVO);
	}

}
