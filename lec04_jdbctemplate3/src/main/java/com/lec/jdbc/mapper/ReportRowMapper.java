package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.ReportVO;

public class ReportRowMapper implements RowMapper<ReportVO> {
	public ReportVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportVO report = new ReportVO();
		report.setSeq(rs.getInt("SEQ"));
		report.setR_status(rs.getString("R_STATUS"));
		report.setR_etime(rs.getString("R_ETIME"));
		report.setR_rs1(rs.getString("R_RS1"));
		report.setR_con(rs.getString("R_CON"));
		report.setR_time(rs.getString("R_TIME"));
		report.setNickname(rs.getString("Nickname"));
		return report;
	}
}