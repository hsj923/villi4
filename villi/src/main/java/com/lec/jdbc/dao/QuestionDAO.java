package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.QuestionRowMapper;
import com.lec.jdbc.vo.QuestionVO;

@Repository("questionDAO")
@PropertySource("classpath:config/questionsql.properties")
public class QuestionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByQuestionSeq = "";
	private String questionTotalRowCount = "";
	private String insertQuestion = "";
	private String deleteQuestion = "";
	private String updateQuestion = "";
	private String updateCount = "";
	private String selectQuestionList = "";
	private String selectQuestionListByTitle = ""; 
	private String selectQuestionListByWriter = ""; 
	private String selectQuestionListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByQuestionSeq              = environment.getProperty("selectByQuestionSeq");
		questionTotalRowCount       = environment.getProperty("questionTotalRowCount");
		insertQuestion              = environment.getProperty("insertQuestion");
		deleteQuestion              = environment.getProperty("deleteQuestion");
		updateQuestion              = environment.getProperty("updateQuestion");
		updateCount              = environment.getProperty("updateCount");
		selectQuestionList          = environment.getProperty("selectQuestionList");
		selectQuestionListByTitle   = environment.getProperty("selectQuestionListByTitle");
		selectQuestionListByWriter  = environment.getProperty("selectQuestionListByWriter");
		selectQuestionListByCate2= environment.getProperty("selectQuestionListByCate2");
	}

	public QuestionVO getQuestion(QuestionVO question) {
		Object[] args = { question.getSeq() };		
		return (QuestionVO) jdbcTemplate.queryForObject(selectByQuestionSeq, args, new QuestionRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = questionTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = questionTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = questionTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = questionTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<QuestionVO> getQuestionList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectQuestionListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectQuestionListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectQuestionListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectQuestionListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new QuestionRowMapper());
	}
	
	public QuestionVO insertQuestion(QuestionVO question) {
		jdbcTemplate.update(insertQuestion, question.getTitle(), question.getWriter(), question.getContent(), question.getFileName1(), question.getFileName2(), question.getFileName3());
		return question;
	}	

	
	public int deleteQuestion(QuestionVO question) {
		
		System.out.println(question.toString());
		
		return jdbcTemplate.update(deleteQuestion, question.getSeq());
	}

	public int updateQuestion(QuestionVO question) {
		return jdbcTemplate.update(updateQuestion, question.getTitle(), question.getContent(), question.getSeq());
	}
	
	public void updateCount(QuestionVO question) {
		jdbcTemplate.update(updateCount,  question.getSeq());
	}
	
	
}