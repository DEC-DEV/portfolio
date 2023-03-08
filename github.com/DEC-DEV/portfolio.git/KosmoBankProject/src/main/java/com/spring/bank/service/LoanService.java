package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface LoanService {
	
	// 대출 원금 조회
	public void loan_principal_search(HttpServletRequest req, Model model);
	// 대출 원금 납부
	public void loan_principal_paid(HttpServletRequest req, Model model);
	// 대출 신규 신청
	public void loan_apply(HttpServletRequest req, Model model);
	// 대출 신규 신청 상환액 계산
	public void loan_apply_calculate(HttpServletRequest req, Model model);
	// 대출 신규 신청 비밀번호 확인
	public String loan_apply_password_check(HttpServletRequest req, Model model);
	// 대출 신규 신청 insert
	public void loan_apply_insert(HttpServletRequest req, Model model);
	// 대출 계좌 조회
	public void loan_account_search(HttpServletRequest req, Model model);
	// 대출 상품 리스트
	public void loan_pro_list(HttpServletRequest req, Model model);
	// 대출 상환 예정표
	public void loan_paid_plan(HttpServletRequest req, Model model);
	// 대출 상환 페이지
	public void loan_paid_detail(HttpServletRequest req, Model model);
	// 대출 상환
	public void loan_paid(HttpServletRequest req, Model model, HttpServletResponse res);
	// 대출 상환 내역 조회
	public void loan_paid_history(HttpServletRequest req, Model model);
	// 대출 해지
	public void loan_cancel(HttpServletRequest req, Model model);
	// 대출 해지 내역 조회
	public void loan_cancel_search(HttpServletRequest req, Model model);
}
