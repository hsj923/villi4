package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setNickname(rs.getString("nickname"));
		user.setName(rs.getString("name"));
		user.setAddress(rs.getString("address"));
		user.setRole(rs.getString("role"));
		return user;
	}
}
