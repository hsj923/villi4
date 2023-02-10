package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsReplyVO;
import com.lec.jdbc.vo.QReplyVO;

public class QReplyRowMapper implements RowMapper<QReplyVO>{

	public QReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		QReplyVO qreply = new QReplyVO();
		qreply.setRno(rs.getInt("RNO"));
		qreply.setSeq(rs.getInt("SEQ"));
		qreply.setWriter(rs.getString("WRITER"));
		qreply.setContent(rs.getString("CONTENT"));
		qreply.setRegDate(rs.getDate("REGDATE"));	
		return qreply;
	}

}
