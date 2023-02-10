package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.LReplyDAO;
import com.lec.jdbc.service.LreplyService;
import com.lec.jdbc.vo.LReplyVO;

@Service("lreplyService")
public class LReplyServiceImpl implements LreplyService{
	
	@Autowired
	LReplyDAO lreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public LReplyVO getLReply(LReplyVO vo) {
		return lreplyDAO.getLReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return lreplyDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<LReplyVO> getLReplyList(int seq) {
		return lreplyDAO.getLReplyList(seq);
	}

	@Override
	public LReplyVO insertLReply(LReplyVO lreply) {
		return lreplyDAO.insertLReply(lreply);
	}

	@Override
	public int deleteLReply(LReplyVO lreply) {
		return lreplyDAO.deleteLReply(lreply);
	}

	@Override
	public int updateLReply(LReplyVO lreply) {
		return lreplyDAO.updateLReply(lreply);
	}


}
