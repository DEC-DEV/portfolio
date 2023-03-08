package com.spring.bank.util;

public class Paging {
	
	private int pageSize = 10;  // 화면에 보여질 게시글의 갯수를 지정
	private int count = 0; 		// 전체 글의 갯수를 저장하는 변수
	private int number = 0;		// 페이지 번호
	private String pageNum;
	
	private int startRow;		// 페이지당 시작 페이지 번호
	private int endRow;			// 페이지당 끝 페이지 번호
	
	private int currentPage; 	// 현재 페이지
	private int pageCount;		// 
	private int startPage;		// 시작 페이지
	private int pageBlock;
	private int endPage;
	
	private int prev; 			// 이전
	private int next;			// 다음
	
	/*
			1	2	3	4	5	6	7 [ 다음 ]
		[ 이전 ] 11 ~~~~~~~~~~~~~~~~~~~~~ 20 [ 다음 ]
		1 : 1~10
		2 : 11~20
		3 : 
	 */
	public Paging() {}
	public Paging(String pageNum) {
		// 맨 처음 boardList.jsp를 시작하거나, 수정 삭제 등 다른 게시글에서
		// 페이지로 넘어올 때 pageNum이 없는 경우 null 처리
		if(pageNum == null) {
			pageNum = "1";
		}
		this.pageNum = pageNum;

		// 현재 페이지로 지정
		currentPage = Integer.parseInt(pageNum);
	}	
	// 전체 게시글 건수를 가지고 옴
	public void setTotalCount(int count) {
		this.count = count;
		System.out.println("현재페이지 : "+currentPage);
		startRow = ( currentPage -1 ) * pageSize +1;
		System.out.println(startRow);
		endRow = currentPage * pageSize;
		this.number = count -( currentPage -1 ) * pageSize;
		
		System.out.println("현재 페이지 : "+currentPage);
		// 페이지 계산
		pageCalculator();
	}
	public void pageCalculator() {
		if(count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			System.out.println("PageCount : "+pageCount);
			startPage = 1;
			
			if(currentPage % 10 != 0) {
				startPage = (int)( currentPage / 10 ) * 10 +1;
			}else {
				endPage = ( (int)(currentPage / 10)-1 ) * 10 + 1; 
			}
			System.out.println("startPage : "+startPage);
			System.out.println("endPage : "+endPage);
			
			pageBlock = 10;
			endPage = startPage + pageBlock -1;
			
			System.out.println(" startPage : "+startPage);
			System.out.println("endPage : "+endPage);
			
			if(endPage > pageCount) endPage = pageCount;
			System.out.println("pageCount = "+pageCount);
			System.out.println("endPage : "+endPage);
			
			// 이전
			if( startPage > pageSize) prev = startPage - 10;
			// 다음
			if( endPage < pageCount) next = startPage + 10;
			System.out.println("prev : "+prev);
			System.out.println("next : "+next);
		}
	}
	
	// getter setter
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
}