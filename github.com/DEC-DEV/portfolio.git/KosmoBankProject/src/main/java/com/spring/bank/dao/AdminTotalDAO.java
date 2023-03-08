package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.TotalChartDTO;

public interface AdminTotalDAO {
	// chart1
	public TotalChartDTO productsignTotal();
	
	// 차트 2 예적금 신청 금액
	public List<TotalChartDTO> deposit_blanace(Map<String,String> map);
	public List<TotalChartDTO> saving_blanace(Map<String,String> map);
	
	// 차트3 대출 신청 상품 금액별 조회
	public  List<TotalChartDTO> loans_product_blanace();
	
	// 차트4 펀드 신청 상품별 후원금액 조회
	public  List<TotalChartDTO> fund_product_blanace();
	
	// 대출 상품 비율
	public List<TotalChartDTO> loansTotal();
	
	// 펀드 상품 비율
	public List<TotalChartDTO> fundTotal();
	
	// 대출 bar Chart Total
	public List<TotalChartDTO> loansbarChartTotal();
	
}
