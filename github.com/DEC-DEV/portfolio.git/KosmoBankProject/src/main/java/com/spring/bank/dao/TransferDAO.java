package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.Savings_itemDTO;
import com.spring.bank.dto.TransferDTO;
import com.spring.bank.dto.auto_transferDTO;

public interface TransferDAO {
	
	
	// 이체 전 정보불러오기
	public List<AccountDTO> call_account_transfer1(String id);
	
	// 이체 전 정보불러오기
	public AccountDTO call_account_transfer2(String account_num);
	
	// 계좌 이체 전 인증 
	public int account_transfer_ck(Map<String, Object> map); 
	
	// 계좌이체 처리 (발란스 불러오기)??
	public int account_transfer(String account_num); 
	
	// 계좌이체 처리 (보내는)
	public int account_transfer_send(Map<String, Object> map); 
	
	//입금되는자 잔액 불러오기??
	public int call_balance(String account_num2);
	
	// 계좌이체 처리 (받는)
	public int accoount_transfer_receive( Map<String, Object> map2);
	
	// 이체정보 저장 (보내는)
	public int t_send_saving( Map<String, Object> map3);
	
	// 이체정보 저장 (받는)
	public int t_receive_saving(TransferDTO dto2);
	
//----------------------------------------------------------------

	// 적금 납입전 정보불러오기 1
	public List<Savings_itemDTO> call_savings_transfer_1(String id);
	
	// 적금 납입전 정보불러오기 2
	public List<Savings_itemDTO> call_savings_transfer_2(String account_num);
	
	// 적금추가납입
	public int savings_add_paid(Map<String, Object> map);
	
	// 적금납입 정보 저장
	public int t_add_paid_saving(Map<String, Object> map);
	
//------------------------------------------------------------------------
	
	// 자동이체 계좌조회1
	public List<auto_transferDTO> auto_search_1(String id);
	
	//자동이체 정보조회2
	public List<auto_transferDTO> auto_search_2(String account_num);

//-------------------------------------	
	// 자동이체 해지
	public int auto_cancel(int jd_num );
	
//-------------------------------------------------
	// 한도 불러오기
	public String select_limit(String account_num);
	
	//sms
	public String select_phone(String id);
}
