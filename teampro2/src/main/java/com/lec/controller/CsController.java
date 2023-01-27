/*package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.service.CsService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsVO;
import com.lec.jdbc.vo.PageInfo;

@Controller
public class CsController {
	
	@Autowired
	private CsService csService;
		
	@Value("#cssql['selectById']") private String selectById;	
	@Value("#cssql['selectCsList']") private String selectCsList;	
	
	@RequestMapping("getCsList.do") 
	public String getCsList(CsVO csVO, Model model,
			@RequestParam(defaultValue="1") int p,
			@RequestParam(defaultValue="10") int perPage) {
		PageInfo pageInfo = csService.getPageInfo(p, perPage);				
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("csList", csService.getCsitemList(p, perPage));	
		return "cs/cs_list.jsp";
	} 
	
	@RequestMapping("/getCs.do")
	public String getCs(CsVO cs, Model model) {	
		model.addAttribute("cs", csService.getCsitem(cs)); 
		return "cs/cs_detail.jsp"; 
	}	
	
	@RequestMapping("insertCs.do")
	public String insertCsitem(CsVO cs) throws IOException {
		csService.insertCsitem(cs);
		return "redirect:/getCsList.do";
	}
	
	
//	@RequestMapping("getCsDetail.do")
//	public String detailCs(CsVO cs) {
//		csService.detailCs(cs);
//		return "getCsList.do";
//	}
	
	@RequestMapping("/deleteCs.do")
	public String deleteCsitem(CsVO cs) {
		csService.deleteCsitem(cs);
		return "getCsList.do";	
	}
	
	@RequestMapping("/updateCs.do")
	public String updateCsitem(CsVO cs) { 
		csService.updateCsitem(cs);
		return "getCsList.do";
	}
	
	@RequestMapping("/downloadCs.do")
	public String download(HttpServletRequest req, HttpServletResponse res) throws Exception { 	
		req.setCharacterEncoding("utf-8");
		String cs_filename = req.getParameter("fn");
		
		String fromPath = "d:/lec03/99.temp/upload/" + cs_filename;
		String toPath = "d:/lec03/99.temp/download/" + cs_filename;
	
		byte[] b = new byte[4096];
		File f = new File(toPath);
		FileInputStream fis = new FileInputStream(fromPath);
		
		String sMimeType = req.getSession().getServletContext().getMimeType(fromPath); // mimetype = file type : pdf, exe, txt.... 
		if(sMimeType == null) sMimeType = "application/octet-stream";
		
		String sEncoding = new String(cs_filename.getBytes("utf-8"), "8859_1");
		String sEncoding1 = URLEncoder.encode(cs_filename, "utf-8");
		
		res.setContentType(sMimeType);
		res.setHeader("Content-Transfer-Encoding", "binary");
		res.setHeader("Content-Disposition", "attachment; filename = " + sEncoding1);
			
		int numRead;
		ServletOutputStream os = res.getOutputStream();
	
		while((numRead=fis.read(b, 0, b.length)) != -1 ) {
			os.write(b, 0, numRead);
		}
		
		os.flush();
		os.close();
		fis.close();
		
		return "getCsList.do";
	}			
}

*/