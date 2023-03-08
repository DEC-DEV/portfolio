package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.FundDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_itemDTO;

//-------------------[ 대출 ]-----------------------
	public interface AdminItemDAO {
		
		// 관리자 대출 상품 등록
		public int loan_pro_add(Loans_itemDTO dto);
		
		// 관리자 대출 상품 목록
		public List<Loans_itemDTO> loan_pro_list(Map<String, Object> map);
		
		// 상품 갯수
		public int loan_cnt();
		
		// 관리자 대출 상품 상세페이지
		public Loans_itemDTO loan_pro_detail(String d_name);
		
		// 관리자 대출 상품 수정
		 public int loan_pro_update(Loans_itemDTO dto);
		
		// 관리자 대출 상품 삭제
		 public int loan_pro_delete(String d_name);
		 
		 
		// 관리자 대출 신청자상세 목록
		public List<LoansDTO> loan_pro_detail_list(Map<String, Object> map);
		
		// 관리자 대출 신청자 상세페이지
		public LoansDTO loan_detail(int d_num);
		
		// 관리자 대출 승인
		public int loan_approve(Map<String, Object> map);
		
		// 괸리자 대출 거절
		public int loan_delete(Map<String, Object> map);
		
		// 관리자 대출 신청자 수정처리
		 public int loan_update_action(LoansDTO dto);
		
		// 관리자 대출 신청자 삭제처리
		 public int loan_delete_action(int d_num);
}
