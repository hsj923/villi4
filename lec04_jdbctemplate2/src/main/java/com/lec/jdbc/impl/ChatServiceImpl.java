package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.ChatDAO;
import com.lec.jdbc.service.ChatService;
import com.lec.jdbc.vo.ChatVO;

@Service("chatService")
public class ChatServiceImpl implements ChatService {

	@Autowired
	ChatDAO chatDAO;
	
//	public ChatServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public ChatVO getChat(ChatVO vo) {
		return chatDAO.getChat(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return chatDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<ChatVO> getChatList(SearchVO searchVO) {
		return chatDAO.getChatList(searchVO);
	}

	@Override
	public ChatVO insertChat(ChatVO chat) {
		return chatDAO.insertChat(chat);
	}

	@Override
	public int deleteChat(ChatVO chat) {
		return chatDAO.deleteChat(chat);
	}

	@Override
	public int updateChat(ChatVO chat) {
		return chatDAO.updateChat(chat);
	}
	
	@Override
	public void updateCount(ChatVO chat) {
		chatDAO.updateCount(chat);
	}
	
}
