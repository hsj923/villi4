package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.QuestionDAO;
import com.lec.jdbc.service.QuestionService;
import com.lec.jdbc.vo.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDAO questionDAO;
	
//	public QuestionServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public QuestionVO getQuestion(QuestionVO vo) {
		return questionDAO.getQuestion(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return questionDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<QuestionVO> getQuestionList(SearchVO searchVO) {
		return questionDAO.getQuestionList(searchVO);
	}

	@Override
	public QuestionVO insertQuestion(QuestionVO question) {
		return questionDAO.insertQuestion(question);
	}
	
	@Override
	public int deleteQuestion(QuestionVO question) {
		return questionDAO.deleteQuestion(question);
	}

	@Override
	public int updateQuestion(QuestionVO question) {
		return questionDAO.updateQuestion(question);
	}
	
	@Override
	public void updateQuestionCount(QuestionVO question) {
		questionDAO.updateQuestionCount(question);
	}

	
}