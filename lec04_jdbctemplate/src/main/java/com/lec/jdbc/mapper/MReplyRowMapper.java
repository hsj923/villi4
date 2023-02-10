package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.MReplyVO;

public class MReplyRowMapper implements RowMapper<MReplyVO>{

	public MReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MReplyVO mreply = new MReplyVO();
		mreply.setRno(rs.getInt("RNO"));
		mreply.setSeq(rs.getInt("SEQ"));
		mreply.setWriter(rs.getString("WRITER"));
		mreply.setContent(rs.getString("CONTENT"));
		mreply.setRegDate(rs.getDate("REGDATE"));	
		return mreply;
	}

}
