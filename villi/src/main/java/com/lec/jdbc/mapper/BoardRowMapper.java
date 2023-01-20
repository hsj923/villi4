package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setStatus(rs.getString("STATUS"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		board.setFileName1(rs.getString("FILENAME1"));
		board.setFileName2(rs.getString("FILENAME2"));
		board.setFileName3(rs.getString("FILENAME3"));
		board.setFileName4(rs.getString("FILENAME4"));
		board.setFileName5(rs.getString("FILENAME5"));
		board.setCate(rs.getString("CATE"));
		board.setCate2(rs.getString("CATE2"));
		board.setPrice(rs.getString("PRICE"));
		// board.setUploadFile(rs.getString("FILE"));
		return board;
	}
}