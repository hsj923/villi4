package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lec.jdbc.vo.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setEmail(rs.getString("EMAIL"));
		user.setName(rs.getString("NAME"));
		user.setNickname(rs.getString("NICKNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setRole(rs.getString("ROLE"));
		user.setFileName(rs.getString("FILENAME"));
		user.setAddress(rs.getString("ADDRESS"));
		return user;
	}
}