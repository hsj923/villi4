package com.lec.jdbc.common;

import java.io.Serializable;

public class PagingVO implements Serializable {
	
	//?ž…? ¥ë°›ëŠ” ?°?´?„°
	private int curPage = 1;           // ?˜„?ž¬ ?Ž˜?´ì§? ë²ˆí˜¸
	private int rowSizePerPage = 10;   // ?•œ ?Ž˜?´ì§??‹¹ ? ˆì½”ë“œ ?ˆ˜      ê¸°ë³¸10
	private int pageSize = 10;         // ?Ž˜?´ì§? ë¦¬ìŠ¤?Š¸?—?„œ ë³´ì—¬ì¤? ?Ž˜?´ì§? ê°??ˆ˜  ?´ê±°ëŠ” ë³´í†µ 10 or 5 ?•ˆ ë³??•¨ 
	private int totalRowCount;        // ì´? ? ˆì½”ë“œ ê±´ìˆ˜
	
	//?ž…? ¥ë°›ëŠ” ?°?´?„°ë¥? ?†µ?•´ ê³„ì‚°?˜?Š” ê°?
	private int firstRow ;           // ?‹œ?ž‘ ? ˆ?¬?“œ ë²ˆí˜¸   
	private int lastRow;             // ë§ˆì?ë§? ? ˆ?¬?“œ ë²ˆí˜¸ 
	private int totalPageCount;      // ì´? ?Ž˜?´ì§? ê±´ìˆ˜
	private int firstPage; 	         // ?Ž˜?´ì§? ë¦¬ìŠ¤?Š¸?—?„œ ?‹œ?ž‘  ?Ž˜?´ì§? ë²ˆí˜¸ 
	private int lastPage;            // ?Ž˜?´ì§? ë¦¬ìŠ¤?Š¸?—?„œ ë§ˆì?ë§? ?Ž˜?´ì§? ë²ˆí˜¸ 
	
	//pageê³„ì‚°
	public void pageSetting() {
		
		totalPageCount=(totalRowCount-1)/rowSizePerPage+1;  
		
		firstRow=(curPage-1)*rowSizePerPage+0;  
		lastRow=firstRow+rowSizePerPage-1;    
		if(lastRow>totalRowCount) lastRow=totalRowCount;
		
		firstPage=(curPage-1)/pageSize*pageSize+1;
		lastPage=firstPage+pageSize-1;
		if(lastPage>totalPageCount) lastPage=totalPageCount;		
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowSizePerPage() {
		return rowSizePerPage;
	}

	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
}