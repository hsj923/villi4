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
import com.lec.jdbc.service.VoteService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.VReplyVO;
import com.lec.jdbc.vo.VoteVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class VoteController {

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
	
	@RequestMapping("getVoteList.do")
	public String getVoteList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(voteService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<VoteVO> voteList = voteService.getVoteList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("voteList", voteList);		
		return "vote/getVoteList.jsp";
	}

	@RequestMapping("*/insertVote.do")
	public String insertVote(VoteVO vote) throws IOException {
		voteService.insertVote(vote);
		return "redirect:/getVoteList.do";
	}	
	
	@RequestMapping(value="/updateVote.do", method=RequestMethod.GET)
	public String updateVote(Model model, VoteVO vote, SearchVO searchVO,int seq) {
		List<VReplyVO> vreplyList = vreplyService.getVReplyList(seq);
		voteService.updateVoteCount(vote);
		model.addAttribute("vreplyList", vreplyList);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("vote", voteService.getVote(vote));
		return "vote/updateVote.jsp";
	}
	
	@RequestMapping(value="/updateVote.do", method=RequestMethod.POST)
	public String updateVote(VoteVO vote) {
		voteService.updateVote(vote);
		return "getVoteList.do";
	}	


	
	
	@RequestMapping(value="/deleteVote.do", method=RequestMethod.GET)
	public String deleteVote(Model model, VoteVO vote, SearchVO searchVO, @RequestParam int seq) {
		vote.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("vote", voteService.getVote(vote));
		return "vote/deleteVote.jsp";
	}
	
	@RequestMapping(value="/deleteVote.do", method=RequestMethod.POST)
	public String deleteVote(VoteVO vote) {
		voteService.deleteVote(vote);
		return "getVoteList.do";
	}	
	
}