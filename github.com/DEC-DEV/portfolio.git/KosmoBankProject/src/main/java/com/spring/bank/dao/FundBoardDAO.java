package com.spring.bank.dao;

import java.util.List;
import java.util.Map;


import com.spring.bank.dto.CounselCommentDTO;
import com.spring.bank.dto.CounselDTO;
import com.spring.bank.dto.Fund_boardDTO;
import com.spring.bank.dto.Fund_board_commentDTO;
import com.spring.bank.dto.NoticeDTO;

public interface FundBoardDAO {

	// 펀드리스트 등록 처리
	public int fund_insert_action(Fund_boardDTO dto);

	 // 펀드리스트 상세조회시 댓글달기
	public int fund_coment_add(Fund_board_commentDTO dto);
	
	 // 펀드리스트 상세조회시 댓글리스트 불러오기
	public List<Fund_board_commentDTO>fund_coment_list_search(int f_num);

	// 펀드리스트 수정/삭제시 비밀번호 체크
	public String fund_update_password_check(Map<String, Object> map);

	// 펀드리스트 수정 처리
	public int fund_update_action(Fund_boardDTO dto);

	// 펀드리스트 삭제 처리
	public int fund_delete_action(int f_num);

	// 펀드리스트 리스트 갯수
	public int fund_list_cnt();

	// 펀드리스트 리스트 조회
	public List<Fund_boardDTO> fund_list_search(Map<String,Object> map);

	// 펀드리스트 상세 조회
	public Fund_boardDTO fund_detail_search(int f_num);



}

