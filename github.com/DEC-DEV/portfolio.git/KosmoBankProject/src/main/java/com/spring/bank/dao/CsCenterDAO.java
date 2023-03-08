package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.CounselCommentDTO;
import com.spring.bank.dto.CounselDTO;
import com.spring.bank.dto.NoticeDTO;

public interface CsCenterDAO {

	// 상담글 등록 처리
	public int counsel_insert_action(CounselDTO dto);

	// 상담글 상세조회시 댓글달기
	public int counsel_coment_add(CounselCommentDTO dto);

	// 상담글 상세조회시 댓글리스트 불러오기
	public List<CounselCommentDTO> counsel_coment_list_search(int b_num);

	// 상담글 수정/삭제시 비밀번호 체크
	public String counsel_update_password_check(Map<String, Object> map);

	// 상담글 수정 처리
	public int counsel_update_action(CounselDTO dto);

	// 상담글 삭제 처리
	public int counsel_delete_action(int b_num);

	// 상담글 리스트 갯수
	public int counsel_list_cnt();

	// 상담글 리스트 조회
	public List<CounselDTO> counsel_list_search(Map<String,Object> map);

	// 상담글 상세 조회
	public CounselDTO counsel_detail_search(int b_num);

	// 공지글 리스트 갯수
	public int notice_list_cnt();

	// 공지글 리스트 조회
	public List<NoticeDTO> notice_list_search(Map<String,Object> map);

	// 공지글 상세 조회
	public NoticeDTO notice_detail_search(int n_board_num);

	// 공지글 상세 조회시 조회수 증가
	public int notice_detail_view_add(int n_board_num);

}
