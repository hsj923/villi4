package com.lec.jdbc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.jdbc.service.CsReplyService;
import com.lec.jdbc.vo.ActionFoward;
import com.lec.jdbc.vo.CsVO2;

public class CsReplyAction implements Action {

	@Override
	public ActionFoward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionFoward forward = null;
		CsVO2 csitem = new CsVO2();
		
		String p = req.getParameter("p");
		csitem.setCs_num(Integer.parseInt(req.getParameter("p")));
		csitem.setCs_name(req.getParameter("cs_name"));
		csitem.setCs_pass(req.getParameter("cs_pass"));
		csitem.setCs_subject(req.getParameter("cs_subject"));
		csitem.setCs_content(req.getParameter("cs_content"));
		csitem.setCs_re_ref(Integer.parseInt(req.getParameter("cs_re_ref")));
		csitem.setCs_re_lev(Integer.parseInt(req.getParameter("cs_re_lev")));
		csitem.setCs_re_seq(Integer.parseInt(req.getParameter("cs_re_seq")));
		
		CsReplyService csReplyService = new CsReplyService();
		boolean isReplySuccess = csReplyService.replyCs(csitem);
		
		if(isReplySuccess) {
			forward = new ActionFoward();
			forward.setRedirect(true);
			forward.setPath("csList.do?p=" + p);
		} else {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("	alert('댓글 쓰기에 실패했습니다!')");
			out.println("	history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
