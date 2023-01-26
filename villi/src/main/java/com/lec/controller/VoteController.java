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
import com.lec.jdbc.vo.VoteVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class VoteController {

	@Autowired
	VoteService voteService;
	
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
		MultipartFile uploadFile1 = vote.getUploadFile1();
		if (!uploadFile1.isEmpty()) {
			String fileName = uploadFile1.getOriginalFilename();
			uploadFile1.transferTo(new File(uploadFolder + fileName));
			vote.setFileName1(fileName);
		}	
		MultipartFile uploadFile2 = vote.getUploadFile2();
		if (!uploadFile2.isEmpty()) {
			String fileName = uploadFile2.getOriginalFilename();
			uploadFile2.transferTo(new File(uploadFolder + fileName));
			vote.setFileName2(fileName);
		}	
		MultipartFile uploadFile3 = vote.getUploadFile3();
		if (!uploadFile3.isEmpty()) {
			String fileName = uploadFile3.getOriginalFilename();
			uploadFile3.transferTo(new File(uploadFolder + fileName));
			vote.setFileName3(fileName);
		}	
		MultipartFile uploadFile4 = vote.getUploadFile4();
		if (!uploadFile4.isEmpty()) {
			String fileName = uploadFile4.getOriginalFilename();
			uploadFile4.transferTo(new File(uploadFolder + fileName));
			vote.setFileName4(fileName);
		}	
		voteService.insertVote(vote);
		return "redirect:/getVoteList.do";
	}	
	
	@RequestMapping(value="/updateVote.do", method=RequestMethod.GET)
	public String updateVote(Model model, VoteVO vote, SearchVO searchVO) {
		voteService.updateCount(vote);
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