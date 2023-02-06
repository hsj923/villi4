package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.ReviewVO;

public interface ReviewService {

	ReviewVO getReview(ReviewVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<ReviewVO> getReviewList(SearchVO searchVO);
	ReviewVO insertReview(ReviewVO review);
	int deleteReview(ReviewVO review);
	int updateReview(ReviewVO review);
	ReviewVO getReview1(ReviewVO vo);
	//**
	ReviewVO getReviewByNick(ReviewVO vo);
}
