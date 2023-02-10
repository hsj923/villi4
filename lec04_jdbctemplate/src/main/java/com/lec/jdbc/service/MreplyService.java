package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.MReplyVO;

public interface MreplyService {

	MReplyVO getMReply(MReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	MReplyVO insertMReply(MReplyVO mreply);
	int deleteMReply(MReplyVO mreply);
	int updateMReply(MReplyVO mreply);
	List<MReplyVO> getMReplyList(int seq);
}
