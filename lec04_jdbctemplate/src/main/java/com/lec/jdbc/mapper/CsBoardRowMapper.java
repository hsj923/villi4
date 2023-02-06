package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.CsBoardVO;

public class CsBoardRowMapper implements RowMapper<CsBoardVO> {
	
	public CsBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CsBoardVO csboard = new CsBoardVO();
		csboard.setBno(rs.getInt("BNO"));
		csboard.setTitle(rs.getString("TITLE"));
		csboard.setWriter(rs.getString("WRITER"));
		csboard.setContent(rs.getString("CONTENT"));
		csboard.setRegDate(rs.getDate("REGDATE"));
		csboard.setViewCnt(rs.getInt("VIEWCNT"));
		// board.setUploadFile(rs.getString("FILE"));
		return csboard;
	}
}