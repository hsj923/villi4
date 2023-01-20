package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;

public interface NoticeService {

	NoticeVO getNotice(NoticeVO notice);
	List<NoticeVO> getNoticeList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	int insertNotice(NoticeVO notice);
	int deleteNotice(NoticeVO notice);
}
