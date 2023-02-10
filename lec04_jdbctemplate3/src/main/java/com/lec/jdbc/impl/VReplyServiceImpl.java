package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.VReplyDAO;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.VReplyVO;

@Service("vreplyService")
public class VReplyServiceImpl implements VreplyService{
	
	@Autowired
	VReplyDAO vreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public VReplyVO getVReply(VReplyVO vo) {
		return vreplyDAO.getVReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return vreplyDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<VReplyVO> getVReplyList(int seq) {
		return vreplyDAO.getVReplyList(seq);
	}

	@Override
	public VReplyVO insertVReply(VReplyVO vreply) {
		return vreplyDAO.insertVReply(vreply);
	}

	@Override
	public int deleteVReply(VReplyVO vreply) {
		return vreplyDAO.deleteVReply(vreply);
	}

	@Override
	public int updateVReply(VReplyVO vreply) {
		return vreplyDAO.updateVReply(vreply);
	}
}
