package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.MReplyRowMapper;
import com.lec.jdbc.vo.MReplyVO;

@Repository("mreplyDAO")
@PropertySource("classpath:config/mreplysql.properties")
public class MReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String mreplyTotalRowCount = "";
	private String insertMReply = "";
	private String deleteMReply = "";
	private String updateMReply = "";
	private String selectMReplyList = "";
	private String selectMReplyListBySeq = ""; 
	private String selectMReplyListByWriter = ""; 
	private String selectMReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno              = environment.getProperty("selectByRno");
		mreplyTotalRowCount       = environment.getProperty("mreplyTotalRowCount");
		insertMReply              = environment.getProperty("insertMReply");
		deleteMReply              = environment.getProperty("deleteMReply");
		updateMReply              = environment.getProperty("updateMReply");
		selectMReplyList          = environment.getProperty("selectMReplyList");
		selectMReplyListBySeq     = environment.getProperty("selectMReplyListBySeq");
		selectMReplyListByWriter  = environment.getProperty("selectMReplyListByWriter");
		selectMReplyListByContent = environment.getProperty("selectMReplyListByContent");
	}
	
	public MReplyVO getMReply(MReplyVO mreply) {
		Object[] args = { mreply.getRno() };		
		return (MReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new MReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = mreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = mreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = mreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = mreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<MReplyVO> getMReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectMReplyList, args, new MReplyRowMapper());
	}
	
	public MReplyVO insertMReply(MReplyVO mreply) {
		jdbcTemplate.update(insertMReply, mreply.getSeq(),mreply.getWriter(), mreply.getContent());
		return mreply;
	}	
	
	public int updateMReply(MReplyVO mreply) {
		return jdbcTemplate.update(updateMReply, mreply.getWriter(), mreply.getContent(), mreply.getSeq());
	}
	
	public int deleteMReply(MReplyVO mreply) {
		return jdbcTemplate.update(deleteMReply, mreply.getRno());
	}
	
	
}