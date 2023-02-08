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
import com.lec.jdbc.service.MeetingService;
import com.lec.jdbc.service.MreplyService;
import com.lec.jdbc.vo.MReplyVO;
import com.lec.jdbc.vo.MeetingVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class MeetingController {

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
	
	@RequestMapping("getMeetingList.do")
	public String getMeetingList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(meetingService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<MeetingVO> meetingList = meetingService.getMeetingList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("meetingList", meetingList);		
		return "meeting/getMeetingList.jsp";
	}
	
	@RequestMapping("*/insertMeeting.do")
	public String insertMeeting(MeetingVO meeting) throws IOException {
		meetingService.insertMeeting(meeting);
		return "redirect:/getMeetingList.do";
	}	
	
	@RequestMapping(value="/updateMeeting.do", method=RequestMethod.GET)
	public String updateMeeting(Model model, MeetingVO meeting, SearchVO searchVO,int seq) {
		
		List<MReplyVO> mreplyList = mreplyService.getMReplyList(seq);
		meetingService.updateMeetingCount(meeting);
		model.addAttribute("mreplyList", mreplyList);
		model.addAttribute("meeting", meetingService.getMeeting(meeting));
		return "meeting/updateMeeting.jsp";
	}
	
	@RequestMapping(value="/updateMeeting.do", method=RequestMethod.POST)
	public String updateMeeting(MeetingVO meeting) {
		meetingService.updateMeeting(meeting);
		return "getMeetingList.do";
	}	

	@RequestMapping(value="/deleteMeeting.do", method=RequestMethod.GET)
	public String deleteMeeting(Model model, MeetingVO meeting, SearchVO searchVO, @RequestParam int seq) {
		meeting.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("meeting", meetingService.getMeeting(meeting));
		return "meeting/deleteMeeting.jsp";
	}
	
	@RequestMapping(value="/deleteMeeting.do", method=RequestMethod.POST)
	public String deleteMeeting(MeetingVO meeting) {
		meetingService.deleteMeeting(meeting);
		return "getMeetingList.do";
	}	
	
}