package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.service.CsService;
import com.lec.jdbc.service.CsService2;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.CsVO2;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Controller
public class CsController2 {
	
	@Autowired
	private CsService2 csService;
		
	@Value("#csitemsql['selectById']") private String selectById;	
	@Value("#csitemsql['selectCsitemList']") private String selectCsitemList;	
	
	@RequestMapping("getCsitemList.do") 
	public String getCsitemList(CsVO csitem, Model model,
			@RequestParam(defaultValue="1") int p,
			@RequestParam(defaultValue="10") int perPage) {
		PageInfo pageInfo = csService.getPageInfo(p, perPage);				
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("csitemList", csService.getCsitemList(p, perPage));	
		return "cs/cs_list.jsp";
	}
	
//	@RequestMapping("*/insertNotice.do")
//	public String insertNotice(NoticeVO notice) throws IOException {
//		MultipartFile uploadFile = board.getUploadFile();
//		if (!uploadFile.isEmpty()) {
//			String fileName = uploadFile.getOriginalFilename();
//			uploadFile.transferTo(new File("d:/lec03/99.temp/upload/" + fileName));
//			board.setFileName(fileName);
//		}	
//		noticeService.insertNotice(notice);
//		return "redirect:/getBoardList.do";
//	}
	
	
	@RequestMapping("/getCsitem.do")
	public String getCsitem(CsVO2 csitem, Model model) {	
		model.addAttribute("csitem", csService.getCsitem(csitem)); // Model
		return "cs/cs_detail.jsp"; // View 
	}	
	
	@RequestMapping("*/insertCsitem.do")
	public String insertCsitem(CsVO2 csitem) {
		csService.getCsitem(csitem);
		return "redirect:/getCsitemList.do";
	}
	
	
	@RequestMapping("/deleteCsitem.do")
	public String deleteCsitem(CsVO2 csitem) {
		csService.deleteCsitem(csitem);
		return "redirect:/getNoticeList.do";	
	}

}
	