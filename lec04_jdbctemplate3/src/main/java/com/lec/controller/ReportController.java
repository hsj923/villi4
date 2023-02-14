package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.ReportService;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.ReportVO;
import com.lec.jdbc.vo.CsReplyVO;


@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	
//	LIST��Ʈ�ѷ�
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
//	insert ��ǰ ��Ʈ�ѷ�
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

//	���� 
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

	
//	�Ű� �Խñ� ��� ����Ʈ
	@RequestMapping("getMyReportList.do")
	public String getCsList(Model model, SearchVO searchVO, String nickname,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
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
		
		
		List<ReportVO> MyreportList = reportService.getMyReportList(nickname);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("MyreportList", MyreportList);		
		return "report/getReportList.jsp";
	}	
}