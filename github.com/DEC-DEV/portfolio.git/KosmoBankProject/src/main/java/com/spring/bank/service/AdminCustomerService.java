package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminCustomerService {
	// 회원별 계좌 관리
	public void account_info(HttpServletRequest req, Model model);
	
	// 관리자 - 회원 계좌 비밀번호 변경처리
	public void account_password_update(HttpServletRequest req, Model model);
	
	// 관리자 - 회원 계좌이체 내역 리스트
	public void account_transfer_history(HttpServletRequest req, Model model);
	
	// 관리자 - 회원 계좌 상태 변경 
	public void account_state(HttpServletRequest req, Model model);
	
	// 관리자 - 회원 한도변경 승인
	public void account_limit_ok(HttpServletRequest req, Model model);
	
	// 환율 정보
	public void exchange_detail(HttpServletRequest req, Model model);
	
	// 계좌 정보 검색
	public void account_search(HttpServletRequest req, Model model);
	
	// 계좌이체 검색
	public void account_transfer_history_search(HttpServletRequest req, Model model);
	
}
