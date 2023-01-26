package com.lec.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.db.JDBCUtility;
import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.mapper.BoardRowMapper;
import com.lec.jdbc.mapper.CsRowMapper;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsVO;

@Repository
@PropertySource("classpath:config/cssql.properties")
public class CsDAO {
	
	Connection conn = null;
	
	@Autowired                    
	private JdbcTemplate jdbcTemplate;

	@Autowired
	Environment environment;
	
	private String sql = "";
	private String get_pageinfo     = ""; 
	private String insert_cs     = "";
	private String update_cs     = "";
	private String delete_cs     = ""; 
	private String get_cs        = "";
	private String get_cs_list   = "";

	@PostConstruct
	public void getSqlPropeties() {
		get_pageinfo     = environment.getProperty("get_pageinfo");
		insert_cs     = environment.getProperty("insert_cs");
		update_cs 	 = environment.getProperty("update_cs");
		delete_cs 	 = environment.getProperty("delete_cs");
		get_cs 		 = environment.getProperty("get_cs");
		get_cs_list   = environment.getProperty("get_cs_list");
		/* detail_cs = environment.getProperty("detail_cs"); */
	}
	
	public List<CsVO> getCsList(int currentPage, int perPage) {		
		Object[] args = {(currentPage-1)*perPage,  perPage };
		return jdbcTemplate.query(get_cs_list, args, new CsRowMapper());		
	}
		
	public CsVO getCs(CsVO cs) {
		try {
		Object[] args = { cs.getCs_num() };
		return jdbcTemplate.queryForObject(get_cs, args, new CsRowMapper());	
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int insertCs(CsVO cs) {
		return jdbcTemplate.update(insert_cs,cs.getCs_subject(), cs.getCs_name(), cs.getCs_content(), cs.getCs_file());
	}

	public int deleteCs(CsVO cs) {
		return jdbcTemplate.update(delete_cs, cs.getCs_num());
	}

	public int updateCs(CsVO cs) {
		return jdbcTemplate.update(update_cs, cs.getCs_subject(), cs.getCs_content(), cs.getCs_num());
	}	

	
//	public CsVO detailCs(CsVO cs) {
//		Object[] args = { cs.getCs_seq() };
//		return jdbcTemplate.queryForObject(detail_cs, args, new CsRowMapper());	
//	}
	
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
	
	/* --------------------------------------------------------------------------------------------------- */

	// ´ñ±Û ¾²±â
	public int insertReplyCs(CsVO cs) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update csitem set cs_re_seq = cs_re_seq + 1 "
				   + " where cs_re_ref = ? and cs_re_seq > ?";
		
		int num = 0;
		int re_ref = cs.getCs_re_ref();
		int re_lev = cs.getCs_re_lev();
		int re_seq = cs.getCs_re_seq();
		
		try {
			pstmt = conn.prepareStatement("select max(cs_num) from csitem");
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1) + 1; else num = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0) JDBCUtility.commit(conn);
			
			// ´ñ±Ûµî·Ï
			re_lev += 1;
			re_seq += 1;
			sql = "insert into csitem(cs_num, cs_name, cs_pass, cs_subject, cs_content, "
				       + "            cs_file, cs_re_ref, cs_re_lev, cs_re_seq, cs_readcount, cs_date) "
					   + "       values(?,?,?,?,?,?,?,?,?,?, now())";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, cs.getCs_name());
			pstmt.setString(3, cs.getCs_pass());
			pstmt.setString(4, cs.getCs_subject());
			pstmt.setString(5, cs.getCs_content());
			pstmt.setString(6, "");
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, cs.getCs_readcount());
			pstmt.setInt(11, 0);
			insertCount = pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("´ñ±Û ¾²±â ½ÇÆÐ!! : " + e.getMessage());
		
		} finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return insertCount;
	}

	
	
/* --------------------------------------------------------------------------------------------------- */
	
	public List<CsVO> getCsList(SearchVO searchVO) {
		sql = "select * from csitem where 1 = 1 "
		    + " and "      + searchVO.getSearchCategory() 
		    + " like '%"   + searchVO.getSearchWord() + "'%"
		    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
		    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.query(sql, new CsRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		sql = "select count(*) from csitem where 1 = 1 "
			    + " and "      + searchVO.getSearchCategory() 
			    + " like '%"   + searchVO.getSearchWord() + "'%"
			    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
			    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.queryForInt(sql);
	}
	
}