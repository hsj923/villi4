package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.VoteRowMapper;
import com.lec.jdbc.vo.VoteVO;

@Repository("voteDAO")
@PropertySource("classpath:config/votesql.properties")
public class VoteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByVoteSeq = "";
	private String voteTotalRowCount = "";
	private String insertVote = "";
	private String deleteVote = "";
	private String updateVote = "";
	private String updateVoteCount = "";
	private String selectVoteList = "";
	private String selectVoteListByTitle = ""; 
	private String selectVoteListByWriter = ""; 
	private String selectVoteListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByVoteSeq              = environment.getProperty("selectByVoteSeq");
		voteTotalRowCount       = environment.getProperty("voteTotalRowCount");
		insertVote              = environment.getProperty("insertVote");
		deleteVote              = environment.getProperty("deleteVote");
		updateVote              = environment.getProperty("updateVote");
		updateVoteCount              = environment.getProperty("updateVoteCount");
		selectVoteList          = environment.getProperty("selectVoteList");
		selectVoteListByTitle   = environment.getProperty("selectVoteListByTitle");
		selectVoteListByWriter  = environment.getProperty("selectVoteListByWriter");
		selectVoteListByCate2= environment.getProperty("selectVoteListByCate2");
	}

	public VoteVO getVote(VoteVO vote) {
		Object[] args = { vote.getSeq() };		
		return (VoteVO) jdbcTemplate.queryForObject(selectByVoteSeq, args, new VoteRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = voteTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = voteTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = voteTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = voteTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<VoteVO> getVoteList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectVoteListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectVoteListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectVoteListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectVoteListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new VoteRowMapper());
	}
	
	public VoteVO insertVote(VoteVO vote) {
		jdbcTemplate.update(insertVote, vote.getTitle(), vote.getWriter(), vote.getContent(), vote.getItemlist1(), vote.getItemlist2(), vote.getItemlist3(), vote.getItemlist4());
		return vote;
	}	

	
	public int deleteVote(VoteVO vote) {
		
		System.out.println(vote.toString());
		
		return jdbcTemplate.update(deleteVote, vote.getSeq());
	}

	public int updateVote(VoteVO vote) {
		return jdbcTemplate.update(updateVote, vote.getItemcnt1(), vote.getItemcnt2(), vote.getItemcnt3(), vote.getItemcnt4(), vote.getSeq());
	}
	
	public void updateVoteCount(VoteVO vote) {
		jdbcTemplate.update(updateVoteCount,  vote.getSeq());
	}
	
	
}