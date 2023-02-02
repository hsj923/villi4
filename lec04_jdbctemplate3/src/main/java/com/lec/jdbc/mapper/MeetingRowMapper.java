package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.MeetingVO;

public class MeetingRowMapper implements RowMapper<MeetingVO> {
	public MeetingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MeetingVO meeting = new MeetingVO();
		meeting.setSeq(rs.getInt("SEQ"));
		meeting.setTitle(rs.getString("TITLE"));
		meeting.setWriter(rs.getString("WRITER"));
		meeting.setContent(rs.getString("CONTENT"));
		meeting.setRegDate(rs.getDate("REGDATE"));
		meeting.setCnt(rs.getInt("CNT"));
		meeting.setPer(rs.getInt("PER"));
		meeting.setPlace(rs.getString("PLACE"));
		meeting.setStatus(rs.getString("STATUS"));
		meeting.setMeet_date(rs.getString("MEET_DATE"));
		return meeting;
	}
}