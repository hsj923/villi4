package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.LReplyVO;

public class LReplyRowMapper implements RowMapper<LReplyVO>{

	public LReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LReplyVO lreply = new LReplyVO();
		lreply.setRno(rs.getInt("RNO"));
		lreply.setSeq(rs.getInt("SEQ"));
		lreply.setWriter(rs.getString("WRITER"));
		lreply.setContent(rs.getString("CONTENT"));
		lreply.setRegDate(rs.getDate("REGDATE"));	
		return lreply;
	}

}
