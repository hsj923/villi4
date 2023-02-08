package com.lec.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lec.jdbc.vo.VoteVO;

public class VoteRowMapper implements RowMapper<VoteVO> {
	public VoteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		VoteVO vote = new VoteVO();
		vote.setSeq(rs.getInt("SEQ"));
		vote.setTitle(rs.getString("TITLE"));
		vote.setWriter(rs.getString("WRITER"));
		vote.setContent(rs.getString("CONTENT"));
		vote.setRegDate(rs.getDate("REGDATE"));
		vote.setCnt(rs.getInt("CNT"));
		vote.setItemcnt1(rs.getInt("ITEMCNT1"));
		vote.setItemcnt2(rs.getInt("ITEMCNT2"));
		vote.setItemcnt3(rs.getInt("ITEMCNT3"));
		vote.setItemcnt4(rs.getInt("ITEMCNT4"));
		vote.setItemlist1(rs.getString("ITEMLIST1"));
		vote.setItemlist2(rs.getString("ITEMLIST2"));
		vote.setItemlist3(rs.getString("ITEMLIST3"));
		vote.setItemlist4(rs.getString("ITEMLIST4"));

		return vote;
	}
}