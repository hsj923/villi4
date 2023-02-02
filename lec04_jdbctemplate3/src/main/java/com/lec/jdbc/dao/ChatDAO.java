package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.ChatRowMapper;
import com.lec.jdbc.vo.ChatVO;

@Repository("chatDAO")
@PropertySource("classpath:config/chatsql.properties")
public class ChatDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectBySeq = "";
	private String chatTotalRowCount = "";
	private String insertChat = "";
	private String deleteChat = "";
	private String updateChat = "";
	private String updateCount = "";
	private String selectChatList = "";
	private String selectChatListByTitle = ""; 
	private String selectChatListByWriter = ""; 
	private String selectChatListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectBySeq              = environment.getProperty("selectBySeq");
		chatTotalRowCount       = environment.getProperty("chatTotalRowCount");
		insertChat              = environment.getProperty("insertChat");
		deleteChat              = environment.getProperty("deleteChat");
		updateChat              = environment.getProperty("updateChat");
		updateCount              = environment.getProperty("updateCount");
		selectChatList          = environment.getProperty("selectChatList");
		selectChatListByTitle   = environment.getProperty("selectChatListByTitle");
		selectChatListByWriter  = environment.getProperty("selectChatListByWriter");
		selectChatListByCate2= environment.getProperty("selectChatListByCate2");
	}

	public ChatVO getChat(ChatVO chat) {
		try {			
			Object[] args = { chat.getSeq() };		
			return (ChatVO) jdbcTemplate.queryForObject(selectBySeq, args, new ChatRowMapper());
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = chatTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = chatTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = chatTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = chatTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<ChatVO> getChatList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectChatListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectChatListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectChatListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectChatListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new ChatRowMapper());
	}
	
	public ChatVO insertChat(ChatVO chat) {
		jdbcTemplate.update(insertChat, chat.getTitle(), chat.getWriter(), chat.getContent(), chat.getCate2(), chat.getPrice(), chat.getFileName1(), chat.getFileName2(), chat.getFileName3(), chat.getFileName4(), chat.getFileName5());
		return chat;
	}	
	
	public int deleteChat(ChatVO chat) {
		
		System.out.println(chat.toString());
		
		return jdbcTemplate.update(deleteChat, chat.getSeq());
	}

	public int updateChat(ChatVO chat) {
		return jdbcTemplate.update(updateChat, chat.getTitle(), chat.getContent(), chat.getSeq());
	}
	
	public void updateCount(ChatVO chat) {
		jdbcTemplate.update(updateCount,  chat.getSeq());
	}
	
	
}