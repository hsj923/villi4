package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsVO;

public class CsRowMapper implements RowMapper<CsVO> {
	
	public CsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CsVO cs = new CsVO();
		cs.setBno(rs.getInt("BNO"));
		cs.setTitle(rs.getString("TITLE"));
		cs.setWriter(rs.getString("WRITER"));
		cs.setContent(rs.getString("CONTENT"));
		cs.setRegDate(rs.getDate("REGDATE"));
		cs.setCnt(rs.getInt("CNT"));
		cs.setFileName1(rs.getString("FILENAME1"));
		return cs;
	}
}