package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.DemandVO;
import com.lec.jdbc.vo.DemandVO;

public interface DemandService {

	DemandVO getDemand(DemandVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<DemandVO> getDemandList(SearchVO searchVO);
	DemandVO insertDemand(DemandVO demand);
	int deleteDemand(DemandVO demand);
	int updateDemand(DemandVO demand);
	void updateDemandCount(DemandVO demand);
	
	
//	요청리스트확인
	List<DemandVO> getMyDemandList(String nickname);
}