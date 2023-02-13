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
import com.lec.jdbc.mapper.VReplyRowMapper;
import com.lec.jdbc.vo.MReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Repository("vreplyDAO")
@PropertySource("classpath:config/vreplysql.properties")
public class VReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String vreplyTotalRowCount = "";
	private String insertVReply = "";
	private String deleteVReply = "";
	private String updateVReply = "";
	private String selectVReplyList = "";
	private String selectVReplyListBySeq = ""; 
	private String selectVReplyListByWriter = ""; 
	private String selectVReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno               = environment.getProperty("selectByRno");
		vreplyTotalRowCount       = environment.getProperty("vreplyTotalRowCount");
		insertVReply              = environment.getProperty("insertVReply");
		deleteVReply              = environment.getProperty("deleteVReply");
		updateVReply              = environment.getProperty("updateVReply");
		selectVReplyList          = environment.getProperty("selectVReplyList");
		selectVReplyListBySeq     = environment.getProperty("selectVReplyListBySeq");
		selectVReplyListByWriter  = environment.getProperty("selectVReplyListByWriter");
		selectVReplyListByContent = environment.getProperty("selectVReplyListByContent");
	}
	
	public VReplyVO getVReply(VReplyVO vreply) {
		Object[] args = { vreply.getRno() };		
		return (VReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new VReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = vreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = vreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = vreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = vreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<VReplyVO> getVReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectVReplyList, args, new VReplyRowMapper());
	}
	
	public VReplyVO insertVReply(VReplyVO vreply) {
		jdbcTemplate.update(insertVReply, vreply.getSeq(),vreply.getWriter(), vreply.getContent());
		return vreply;
	}	
	
	public int updateVReply(VReplyVO vreply) {
		return jdbcTemplate.update(updateVReply, vreply.getWriter(), vreply.getContent(), vreply.getSeq());
	}
	
	public int deleteVReply(VReplyVO vreply) {
		return jdbcTemplate.update(deleteVReply, vreply.getRno());
	}

	
}