package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.DReplyVO;

public class DReplyRowMapper implements RowMapper<DReplyVO>{

	public DReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DReplyVO dreply = new DReplyVO();
		dreply.setRno(rs.getInt("RNO"));
		dreply.setSeq(rs.getInt("SEQ"));
		dreply.setWriter(rs.getString("WRITER"));
		dreply.setContent(rs.getString("CONTENT"));
		dreply.setRegDate(rs.getDate("REGDATE"));	
		return dreply;
	}

}
