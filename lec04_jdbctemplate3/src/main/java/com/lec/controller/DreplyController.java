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
import com.lec.jdbc.service.DemandService;
import com.lec.jdbc.service.DreplyService;
import com.lec.jdbc.service.VoteService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class DreplyController {

	@Autowired
	DemandService demandService;

	@Autowired
	DreplyService dreplyService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getDReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(dreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<DReplyVO> dreplyList = dreplyService.getDReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("dreplyList", dreplyList);
		return "demand/getDemandList.jsp";
	}

	// ????????? ????????
	@RequestMapping(value = "/insertDReply.do", method = RequestMethod.POST)
	public String insertDReply(DReplyVO vreply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		dreplyService.insertDReply(vreply);
		return "redirect:/updateDemand.do";
	}

	@RequestMapping(value = "/updateDReply.do", method = RequestMethod.GET)
	public String updateDReply(Model model, DReplyVO dreply, int seq, SearchVO searchVO) {
		List<DReplyVO> dreplyList = dreplyService.getDReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("dreplyList", dreplyList);
		return "demand/updateDemand.jsp";
	}

	@RequestMapping(value = "/updateDReply.do", method = RequestMethod.POST)
	public String updateDReply(DReplyVO dreply) {
		dreplyService.updateDReply(dreply);
		return "getDemandList.do";
	}

	  @RequestMapping(value="/deleteDReply.do", method=RequestMethod.GET) 
	  public String deleteDReply(Model model, DReplyVO dreply, SearchVO searchVO, @RequestParam int rno) { 
		  dreply.setRno(rno);
		  dreplyService.deleteDReply(dreply);
		  return "getDemandList.do"; 
	  
	  }

}