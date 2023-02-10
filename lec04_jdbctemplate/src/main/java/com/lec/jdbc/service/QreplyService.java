package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.QReplyVO;

public interface QreplyService {

	QReplyVO getQReply(QReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	QReplyVO insertQReply(QReplyVO qreply);
	int deleteQReply(QReplyVO qreply);
	int updateQReply(QReplyVO qreply);
	List<QReplyVO> getQReplyList(int seq);
}