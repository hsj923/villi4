package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.GroupBuyingRowMapper;
import com.lec.jdbc.vo.GroupBuyingVO;

@Repository("groupBuyingDAO")
@PropertySource("classpath:config/groupbuyingsql.properties")
public class GroupBuyingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByGroupBuyingSeq = "";
	private String groupBuyingTotalRowCount = "";
	private String insertGroupBuying = "";
	private String deleteGroupBuying = "";
	private String updateGroupBuying = "";
	private String updateCount = "";
	private String selectGroupBuyingList = "";
	private String selectGroupBuyingListByTitle = ""; 
	private String selectGroupBuyingListByWriter = ""; 
	private String selectGroupBuyingListByCate2 = ""; 
	
	@PostConstruct
	public void getSqlPropeties() {
		selectByGroupBuyingSeq              = environment.getProperty("selectByGroupBuyingSeq");
		groupBuyingTotalRowCount       = environment.getProperty("groupBuyingTotalRowCount");
		insertGroupBuying              = environment.getProperty("insertGroupBuying");
		deleteGroupBuying              = environment.getProperty("deleteGroupBuying");
		updateGroupBuying              = environment.getProperty("updateGroupBuying");
		updateCount              = environment.getProperty("updateCount");
		selectGroupBuyingList          = environment.getProperty("selectGroupBuyingList");
		selectGroupBuyingListByTitle   = environment.getProperty("selectGroupBuyingListByTitle");
		selectGroupBuyingListByWriter  = environment.getProperty("selectGroupBuyingListByWriter");
		selectGroupBuyingListByCate2= environment.getProperty("selectGroupBuyingListByCate2");
	}

	public GroupBuyingVO getGroupBuying(GroupBuyingVO groupBuying) {
		Object[] args = { groupBuying.getSeq() };		
		return (GroupBuyingVO) jdbcTemplate.queryForObject(selectByGroupBuyingSeq, args, new GroupBuyingRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = groupBuyingTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = groupBuyingTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = groupBuyingTotalRowCount + " and writer like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = groupBuyingTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<GroupBuyingVO> getGroupBuyingList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectGroupBuyingListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectGroupBuyingListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("writer")) {
				sql = selectGroupBuyingListByWriter;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectGroupBuyingListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new GroupBuyingRowMapper());
	}
	
	public GroupBuyingVO insertGroupBuying(GroupBuyingVO groupBuying) {
		jdbcTemplate.update(insertGroupBuying, groupBuying.getTitle(), groupBuying.getWriter(), groupBuying.getContent(), groupBuying.getFileName1(), groupBuying.getPer(), groupBuying.getPlace(), groupBuying.getBuying_date(), groupBuying.getPrice());
		return groupBuying;
	}	

	
	public int deleteGroupBuying(GroupBuyingVO groupBuying) {
		
		System.out.println(groupBuying.toString());
		
		return jdbcTemplate.update(deleteGroupBuying, groupBuying.getSeq());
	}

	public int updateGroupBuying(GroupBuyingVO groupBuying) {
		return jdbcTemplate.update(updateGroupBuying, groupBuying.getTitle(), groupBuying.getContent(), groupBuying.getSeq());
	}
	
	public void updateCount(GroupBuyingVO groupBuying) {
		jdbcTemplate.update(updateCount,  groupBuying.getSeq());
	}
	
	
}