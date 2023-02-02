package com.lec.jdbc.common;

import java.io.Serializable;

public class PagingVO implements Serializable {
	
	//?��?��받는 ?��?��?��
	private int curPage = 1;           // ?��?�� ?��?���? 번호
	private int rowSizePerPage = 10;   // ?�� ?��?���??�� ?��코드 ?��      기본10
	private int pageSize = 10;         // ?��?���? 리스?��?��?�� 보여�? ?��?���? �??��  ?��거는 보통 10 or 5 ?�� �??�� 
	private int totalRowCount;        // �? ?��코드 건수
	
	//?��?��받는 ?��?��?���? ?��?�� 계산?��?�� �?
	private int firstRow ;           // ?��?�� ?��?��?�� 번호   
	private int lastRow;             // 마�?�? ?��?��?�� 번호 
	private int totalPageCount;      // �? ?��?���? 건수
	private int firstPage; 	         // ?��?���? 리스?��?��?�� ?��?��  ?��?���? 번호 
	private int lastPage;            // ?��?���? 리스?��?��?�� 마�?�? ?��?���? 번호 
	
	//page계산
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