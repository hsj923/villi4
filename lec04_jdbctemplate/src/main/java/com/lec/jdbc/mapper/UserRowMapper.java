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
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setAddress(rs.getString("address"));
		user.setFileName1(rs.getString("filename1"));
		user.setNickname(rs.getString("nickname"));
	
		return user;
	}
}
