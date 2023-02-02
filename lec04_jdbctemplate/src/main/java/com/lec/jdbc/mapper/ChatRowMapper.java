package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.ChatVO;

public class ChatRowMapper implements RowMapper<ChatVO> {
	public ChatVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChatVO chat = new ChatVO();
		chat.setSeq(rs.getInt("SEQ"));
		chat.setTitle(rs.getString("TITLE"));
		chat.setWriter(rs.getString("WRITER"));
		chat.setContent(rs.getString("CONTENT"));
		chat.setStatus(rs.getString("STATUS"));
		chat.setRegDate(rs.getDate("REGDATE"));
		chat.setCnt(rs.getInt("CNT"));
		chat.setFileName1(rs.getString("FILENAME1"));
		chat.setFileName2(rs.getString("FILENAME2"));
		chat.setFileName3(rs.getString("FILENAME3"));
		chat.setFileName4(rs.getString("FILENAME4"));
		chat.setFileName5(rs.getString("FILENAME5"));
		chat.setCate(rs.getString("CATE"));
		chat.setCate2(rs.getString("CATE2"));
		chat.setPrice(rs.getString("PRICE"));
		// chat.setUploadFile(rs.getString("FILE"));
		return chat;
	}
}