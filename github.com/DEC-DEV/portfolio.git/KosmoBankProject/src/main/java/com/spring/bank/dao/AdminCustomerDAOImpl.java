package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.TransferDTO;
@Repository
public class AdminCustomerDAOImpl implements AdminCustomerDAO {
	@Autowired
	SqlSession sqlSession;
	
	// 회원 수 카운트
	@Override
	public int accountCnt() {
		System.out.println("DAO - accountCnt");
		int total = sqlSession.selectOne("com.spring.bank.dao.AdminCustomerDAO.accountCnt");
		return total;

	}
	
	// 회원 계좌 관리 목록
	@Override
	public List<AccountDTO> account_info(Map<String, Object> map) {
		List<AccountDTO> list = sqlSession.selectList("com.spring.bank.dao.AdminCustomerDAO.account_info", map);
		return list;

	}
	// 회원 계좌이체 내역 리스트 수
	@Override
	public int historyCnt() {
		System.out.println("DAO - historyCnt");
		int total = sqlSession.selectOne("com.spring.bank.dao.AdminCustomerDAO.historyCnt");
		return total;
	}

	// 회원 계좌이체 내역 리스트 목록
	@Override
	public List<TransferDTO> account_transfer_history(Map<String, Object> map) {
		System.out.println("DAO - account_transfer_history");
		List<TransferDTO> list = sqlSession.selectList("com.spring.bank.dao.AdminCustomerDAO.account_transfer_history", map);
		return list;
	}

	// 회원 계좌 비밀번호 변경
	@Override
	public int account_password_update(Map<String,Object> map) {
		System.out.println("DAO - account_password_update");
		int passwordCnt = sqlSession.update("com.spring.bank.dao.AdminCustomerDAO.account_password_update", map);
		System.out.println("passwordCnt : " + passwordCnt);
		return passwordCnt;
		
	}

	// 관리자 - 회원 계좌 상태 변경 
	@Override
	public int account_state(AccountDTO dto) {
		System.out.println("DAO - account_state");
		int stateCnt = sqlSession.update("com.spring.bank.dao.AdminCustomerDAO.account_state", dto);
		System.out.println("stateCnt : " + stateCnt);
		return stateCnt;
	}

	// 관리자 - 회원 한도변경 승인
	@Override
	public int account_limit_ok(AccountDTO dto) {
		System.out.println("DAO - account_limit_ok");
		int limitCnt = sqlSession.update("com.spring.bank.dao.AdminCustomerDAO.account_limit_ok", dto);
		System.out.println("limitCnt : " + limitCnt);
		return limitCnt;
	}

	
	 // 관리자 - 계좌 정보 검색
	 @Override 
	 public List<AccountDTO> account_search(Map<String, Object> map) {
		 System.out.println("DAO - account_search"); 
		 List<AccountDTO> list = sqlSession.selectList("com.spring.bank.dao.AdminCustomerDAO.account_search", map); 
		 return list; 
	 }
	 

//	//관리자 - 계좌이체 검색수 카운트
//	@Override
//	public int historySearchCnt(Map<String, Object> searchMap) {
//		System.out.println("DAO - historySearchCnt");
//		int total = sqlSession.selectOne("com.spring.bank.dao.AdminCustomerDAO.historySearchCnt", searchMap);
//		return total;
//	}
		
	// 관리자 - 계좌이체내역 검색
	@Override
	public List<TransferDTO> account_transfer_history_search(Map<String, Object> map) {
		System.out.println("DAO - account_transfer_history_search");
		List<TransferDTO> list = sqlSession.selectList("com.spring.bank.dao.AdminCustomerDAO.account_transfer_history_search" , map);
		return list;
	}

	
	
}
