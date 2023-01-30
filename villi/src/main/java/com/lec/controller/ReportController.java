package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.ReportService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.ReportVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getReportList.do")
	public String getReportList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(reportService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<ReportVO> reportList = reportService.getReportList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("reportList", reportList);		
		return "report/getReportList.jsp";
	}
	
	@RequestMapping("*/insertReport.do")
	public String insertReport(ReportVO report) throws IOException {
		reportService.insertReport(report);
		return "redirect:/getReportList.do";
	}	
	

	
	
	
	@RequestMapping(value="/updateReport.do", method=RequestMethod.GET)
	public String updateReport(Model model, ReportVO report, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("report", reportService.getReport(report));
		return "report/updateReport.jsp";
	}
	
	@RequestMapping(value="/updateReport.do", method=RequestMethod.POST)
	public String updateReport(ReportVO report) {
		reportService.updateReport(report);
		return "getReportList.do";
	}	

	@RequestMapping(value="/deleteReport.do", method=RequestMethod.GET)
	public String deleteReport(Model model, ReportVO report, SearchVO searchVO, @RequestParam int seq) {
		report.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("report", reportService.getReport(report));
		return "report/deleteReport.jsp";
	}
	
	@RequestMapping(value="/deleteReport.do", method=RequestMethod.POST)
	public String deleteReport(ReportVO report) {
		reportService.deleteReport(report);
		return "getReportList.do";
	}	
	
}