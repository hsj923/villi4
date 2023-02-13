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
	private String selectDemandListByNickname = ""; 
	private String selectDemandListByAddress = ""; 
	private String selectMyDemandList        = ""; 
	
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
		selectDemandListByNickname  = environment.getProperty("selectDemandListByNickname");
		selectDemandListByAddress= environment.getProperty("selectDemandListByAddress");
		selectMyDemandList= environment.getProperty("selectMyDemandList");
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
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = demandTotalRowCount + " and nickname like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("address")) {
				sql = demandTotalRowCount + " and address like '%" + searchVO.getSearchWord() + "%'";
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
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = selectDemandListByNickname;
			} else if(searchVO.getSearchType().equalsIgnoreCase("address")) {
				sql = selectDemandListByAddress;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new DemandRowMapper());
	}
	
	public DemandVO insertDemand(DemandVO demand) {
		jdbcTemplate.update(insertDemand, demand.getTitle(), demand.getNickname(), demand.getContent(), demand.getPrice(), demand.getFileName1());
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
	
	
	//신고 게시글 목록
	public List<DemandVO> getMyDemandList(String nickname) {
		Object[] args = {nickname};
		return jdbcTemplate.query(selectMyDemandList, args, new DemandRowMapper());
	}
	
}