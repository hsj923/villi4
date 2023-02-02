package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.CsBoardRowMapper;
import com.lec.jdbc.vo.CsBoardVO;

@Repository("csboardDAO")
@PropertySource("classpath:config/csboardsql.properties")
public class CsBoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByBno = "";
	private String csboardTotalRowCount = "";
	private String insertCsBoard = "";
	private String deleteCsBoard = "";
	private String updateCsBoard = "";
	private String updateCsCount = "";
	private String selectCsBoardList = "";
	private String selectCsBoardListByTitle = ""; 
	private String selectCsBoardListByWriter = ""; 
	private String selectCsBoardListByContent = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByBno              = environment.getProperty("selectByBno");
		csboardTotalRowCount       = environment.getProperty("csboardTotalRowCount");
		insertCsBoard              = environment.getProperty("insertCsBoard");
		deleteCsBoard              = environment.getProperty("deleteCsBoard");
		updateCsBoard              = environment.getProperty("updateCsBoard");
		updateCsCount              = environment.getProperty("updateCsCount");
		selectCsBoardList          = environment.getProperty("selectCsBoardList");
		selectCsBoardListByTitle   = environment.getProperty("selectCsBoardListByTitle");
		selectCsBoardListByWriter  = environment.getProperty("selectCsBoardListByWriter");
		selectCsBoardListByContent = environment.getProperty("selectCsBorderListByContent");
	}
	
	public CsBoardVO getCsBoard(CsBoardVO csboard) {
		Object[] args = { csboard.getBno() };		
		return (CsBoardVO) jdbcTemplate.queryForObject(selectByBno, args, new CsBoardRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = csboardTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = csboardTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = csboardTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = csboardTotalRowCount + " and content like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<CsBoardVO> getCsBoardList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectCsBoardListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectCsBoardListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectCsBoardListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("content")) {
				sql = selectCsBoardListByContent;
			} 					
		}
		//System.out.println(sql);
		//System.out.println(searchVO.getFirstRow());
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new CsBoardRowMapper());
	}
	
	public CsBoardVO insertCsBoard(CsBoardVO csboard) {
		jdbcTemplate.update(insertCsBoard, csboard.getTitle(), csboard.getWriter(), csboard.getContent(), csboard.getRegDate());
		return csboard;
	}	
	
	public int deleteCsBoard(CsBoardVO csboard) {
		
		System.out.println(csboard.toString());
		
		return jdbcTemplate.update(deleteCsBoard, csboard.getBno());
	}

	public int updateCsBoard(CsBoardVO csboard) {
		return jdbcTemplate.update(updateCsBoard, csboard.getTitle(), csboard.getContent(), csboard.getBno());
	}
	
	public void updateCsCount(CsBoardVO csboard) {
		jdbcTemplate.update(updateCsCount, csboard.getBno());
	}
	
	
}