package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.NoticeDTO;

public interface AdminCsCenterDAO {

	// 공지글 리스트 갯수
	public int notice_list_cnt();

	// 공지글 리스트 조회
	public List<NoticeDTO> notice_list_search(Map<String,Object> map);

	// 공지글 상세 조회
	public NoticeDTO notice_detail_search(int n_board_num);

	// 공지글 등록 처리
	public int notice_insert_action(NoticeDTO dto);

	// 공지글 수정 처리
	public int notice_update_action(NoticeDTO dto);

	// 공지글 삭제 처리
	public int notice_delete_action(int n_board_num);

}
