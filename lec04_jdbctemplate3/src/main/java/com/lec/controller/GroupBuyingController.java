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
import com.lec.jdbc.service.GreplyService;
import com.lec.jdbc.service.GroupBuyingService;
import com.lec.jdbc.vo.GReplyVO;
import com.lec.jdbc.vo.GroupBuyingVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class GroupBuyingController {

	@Autowired
	GroupBuyingService groupBuyingService;
	
	@Autowired
	GreplyService greplyService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getGroupBuyingList.do")
	public String getGroupBuyingList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(groupBuyingService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<GroupBuyingVO> groupBuyingList = groupBuyingService.getGroupBuyingList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("groupBuyingList", groupBuyingList);		
		return "groupBuying/getGroupBuyingList.jsp";
	}
	
	@RequestMapping("*/insertGroupBuying.do")
	public String insertGroupBuying(GroupBuyingVO groupBuying) throws IOException {
		MultipartFile uploadFile1 = groupBuying.getUploadFile1();
		if (!uploadFile1.isEmpty()) {
			String fileName = uploadFile1.getOriginalFilename();
			uploadFile1.transferTo(new File(uploadFolder + fileName));
			groupBuying.setFileName1(fileName);
		}	
		groupBuyingService.insertGroupBuying(groupBuying);
		return "redirect:/getGroupBuyingList.do";
	}	
	
	@RequestMapping(value="/updateGroupBuying.do", method=RequestMethod.GET)
	public String updateGroupBuying(Model model, GroupBuyingVO groupBuying, SearchVO searchVO, int seq) {
		List<GReplyVO> greplyList = greplyService.getGReplyList(seq);
		groupBuyingService.updateGroupBuyingCount(groupBuying);
		model.addAttribute("greplyList", greplyList);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("groupBuying", groupBuyingService.getGroupBuying(groupBuying));
		return "groupBuying/updateGroupBuying.jsp";
	}
	
	@RequestMapping(value="/updateGroupBuying.do", method=RequestMethod.POST)
	public String updateGroupBuying(GroupBuyingVO groupBuying) {
		groupBuyingService.updateGroupBuying(groupBuying);
		return "getGroupBuyingList.do";
	}	

	@RequestMapping(value="/deleteGroupBuying.do", method=RequestMethod.GET)
	public String deleteGroupBuying(Model model, GroupBuyingVO groupBuying, SearchVO searchVO, @RequestParam int seq) {
		groupBuying.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("groupBuying", groupBuyingService.getGroupBuying(groupBuying));
		return "groupBuying/deleteGroupBuying.jsp";
	}
	
	@RequestMapping(value="/deleteGroupBuying.do", method=RequestMethod.POST)
	public String deleteGroupBuying(GroupBuyingVO groupBuying) {
		groupBuyingService.deleteGroupBuying(groupBuying);
		return "getGroupBuyingList.do";
	}	
	
}