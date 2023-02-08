package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.VoteVO;

public interface VoteService {

	VoteVO getVote(VoteVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<VoteVO> getVoteList(SearchVO searchVO);
	VoteVO insertVote(VoteVO vote);
	int deleteVote(VoteVO vote);
	int updateVote(VoteVO vote);
	void updateVoteCount(VoteVO vote);
}