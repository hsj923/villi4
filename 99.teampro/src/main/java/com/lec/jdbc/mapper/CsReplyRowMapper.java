package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsReplyVO;

public class CsReplyRowMapper implements RowMapper<CsReplyVO>{

	public CsReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CsReplyVO csreply = new CsReplyVO();
		csreply.setRno(rs.getInt("RNO"));
		csreply.setBno(rs.getInt("BNO"));
		csreply.setWriter(rs.getString("WRITER"));
		csreply.setContent(rs.getString("CONTENT"));
		csreply.setRegDate(rs.getDate("REGDATE"));	
		return csreply;
	}

}
