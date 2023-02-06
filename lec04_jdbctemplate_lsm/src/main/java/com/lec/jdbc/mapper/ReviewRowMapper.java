package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.ReviewVO;

public class ReviewRowMapper implements RowMapper<ReviewVO> {

	@Override
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewVO review = new ReviewVO();
		review.setEmail(rs.getString("email"));
		review.setName(rs.getString("name"));
		review.setNickname(rs.getString("nickname"));
		review.setPassword(rs.getString("password"));
		review.setRole(rs.getString("role"));
		review.setFileName(rs.getString("filename"));
		return review;
	}
}