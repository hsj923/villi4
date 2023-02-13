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
import com.lec.jdbc.service.QreplyService;
import com.lec.jdbc.service.QuestionService;
import com.lec.jdbc.vo.QReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class QreplyController {

	@Autowired
	QuestionService questionService;

	@Autowired
	QreplyService qreplyService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getQReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(qreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<QReplyVO> qreplyList = qreplyService.getQReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("qreplyList", qreplyList);
		return "question/getQuestionList.jsp";
	}

	// ��� �ۼ�
	@RequestMapping(value = "/insertQReply.do", method = RequestMethod.POST)
	public String insertQReply(QReplyVO qreply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		qreplyService.insertQReply(qreply);
		return "redirect:/updateQuestion.do";
	}

	@RequestMapping(value = "/updateQReply.do", method = RequestMethod.GET)
	public String updateQReply(Model model, QReplyVO qreply, int seq, SearchVO searchVO) {
		List<QReplyVO> qreplyList = qreplyService.getQReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("qreplyList", qreplyList);
		return "question/updateQuestion.jsp";
	}

	@RequestMapping(value = "/updateQReply.do", method = RequestMethod.POST)
	public String updateQReply(QReplyVO qreply) {
		qreplyService.updateQReply(qreply);
		return "getQuestionList.do";
	}

	
	  @RequestMapping(value="/deleteQReply.do", method=RequestMethod.GET) public
	  String deleteQReply(Model model, QReplyVO qreply, SearchVO searchVO, @RequestParam int rno) { 
		  qreply.setRno(rno);
		  model.addAttribute("searchVO", searchVO); 
		  model.addAttribute("qreply",qreplyService.getQReply(qreply)); 
		  return "question/deleteCsBoard.jsp"; 
	  
	  }
	  
	  @RequestMapping(value="/deleteQReply.do", method=RequestMethod.POST)
		public String deleteQReply(QReplyVO qreply) {
		  qreplyService.deleteQReply(qreply);
		  return "getQuestionList.do";
		}	
	 

}