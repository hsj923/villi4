package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsVO;

public class CsRowMapper implements RowMapper<CsVO> {
	
	public CsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CsVO cs = new CsVO();
		cs.setCs_num(rs.getInt("CS_NUM"));
		cs.setCs_name(rs.getString("CS_NAME"));
		cs.setCs_pass(rs.getString("CS_PASS"));
		cs.setCs_subject(rs.getString("CS_SUBJECT"));
		cs.setCs_content(rs.getString("CS_CONTENT"));
		cs.setCs_file(rs.getString("CS_FILE"));
		cs.setCs_re_ref(rs.getInt("CS_RE_REF"));
		cs.setCs_re_lev(rs.getInt("CS_RE_LEV"));
		cs.setCs_re_seq(rs.getInt("CS_RE_SEQ"));
		cs.setCs_readcount(rs.getInt("CS_READCOUNT"));
		cs.setCs_date(rs.getDate("CS_DATE"));
		return cs;
	}
}

// board.setUploadFile(rs.getString("FILE"));