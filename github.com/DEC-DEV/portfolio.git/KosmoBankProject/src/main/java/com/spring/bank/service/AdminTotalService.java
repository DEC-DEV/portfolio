package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.TotalChartDTO;

public interface AdminTotalService {
	
	// 차트1 상품 가입자 비율
	public TotalChartDTO productsignTotal(HttpServletRequest req, Model model);
	
	// 차트 2 예적금 신청 금액
	public TotalChartDTO product_blanace(HttpServletRequest req, Model model);
	
	// 차트3 대출 신청 상품 금액별 조회
	public TotalChartDTO loans_product_blanace(HttpServletRequest req, Model model);
	
	// 차트4 펀드 신청 상품별 후원금액 조회
	public TotalChartDTO fund_product_blanace(HttpServletRequest req, Model model);
	
	// 대출 상품 비율
	public void loansTotal(HttpServletRequest req, Model model);
	
	// 펀드 상품 비율
	public void fundTotal(HttpServletRequest req, Model model);
	
	// 대출 bar 차트
	public void loansbarChartTotal(HttpServletRequest req, Model model);
}
