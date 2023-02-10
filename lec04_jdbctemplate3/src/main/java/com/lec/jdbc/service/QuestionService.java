package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.QuestionVO;

public interface QuestionService {

	QuestionVO getQuestion(QuestionVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<QuestionVO> getQuestionList(SearchVO searchVO);
	QuestionVO insertQuestion(QuestionVO question);
	int deleteQuestion(QuestionVO question);
	int updateQuestion(QuestionVO question);
	void updateQuestionCount(QuestionVO question);
}