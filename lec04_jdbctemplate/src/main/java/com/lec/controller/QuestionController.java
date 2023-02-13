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
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.QreplyService;
import com.lec.jdbc.service.QuestionService;
import com.lec.jdbc.vo.QReplyVO;
import com.lec.jdbc.vo.QuestionVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class QuestionController {

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
	
	@RequestMapping("getQuestionList.do")
	public String getQuestionList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(questionService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<QuestionVO> questionList = questionService.getQuestionList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("questionList", questionList);		
		return "question/getQuestionList.jsp";
	}
	
	@RequestMapping("*/insertQuestion.do")
	public String insertQuestion(QuestionVO question) throws IOException {
		MultipartFile uploadFile1 = question.getUploadFile1();
		if (!uploadFile1.isEmpty()) {
			String fileName = uploadFile1.getOriginalFilename();
			uploadFile1.transferTo(new File(uploadFolder + fileName));
			question.setFileName1(fileName);
		}	
		MultipartFile uploadFile2 = question.getUploadFile2();
		if (!uploadFile2.isEmpty()) {
			String fileName = uploadFile2.getOriginalFilename();
			uploadFile2.transferTo(new File(uploadFolder + fileName));
			question.setFileName2(fileName);
		}	
		MultipartFile uploadFile3 = question.getUploadFile3();
		if (!uploadFile3.isEmpty()) {
			String fileName = uploadFile3.getOriginalFilename();
			uploadFile3.transferTo(new File(uploadFolder + fileName));
			question.setFileName3(fileName);
		}	
		questionService.insertQuestion(question);
		return "redirect:/getQuestionList.do";
	}	
	
	@RequestMapping(value="/updateQuestion.do", method=RequestMethod.GET)
	public String updateQuestion(Model model, QuestionVO question, SearchVO searchVO, int seq) {
		
		List<QReplyVO> qreplyList = qreplyService.getQReplyList(seq);
		questionService.updateQuestionCount(question);
		model.addAttribute("qreplyList", qreplyList);
		model.addAttribute("question", questionService.getQuestion(question));
		
		return "question/updateQuestion.jsp";
	}
	
	@RequestMapping(value="/updateQuestion.do", method=RequestMethod.POST)
	public String updateQuestion(QuestionVO question) {
		questionService.updateQuestion(question);
		return "getQuestionList.do";
	}	

	@RequestMapping(value="/deleteQuestion.do", method=RequestMethod.GET)
	public String deleteQuestion(Model model, QuestionVO question, SearchVO searchVO, @RequestParam int seq) {
		question.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("question", questionService.getQuestion(question));
		return "question/deleteQuestion.jsp";
	}
	
	@RequestMapping(value="/deleteQuestion.do", method=RequestMethod.POST)
	public String deleteQuestion(QuestionVO question) {
		questionService.deleteQuestion(question);
		return "getQuestionList.do";
	}	
	
}