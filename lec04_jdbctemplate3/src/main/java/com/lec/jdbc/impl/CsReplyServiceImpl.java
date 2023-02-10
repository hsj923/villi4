package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.CsReplyDAO;
import com.lec.jdbc.service.CsreplyService;
import com.lec.jdbc.vo.CsReplyVO;

@Service("csreplyService")
public class CsReplyServiceImpl implements CsreplyService{
	
	@Autowired
	CsReplyDAO csreplyDAO;
	
//	public BoardServiceImpl() {
//	System.out.println("Service ��ü ����!!!!");
//}
	
	@Override
	public CsReplyVO getCsReply(CsReplyVO vo) {
		return csreplyDAO.getCsReply(vo);
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return csreplyDAO.getTotalRowCount(searchVO);
	}

	@Override
	public List<CsReplyVO> getCsReplyList(int bno) {
		return csreplyDAO.getCsReplyList(bno);
	}

	@Override
	public CsReplyVO insertCsReply(CsReplyVO csreply) {
		return csreplyDAO.insertCsReply(csreply);
	}

	@Override
	public int deleteCsReply(CsReplyVO csreply) {
		return csreplyDAO.deleteCsReply(csreply);
	}

	@Override
	public int updateCsReply(CsReplyVO csreply) {
		return csreplyDAO.updateCsReply(csreply);
	}

}