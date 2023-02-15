package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.ReportRowMapper;
import com.lec.jdbc.vo.ReportVO;

@Repository("reportDAO")
@PropertySource("classpath:config/reportsql.properties")
public class ReportDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByReportSeq = "";
	private String reportTotalRowCount = "";
	private String insertReport = "";
	private String deleteReport = "";
	private String updateReport = "";
	private String selectReportList = "";
	private String selectMeetingListByR_rs1 = ""; 
	private String selectMeetingListByR_status = ""; 
	private String selectMeetingListByName = ""; 

	@PostConstruct
	public void getSqlPropeties() {
		selectByReportSeq              = environment.getProperty("selectByReportSeq");
		reportTotalRowCount       = environment.getProperty("reportTotalRowCount");
		insertReport              = environment.getProperty("insertReport");
		deleteReport              = environment.getProperty("deleteReport");
		updateReport              = environment.getProperty("updateReport");
		selectReportList          = environment.getProperty("selectReportList");
		selectMeetingListByR_rs1   = environment.getProperty("selectMeetingListByR_rs1");
		selectMeetingListByR_status  = environment.getProperty("selectMeetingListByR_status");
		selectMeetingListByName= environment.getProperty("selectMeetingListByName");
	}

	public ReportVO getReport(ReportVO report) {
		Object[] args = { report.getSeq() };		
		return (ReportVO) jdbcTemplate.queryForObject(selectByReportSeq, args, new ReportRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = reportTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = reportTotalRowCount + " and r_rs1 like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = reportTotalRowCount + " and r_status like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = reportTotalRowCount + " and name like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<ReportVO> getReportList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectMeetingListByR_rs1;
			searchVO.setSearchType("r_rs1");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("r_rs1")) {
				sql = selectMeetingListByR_rs1;
			} else if(searchVO.getSearchType().equalsIgnoreCase("r_status")) {
				sql = selectMeetingListByR_status;
			} else if(searchVO.getSearchType().equalsIgnoreCase("name")) {
				sql = selectMeetingListByName;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new ReportRowMapper());
	}
	
	public ReportVO insertReport(ReportVO report) {
		jdbcTemplate.update(insertReport, report.getName(), report.getR_con(), report.getR_rs1());
		return report;
	}	

	
	public int deleteReport(ReportVO report) {
		
		System.out.println(report.toString());
		
		return jdbcTemplate.update(deleteReport, report.getSeq());
	}

	public int updateReport(ReportVO report) {
		return jdbcTemplate.update(updateReport, report.getSeq());
	}

	
}