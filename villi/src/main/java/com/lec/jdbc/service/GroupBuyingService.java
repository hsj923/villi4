package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.GroupBuyingVO;

public interface GroupBuyingService {

	GroupBuyingVO getGroupBuying(GroupBuyingVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<GroupBuyingVO> getGroupBuyingList(SearchVO searchVO);
	GroupBuyingVO insertGroupBuying(GroupBuyingVO groupBuying);
	int deleteGroupBuying(GroupBuyingVO groupBuying);
	int updateGroupBuying(GroupBuyingVO groupBuying);
	void updateCount(GroupBuyingVO groupBuying);
}
