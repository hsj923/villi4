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
import com.lec.jdbc.service.CsService;
import com.lec.jdbc.vo.CsVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class CsController {

	@Autowired
	CsService csService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getCsList.do")
	public String getCsList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(csService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<CsVO> csList = csService.getCsList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csList", csList);		
		return "cs/getCsList.jsp";
	}
	
	

	
	@RequestMapping("*/insertCs.do")
	public String insertCs(CsVO cs) throws IOException {
		MultipartFile uploadFile1 = cs.getUploadFile1();
		if (!uploadFile1.isEmpty()) {
			String fileName = uploadFile1.getOriginalFilename();
			uploadFile1.transferTo(new File(uploadFolder + fileName));
			cs.setFileName1(fileName);
		}	
		csService.insertCs(cs);
		return "redirect:/getCsList.do";
	}	
	
	@RequestMapping(value="/updateCs.do", method=RequestMethod.GET)
	public String updateCs(Model model, CsVO cs, SearchVO searchVO) {
		csService.updateCsCount(cs);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("cs", csService.getCs(cs));
		return "cs/updateCs.jsp";
	}
	
	@RequestMapping(value="/updateCs.do", method=RequestMethod.POST)
	public String updateCs(CsVO cs) {
		csService.updateCs(cs);
		return "getCsList.do";
	}	

	@RequestMapping(value="/deleteCs.do", method=RequestMethod.GET)
	public String deleteCs(Model model, CsVO cs, SearchVO searchVO, @RequestParam int seq) {
		cs.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("cs", csService.getCs(cs));
		return "cs/deleteCs.jsp";
	}
	
	@RequestMapping(value="/deleteCs.do", method=RequestMethod.POST)
	public String deleteCs(CsVO cs) {
		csService.deleteCs(cs);
		return "getCsList.do";
	}	
	
	}	
