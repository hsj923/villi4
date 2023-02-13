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
import com.lec.jdbc.service.DemandService;
import com.lec.jdbc.service.DreplyService;
import com.lec.jdbc.service.GreplyService;
import com.lec.jdbc.service.GroupBuyingService;
import com.lec.jdbc.service.VoteService;
import com.lec.jdbc.service.VreplyService;
import com.lec.jdbc.vo.DReplyVO;
import com.lec.jdbc.vo.GReplyVO;
import com.lec.jdbc.vo.QReplyVO;
import com.lec.jdbc.vo.VReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class GreplyController {

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

	@RequestMapping("getGReplyList.do")
	public String getCsBoardList(Model model, SearchVO searchVO, int seq,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

		searchVO.setTotalRowCount(greplyService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();

		List<GReplyVO> greplyList = greplyService.getGReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("greplyList", greplyList);
		return "groupBuying/getGroupBuyingList.jsp";
	}

	@RequestMapping(value = "/insertGReply.do", method = RequestMethod.POST)
	public String insertGReply(GReplyVO greply, Model model, int seq) throws Exception {
		model.addAttribute("seq", seq);
		greplyService.insertGReply(greply);
		return "redirect:/updateGroupBuying.do";
	}
	
	

	@RequestMapping(value = "/updateGReply.do", method = RequestMethod.GET)
	public String updateGReply(Model model, GReplyVO greply, int seq, SearchVO searchVO) {
		List<GReplyVO> greplyList = greplyService.getGReplyList(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("greplyList", greplyList);
		return "groupBuying/updateGroupBuying.jsp";
	}

	@RequestMapping(value = "/updateGReply.do", method = RequestMethod.POST)
	public String updateGReply(GReplyVO greply) {
		greplyService.updateGReply(greply);
		return "getGroupBuyingList.do";
	}

	
	/*
	 * @RequestMapping(value="/deleteLReply.do", method=RequestMethod.GET) public
	 * String deleteLReply(Model model, LReplyVO lreply, SearchVO
	 * searchVO, @RequestParam int rno) { lreply.setRno(rno);
	 * model.addAttribute("searchVO", searchVO);
	 * model.addAttribute("qreply",lreplyService.getLReply(lreply)); return
	 * "lost/deleteCsBoard.jsp";
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/deleteLReply.do", method=RequestMethod.POST) public
	 * String deleteLReply(QReplyVO qreply) { lreplyService.deleteQReply(qreply);
	 * return "getLostList.do"; }
	 */

}