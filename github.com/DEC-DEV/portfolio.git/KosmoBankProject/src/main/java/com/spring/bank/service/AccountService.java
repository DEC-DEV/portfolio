package com.spring.bank.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.TransferDTO;

@Service
public interface AccountService {
	
	// 내 보유 계좌 조회 (select)
	public void my_account(HttpServletRequest req, Model model);
	
	// 내 거래 내역 계좌 조회 (select)
	public String my_trade_history(HttpServletRequest req, Model model); 
	
	// 내 해지 계좌 조회(select)
	public String my_cancel_account(HttpServletRequest req, Model model);

	// 내 계정 정보 조회
	public CustomerDTO my_select_info(HttpServletRequest req, Model model);
	
	// 계좌 등록
	public Map<String,Object> account_add(HttpServletRequest req, Model model);
	
	// 계좌 타입 변경 조회
	public List<AccountDTO> account_type_change(HttpServletRequest req, Model model);
	
	// 계좌 해지 페이지로 이동
	public void account_info_cancel(HttpServletRequest req, Model model);
	
	// 계좌 1건에 대한 정보 조회
	public AccountDTO account_selected_info(HttpServletRequest req, Model model);
	
	// 계좌 비밀번호 체크
	public int account_pwd_chk(HttpServletRequest req, Model model);
	
	// 계좌 해지로 상태 변경
	public int my_sleep_account(HttpServletRequest req, Model model);
	
	// 입출금 계좌로 변경
	public int account_type_default(HttpServletRequest req, Model model);
	// 거래내역 조회 ( 기간 )
	public List<TransferDTO> select_trade_history(HttpServletRequest req, Model model);
	//
	public List<AccountDTO> select_account_history(HttpServletRequest req, Model model);
	
	// 보유 계좌 정렬 [ 생성날짜, 거래내역 ]
	public List<AccountDTO> my_account_sorting(HttpServletRequest req, Model model);
	
}
