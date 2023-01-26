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
import com.lec.jdbc.service.DemandService;
import com.lec.jdbc.vo.DemandVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class DemandController {

	@Autowired
	DemandService demandService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getDemandList.do")
	public String getDemandList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(demandService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<DemandVO> demandList = demandService.getDemandList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("demandList", demandList);		
		return "demand/getDemandList.jsp";
	}
	
	@RequestMapping("*/insertDemand.do")
	public String insertDemand(DemandVO demand) throws IOException {
		MultipartFile uploadFile1 = demand.getUploadFile1();
		if (!uploadFile1.isEmpty()) {
			String fileName = uploadFile1.getOriginalFilename();
			uploadFile1.transferTo(new File(uploadFolder + fileName));
			demand.setFileName1(fileName);
		}	
		demandService.insertDemand(demand);
		return "redirect:/getDemandList.do";
	}	
	
	@RequestMapping(value="/updateDemand.do", method=RequestMethod.GET)
	public String updateDemand(Model model, DemandVO demand, SearchVO searchVO) {
		demandService.updateCount(demand);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("demand", demandService.getDemand(demand));
		return "demand/updateDemand.jsp";
	}
	
	@RequestMapping(value="/updateDemand.do", method=RequestMethod.POST)
	public String updateDemand(DemandVO demand) {
		demandService.updateDemand(demand);
		return "getDemandList.do";
	}	

	@RequestMapping(value="/deleteDemand.do", method=RequestMethod.GET)
	public String deleteDemand(Model model, DemandVO demand, SearchVO searchVO, @RequestParam int seq) {
		demand.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("demand", demandService.getDemand(demand));
		return "demand/deleteDemand.jsp";
	}
	
	@RequestMapping(value="/deleteDemand.do", method=RequestMethod.POST)
	public String deleteDemand(DemandVO demand) {
		demandService.deleteDemand(demand);
		return "getDemandList.do";
	}	
	
}