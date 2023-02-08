package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.CsRowMapper;
import com.lec.jdbc.vo.CsVO;

@Repository("csDAO")
@PropertySource("classpath:config/cssql.properties")
public class CsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByCsSeq = "";
	private String csTotalRowCount = "";
	private String insertCs = "";
	private String deleteCs = "";
	private String updateCs = "";
	private String updateCsCount = "";
	private String selectCsList = "";
	private String selectCsListByTitle = ""; 
	private String selectCsListByContent = ""; 
	
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByCsSeq              = environment.getProperty("selectByCsSeq");
		csTotalRowCount       = environment.getProperty("csTotalRowCount");
		insertCs              = environment.getProperty("insertCs");
		deleteCs              = environment.getProperty("deleteCs");
		updateCs              = environment.getProperty("updateCs");
		updateCsCount              = environment.getProperty("updateCsCount");
		selectCsList          = environment.getProperty("selectCsList");
		selectCsListByTitle   = environment.getProperty("selectCsListByTitle");
		selectCsListByContent  = environment.getProperty("selectCsListByContent");

		
	}
	
	public CsVO getCs(CsVO cs) {
		Object[] args = { cs.getBno() };		
		return (CsVO) jdbcTemplate.queryForObject(selectByCsSeq, args, new CsRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = csTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = csTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = csTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			}
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<CsVO> getCsList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectCsListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectCsListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = selectCsListByContent;
			} 				
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new CsRowMapper());
	}
	
	public CsVO insertCs(CsVO cs) {
		jdbcTemplate.update(insertCs, cs.getTitle(), cs.getWriter(), cs.getContent(), cs.getFileName1());
		return cs;
	}	
	
	
	public int deleteCs(CsVO cs) {
		
		System.out.println(cs.toString());
		
		return jdbcTemplate.update(deleteCs, cs.getBno());
	}

	public int updateCs(CsVO cs) {
		return jdbcTemplate.update(updateCs, cs.getTitle(), cs.getContent(), cs.getBno());
	}
	
	public void updateCsCount(CsVO cs) {
		jdbcTemplate.update(updateCsCount,  cs.getBno());
	}
	
	
}