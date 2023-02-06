package com.lec.controller;

import java.io.File;
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
import com.lec.jdbc.service.ReviewService;
import com.lec.jdbc.vo.ReviewVO;

@Controller("reviewController")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	Environment environment;

	private String uploadFolder = "";

	@PostConstruct
	public void getUploadPathPropererties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}

	@RequestMapping("getReviewList.do")
	public String getReviewList(Model model, SearchVO searchVO, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "") String searchCategory, @RequestParam(defaultValue = "") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {

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
		return "review/mypage.jsp";
	}

	@RequestMapping("*/insertReview.do")
	public String insertReview(ReviewVO review) {
		reviewService.insertReview(review);
		return "redirect:/getReviewList.do";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.GET)
	public String updateReview(Model model, ReviewVO review, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("review", reviewService.getReview(review));
		return "review/updateReview.jsp";
	}

	@RequestMapping(value = "/updateReview.do", method = RequestMethod.POST)
	public String updateReview(ReviewVO review) throws IOException {
		MultipartFile uploadFile = review.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			review.setFileName(fileName);
		}
		reviewService.updateReview(review);
		return "getReviewList.do";
	}

	// **

	@RequestMapping(value = "/getReview.do", method = RequestMethod.GET)
	public String getReview(Model model, ReviewVO review, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("review", reviewService.getReviewByNick(review));
		return "review/getReview.jsp";
	}

	@RequestMapping(value = "/getReview.do", method = RequestMethod.POST)
	public String getReview(ReviewVO review) throws IOException {
		MultipartFile uploadFile = review.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			review.setFileName(fileName);
		}
		reviewService.getReviewByNick(review);
		return "getReviewList.do";
	}

	@RequestMapping(value = "/deleteReview.do", method = RequestMethod.GET)
	public String deleteReview(Model model, ReviewVO review, SearchVO searchVO, @RequestParam String email) {
		review.setEmail(email);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("review", reviewService.getReview(review));
		return "review/deleteReview.jsp";
	}

	@RequestMapping(value = "/deleteReview.do", method = RequestMethod.POST)
	public String deleteReview(ReviewVO review) {
		reviewService.deleteReview(review);
		return "getReviewList.do";
	}

}