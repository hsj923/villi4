package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.DemandDAO;
import com.lec.jdbc.service.DemandService;
import com.lec.jdbc.vo.DemandVO;

@Service("demandService")
public class DemandServiceImpl implements DemandService {

	@Autowired
	DemandDAO demandDAO;
	
//	public DemandServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public DemandVO getDemand(DemandVO vo) {
		return demandDAO.getDemand(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return demandDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<DemandVO> getDemandList(SearchVO searchVO) {
		return demandDAO.getDemandList(searchVO);
	}

	@Override
	public DemandVO insertDemand(DemandVO demand) {
		return demandDAO.insertDemand(demand);
	}
	
	@Override
	public int deleteDemand(DemandVO demand) {
		return demandDAO.deleteDemand(demand);
	}

	@Override
	public int updateDemand(DemandVO demand) {
		return demandDAO.updateDemand(demand);
	}
	
	@Override
	public void updateDemandCount(DemandVO demand) {
		demandDAO.updateDemandCount(demand);
	}

	
}