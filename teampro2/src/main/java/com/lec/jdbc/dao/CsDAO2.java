package com.lec.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.db.JDBCUtility;
import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.mapper.CsRowMapper;
import com.lec.jdbc.mapper.CsRowMapper2;
import com.lec.jdbc.mapper.NoticeRowMapper;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.CsVO2;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;

@Repository
@PropertySource("classpath:config/cssql.properties")
public class CsDAO2 {
	
	private CsDAO2() {}
	private static CsDAO2 csDAO2;
	public static CsDAO2 getInstance() {
		if(csDAO2 == null) csDAO2 = new CsDAO2();
		return csDAO2;
		
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	//DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	@Autowired                    
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String get_pageinfo     = "";
	private String insert_cs     = "";
	private String update_cs     = "";
	private String delete_cs    = "";
	private String get_cs       = "";
	private String get_cs_list   = "";
	
	@PostConstruct
	public void getSqlPropeties() {
		get_pageinfo    = environment.getProperty("get_pageinfo");
		insert_cs     = environment.getProperty("insert_cs");
		update_cs     = environment.getProperty("update_cs");
		delete_cs 	 = environment.getProperty("delete_cs");
		get_cs 		 = environment.getProperty("get_cs");
		get_cs_list   = environment.getProperty("get_cs_list");
		
	}
	
	public List<CsVO2> getCsitemList(int currentPage, int perPage) {		
		Object[] args = {(currentPage-1)*perPage,  perPage };
		return jdbcTemplate.query(get_cs_list, args, new CsRowMapper2());		
	}
		
	public CsVO2 getCsitem(CsVO2 csitem) {
		try {
		Object[] args = { csitem.getCs_num() };
		return jdbcTemplate.queryForObject(get_cs, args, new CsRowMapper2());
		} catch (EmptyResultDataAccessException e){
			return null;
		}
	}

	public int insertCsitem(CsVO2 csitem) {
		return jdbcTemplate.update(insert_cs, csitem.getCs_num(), csitem.getCs_subject(), csitem.getCs_content());
	}
	
	public int updateCsitem(CsVO2 csitem) {
		return jdbcTemplate.update(update_cs, csitem.getCs_num());
	}

	public int deleteCsitem(CsVO2 csitem) {
		return jdbcTemplate.update(delete_cs, csitem.getCs_num());
	}
	
	// 댓글 쓰기 기능 구현 
	
	public int insertReplyCsitem(CsVO2 csitem) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "update csitem set cs_re_seq = cs_re_seq + 1" 
					+ " where cs_re_ref = ? and cs_re_seq > ?";
		
		int cs_num = 0;
		int re_ref = csitem.getCs_re_ref();
		int re_lev = csitem.getCs_re_lev();
		int re_seq = csitem.getCs_re_seq();
		
		try {
			pstmt = conn.prepareStatement("select max(cs_num) from csitem");
			rs = pstmt.executeQuery();
			if(rs.next()) cs_num = rs.getInt(1) + 1; else cs_num = 1;
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0) JDBCUtility.commit(conn);
			
		// 댓글 등록 하는 기능 구현
			
			re_lev += 1;
			re_seq += 1;
			sql = "insert into csitem(cs_num, cs_name, cs_pass, cs_subject, cs_content, "
				 +" 					 cs_file, cs_re_ref, cs_re_lev, cs_re_seq, cs_readcount, cs_date)"
				 +"				values(?,?,?,?,?,?,?,?,?,?, now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_num);
			pstmt.setString(2, csitem.getCs_name());
			pstmt.setString(3, csitem.getCs_pass());
			pstmt.setString(4, csitem.getCs_subject());
			pstmt.setString(5, csitem.getCs_content());
			pstmt.setString(6, "");
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("댓글 쓰기 실패!! : " + e.getMessage());
		} finally {
			JDBCUtility.close(null, pstmt, rs);
		}
		return insertCount;
		
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
	
/* --------------------------------------------------------------------------------------------------- */
	
	public List<CsVO2> getCsitemList(SearchVO searchVO) {
		sql = "select * from csitem where 1 = 1 "
		    + " and "      + searchVO.getSearchCategory() 
		    + " like '%"   + searchVO.getSearchWord() + "'%"
		    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
		    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.query(sql, new CsRowMapper2());
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
