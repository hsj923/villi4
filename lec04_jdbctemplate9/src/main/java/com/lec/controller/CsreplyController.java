package com.lec.controller;


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


import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.CsService;
import com.lec.jdbc.service.CsreplyService;
import com.lec.jdbc.vo.CsReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class CsreplyController {

	@Autowired
	CsService csService;
	
	@Autowired
	CsreplyService csreplyService;
	
	@Autowired
	Environment environment;
	
	
	@RequestMapping("getCsReplyList.do")
	public String getCsList(Model model, SearchVO searchVO, int bno,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(csreplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<CsReplyVO> csreplyList = csreplyService.getCsReplyList(bno);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreplyList", csreplyList);		
		return "cs/getCsList.jsp";
	}
	

	@RequestMapping(value= "/insertCsReply.do" , method = RequestMethod.POST)
	public String insertCsReply(CsReplyVO csreply, Model model, int bno) throws Exception {
		model.addAttribute("bno" , bno);
		csreplyService.insertCsReply(csreply);
		return "redirect:/updateCs.do";
	}
	
	@RequestMapping(value="/updateCsReply.do", method=RequestMethod.GET)
	public String updateCsReply(Model model, CsReplyVO csreply, int bno,SearchVO searchVO) {
		List<CsReplyVO> csreplyList = csreplyService.getCsReplyList(bno);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreplyList", csreplyList);
		return "cs/updateCs.jsp";
	}
	
	@RequestMapping(value="/updateCsReply.do", method=RequestMethod.POST)
	public String updateCsReply(CsReplyVO csreply) {
		csreplyService.updateCsReply(csreply);
		return "getCsList.do";
	}	

	@RequestMapping(value="/deleteCsReply.do", method=RequestMethod.GET)
	public String deleteCsReply(Model model, CsReplyVO csreply, SearchVO searchVO, @RequestParam int rno) {
		csreply.setRno(rno);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csreply", csreplyService.getCsReply(csreply));
		return "cs/deleteCs.jsp";
	}
	
	@RequestMapping(value="/deleteCsReply.do", method=RequestMethod.POST)
	public String deleteCsReply(CsReplyVO csreply) {
		csreplyService.deleteCsReply(csreply);
		return "getCsList.do";
	}	

}