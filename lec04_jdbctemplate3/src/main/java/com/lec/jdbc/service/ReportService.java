package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.ReportVO;

public interface ReportService {

	ReportVO getReport(ReportVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<ReportVO> getReportList(SearchVO searchVO);
	ReportVO insertReport(ReportVO report);
	int deleteReport(ReportVO report);
	int updateReport(ReportVO report);
	
//	�Ű�����ƮȮ��
	List<ReportVO> getMyReportList(String nickname);
}