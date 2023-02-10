package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.DReplyRowMapper;
import com.lec.jdbc.mapper.MReplyRowMapper;
import com.lec.jdbc.mapper.VReplyRowMapper;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.MReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Repository("dreplyDAO")
@PropertySource("classpath:config/dreplysql.properties")
public class DReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String dreplyTotalRowCount = "";
	private String insertDReply = "";
	private String deleteDReply = "";
	private String updateDReply = "";
	private String selectDReplyList = "";
	private String selectDReplyListBySeq = ""; 
	private String selectDReplyListByWriter = ""; 
	private String selectDReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno               = environment.getProperty("selectByRno");
		dreplyTotalRowCount       = environment.getProperty("dreplyTotalRowCount");
		insertDReply              = environment.getProperty("insertDReply");
		deleteDReply              = environment.getProperty("deleteDReply");
		updateDReply              = environment.getProperty("updateDReply");
		selectDReplyList          = environment.getProperty("selectDReplyList");
		selectDReplyListBySeq     = environment.getProperty("selectDReplyListBySeq");
		selectDReplyListByWriter  = environment.getProperty("selectDReplyListByWriter");
		selectDReplyListByContent = environment.getProperty("selectDReplyListByContent");
	}
	
	public DReplyVO getDReply(DReplyVO dreply) {
		Object[] args = { dreply.getRno() };		
		return (DReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new DReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = dreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = dreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = dreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = dreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<DReplyVO> getDReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectDReplyList, args, new DReplyRowMapper());
	}
	
	public DReplyVO insertDReply(DReplyVO dreply) {
		jdbcTemplate.update(insertDReply, dreply.getSeq(),dreply.getWriter(), dreply.getContent());
		return dreply;
	}	
	
	public int updateDReply(DReplyVO dreply) {
		return jdbcTemplate.update(updateDReply, dreply.getWriter(), dreply.getContent(), dreply.getSeq());
	}
	
	public int deleteDReply(DReplyVO dreply) {
		return jdbcTemplate.update(deleteDReply, dreply.getRno());
	}

	
}