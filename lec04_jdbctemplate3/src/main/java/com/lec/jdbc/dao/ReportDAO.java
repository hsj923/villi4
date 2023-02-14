package com.lec.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.ReportRowMapper;
import com.lec.jdbc.mapper.CsReplyRowMapper;
import com.lec.jdbc.vo.ReportVO;
import com.lec.jdbc.vo.CsReplyVO;

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
	
//	�������۸��
	private String selectMyReportList ="";
	
	
//	����,�ۼ���,ī�װ����� �˻��ϱ�
	private String selectReportListByTitle = ""; 
	private String selectReportListByNickname = ""; 
	private String selectReportListByCate2 = "";

	
	@PostConstruct
	public void getSqlPropeties() {
		selectByReportSeq         = environment.getProperty("selectByReportSeq");
		reportTotalRowCount       = environment.getProperty("reportTotalRowCount");
		insertReport              = environment.getProperty("insertReport");
		deleteReport              = environment.getProperty("deleteReport");
		updateReport              = environment.getProperty("updateReport");
		selectReportList          = environment.getProperty("selectReportList");
		
		
		selectMyReportList   = environment.getProperty("selectMyReportList");
		selectReportListByTitle   = environment.getProperty("selectReportListByTitle");
		selectReportListByNickname  = environment.getProperty("selectReportListByNickname");
		selectReportListByCate2= environment.getProperty("selectReportListByCate2");
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
				sql = reportTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = reportTotalRowCount + " and nickname like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = reportTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<ReportVO> getReportList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectReportListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectReportListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = selectReportListByNickname;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectReportListByCate2;
			} 					
		}
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new ReportRowMapper());
	}
	
	public ReportVO insertReport(ReportVO report) {
		jdbcTemplate.update(insertReport, report.getNickname(), report.getR_con(), report.getR_rs1(), report.getR_status(), report.getR_time());
		return report;
	}	
	
	
	public int deleteReport(ReportVO report) {
		return jdbcTemplate.update(deleteReport, report.getSeq());
	}

	public int updateReport(ReportVO report) {
		return jdbcTemplate.update(updateReport, report.getR_status(), report.getR_etime());
	}

	
	
	
	//신고 게시글 목록
	public List<ReportVO> getMyReportList(String nickname) {
		Object[] args = {nickname};
		return jdbcTemplate.query(selectMyReportList, args, new ReportRowMapper());
	}
	
	
}