package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.MeetingDAO;
import com.lec.jdbc.service.MeetingService;
import com.lec.jdbc.vo.MeetingVO;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MeetingDAO meetingDAO;
	
//	public MeetingServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public MeetingVO getMeeting(MeetingVO vo) {
		return meetingDAO.getMeeting(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return meetingDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<MeetingVO> getMeetingList(SearchVO searchVO) {
		return meetingDAO.getMeetingList(searchVO);
	}

	@Override
	public MeetingVO insertMeeting(MeetingVO meeting) {
		return meetingDAO.insertMeeting(meeting);
	}
	
	@Override
	public int deleteMeeting(MeetingVO meeting) {
		return meetingDAO.deleteMeeting(meeting);
	}

	@Override
	public int updateMeeting(MeetingVO meeting) {
		return meetingDAO.updateMeeting(meeting);
	}
	
	@Override
	public void updateMeetingCount(MeetingVO meeting) {
		meetingDAO.updateMeetingCount(meeting);
	}

	
}