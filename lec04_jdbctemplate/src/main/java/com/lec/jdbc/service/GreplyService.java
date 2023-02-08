package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.GReplyVO;

public interface GreplyService {

	GReplyVO getGReply(GReplyVO vo);
	int getTotalRowCount(SearchVO searchVO);
	GReplyVO insertGReply(GReplyVO greply);
	int deleteGReply(GReplyVO greply);
	int updateGReply(GReplyVO greply);
	List<GReplyVO> getGReplyList(int seq);
}
