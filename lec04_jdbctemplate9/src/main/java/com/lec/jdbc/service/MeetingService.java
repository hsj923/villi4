package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.MeetingVO;

public interface MeetingService {

	MeetingVO getMeeting(MeetingVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<MeetingVO> getMeetingList(SearchVO searchVO);
	MeetingVO insertMeeting(MeetingVO meeting);
	int deleteMeeting(MeetingVO meeting);
	int updateMeeting(MeetingVO meeting);
	void updateMeetingCount(MeetingVO meeting);
}