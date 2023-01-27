package com.lec.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.NoticeVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@Autowired
	Environment environment;
	
	
	@RequestMapping("getNoticeList.do")
	public String getNoticeList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<NoticeVO> noticeList = noticeService.getNoticeList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("noticeList", noticeList);		
		return "notice/getNoticeList.jsp";
	}
	
	@RequestMapping("*/insertNotice.do")
	public String insertNotice(NoticeVO notice) throws IOException {
		noticeService.insertNotice(notice);
		return "redirect:/getNoticeList.do";
	}
	
	
	@RequestMapping(value="/updateNotice.do", method=RequestMethod.GET)
	public String updateNotice(Model model, NoticeVO notice, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("notice", noticeService.getNotice(notice));
		return "notice/notice_detail.jsp";
	}
	
	@RequestMapping(value="/updateNotice.do", method=RequestMethod.POST)
	public String updateNotice(NoticeVO notice) {
		noticeService.updateNotice(notice);
		return "getNoticeList.do";
	}	

	
	
	/*
	 * @RequestMapping(value="/deleteNotice.do", method=RequestMethod.GET) public
	 * String deleteNotice(Model model, NoticeVO notice, SearchVO
	 * searchVO, @RequestParam int noti_seq) { notice.setNoti_seq(noti_seq);
	 * model.addAttribute("searchVO", searchVO); model.addAttribute("board" ,
	 * noticeService.getNotice(notice)); return "notice/deleteNotice.jsp"; }
	 * 
	 * @RequestMapping(value="/deleteNotice.do", method=RequestMethod.POST) public
	 * String deleteNotice(NoticeVO notice) { noticeService.deleteNotice(notice);
	 * return "getNoticeList.do"; }
	 */

// ------------------- 삭제 다시 해보기 --------------------
	
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeVO notice) {
		noticeService.deleteNotice(notice);
		return "redirect:/getNoticeList.do";	
	}
	
	

	
}