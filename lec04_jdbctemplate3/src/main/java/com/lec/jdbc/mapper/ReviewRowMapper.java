package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.ReviewVO;

public class ReviewRowMapper implements RowMapper<ReviewVO> {
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewVO review = new ReviewVO();
		review.setSeq(rs.getInt("SEQ"));
		review.setNickname(rs.getString("Nickname"));
		review.setRv_con(rs.getString("RV_CON"));
		review.setRv_time(rs.getString("RV_TIME"));
		return review;
	}
}