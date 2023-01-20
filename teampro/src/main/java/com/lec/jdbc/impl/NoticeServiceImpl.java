package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.dao.NoticeDAO;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO NoticeDAO;
	
	
	@Override
	public NoticeVO getNotice(NoticeVO notice) {
		return NoticeDAO.getNotice(notice);
	}

	@Override
	public List<NoticeVO> getNoticeList(int currentPage, int perPage) {
		return NoticeDAO.getNoticeList(currentPage, perPage);
	}

	@Override
	public PageInfo getPageInfo(int currentPage, int perPage) {
		return NoticeDAO.getPageInfo("notice", currentPage, perPage);
	}

	@Override
	public int insertNotice(NoticeVO notice) {
		return NoticeDAO.insertNotice(notice);
	}

	@Override
	public int deleteNotice(NoticeVO notice) {
		return NoticeDAO.deleteNotice(notice);
	}

}
