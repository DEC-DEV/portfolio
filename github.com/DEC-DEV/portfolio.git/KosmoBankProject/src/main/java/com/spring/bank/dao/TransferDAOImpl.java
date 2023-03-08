package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.Savings_itemDTO;
import com.spring.bank.dto.TransferDTO;
import com.spring.bank.dto.auto_transferDTO;

@Repository
public class TransferDAOImpl implements TransferDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 이체 전 정보 불러오기 1-1( 화면에 뿌려주는 값들)
	@Override
	public List<AccountDTO> call_account_transfer1(String id) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.call_account_transfer1(id);
	}
	
	// 이체 전 정보 불러오기 1-2 ( 화면에 뿌려주는 값들)
	@Override
	public AccountDTO call_account_transfer2(String account_num) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.call_account_transfer2(account_num);
	}

	// 계좌이체 전 인증 
	@Override
	public int account_transfer_ck(Map<String, Object> map) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.account_transfer_ck(map);
	}

	// 계좌이체 처리 시 balance불러오기
	@Override
	public int account_transfer(String account_num) {
		
		/*
		 * int balance=0; 
		 * select balance from account_info where account_num=
		 * account_num;
		 */
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.account_transfer(account_num);
	}

	
	//  보내는(-)
	@Override
	public int account_transfer_send(Map<String, Object> map) {
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		return dao.account_transfer_send(map);
	}
	
		
	
	// 입금되는자 잔액 불러오기
	@Override
	public int call_balance(String account_num2) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.call_balance(account_num2);
	}
	
	// 받는(+)
	@Override
	public int accoount_transfer_receive( Map<String, Object> map2) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		System.out.println("dao 에 map2 : " +map2);
		return dao.accoount_transfer_receive(map2);
		
	}

	// 이체정보 저장 (보내는)
	@Override
	public int t_send_saving( Map<String, Object> map3) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.t_send_saving(map3);
	}

	// 이체정보 저장 (받는)
	@Override
	public int t_receive_saving(TransferDTO dto2) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.t_receive_saving(dto2);
	}



//-적금------------------------------------------------------------------	
	// 적금 납입전 정보 불러오기 1
	public List<Savings_itemDTO> call_savings_transfer_1(String id) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.call_savings_transfer_1(id);
		
	}
	
	// 적금 납입전 정보 불러오기 2
	public List<Savings_itemDTO> call_savings_transfer_2(String account_num) {
		
		return sqlSession.getMapper(TransferDAO.class).call_savings_transfer_2(account_num);
		
	}
	
	// 적금 추가 납입
	@Override
	public int savings_add_paid(Map<String, Object> map) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.savings_add_paid(map);
	}

	// 추가납입 정보 저장
	@Override
	public int t_add_paid_saving(Map<String, Object> map2) {
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.t_add_paid_saving(map2);
	}

	// 자동이체 조회  
	// 자동이체  전  로그인한 id의 모든 계좌번호 불러오기 
	@Override
	public List<auto_transferDTO> auto_search_1(String id) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.auto_search_1(id);
		
	}

	// 자동이체 조회  
	// 셀렉계좌의 자동이체 정보 불러오기
	@Override
	public List<auto_transferDTO> auto_search_2(String account_num) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.auto_search_2(account_num);
	}
	
	// 자동이체 해지 
	@Override
	public int auto_cancel(int jd_num) {
		
	 	TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.auto_cancel(jd_num);
	}

	// 한도불러오기 
	@Override
	public String select_limit(String account_num) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		
		return dao.select_limit(account_num);
	
	}
	// sms 폰번호 불러오기
	@Override
	public String select_phone(String id) {
		
		TransferDAO dao = sqlSession.getMapper(TransferDAO.class);
		return dao.select_phone(id);
	}
	

}
