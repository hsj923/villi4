package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.GroupBuyingDAO;
import com.lec.jdbc.service.GroupBuyingService;
import com.lec.jdbc.vo.GroupBuyingVO;

@Service("groupBuyingService")
public class GroupBuyingimpl implements GroupBuyingService {

	@Autowired
	GroupBuyingDAO groupBuyingDAO;
	
//	public GroupBuyingServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public GroupBuyingVO getGroupBuying(GroupBuyingVO vo) {
		return groupBuyingDAO.getGroupBuying(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return groupBuyingDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<GroupBuyingVO> getGroupBuyingList(SearchVO searchVO) {
		return groupBuyingDAO.getGroupBuyingList(searchVO);
	}

	@Override
	public GroupBuyingVO insertGroupBuying(GroupBuyingVO groupBuying) {
		return groupBuyingDAO.insertGroupBuying(groupBuying);
	}
	
	@Override
	public int deleteGroupBuying(GroupBuyingVO groupBuying) {
		return groupBuyingDAO.deleteGroupBuying(groupBuying);
	}

	@Override
	public int updateGroupBuying(GroupBuyingVO groupBuying) {
		return groupBuyingDAO.updateGroupBuying(groupBuying);
	}
	
	@Override
	public void updateGroupBuyingCount(GroupBuyingVO groupBuying) {
		groupBuyingDAO.updateGroupBuyingCount(groupBuying);
	}

	
}