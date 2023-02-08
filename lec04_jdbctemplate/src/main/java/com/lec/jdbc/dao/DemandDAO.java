package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.DemandRowMapper;
import com.lec.jdbc.vo.DemandVO;

@Repository("demandDAO")
@PropertySource("classpath:config/demandsql.properties")
public class DemandDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByDemandSeq = "";
	private String demandTotalRowCount = "";
	private String insertDemand = "";
	private String deleteDemand = "";
	private String updateDemand = "";
	private String updateDemandCount = "";
	private String selectDemandList = "";
	private String selectDemandListByTitle = ""; 
	private String selectDemandListByWriter = ""; 
	private String selectDemandListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByDemandSeq              = environment.getProperty("selectByDemandSeq");
		demandTotalRowCount       = environment.getProperty("demandTotalRowCount");
		insertDemand              = environment.getProperty("insertDemand");
		deleteDemand              = environment.getProperty("deleteDemand");
		updateDemand              = environment.getProperty("updateDemand");
		updateDemandCount              = environment.getProperty("updateDemandCount");
		selectDemandList          = environment.getProperty("selectDemandList");
		selectDemandListByTitle   = environment.getProperty("selectDemandListByTitle");
		selectDemandListByWriter  = environment.getProperty("selectDemandListByWriter");
		selectDemandListByCate2= environment.getProperty("selectDemandListByCate2");
	}

	public DemandVO getDemand(DemandVO demand) {
		Object[] args = { demand.getSeq() };		
		return (DemandVO) jdbcTemplate.queryForObject(selectByDemandSeq, args, new DemandRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = demandTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = demandTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = demandTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = demandTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<DemandVO> getDemandList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectDemandListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectDemandListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectDemandListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectDemandListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new DemandRowMapper());
	}
	
	public DemandVO insertDemand(DemandVO demand) {
		jdbcTemplate.update(insertDemand, demand.getTitle(), demand.getWriter(), demand.getContent(), demand.getPrice(), demand.getFileName1());
		return demand;
	}	

	
	public int deleteDemand(DemandVO demand) {
		
		System.out.println(demand.toString());
		
		return jdbcTemplate.update(deleteDemand, demand.getSeq());
	}

	public int updateDemand(DemandVO demand) {
		return jdbcTemplate.update(updateDemand, demand.getTitle(), demand.getContent(), demand.getSeq());
	}
	
	public void updateDemandCount(DemandVO demand) {
		jdbcTemplate.update(updateDemandCount,  demand.getSeq());
	}
	
	
}