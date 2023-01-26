package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.GroupBuyingVO;

public class GroupBuyingRowMapper implements RowMapper<GroupBuyingVO> {
	public GroupBuyingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		GroupBuyingVO groupBuying = new GroupBuyingVO();
		groupBuying.setSeq(rs.getInt("SEQ"));
		groupBuying.setTitle(rs.getString("TITLE"));
		groupBuying.setWriter(rs.getString("WRITER"));
		groupBuying.setContent(rs.getString("CONTENT"));
		groupBuying.setPlace(rs.getString("PLACE"));
		groupBuying.setStatus(rs.getString("STATUS"));
		groupBuying.setRegDate(rs.getDate("REGDATE"));
		groupBuying.setBuying_date(rs.getDate("BUYING_DATE"));
		groupBuying.setCnt(rs.getInt("CNT"));
		groupBuying.setPer(rs.getInt("PER"));
		groupBuying.setPrice(rs.getString("PRICE"));
		groupBuying.setFileName1(rs.getString("FILENAME1"));
		return groupBuying;
	}
}