package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface FundBoardService {
	// 펀드리스트 등록 처리
	public void fund_insert_action(HttpServletRequest req, Model model);

	// 펀드리스트 리스트 조회
	public void fund_list_search(HttpServletRequest req, Model model);

	// 펀드리스트 상세 조회
	public void fund_detail_search(HttpServletRequest req, Model model);

	// 펀드리스트 상세조회시 댓글 달기
	public void fund_coment_add(HttpServletRequest req, Model model);

	// 펀드리스트 상세조회시 댓글리스트 불러오기
	public void fund_coment_list_search(HttpServletRequest req, Model model);

	// 펀드리스트 수정/삭제시 비밀번호 체크
	public String fund_update_password_check(HttpServletRequest req, Model model);

	// 펀드리스트 수정/삭제 페이지
	public void fund_update(HttpServletRequest req, Model model);

	// 펀드리스트 수정 처리
	public void fund_update_action(HttpServletRequest req, Model model);

	// 펀드리스트 삭제 처리
	public void fund_delete_action(HttpServletRequest req, Model model);

}

