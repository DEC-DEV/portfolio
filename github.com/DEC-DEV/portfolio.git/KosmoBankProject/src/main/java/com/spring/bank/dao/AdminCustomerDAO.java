package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.TransferDTO;

public interface AdminCustomerDAO {
	
	// 회원 수 카운트	
	public int accountCnt();
		
	// 회원 계좌 관리 목록	
	public List<AccountDTO> account_info(Map<String, Object> map);
	
	// 회원 계좌이체 내역 리스트 수
	public int historyCnt();
	
	// 회원 계좌이체 내역 리스트 목록
	public List<TransferDTO> account_transfer_history(Map<String, Object> map);
	
	// 회원 계좌 비밀번호 변경
	public int account_password_update(Map<String,Object> map);
	
	// 관리자 - 회원 계좌 상태 변경 
	public int account_state(AccountDTO dto);

	// 관리자 - 회원 한도변경 승인
	public int account_limit_ok(AccountDTO dto);
	
	
	// 관리자 - 계좌정보 검색
	public List<AccountDTO> account_search(Map<String, Object> map);
	 
	
//	//계좌이체 검색수 카운트
//	public int historySearchCnt(Map<String, Object> searchMap);
//	
	// 관리자 - 계좌이체내역 검색
	public List<TransferDTO> account_transfer_history_search(Map<String, Object> map);
	
	

}
