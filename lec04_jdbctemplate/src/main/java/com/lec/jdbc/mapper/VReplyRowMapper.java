package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.VReplyVO;

public class VReplyRowMapper implements RowMapper<VReplyVO>{

	public VReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VReplyVO vreply = new VReplyVO();
		vreply.setRno(rs.getInt("RNO"));
		vreply.setSeq(rs.getInt("SEQ"));
		vreply.setWriter(rs.getString("WRITER"));
		vreply.setContent(rs.getString("CONTENT"));
		vreply.setRegDate(rs.getDate("REGDATE"));	
		return vreply;
	}

}
