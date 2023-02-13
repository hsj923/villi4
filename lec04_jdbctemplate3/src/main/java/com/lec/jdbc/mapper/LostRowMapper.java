package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.LostVO;

public class LostRowMapper implements RowMapper<LostVO> {
	public LostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LostVO lost = new LostVO();
		lost.setSeq(rs.getInt("SEQ"));
		lost.setTitle(rs.getString("TITLE"));
		lost.setWriter(rs.getString("WRITER"));
		lost.setContent(rs.getString("CONTENT"));
		lost.setRegDate(rs.getDate("REGDATE"));
		lost.setCnt(rs.getInt("CNT"));
		lost.setFileName1(rs.getString("FILENAME1"));
		lost.setFileName2(rs.getString("FILENAME2"));
		lost.setFileName3(rs.getString("FILENAME3"));
		return lost;
	}
}