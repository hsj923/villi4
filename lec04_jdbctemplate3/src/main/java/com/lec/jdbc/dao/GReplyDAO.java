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
import com.lec.jdbc.mapper.GReplyRowMapper;
import com.lec.jdbc.mapper.MReplyRowMapper;
import com.lec.jdbc.mapper.VReplyRowMapper;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.GReplyVO;
import com.lec.jdbc.vo.MReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Repository("greplyDAO")
@PropertySource("classpath:config/greplysql.properties")
public class GReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String greplyTotalRowCount = "";
	private String insertGReply = "";
	private String deleteGReply = "";
	private String updateGReply = "";
	private String selectGReplyList = "";
	private String selectGReplyListBySeq = ""; 
	private String selectGReplyListByWriter = ""; 
	private String selectGReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno               = environment.getProperty("selectByRno");
		greplyTotalRowCount       = environment.getProperty("greplyTotalRowCount");
		insertGReply              = environment.getProperty("insertGReply");
		deleteGReply              = environment.getProperty("deleteGReply");
		updateGReply              = environment.getProperty("updateGReply");
		selectGReplyList          = environment.getProperty("selectGReplyList");
		selectGReplyListBySeq     = environment.getProperty("selectGReplyListBySeq");
		selectGReplyListByWriter  = environment.getProperty("selectGReplyListByWriter");
		selectGReplyListByContent = environment.getProperty("selectGReplyListByContent");
	}
	
	public GReplyVO getGReply(GReplyVO greply) {
		Object[] args = { greply.getRno() };		
		return (GReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new GReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = greplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = greplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = greplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = greplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<GReplyVO> getGReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectGReplyList, args, new GReplyRowMapper());
	}
	
	public GReplyVO insertGReply(GReplyVO greply) {
		jdbcTemplate.update(insertGReply, greply.getSeq(),greply.getWriter(), greply.getContent());
		return greply;
	}	
	
	public int updateGReply(GReplyVO greply) {
		return jdbcTemplate.update(updateGReply, greply.getWriter(), greply.getContent(), greply.getSeq());
	}
	
	public int deleteGReply(GReplyVO greply) {
		return jdbcTemplate.update(deleteGReply, greply.getRno());
	}

	
}