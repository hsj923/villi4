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
import com.lec.jdbc.vo.CsReplyVO;

@Repository("csreplyDAO")
@PropertySource("classpath:config/csreplysql.properties")
public class CsReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String csreplyTotalRowCount = "";
	private String insertCsReply = "";
	private String deleteCsReply = "";
	private String updateCsReply = "";
	private String selectCsReplyList = "";
	private String selectCsReplyListByBno = ""; 
	private String selectCsReplyListByWriter = ""; 
	private String selectCsReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno              = environment.getProperty("selectByRno");
		csreplyTotalRowCount       = environment.getProperty("csreplyTotalRowCount");
		insertCsReply              = environment.getProperty("insertCsReply");
		deleteCsReply              = environment.getProperty("deleteCsReply");
		updateCsReply              = environment.getProperty("updateCsReply");
		selectCsReplyList          = environment.getProperty("selectCsReplyList");
		selectCsReplyListByBno     = environment.getProperty("selectCsReplyListByBno");
		selectCsReplyListByWriter  = environment.getProperty("selectCsReplyListByWriter");
		selectCsReplyListByContent = environment.getProperty("selectCsReplyListByContent");
	}
	
	public CsReplyVO getCsReply(CsReplyVO csreply) {
		Object[] args = { csreply.getRno() };		
		return (CsReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new CsReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = csreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = csreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = csreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = csreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<CsReplyVO> getCsReplyList(int bno) {
		Object[] args = {bno};
		return jdbcTemplate.query(selectCsReplyList, args, new CsReplyRowMapper());
	}
	
	public CsReplyVO insertCsReply(CsReplyVO csreply) {
		jdbcTemplate.update(insertCsReply, csreply.getWriter(), csreply.getContent(), csreply.getRegDate());
		return csreply;
	}	
	
	public int updateCsReply(CsReplyVO csreply) {
		return jdbcTemplate.update(updateCsReply, csreply.getWriter(), csreply.getContent(), csreply.getBno());
	}
	
	public int deleteCsReply(CsReplyVO csreply) {
		return jdbcTemplate.update(deleteCsReply, csreply.getRno());
	}
	
	
}