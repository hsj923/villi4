package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.DReplyVO;

public interface DreplyService {

	DReplyVO getDReply(DReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	DReplyVO insertDReply(DReplyVO dreply);
	int deleteDReply(DReplyVO dreply);
	int updateDReply(DReplyVO dreply);
	List<DReplyVO> getDReplyList(int seq);
}
