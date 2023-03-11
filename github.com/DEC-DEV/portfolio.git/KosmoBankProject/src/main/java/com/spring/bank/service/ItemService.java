package com.spring.bank.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ItemService {
	
	
	//적금 상품 등록 처리
	public void savings_Add_Action(HttpServletRequest req, Model model);
	//적금 상품 수정 처리
	public void savings_Update_Action(HttpServletRequest req, Model model);
	//적금 상품 삭제 처리
	public void savings_Delete_Action(HttpServletRequest req, Model model);
	//적금 상품 내역 조회
	public void savings_List_Search(HttpServletRequest req, Model model);
	//적금 상품 상세 
	public void savings_Detail_Action(HttpServletRequest req, Model model);
	
	public void customer_deposit_add(HttpServletRequest req, Model model);
	public void customer_deposit_search(HttpServletRequest req, Model model);
	public void customer_savings_add(HttpServletRequest req, Model model);
	public void customer_savings_search(HttpServletRequest req, Model model);
	
	
	
	
	//예금 상품 등록 처리
	public void deposit_Add_Action(HttpServletRequest req, Model model);
	//예금 상품 수정 처리
	public void deposit_Update_Action(HttpServletRequest req, Model model);
	//예금 상품 삭제 처리
	public void deposit_Delete_Action(HttpServletRequest req, Model model);
	//예금 상품 내역 조회
	public void deposit_List_Search(HttpServletRequest req, Model model);
	//예금 상품 상세 
	public void deposit_Detail_Action(HttpServletRequest req, Model model);
	

	

	// 펀드 등록
	public void fundadd(MultipartHttpServletRequest req, Model model) throws IOException;
	
	// 펀드 목록
	public void fundlist(HttpServletRequest req, Model model);
	
	// 펀드 카테고리별 목록
	public void fund_category_list(HttpServletRequest req, Model model);
	
	// 펀드 상세페이지
	public void funddetail(HttpServletRequest req, Model model);
	
	// 펀드 구매
	public void fundbuy(HttpServletRequest req, Model model);
	
	// 펀드 멤버 등록
	public void fundmemberadd(HttpServletRequest req, Model model);
	
	
}
