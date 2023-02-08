package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.LostRowMapper;
import com.lec.jdbc.vo.LostVO;

@Repository("lostDAO")
@PropertySource("classpath:config/lostsql.properties")
public class LostDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByLostSeq = "";
	private String lostTotalRowCount = "";
	private String insertLost = "";
	private String deleteLost = "";
	private String updateLost = "";
	private String updateLostCount = "";
	private String selectLostList = "";
	private String selectLostListByTitle = ""; 
	private String selectLostListByWriter = ""; 
	private String selectLostListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByLostSeq              = environment.getProperty("selectByLostSeq");
		lostTotalRowCount       = environment.getProperty("lostTotalRowCount");
		insertLost              = environment.getProperty("insertLost");
		deleteLost              = environment.getProperty("deleteLost");
		updateLost              = environment.getProperty("updateLost");
		updateLostCount              = environment.getProperty("updateLostCount");
		selectLostList          = environment.getProperty("selectLostList");
		selectLostListByTitle   = environment.getProperty("selectLostListByTitle");
		selectLostListByWriter  = environment.getProperty("selectLostListByWriter");
		selectLostListByCate2= environment.getProperty("selectLostListByCate2");
	}

	public LostVO getLost(LostVO lost) {
		Object[] args = { lost.getSeq() };		
		return (LostVO) jdbcTemplate.queryForObject(selectByLostSeq, args, new LostRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = lostTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = lostTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = lostTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = lostTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<LostVO> getLostList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectLostListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectLostListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectLostListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectLostListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new LostRowMapper());
	}
	
	public LostVO insertLost(LostVO lost) {
		jdbcTemplate.update(insertLost, lost.getTitle(), lost.getWriter(), lost.getContent(), lost.getFileName1(), lost.getFileName2(), lost.getFileName3());
		return lost;
	}	

	
	public int deleteLost(LostVO lost) {
		
		System.out.println(lost.toString());
		
		return jdbcTemplate.update(deleteLost, lost.getSeq());
	}

	public int updateLost(LostVO lost) {
		return jdbcTemplate.update(updateLost, lost.getTitle(), lost.getContent(), lost.getSeq());
	}
	
	public void updateLostCount(LostVO lost) {
		jdbcTemplate.update(updateLostCount,  lost.getSeq());
	}
	
	
}