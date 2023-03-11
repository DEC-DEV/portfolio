package com.spring.bank.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.AutoTransfer_ListDTO;
public interface AutotransferService {
	//캘린더 리스트 조회
	public List<AutoTransfer_ListDTO> get_Calender_List();
	//자동 이체 등록
	public void auto_add(HttpServletRequest req, Model model);
	//이체 내역
	public void auto_List();
	//고객 계좌 조회
	public void customer_Account_Search(HttpServletRequest req, Model model);
	
	
}
