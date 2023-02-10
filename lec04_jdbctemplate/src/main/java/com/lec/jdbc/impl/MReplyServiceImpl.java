package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.LReplyDAO;
import com.lec.jdbc.dao.MReplyDAO;
import com.lec.jdbc.service.LreplyService;
import com.lec.jdbc.service.MreplyService;
import com.lec.jdbc.vo.LReplyVO;
import com.lec.jdbc.vo.MReplyVO;

@Service("mreplyService")
public class MReplyServiceImpl implements MreplyService{
	
	@Autowired
	MReplyDAO mreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public MReplyVO getMReply(MReplyVO vo) {
		return mreplyDAO.getMReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return mreplyDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<MReplyVO> getMReplyList(int seq) {
		return mreplyDAO.getMReplyList(seq);
	}

	@Override
	public MReplyVO insertMReply(MReplyVO mreply) {
		return mreplyDAO.insertMReply(mreply);
	}

	@Override
	public int deleteMReply(MReplyVO mreply) {
		return mreplyDAO.deleteMReply(mreply);
	}

	@Override
	public int updateMReply(MReplyVO mreply) {
		return mreplyDAO.updateMReply(mreply);
	}


}
