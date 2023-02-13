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
import com.lec.jdbc.service.MeetingService;
import com.lec.jdbc.service.MreplyService;
import com.lec.jdbc.vo.GReplyVO;
import com.lec.jdbc.vo.MReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class MreplyController {

	@Autowired
	MeetingService meetingService;

	@Autowired
	MreplyService mreplyService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getMReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(mreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<MReplyVO> mreplyList = mreplyService.getMReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("mreplyList", mreplyList);
		return "meeting/getMeetingList.jsp";
	}

	// ��� �ۼ�
	@RequestMapping(value = "/insertMReply.do", method = RequestMethod.POST)
	public String insertMReply(MReplyVO mreply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		mreplyService.insertMReply(mreply);
		return "redirect:/updateMeeting.do";
	}

	@RequestMapping(value = "/updateMReply.do", method = RequestMethod.GET)
	public String updateMReply(Model model, MReplyVO mreply, int seq, SearchVO searchVO) {
		List<MReplyVO> mreplyList = mreplyService.getMReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("mreplyList", mreplyList);
		return "meeting/updateMeeting.jsp";
	}

	@RequestMapping(value = "/updateMReply.do", method = RequestMethod.POST)
	public String updateMReply(MReplyVO mreply) {
		mreplyService.updateMReply(mreply);
		return "getMeetingList.do";
	}

	
	  @RequestMapping(value="/deleteMReply.do", method=RequestMethod.GET) 
	  public String deleteMReply(Model model, MReplyVO mreply, SearchVO searchVO, @RequestParam int rno) { 
		  mreply.setRno(rno);
		  mreplyService.deleteMReply(mreply);
		  return "getMeetingList.do"; 
	  
	  }

}