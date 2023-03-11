package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.TotalChartDTO;

public interface AdminTotalDAO {
	// chart1
	public TotalChartDTO productsignTotal();
	
	// 李⑦듃 2 �삁�쟻湲� �떊泥� 湲덉븸
	public List<TotalChartDTO> deposit_blanace(Map<String,String> map);
	public List<TotalChartDTO> saving_blanace(Map<String,String> map);
	
	// 李⑦듃3 ��異� �떊泥� �긽�뭹 湲덉븸蹂� 議고쉶
	public  List<TotalChartDTO> loans_product_blanace();
	
	// 李⑦듃4 ���뱶 �떊泥� �긽�뭹蹂� �썑�썝湲덉븸 議고쉶
	public  List<TotalChartDTO> fund_product_blanace();
	
	// ��異� �긽�뭹 鍮꾩쑉
	public List<TotalChartDTO> loansTotal();
	
	// ���뱶 �긽�뭹 鍮꾩쑉
	public List<TotalChartDTO> fundTotal();
	
	// ��異� bar Chart Total
	public List<TotalChartDTO> loansbarChartTotal();
	
}
