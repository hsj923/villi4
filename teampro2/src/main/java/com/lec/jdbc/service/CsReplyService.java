package com.lec.jdbc.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.jdbc.dao.CsDAO2;
import com.lec.jdbc.vo.CsVO2;

public class CsReplyService {

	public boolean replyCs(CsVO2 csitem) {
		
		boolean isReplySuccess = false;
		
		Connection conn = JDBCUtility.getConnection();
		CsDAO2 csDAO2 = CsDAO2.getInstance();
		csDAO2.setConnection(conn);
		int insertCount = csDAO2.insertCsitem(csitem);
		
		if(insertCount>0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isReplySuccess = true;
		} else {
			JDBCUtility.rollback(conn);
		}		
		return isReplySuccess;
		
	}
}
