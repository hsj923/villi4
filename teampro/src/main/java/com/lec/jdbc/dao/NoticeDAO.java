package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.mapper.NoticeRowMapper;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;

@Repository
@PropertySource("classpath:config/noticesql.properties")
public class NoticeDAO {

	@Autowired                    
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String get_pageinfo     = "";
	private String insert_notice     = "";
	private String delete_notice    = "";
	private String get_notice       = "";
	private String get_notice_list   = "";
	
	@PostConstruct
	public void getSqlPropeties() {
		get_pageinfo     = environment.getProperty("get_pageinfo");
		insert_notice     = environment.getProperty("insert_notice");
		delete_notice 	 = environment.getProperty("delete_notice");
		get_notice 		 = environment.getProperty("get_notice");
		get_notice_list   = environment.getProperty("get_notice_list");
		
	}
	
	public List<NoticeVO> getNoticeList(int currentPage, int perPage) {		
		Object[] args = {(currentPage-1)*perPage,  perPage };
		return jdbcTemplate.query(get_notice_list, args, new NoticeRowMapper());		
	}
		
	public NoticeVO getNotice(NoticeVO notice) {
		try {
		Object[] args = { notice.getNoti_seq() };
		return jdbcTemplate.queryForObject(get_notice, args, new NoticeRowMapper());
		} catch (EmptyResultDataAccessException e){
			return null;
		}

	}

	public int insertNotice(NoticeVO notice) {
		return jdbcTemplate.update(insert_notice, notice.getNoti_seq(), notice.getNoti_title(), notice.getNoti_content());
	}

	public int deleteNotice(NoticeVO notice) {
		return jdbcTemplate.update(delete_notice, notice.getNoti_seq());
	}

	public PageInfo getPageInfo(String tableName, int currentPage, int perPage) {
		
		PageInfo pageInfo = new PageInfo();
		int totalCount = 0;
		int totalPages = 0;
		int startPage = 0;
		int endPage = 0;

		totalCount = jdbcTemplate.queryForInt(get_pageinfo);
		
		if(totalCount>0) {
			totalPages = (int)(totalCount / perPage) + ((totalCount % perPage == 0) ? 0 : 1);
			startPage = (int)(currentPage / perPage) * perPage + 1 + ((currentPage % perPage == 0) ? -perPage : 0);
			endPage = startPage + perPage - 1;
			endPage = (endPage >= totalPages) ? totalPages : endPage;
		}				
		pageInfo.setTotalPages(totalPages);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		return pageInfo;
	}
	
}
