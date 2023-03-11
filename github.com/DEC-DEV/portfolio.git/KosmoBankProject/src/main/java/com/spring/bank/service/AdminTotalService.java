package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.TotalChartDTO;

public interface AdminTotalService {
	
	// 李⑦듃1 �긽�뭹 媛��엯�옄 鍮꾩쑉
	public TotalChartDTO productsignTotal(HttpServletRequest req, Model model);
	
	// 李⑦듃 2 �삁�쟻湲� �떊泥� 湲덉븸
	public TotalChartDTO product_blanace(HttpServletRequest req, Model model);
	
	// 李⑦듃3 ��異� �떊泥� �긽�뭹 湲덉븸蹂� 議고쉶
	public TotalChartDTO loans_product_blanace(HttpServletRequest req, Model model);
	
	// 李⑦듃4 ���뱶 �떊泥� �긽�뭹蹂� �썑�썝湲덉븸 議고쉶
	public TotalChartDTO fund_product_blanace(HttpServletRequest req, Model model);
	
	// ��異� �긽�뭹 鍮꾩쑉
	public void loansTotal(HttpServletRequest req, Model model);
	
	// ���뱶 �긽�뭹 鍮꾩쑉
	public void fundTotal(HttpServletRequest req, Model model);
	
	// ��異� bar 李⑦듃
	public void loansbarChartTotal(HttpServletRequest req, Model model);
}
