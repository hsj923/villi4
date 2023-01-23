package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.ChatVO;

public interface ChatService {

	ChatVO getChat(ChatVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<ChatVO> getChatList(SearchVO searchVO);
	ChatVO insertChat(ChatVO chat);
	int deleteChat(ChatVO chat);
	int updateChat(ChatVO chat);
	void updateCount(ChatVO chat);
}
