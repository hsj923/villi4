package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.DReplyDAO;
import com.lec.jdbc.dao.VReplyDAO;
import com.lec.jdbc.service.DreplyService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Service("dreplyService")
public class DReplyServiceImpl implements DreplyService{
	
	@Autowired
	DReplyDAO dreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public DReplyVO getDReply(DReplyVO vo) {
		return dreplyDAO.getDReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return dreplyDAO.getTotalRowCount(searchVO);
	}

	@Override
	public List<DReplyVO> getDReplyList(int seq) {
		return dreplyDAO.getDReplyList(seq);
	}
	
	@Override
	public DReplyVO insertDReply(DReplyVO dreply) {
		return dreplyDAO.insertDReply(dreply);
	}

	@Override
	public int deleteDReply(DReplyVO dreply) {
		return dreplyDAO.deleteDReply(dreply);
	}

	@Override
	public int updateDReply(DReplyVO dreply) {
		return dreplyDAO.updateDReply(dreply);
	}
}
