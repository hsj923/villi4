package com.lec.jdbc.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.jdbc.dao.CsDAO2;
import com.lec.jdbc.vo.CsVO2;

public class CsDetailService {
	
	public CsVO2 getCs(int cs_num) {
		
		CsVO2 csitem = null;
		Connection conn = JDBCUtility.getConnection();
		CsDAO2 csDAO2 = CsDAO2.getInstance();
		csDAO2.setConnection(conn);
		return csitem;
	}

}
