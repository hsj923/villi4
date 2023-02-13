package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.LReplyVO;

public interface LreplyService {

	LReplyVO getLReply(LReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	LReplyVO insertLReply(LReplyVO lreply);
	int deleteLReply(LReplyVO lreply);
	int updateLReply(LReplyVO lreply);
	List<LReplyVO> getLReplyList(int seq);
}
