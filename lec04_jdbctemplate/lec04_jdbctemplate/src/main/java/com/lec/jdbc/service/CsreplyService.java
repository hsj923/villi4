package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.CsReplyVO;

public interface CsreplyService {

	CsReplyVO getCsReply(CsReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	CsReplyVO insertCsReply(CsReplyVO csreply);
	int deleteCsReply(CsReplyVO csreply);
	int updateCsReply(CsReplyVO csreply);
	List<CsReplyVO> getCsReplyList(int bno);
}