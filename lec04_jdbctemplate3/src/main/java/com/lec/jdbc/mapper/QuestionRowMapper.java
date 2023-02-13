package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.QuestionVO;

public class QuestionRowMapper implements RowMapper<QuestionVO> {
	public QuestionVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionVO question = new QuestionVO();
		question.setSeq(rs.getInt("SEQ"));
		question.setTitle(rs.getString("TITLE"));
		question.setWriter(rs.getString("WRITER"));
		question.setContent(rs.getString("CONTENT"));
		question.setRegDate(rs.getDate("REGDATE"));
		question.setCnt(rs.getInt("CNT"));
		question.setFileName1(rs.getString("FILENAME1"));
		question.setFileName2(rs.getString("FILENAME2"));
		question.setFileName3(rs.getString("FILENAME3"));
		return question;
	}
}