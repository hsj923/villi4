package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.NoticeRowMapper;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.NoticeVO;


@Repository("noticeDAO")
@PropertySource("classpath:config/noticesql.properties")
public class NoticeDAO {

	@Autowired 
	NoticeService noticeService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByNotiseq = "";
	private String insertNotice = "";
	private String deleteNotice = "";
	private String updateNotice = "";
	private String selectNoticeList = "";
	private String selectNoticeListByTitle = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByNotiseq           = environment.getProperty("selectByNotiseq");
		insertNotice              = environment.getProperty("insertNotice");
		deleteNotice              = environment.getProperty("deleteNotice");
		updateNotice              = environment.getProperty("updateNotice");
		selectNoticeList          = environment.getProperty("selectNoticeList");
		selectNoticeListByTitle   = environment.getProperty("selectNoticeListByTitle");
	}

	public NoticeVO getNotice(NoticeVO notice) {
		Object[] args = { notice.getNoti_seq() };		
		return (NoticeVO) jdbcTemplate.queryForObject(selectByNotiseq, args, new NoticeRowMapper());
	}
	

	public List<NoticeVO> getNoticeList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectNoticeListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectNoticeListByTitle;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new NoticeRowMapper());
	}
	
	public NoticeVO insertNotice(NoticeVO notice) {
		jdbcTemplate.update(insertNotice, notice.getNoti_title(), notice.getNoti_content());
		return notice;
	}	


	public int deleteNotice(NoticeVO notice) {
		return jdbcTemplate.update(deleteNotice, notice.getNoti_seq());
	}
	
	
	public int updateNotice(NoticeVO notice) {
		return jdbcTemplate.update(updateNotice, notice.getNoti_title(), notice.getNoti_content(), notice.getNoti_seq());
	}
	
	
	
}