package com.lec.jdbc.dao;


import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.ReviewRowMapper;
import com.lec.jdbc.vo.ReviewVO;

@Repository("reviewDAO")
@PropertySource("classpath:config/reviewsql.properties")
public class ReviewDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByReviewSeq = "";
	private String reviewTotalRowCount = "";
	private String insertReview = "";
	private String deleteReview = "";
	private String updateReview = "";
	private String selectReviewList = "";
	
//	내가쓴글목록
	private String selectMyReviewList ="";
	
	
//	제목,작성자,카테고리로 검색하기
	private String selectReviewListByTitle = ""; 
	private String selectReviewListByNickname = ""; 
	private String selectReviewListByCate2 = "";

	
	@PostConstruct
	public void getSqlPropeties() {
		selectByReviewSeq              = environment.getProperty("selectByReviewSeq");
		reviewTotalRowCount       = environment.getProperty("reviewTotalRowCount");
		insertReview              = environment.getProperty("insertReview");
		deleteReview              = environment.getProperty("deleteReview");
		updateReview              = environment.getProperty("updateReview");
		selectReviewList          = environment.getProperty("selectReviewList");
		
		
		selectMyReviewList   = environment.getProperty("selectMyReviewList");
		selectReviewListByTitle   = environment.getProperty("selectReviewListByTitle");
		selectReviewListByNickname  = environment.getProperty("selectReviewListByNickname");
		selectReviewListByCate2= environment.getProperty("selectReviewListByCate2");
	}

	public ReviewVO getReview(ReviewVO review) {
		Object[] args = { review.getSeq() };		
		return (ReviewVO) jdbcTemplate.queryForObject(selectByReviewSeq, args, new ReviewRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = reviewTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = reviewTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = reviewTotalRowCount + " and nickname like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = reviewTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<ReviewVO> getReviewList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectReviewListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectReviewListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = selectReviewListByNickname;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectReviewListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new ReviewRowMapper());
	}
	
	public ReviewVO insertReview(ReviewVO review) {
		jdbcTemplate.update(insertReview, review.getNickname(), review.getRv_con());
		return review;
	}	
	
	
	public int deleteReview(ReviewVO review) {
		
		System.out.println(review.toString());
		
		return jdbcTemplate.update(deleteReview, review.getSeq());
	}

	public int updateReview(ReviewVO review) {
		return jdbcTemplate.update(updateReview, review.getRv_con());
	}

	
	
	
	//신고 게시글 목록
	public List<ReviewVO> getMyReviewList(String nickname) {
		Object[] args = {nickname};
		return jdbcTemplate.query(selectMyReviewList, args, new ReviewRowMapper());
	}
	
	
}