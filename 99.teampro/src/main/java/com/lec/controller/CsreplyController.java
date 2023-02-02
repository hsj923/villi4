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
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.service.CsboardService;
import com.lec.jdbc.service.CsreplyService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsBoardVO;
import com.lec.jdbc.vo.CsReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class CsreplyController {

	@Autowired
	CsboardService csboardService;
	
	@Autowired
	CsreplyService csreplyService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getCsReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO,int bno,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(csreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<CsReplyVO> csreplyList = csreplyService.getCsReplyList(bno, searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreplyList", csreplyList);		
		return "cs/getCsBoardList.jsp";
	}
	
	@RequestMapping("/insertCsReply.do")
	public String insertCsReply(CsReplyVO csreply) {		
		csreplyService.insertCsReply(csreply);
		return "getCsBoardList.jsp";
	}	
	
	@RequestMapping(value="/updateCsReply.do", method=RequestMethod.GET)
	public String updateCsReply(Model model, CsReplyVO csreply, SearchVO searchVO) {
		csreplyService.getCsReplyList(0, searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreply", csreplyService.getCsReply(csreply));
		return "cs/updateCsBoard.jsp";
	}
	
	@RequestMapping(value="/updateCsReply.do", method=RequestMethod.POST)
	public String updateCsReply(CsReplyVO csreply) {
		csreplyService.updateCsReply(csreply);
		return "getCsBoardList.do";
	}	

	@RequestMapping(value="/deleteCsReply.do", method=RequestMethod.GET)
	public String deleteCsReply(Model model, CsReplyVO csreply, SearchVO searchVO, @RequestParam int rno) {
		csreply.setRno(rno);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreply", csreplyService.getCsReply(csreply));
		return "cs/deleteCsBoard.jsp";
	}
	
	@RequestMapping(value="/deleteCsReply.do", method=RequestMethod.POST)
	public String deleteCsReply(CsReplyVO csreply) {
		csreplyService.deleteCsReply(csreply);
		return "getCsBoardList.do";
	}	

}