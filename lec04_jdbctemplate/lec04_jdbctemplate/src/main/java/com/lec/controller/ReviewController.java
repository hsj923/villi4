package com.lec.controller;

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
import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.ReviewService;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.ReviewVO;


@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
//	LIST컨트롤러
	@RequestMapping("getReviewList.do")
	public String getReviewList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(reviewService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<ReviewVO> reviewList = reviewService.getReviewList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("reviewList", reviewList);		
		return "review/getReviewList.jsp";
	}
//	insert 상품 컨트롤러
	@RequestMapping("*/insertReview.do")
	public String insertReview(ReviewVO review) throws IOException {
		reviewService.insertReview(review);
		return "redirect:/getReviewList.do";
	}

	
	

	@RequestMapping(value="/updateReview.do", method=RequestMethod.GET)
	public String updateReview(Model model, ReviewVO review, SearchVO searchVO) {
		
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("review", reviewService.getReview(review));
		return "review/updateReview.jsp";
	}
	
	
	
	@RequestMapping(value="/updateReview.do", method=RequestMethod.POST)
	public String updateReview(ReviewVO review) {
		
		reviewService.updateReview(review);
		return "getReviewList.do";	
	}	

//	삭제 
	@RequestMapping(value="/deleteReview.do", method=RequestMethod.GET)
	public String deleteReview(Model model, ReviewVO review, SearchVO searchVO, @RequestParam int seq) {
		review.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("review", reviewService.getReview(review));
		return "review/deleteReview.jsp";
	}
	
	@RequestMapping(value="/deleteReview.do", method=RequestMethod.POST)
	public String deleteReview(ReviewVO review) {
		reviewService.deleteReview(review);
		return "getReviewList.do";
	}

	
//	신고 게시글 목록 리스트
	@RequestMapping("getMyReviewList.do")
	public String getCsList(Model model, SearchVO searchVO, String nickname,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(reviewService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
		
		
		List<ReviewVO> MyreviewList = reviewService.getMyReviewList(nickname);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("MyreviewList", MyreviewList);		
		return "review/getReviewList.jsp";
	}	
}