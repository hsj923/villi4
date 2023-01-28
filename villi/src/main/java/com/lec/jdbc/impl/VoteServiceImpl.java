package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.VoteDAO;
import com.lec.jdbc.service.VoteService;
import com.lec.jdbc.vo.VoteVO;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteDAO voteDAO;
	
//	public VoteServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public VoteVO getVote(VoteVO vo) {
		return voteDAO.getVote(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return voteDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<VoteVO> getVoteList(SearchVO searchVO) {
		return voteDAO.getVoteList(searchVO);
	}

	@Override
	public VoteVO insertVote(VoteVO vote) {
		return voteDAO.insertVote(vote);
	}
	
	@Override
	public int deleteVote(VoteVO vote) {
		return voteDAO.deleteVote(vote);
	}

	@Override
	public int updateVote(VoteVO vote) {
		return voteDAO.updateVote(vote);
	}
	
	@Override
	public void updateVoteCount(VoteVO vote) {
		voteDAO.updateVoteCount(vote);
	}

	
}
