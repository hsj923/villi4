package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.NoticeVO;

public class NoticeRowMapper implements RowMapper<NoticeVO>{

	@Override
	public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NoticeVO notice = new NoticeVO();
		notice.setNoti_seq(rs.getInt("NOTI_SEQ"));
		notice.setNoti_title(rs.getString("NOTI_TITLE"));
		notice.setNoti_content(rs.getString("NOTI_CONTENT"));
		notice.setNoti_regDate(rs.getDate("NOTI_REGDATE"));
		
		return notice;
	}

}
