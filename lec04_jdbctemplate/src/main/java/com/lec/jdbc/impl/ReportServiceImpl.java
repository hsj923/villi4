package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.ReportDAO;
import com.lec.jdbc.service.ReportService;
import com.lec.jdbc.vo.ReportVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportDAO reportDAO;
	
//	public ReportServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public ReportVO getReport(ReportVO vo) {
		return reportDAO.getReport(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return reportDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<ReportVO> getReportList(SearchVO searchVO) {
		return reportDAO.getReportList(searchVO);
	}

	@Override
	public ReportVO insertReport(ReportVO report) {
		return reportDAO.insertReport(report);
	}
	
	@Override
	public int deleteReport(ReportVO report) {
		return reportDAO.deleteReport(report);
	}

	@Override
	public int updateReport(ReportVO report) {
		return reportDAO.updateReport(report);
	}

	
//	내가쓴글목록
	@Override
	public List<ReportVO> getMyReportList(String nickname) {
		return reportDAO.getMyReportList(nickname);
	}
	
}