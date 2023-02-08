package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.QReplyRowMapper;
import com.lec.jdbc.vo.QReplyVO;

@Repository("qreplyDAO")
@PropertySource("classpath:config/qreplysql.properties")
public class QReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByRno = "";
	private String qreplyTotalRowCount = "";
	private String insertQReply = "";
	private String deleteQReply = "";
	private String updateQReply = "";
	private String selectQReplyList = "";
	private String selectQReplyListBySeq = ""; 
	private String selectQReplyListByWriter = ""; 
	private String selectQReplyListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByRno              = environment.getProperty("selectByRno");
		qreplyTotalRowCount       = environment.getProperty("qreplyTotalRowCount");
		insertQReply              = environment.getProperty("insertQReply");
		deleteQReply              = environment.getProperty("deleteQReply");
		updateQReply              = environment.getProperty("updateQReply");
		selectQReplyList          = environment.getProperty("selectQReplyList");
		selectQReplyListBySeq     = environment.getProperty("selectQReplyListBySeq");
		selectQReplyListByWriter  = environment.getProperty("selectQReplyListByWriter");
		selectQReplyListByContent = environment.getProperty("selectQReplyListByContent");
	}
	
	public QReplyVO getQReply(QReplyVO qreply) {
		Object[] args = { qreply.getRno() };		
		return (QReplyVO) jdbcTemplate.queryForObject(selectByRno, args, new QReplyRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = qreplyTotalRowCount;
			searchVO.setSearchType("rno");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("rno")) {
				sql = qreplyTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = qreplyTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = qreplyTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<QReplyVO> getQReplyList(int seq) {
		Object[] args = {seq};
		return jdbcTemplate.query(selectQReplyList, args, new QReplyRowMapper());
	}
	
	public QReplyVO insertQReply(QReplyVO qreply) {
		jdbcTemplate.update(insertQReply, qreply.getSeq(), qreply.getWriter(), qreply.getContent());
		return qreply;
	}	
	
	public int updateQReply(QReplyVO qreply) {
		return jdbcTemplate.update(updateQReply, qreply.getWriter(), qreply.getContent(), qreply.getSeq());
	}
	
	public int deleteQReply(QReplyVO qreply) {
		return jdbcTemplate.update(deleteQReply, qreply.getRno());
	}
	
	
}