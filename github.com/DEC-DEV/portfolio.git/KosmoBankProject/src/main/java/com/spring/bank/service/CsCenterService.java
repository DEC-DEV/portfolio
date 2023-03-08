package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CsCenterService {


	// 상담글 등록 처리
	public void counsel_insert_action(HttpServletRequest req, Model model);

	// 상담글 리스트 조회
	public void counsel_list_search(HttpServletRequest req, Model model);

	// 상담글 상세 조회
	public void counsel_detail_search(HttpServletRequest req, Model model);

	// 상담글 상세조회시 댓글 달기
	public void counsel_coment_add(HttpServletRequest req, Model model);

	// 상담글 상세조회시 댓글리스트 불러오기
	public void counsel_coment_list_search(HttpServletRequest req, Model model);

	// 상담글 수정/삭제시 비밀번호 체크
	public String counsel_update_password_check(HttpServletRequest req, Model model);

	// 상담글 수정/삭제 페이지
	public void counsel_update(HttpServletRequest req, Model model);

	// 상담글 수정 처리
	public void counsel_update_action(HttpServletRequest req, Model model);

	// 상담글 삭제 처리
	public void counsel_delete_action(HttpServletRequest req, Model model);

	// 공지글 리스트 조회
	public void notice_list_search(HttpServletRequest req, Model model);

	// 공지글 상세 조회
	public void notice_detail_search(HttpServletRequest req, Model model);

	// 공지글 상세 조회시 조회수 증가
	public void notice_detail_view_add(HttpServletRequest req, Model model);
}
