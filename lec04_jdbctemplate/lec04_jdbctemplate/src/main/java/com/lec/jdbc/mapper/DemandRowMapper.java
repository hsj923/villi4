package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.DemandVO;

public class DemandRowMapper implements RowMapper<DemandVO> {
	public DemandVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DemandVO demand = new DemandVO();
		demand.setSeq(rs.getInt("SEQ"));
		demand.setTitle(rs.getString("TITLE"));
		demand.setNickname(rs.getString("NICKNAME"));
		demand.setContent(rs.getString("CONTENT"));
		demand.setPrice(rs.getString("PRICE"));
		demand.setStatus(rs.getString("STATUS"));
		demand.setRegDate(rs.getDate("REGDATE"));
		demand.setCnt(rs.getInt("CNT"));
		demand.setFileName1(rs.getString("FILENAME1"));
		demand.setAddress(rs.getString("ADDRESS"));
		return demand;
	}
}