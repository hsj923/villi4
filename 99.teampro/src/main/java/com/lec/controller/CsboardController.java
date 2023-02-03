package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.service.CsboardService;
import com.lec.jdbc.service.CsreplyService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsBoardVO;
import com.lec.jdbc.vo.CsReplyVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class CsboardController {

	@Autowired
	CsboardService csboardService;
	
	@Autowired
	CsreplyService csreplyService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getCsBoardList.do")
	public String getCsBoardList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(csboardService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<CsBoardVO> csboardList = csboardService.getCsBoardList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csboardList", csboardList);
		return "cs/getCsBoardList.jsp";
	}
	
	@RequestMapping("/insertCsBoard.do")
	public String insertCsBoard(CsBoardVO csboard) {		
		csboardService.insertCsBoard(csboard);
		return "getCsBoardList.jsp";
	}	
	
	@RequestMapping(value="/updateCsBoard.do", method=RequestMethod.GET)
	public String updateCsBoard(Model model, CsBoardVO csboard, SearchVO searchVO,int bno) {
		
		List<CsReplyVO> csreplyList = csreplyService.getCsReplyList(bno);
		//System.out.println(csreplyList.toString());
		model.addAttribute("csreplyList", csreplyList);
		
		csboardService.updateCsCount(csboard);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csboard", csboardService.getCsBoard(csboard));
		
		
		return "cs/updateCsBoard.jsp";
	}
	
	@RequestMapping(value="/updateCsBoard.do", method=RequestMethod.POST)
	public String updateCsBoard(CsBoardVO csboard) {
		csboardService.updateCsBoard(csboard);
		return "getCsBoardList.do";
	}	

	@RequestMapping(value="/deleteCsBoard.do", method=RequestMethod.GET)
	public String deleteCsBoard(Model model, CsBoardVO csboard, SearchVO searchVO, @RequestParam int bno) {
		csboard.setBno(bno);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("csboard", csboardService.getCsBoard(csboard));
		return "cs/deleteCsBoard.jsp";
	}
	
	@RequestMapping(value="/deleteCsBoard.do", method=RequestMethod.POST)
	public String deleteCsBoard(CsBoardVO csboard) {
		csboardService.deleteCsBoard(csboard);
		return "getCsBoardList.do";
	}	
	

	/*  파일 다운로드 구현
	 * @RequestMapping("/download.do") public String download(HttpServletRequest
	 * req, HttpServletResponse res) throws Exception {
	 * req.setCharacterEncoding("utf-8"); String fileName = req.getParameter("fn");
	 * 
	 * String fromPath = uploadFolder + fileName; String toPath = uploadFolder +
	 * fileName;
	 * 
	 * byte[] b = new byte[4096]; File f = new File(toPath); FileInputStream fis =
	 * new FileInputStream(fromPath);
	 * 
	 * String sMimeType =
	 * req.getSession().getServletContext().getMimeType(fromPath); // mimetype =
	 * file type : pdf, exe, txt.... if(sMimeType == null) sMimeType =
	 * "application/octet-stream";
	 * 
	 * String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1"); String
	 * sEncoding1 = URLEncoder.encode(fileName, "utf-8");
	 * 
	 * res.setContentType(sMimeType); res.setHeader("Content-Transfer-Encoding",
	 * "binary"); res.setHeader("Content-Disposition", "attachment; filename = " +
	 * sEncoding1);
	 * 
	 * int numRead; ServletOutputStream os = res.getOutputStream();
	 * 
	 * while((numRead=fis.read(b, 0, b.length)) != -1 ) { os.write(b, 0, numRead); }
	 * 
	 * os.flush(); os.close(); fis.close();
	 * 
	 * return "getBoardList.do"; }
	 */
}