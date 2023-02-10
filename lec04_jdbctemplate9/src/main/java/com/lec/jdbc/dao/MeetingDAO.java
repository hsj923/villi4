package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.MeetingRowMapper;
import com.lec.jdbc.vo.MeetingVO;

@Repository("meetingDAO")
@PropertySource("classpath:config/meetingsql.properties")
public class MeetingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByMeetingSeq = "";
	private String meetingTotalRowCount = "";
	private String insertMeeting = "";
	private String deleteMeeting = "";
	private String updateMeeting = "";
	private String updateMeetingCount = "";
	private String selectMeetingList = "";
	private String selectMeetingListByTitle = ""; 
	private String selectMeetingListByWriter = ""; 
	private String selectMeetingListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByMeetingSeq              = environment.getProperty("selectByMeetingSeq");
		meetingTotalRowCount       = environment.getProperty("meetingTotalRowCount");
		insertMeeting              = environment.getProperty("insertMeeting");
		deleteMeeting              = environment.getProperty("deleteMeeting");
		updateMeeting              = environment.getProperty("updateMeeting");
		updateMeetingCount              = environment.getProperty("updateMeetingCount");
		selectMeetingList          = environment.getProperty("selectMeetingList");
		selectMeetingListByTitle   = environment.getProperty("selectMeetingListByTitle");
		selectMeetingListByWriter  = environment.getProperty("selectMeetingListByWriter");
		selectMeetingListByCate2= environment.getProperty("selectMeetingListByCate2");
	}

	public MeetingVO getMeeting(MeetingVO meeting) {
		Object[] args = { meeting.getSeq() };		
		return (MeetingVO) jdbcTemplate.queryForObject(selectByMeetingSeq, args, new MeetingRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = meetingTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = meetingTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = meetingTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = meetingTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<MeetingVO> getMeetingList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectMeetingListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectMeetingListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectMeetingListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectMeetingListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new MeetingRowMapper());
	}
	
	public MeetingVO insertMeeting(MeetingVO meeting) {
		jdbcTemplate.update(insertMeeting, meeting.getTitle(), meeting.getWriter(), meeting.getContent(), meeting.getPer(), meeting.getPlace(), meeting.getMeet_date());
		return meeting;
	}	

	
	public int deleteMeeting(MeetingVO meeting) {
		
		System.out.println(meeting.toString());
		
		return jdbcTemplate.update(deleteMeeting, meeting.getSeq());
	}

	public int updateMeeting(MeetingVO meeting) {
		return jdbcTemplate.update(updateMeeting, meeting.getTitle(), meeting.getContent(), meeting.getSeq());
	}
	
	public void updateMeetingCount(MeetingVO meeting) {
		jdbcTemplate.update(updateMeetingCount,  meeting.getSeq());
	}
	
	
}