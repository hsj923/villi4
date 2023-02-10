package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.VReplyVO;

public interface VreplyService {

	VReplyVO getVReply(VReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	VReplyVO insertVReply(VReplyVO vreply);
	int deleteVReply(VReplyVO vreply);
	int updateVReply(VReplyVO vreply);
	List<VReplyVO> getVReplyList(int seq);
}
