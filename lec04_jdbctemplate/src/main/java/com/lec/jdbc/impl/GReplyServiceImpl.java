package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.DReplyDAO;
import com.lec.jdbc.dao.GReplyDAO;
import com.lec.jdbc.dao.VReplyDAO;
import com.lec.jdbc.service.DreplyService;
import com.lec.jdbc.service.GreplyService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.GReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Service("greplyService")
public class GReplyServiceImpl implements GreplyService{
	
	@Autowired
	GReplyDAO greplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public GReplyVO getGReply(GReplyVO vo) {
		return greplyDAO.getGReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return greplyDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<GReplyVO> getGReplyList(int seq) {
		return greplyDAO.getGReplyList(seq);
	}

	@Override
	public GReplyVO insertGReply(GReplyVO greply) {
		return greplyDAO.insertGReply(greply);
	}

	@Override
	public int deleteGReply(GReplyVO greply) {
		return greplyDAO.deleteGReply(greply);
	}

	@Override
	public int updateGReply(GReplyVO greply) {
		return greplyDAO.updateGReply(greply);
	}
}
