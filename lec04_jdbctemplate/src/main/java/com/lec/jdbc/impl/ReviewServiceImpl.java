package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.ReviewDAO;
import com.lec.jdbc.service.ReviewService;
import com.lec.jdbc.vo.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;
	
//	public ReviewServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public ReviewVO getReview(ReviewVO vo) {
		return reviewDAO.getReview(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return reviewDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<ReviewVO> getReviewList(SearchVO searchVO) {
		return reviewDAO.getReviewList(searchVO);
	}

	@Override
	public ReviewVO insertReview(ReviewVO review) {
		return reviewDAO.insertReview(review);
	}
	
	@Override
	public int deleteReview(ReviewVO review) {
		return reviewDAO.deleteReview(review);
	}

	@Override
	public int updateReview(ReviewVO review) {
		return reviewDAO.updateReview(review);
	}

	
//	내가쓴글목록
	@Override
	public List<ReviewVO> getMyReviewList(String nickname) {
		return reviewDAO.getMyReviewList(nickname);
	}
	
}