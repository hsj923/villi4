package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.CsReplyRowMapper;
import com.lec.jdbc.mapper.LReplyRowMapper;
import com.lec.jdbc.mapper.QReplyRowMapper;
import com.lec.jdbc.vo.CsReplyVO;
import com.lec.jdbc.vo.LReplyVO;
import com.lec.jdbc.vo.QReplyVO;

@Repository("lreplyDAO")
@PropertySource("classpath:config/lreplysql.properties")
public class LReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String lreplyTotalRowCount = "";
	private String insertLReply = "";
	private String deleteLReply = "";
	private String updateLReply = "";
	private String selectLReplyList = "";
	private String selectLReplyListBySeq = ""; 
	private String selectLReplyListByWriter = ""; 
	private String selectLReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno              = environment.getProperty("selectByRno");
		lreplyTotalRowCount       = environment.getProperty("lreplyTotalRowCount");
		insertLReply              = environment.getProperty("insertLReply");
		deleteLReply              = environment.getProperty("deleteLReply");
		updateLReply              = environment.getProperty("updateLReply");
		selectLReplyList          = environment.getProperty("selectLReplyList");
		selectLReplyListBySeq     = environment.getProperty("selectLReplyListBySeq");
		selectLReplyListByWriter  = environment.getProperty("selectLReplyListByWriter");
		selectLReplyListByContent = environment.getProperty("selectLReplyListByContent");
	}
	
	public LReplyVO getLReply(LReplyVO lreply) {
		Object[] args = { lreply.getRno() };		
		return (LReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new LReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = lreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = lreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = lreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = lreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<LReplyVO> getLReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectLReplyList, args, new LReplyRowMapper());
	}
	
	public LReplyVO insertLReply(LReplyVO lreply) {
		jdbcTemplate.update(insertLReply, lreply.getSeq(),lreply.getWriter(), lreply.getContent());
		return lreply;
	}	
	
	public int updateLReply(LReplyVO lreply) {
		return jdbcTemplate.update(updateLReply, lreply.getWriter(), lreply.getContent(), lreply.getSeq());
	}
	
	public int deleteLReply(LReplyVO lreply) {
		return jdbcTemplate.update(deleteLReply, lreply.getRno());
	}
	
	
}