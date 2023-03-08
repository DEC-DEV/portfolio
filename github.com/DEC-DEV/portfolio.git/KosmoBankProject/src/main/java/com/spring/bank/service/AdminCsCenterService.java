package com.spring.bank.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminCsCenterService {

	// 상담글 리스트 조회
	public void counsel_list_search(HttpServletRequest req, Model model);

	// 상담글 상세 조회
	public void counsel_detail_search(HttpServletRequest req, Model model);

	// 상담글 상세 조회시 코멘트 조회
	public void counsel_coment_list_search(HttpServletRequest req, Model model);

	// 상당글 상세 조회시 코멘트 추가
	public void counsel_coment_add(HttpServletRequest req, Model model);

	// 상담글 삭제 처리
	public void counsel_delete_action(HttpServletRequest req, Model model);

	// 공지글 리스트 조회
	public void notice_list_search(HttpServletRequest req, Model model);

	// 공지글 상세 조회
	public void notice_detail_search(HttpServletRequest req, Model model);

	// 공지글 등록 처리
	public void notice_insert_action(HttpServletRequest req, Model model);

	// 공지글 수정/삭제 페이지
	public void notice_update(HttpServletRequest req, Model model);

	// 공지글 수정 처리
	public void notice_update_action(HttpServletRequest req, Model model);

	// 공지글 삭제 처리
	public void notice_delete_action(HttpServletRequest req, Model model);
}
