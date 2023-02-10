package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.QReplyDAO;
import com.lec.jdbc.service.QreplyService;
import com.lec.jdbc.vo.QReplyVO;

@Service("qreplyService")
public class QReplyServiceImpl implements QreplyService{
	
	@Autowired
	QReplyDAO qreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service °´Ã¼ »ý¼º!!!!");
//}

	@Override
	public QReplyVO getQReply(QReplyVO vo) {
		return qreplyDAO.getQReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return qreplyDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<QReplyVO> getQReplyList(int seq) {
		return qreplyDAO.getQReplyList(seq);
	}

	@Override
	public QReplyVO insertQReply(QReplyVO qreply) {
		return qreplyDAO.insertQReply(qreply);
	}

	@Override
	public int deleteQReply(QReplyVO qreply) {
		return qreplyDAO.deleteQReply(qreply);
	}

	@Override
	public int updateQReply(QReplyVO qreply) {
		return qreplyDAO.updateQReply(qreply);
	}	

}
