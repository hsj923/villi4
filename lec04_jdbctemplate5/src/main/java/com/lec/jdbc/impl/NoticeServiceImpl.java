package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.NoticeDAO;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDAO noticeDAO;
	
//	public NoticeServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}
	
	
	@Override
	public List<NoticeVO> getNoticeList(SearchVO searchVO) {
		return noticeDAO.getNoticeList(searchVO);
	}

	@Override
	public NoticeVO insertNotice(NoticeVO notice) {
		return noticeDAO.insertNotice(notice);
	}
	
	
	@Override
	public int deleteNotice(NoticeVO notice) {
		return noticeDAO.deleteNotice(notice);
	}
	
	
	@Override
	public int updateNotice(NoticeVO notice) {
		return noticeDAO.updateNotice(notice);
	}
	
}