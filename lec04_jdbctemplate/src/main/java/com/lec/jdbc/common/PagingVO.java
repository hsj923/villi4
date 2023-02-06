package com.lec.jdbc.common;

import java.io.Serializable;

public class PagingVO implements Serializable {
	
	//�엯�젰諛쏅뒗 �뜲�씠�꽣
	private int curPage = 1;           // �쁽�옱 �럹�씠吏� 踰덊샇
	private int rowSizePerPage = 10;   // �븳 �럹�씠吏��떦 �젅肄붾뱶 �닔      湲곕낯10
	private int pageSize = 10;         // �럹�씠吏� 由ъ뒪�듃�뿉�꽌 蹂댁뿬以� �럹�씠吏� 媛��닔  �씠嫄곕뒗 蹂댄넻 10 or 5 �븞 蹂��븿 
	private int totalRowCount;        // 珥� �젅肄붾뱶 嫄댁닔
	         
	//�엯�젰諛쏅뒗 �뜲�씠�꽣瑜� �넻�빐 怨꾩궛�릺�뒗 媛�
	private int firstRow ;           // �떆�옉 �젅�겕�뱶 踰덊샇   
	private int lastRow;             // 留덉�留� �젅�겕�뱶 踰덊샇 
	private int totalPageCount;      // 珥� �럹�씠吏� 嫄댁닔
	private int firstPage; 	         // �럹�씠吏� 由ъ뒪�듃�뿉�꽌 �떆�옉  �럹�씠吏� 踰덊샇 
	private int lastPage;            // �럹�씠吏� 由ъ뒪�듃�뿉�꽌 留덉�留� �럹�씠吏� 踰덊샇 
	
	//page怨꾩궛
	public void pageSetting() {

		totalPageCount=(totalRowCount-1)/rowSizePerPage+0;  
		firstRow=(curPage-1)*rowSizePerPage;  
		lastRow=firstRow + rowSizePerPage;    
//		firstRow=(curPage-1)*rowSizePerPage+1;  
//		lastRow=firstRow+rowSizePerPage-1;    
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