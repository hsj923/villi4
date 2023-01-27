package com.lec.jdbc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.jdbc.service.CsDetailService;
import com.lec.jdbc.vo.ActionFoward;
import com.lec.jdbc.vo.CsVO2;

public class CsReplyFormAction implements Action {

	@Override
	public ActionFoward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionFoward forward = new ActionFoward();
		
		int cs_num = Integer.parseInt(req.getParameter("cs_num"));
		String p = req.getParameter("p");
		
		CsDetailService csDetailService = new CsDetailService();
		CsVO2 csitem = csDetailService.getCs(cs_num);
		req.setAttribute("p", p);
		req.setAttribute("csitem", csitem);
		forward.setPath("/cs/cs_reply.jsp");
		return forward;
	}

	 
}
