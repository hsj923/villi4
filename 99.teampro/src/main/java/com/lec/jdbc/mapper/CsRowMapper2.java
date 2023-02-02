package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.CsVO2;

public class CsRowMapper2 implements RowMapper<CsVO2>{

	@Override
	public CsVO2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CsVO2 csitem = new CsVO2();
		csitem.setCs_num(rs.getInt("CS_NUM"));
		csitem.setCs_name(rs.getString("CS_NAME"));
		csitem.setCs_pass(rs.getString("CS_PASS"));
		csitem.setCs_subject(rs.getString("CS_SUBJECT"));
		csitem.setCs_content(rs.getString("CS_CONTENT"));
		csitem.setCs_file(rs.getString("CS_FILE"));
		csitem.setCs_re_ref(rs.getInt("CS_RE_REF"));
		csitem.setCs_re_lev(rs.getInt("CS_RE_LEV"));
		csitem.setCs_re_seq(rs.getInt("CS_RE_SEQ"));
		csitem.setCs_date(rs.getDate("CS_DATE"));
		
		return csitem;
	}

}
