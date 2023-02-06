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
	private String selectById = "";
	private String reviewTotalRowCount = "";
	private String insertReview = "";
	private String deleteReview = "";
	private String updateReview = "";
	private String selectReviewList = "";
	private String selectReviewListById = ""; 
	private String selectReviewListByName = ""; 
	
	//**
	
	private String selectByNickname = "";
	
	@PostConstruct
	public void getSqlPropeties() {
		selectById           = environment.getProperty("selectById");
		reviewTotalRowCount    = environment.getProperty("reviewTotalRowCount");
		insertReview           = environment.getProperty("insertReview");
		deleteReview           = environment.getProperty("deleteReview");
		updateReview           = environment.getProperty("updateReview");
		selectReviewList       = environment.getProperty("selectReviewList");
		selectReviewListById   = environment.getProperty("selectReviewListById");
		selectReviewListByName = environment.getProperty("selectReviewListByName");
		
		
		//**
		
		selectByNickname = environment.getProperty("selectByNickname");
	}

	public ReviewVO getReview(ReviewVO review) {
		// System.out.println(jdbcTemplate.getDataSource().getConnection().toString());
		Object[] args = { review.getEmail() };		
		return (ReviewVO) jdbcTemplate.queryForObject(selectById, args, new ReviewRowMapper());
	}
	
	
	
	//** 
	

	public ReviewVO getReviewByNick(ReviewVO review) {
		// System.out.println(jdbcTemplate.getDataSource().getConnection().toString());
		Object[] args = { review.getNickname() };		
		return (ReviewVO) jdbcTemplate.queryForObject(selectByNickname, args, new ReviewRowMapper());
	}
	
	
	
	
	
	
	
	public int getTotalRowCount(SearchVO searchVO) {
		sql = reviewTotalRowCount;
		String sw = searchVO.getSearchWord()==null ? "" : searchVO.getSearchWord();
		String st = searchVO.getSearchType();
		sql = sw =="" ? sql : (st.equalsIgnoreCase("id") ? sql + " and id like '%" + sw +"%'" : sql + " and name like '%" + sw + "%'");
		return jdbcTemplate.queryForInt(sql);
	}

	public List<ReviewVO> getReviewList(SearchVO searchVO) {	
		sql = searchVO.getSearchWord()==null ? selectReviewListById : 
				(searchVO.getSearchType().equalsIgnoreCase("id") ? selectReviewListById : selectReviewListByName);
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";			
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new ReviewRowMapper());
	}
	
	public ReviewVO insertReview(ReviewVO review) {
		review.setRole((review.getRole() != null) ? "ADMIN" : "Review");	
		jdbcTemplate.update(insertReview, review.getEmail(), review.getPassword(), review.getName(), review.getRole());
		return review;
	}	
	
	public int deleteReview(ReviewVO review) {
		return jdbcTemplate.update(deleteReview, review.getEmail());
	}

	public int updateReview(ReviewVO review) {
		review.setRole((review.getRole() != null) ? "ADMIN" : "Review");
		return jdbcTemplate.update(updateReview, review.getName(), review.getPassword(), review.getRole(), review.getEmail(), review.getFileName());
	}

}
