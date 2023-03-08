package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AdminFundService {

	// 펀드목록
	public void fund_list(HttpServletRequest req, Model model);
	
	// 펀드 승인
	public void fund_approve(HttpServletRequest req, Model model);
	
	// 펀드 거절
	public void fund_delete(HttpServletRequest req, Model model);
	
	// 펀드 상세페이지
	public void fund_detail(HttpServletRequest req, Model model);
	
	// 펀드 수정처리
	public void fund_update_action(MultipartHttpServletRequest req, Model model);
	
	// 펀드 삭제처리
	public void fund_delete_action(HttpServletRequest req, Model model);
}
