package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.AutoTransferDTO;
import com.spring.bank.dto.AutoTransfer_ListDTO;

public interface AutoTransferDAO {
	// 자동 이체 내역 조회
	public List<AutoTransfer_ListDTO> calenderList();
	// 자동 이체 등록
	public int auto_Transfer_add(AutoTransferDTO dto);
	// 자동 입금
	public List<AutoTransferDTO> auto_List(int iday);
	// 자동 증가
	public int auto_increament(Map<String, Object> map);
	// 자동 감소
	public int auto_decreament(Map<String, Object> map);
	// 이력 입력
	public int auto_history();
	// 고객 계좌 조회
	public List<AccountDTO> customer_Account_Search(String id);
	
	
	
}
