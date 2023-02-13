package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.NoticeVO;

public interface NoticeService {

	NoticeVO getNotice(NoticeVO vo);
	List<NoticeVO> getNoticeList(SearchVO searchVO);
	NoticeVO insertNotice(NoticeVO notice);
	int deleteNotice(NoticeVO notice);
	int updateNotice(NoticeVO notice);
	
}