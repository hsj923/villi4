package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.GReplyVO;

public class GReplyRowMapper implements RowMapper<GReplyVO>{

	public GReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GReplyVO greply = new GReplyVO();
		greply.setRno(rs.getInt("RNO"));
		greply.setSeq(rs.getInt("SEQ"));
		greply.setWriter(rs.getString("WRITER"));
		greply.setContent(rs.getString("CONTENT"));
		greply.setRegDate(rs.getDate("REGDATE"));	
		return greply;
	}

}
