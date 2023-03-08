package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminItemService {
	
	// --------------------- [ 대출 ] ----------------------------
	// 관리자 대출 상품 등록 - 현우
	public void loan_pro_add(HttpServletRequest req, Model model);
	
	// 관리자 대출 상품 조회
	public void loan_pro_list(HttpServletRequest req, Model model);
	
	// 관리자 대출 상품 상세페이지
	public void loan_pro_detail(HttpServletRequest req, Model model);
	
	// 관리자 대출 상품 수정
	public void loan_pro_update(HttpServletRequest req, Model model);
	
	// 관리자 대출 상품 삭제
	public void loan_pro_delete(HttpServletRequest req, Model model);
	
	
	// 관리자 대출 승인
	public void loan_approve(HttpServletRequest req, Model model);
		
	// 관리자 대출 거절
	public void loan_deny(HttpServletRequest req, Model model);
	
	// 관리자 대출 신청내역
	public void loan_pro_detail_list(HttpServletRequest req, Model model);
	
	// 관리자 대출 신청내역 상세페이지
	public void loan_detail_list(HttpServletRequest req, Model model);
		
	// 관리자 대출 신청내역 수정
	public void loan_update_detail_list(HttpServletRequest req, Model model);
	
	// 관리자 대출 신청내역 삭제
	public void loan_delete_detail_list(HttpServletRequest req, Model model);	
	
}
