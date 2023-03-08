package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.TransferDTO;

public interface AccountDAO {
	
	/*
	 ACCOUNT_NUM	VARCHAR2(20 BYTE) - 임의 계좌번호 부여
	 ACCOUNT_PASSWORD	NUMBER(4,0) - 
	 A_NAME	VARCHAR2(20 BYTE)
	 ID	VARCHAR2(20 BYTE)
	 ACCOUNT_TYPE	VARCHAR2(20 BYTE)
	 BALANCE	VARCHAR2(20 BYTE)
	 NEW_DATE	TIMESTAMP(6)
	 SLEEP_DATE	TIMESTAMP(6)
	 ACCOUNT_STATE	VARCHAR2(2000 BYTE)
	 DELETE_DATE	TIMESTAMP(6)
	 ACCOUNT_LIMIT	NUMBER(20,0)
	 HISTORY	VARCHAR2(20 BYTE) 
	 */
	
	// 계좌 개설
	public int Account_add(AccountDTO dto );
	
	// 계좌 해지
	public int Account_delete(String account_num);
	
	// 내 모든 계좌 조회
	public List<AccountDTO> Account_All_selected(String id);
	
	// 내 계정 정보 조회 - ex) 이름, 아이디,회원정보 등
	public CustomerDTO my_select_info(String id);
	
	// 내 계좌 정보 조회
	public List<AccountDTO> my_account_All_info(String id);

	// 거래내역 조회 ( 최웅)
	public List<TransferDTO> my_trade_history(String account_num);
	
	// 계좌 1건에 대한 정보 조회
	public AccountDTO account_info_selected(String account_num);
	
	//계좌 비밀번호 조회
	public int account_pwd_chk(Map<String,String> map);
	
	// 계좌를 해지상태로 변경
	public int my_sleep_account(String account_num);
	
	// 입출금 계좌로 변경
	public int account_type_default(String account_num);
	
	// 최근 등록 계좌 정보 조회
	public String account_recent_select(String id);
	
	// 거래내역 조회( 기간별 )
	public List<TransferDTO> select_trade_history(Map<String,String> map);
	
	// 계좌 조회 타입 변경
	public List<AccountDTO> account_type_change(Map<String,String> map);
	
	// 계좌 상태값에 따라 변경
	public List<AccountDTO> account_selected_state(Map<String,String> map);
	
	// 계좌 정보 조회
	public List<AccountDTO> select_account_history(Map<String,String> map);
	// 보유 계좌 번호만 전체 조회
	public List<AccountDTO> my_account_all(String id);
	// 계좌별 거래내역 시간 조회
	public List<AccountDTO> transfer_time_select(String id);
	
	// 계좌 한도 변경 신청 
	public void account_limit_update(Map<String,Object> map);
	
	// 계좌 한도 변경 승인 후 상태값 변경
	public void account_limit_approve(String account_num);
	
	// 보유 계좌 정렬 [ 생성날짜, 거래내역 ]
	public List<AccountDTO> my_account_sorting_history(String id);
	public List<AccountDTO> my_account_sorting_newdate(String id);
	
	// 보유 계좌 정보 확인
	public AccountDTO android_accountInfo(String account_num);
	
}
