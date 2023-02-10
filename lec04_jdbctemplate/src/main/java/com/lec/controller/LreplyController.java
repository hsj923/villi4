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
import com.lec.jdbc.service.CsreplyService;
import com.lec.jdbc.service.LostService;
import com.lec.jdbc.service.LreplyService;
import com.lec.jdbc.service.QreplyService;
import com.lec.jdbc.service.QuestionService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsReplyVO;
import com.lec.jdbc.vo.LReplyVO;
import com.lec.jdbc.vo.QReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class LreplyController {

	@Autowired
	LostService lostService;

	@Autowired
	LreplyService lreplyService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getLReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(lreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<LReplyVO> lreplyList = lreplyService.getLReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("qreplyList", lreplyList);
		return "lost/getLostList.jsp";
	}

	// ��� �ۼ�
	@RequestMapping(value = "/insertLReply.do", method = RequestMethod.POST)
	public String insertLReply(LReplyVO lreply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		lreplyService.insertLReply(lreply);
		return "redirect:/updateLost.do";
	}

	@RequestMapping(value = "/updateLReply.do", method = RequestMethod.GET)
	public String updateLReply(Model model, LReplyVO lreply, int seq, SearchVO searchVO) {
		List<LReplyVO> lreplyList = lreplyService.getLReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("lreplyList", lreplyList);
		return "lost/updateLost.jsp";
	}

	@RequestMapping(value = "/updateLReply.do", method = RequestMethod.POST)
	public String updateLReply(LReplyVO lreply) {
		lreplyService.updateLReply(lreply);
		return "getLostList.do";
	}

	
	/*
	 * @RequestMapping(value="/deleteLReply.do", method=RequestMethod.GET) public
	 * String deleteLReply(Model model, LReplyVO lreply, SearchVO
	 * searchVO, @RequestParam int rno) { lreply.setRno(rno);
	 * model.addAttribute("searchVO", searchVO);
	 * model.addAttribute("qreply",lreplyService.getLReply(lreply)); return
	 * "lost/deleteCsBoard.jsp";
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/deleteLReply.do", method=RequestMethod.POST) public
	 * String deleteLReply(QReplyVO qreply) { lreplyService.deleteQReply(qreply);
	 * return "getLostList.do"; }
	 */

}