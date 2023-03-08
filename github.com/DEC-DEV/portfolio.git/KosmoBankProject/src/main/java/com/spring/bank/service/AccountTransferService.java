package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AccountTransferService {

	// 계좌이체 전 인증 처리
	public String account_transfer_check(HttpServletRequest req, Model model);
	
	// 이체 전 정보 불러오기 1-1
	public void call_account_transfer1(HttpServletRequest req, Model model);
	
	// 이체 전 정보 불러오기 1-2
	public void call_account_transfer2(HttpServletRequest req, Model model);
	
	// 계좌이체 처리 (-, +)
	public void account_transfer2(HttpServletRequest req, Model model);
	
	// 적금추가납입 전 정보불러오기 1-1
	public void call_add_paid_1(HttpServletRequest req, Model model);
	
	// 적금추가납입 전 정보불러오기 1-2
	public void call_add_paid_2(HttpServletRequest req, Model model);
	
	
	// 적급추가납입
	public void add_paid(HttpServletRequest req, Model model);
	
	// 자동이체 조회 1-1
	public void auto_search(HttpServletRequest req, Model model);
	
	// 자동이체조회 1-2
	public void auto_search_2(HttpServletRequest req, Model model);
	
	//자동이체 해지 
	public void auto_cancel(HttpServletRequest req, Model model);
	
	//한도 변경 신청 - 한도불러오기
	public void limit_call(HttpServletRequest req, Model model);
	
	//한도변경 신청 처리
	public void limit_apply(HttpServletRequest req, Model model);
	

}
