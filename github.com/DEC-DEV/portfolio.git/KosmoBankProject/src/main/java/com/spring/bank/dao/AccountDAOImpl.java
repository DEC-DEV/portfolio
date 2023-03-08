package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.TransferDTO;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	SqlSession SqlSession;

	// 계좌 개설
	@Override
	public int Account_add(AccountDTO dto ) {
		return SqlSession.getMapper(AccountDAO.class).Account_add(dto);
	}
	//계좌 해지
	@Override
	public int Account_delete(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).Account_delete(account_num);
	}
	// 계좌 정보 1건만 조회


	// 내 계좌 정보 조회
	@Override
	public List<AccountDTO> Account_All_selected(String id) {
		return SqlSession.getMapper(AccountDAO.class).Account_All_selected( id );
	}
	// 내 회원 정보 조회
	@Override
	public CustomerDTO my_select_info(String id) {
		return SqlSession.getMapper(AccountDAO.class).my_select_info(id);
	}
	// 내 계좌 전체 정보 조회
	@Override
	public List<AccountDTO> my_account_All_info(String id) {
		return SqlSession.getMapper(AccountDAO.class).my_account_All_info(id);
	}
	// 거래 내역 조회
	@Override
	public List<TransferDTO> my_trade_history(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).my_trade_history(account_num);
	}
	// 1건의 계좌 정보 조회
	@Override
	public AccountDTO account_info_selected(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).account_info_selected(account_num);
	}
	// 계좌 비밀번호 체크
	@Override
	public int account_pwd_chk(Map<String, String> map) {
		return SqlSession.getMapper(AccountDAO.class).account_pwd_chk(map);
	}
	// 해지 계좌 조회 (ajax)
	@Override
	public int my_sleep_account(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).my_sleep_account(account_num);
	}
	// 계좌  타입 확인 ( ajax) [ 해지,휴면, 정상 등 ]
	@Override
	public int account_type_default(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).account_type_default(account_num);
	}
	// 거래 내역 조회
	@Override
	public List<TransferDTO> select_trade_history(Map<String,String> map) {
		return SqlSession.getMapper(AccountDAO.class).select_trade_history(map);
	}
	// 계좌 타입 변경 (ajax) 거래내역 조회
	@Override
	public List<AccountDTO> account_type_change(Map<String, String> map) {
		return SqlSession.getMapper(AccountDAO.class).account_type_change(map);
	}
	//  계좌 해지상태 조회 [해지,정상 ] 거래 내역 조회 에서 확인 , 개설,해지 x
	@Override
	public List<AccountDTO> account_selected_state(Map<String, String> map) {
		System.out.println("map  id "+map.get("id"));
		System.out.println("map accont_type = ");
		return SqlSession.getMapper(AccountDAO.class).account_selected_state(map);
	}
	//  거래 내역 조회 개설 x
	@Override
	public List<AccountDTO> select_account_history(Map<String, String> map) {
		System.out.println("dao");
		return SqlSession.getMapper(AccountDAO.class).select_account_history(map);
	}
	// 나의 보유 계좌 조회
	@Override
	public List<AccountDTO> my_account_all(String id) {
		return SqlSession.getMapper(AccountDAO.class).my_account_all(id);
	}
	// 거래 내역 조회
	@Override
	public List<AccountDTO>  transfer_time_select(String id) {
		return SqlSession.getMapper(AccountDAO.class).transfer_time_select(id);
	}
	// 거래 내역 조회
	@Override
	public String account_recent_select(String id) {
		return SqlSession.getMapper(AccountDAO.class).account_recent_select(id);
	}

	@Override
	public void account_limit_update(Map<String, Object> map) {
		SqlSession.getMapper(AccountDAO.class).account_limit_update(map);
		
	}
	@Override
	public void account_limit_approve(String account_num) {
		SqlSession.getMapper(AccountDAO.class).account_limit_approve(account_num);
	}
	@Override
	public List<AccountDTO>my_account_sorting_history(String id) {
		// TODO Auto-generated method stub
		return SqlSession.getMapper(AccountDAO.class).my_account_sorting_history(id);
	}
	@Override
	public List<AccountDTO> my_account_sorting_newdate(String id) {
		return SqlSession.getMapper(AccountDAO.class).my_account_sorting_newdate(id);
	}
	@Override
	public AccountDTO android_accountInfo(String account_num) {
		return SqlSession.getMapper(AccountDAO.class).android_accountInfo(account_num);
	}
	

}
