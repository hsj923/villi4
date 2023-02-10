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
import com.lec.jdbc.service.VoteService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.VReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class VreplyController {

	@Autowired
	VoteService voteService;

	@Autowired
	VreplyService vreplyService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getVReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(vreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<VReplyVO> vreplyList = vreplyService.getVReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("vreplyList", vreplyList);
		return "vote/getVoteList.jsp";
	}

	// ��� �ۼ�
	@RequestMapping(value = "/insertVReply.do", method = RequestMethod.POST)
	public String insertVReply(VReplyVO vreply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		vreplyService.insertVReply(vreply);
		return "redirect:/updateVote.do";
	}

	@RequestMapping(value = "/updateVReply.do", method = RequestMethod.GET)
	public String updateVReply(Model model, VReplyVO vreply, int seq, SearchVO searchVO) {
		List<VReplyVO> vreplyList = vreplyService.getVReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("vreplyList", vreplyList);
		return "vote/updateVote.jsp";
	}

	@RequestMapping(value = "/updateVReply.do", method = RequestMethod.POST)
	public String updateVReply(VReplyVO vreply) {
		vreplyService.updateVReply(vreply);
		return "getVoteList.do";
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