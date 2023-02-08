package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.DemandVO;

public interface DemandService {

	DemandVO getDemand(DemandVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<DemandVO> getDemandList(SearchVO searchVO);
	DemandVO insertDemand(DemandVO demand);
	int deleteDemand(DemandVO demand);
	int updateDemand(DemandVO demand);
	void updateDemandCount(DemandVO demand);
}