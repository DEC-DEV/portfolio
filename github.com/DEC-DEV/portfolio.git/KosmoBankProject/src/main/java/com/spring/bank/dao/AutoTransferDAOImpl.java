package com.spring.bank.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.AutoTransferDTO;
import com.spring.bank.dto.AutoTransfer_ListDTO;

//LJH, 2022-04-21
@Repository
public class AutoTransferDAOImpl implements AutoTransferDAO{

	@Autowired
	SqlSession sqlSession;
	// 캘린더 자동 이체 내역 조회
	@Override
	public List<AutoTransfer_ListDTO> calenderList() {
		System.out.println(" [ DAO - calenderList ] ");
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		
		List<AutoTransfer_ListDTO> list = dao.calenderList();
		
		return list;
	}
	// 자동 이체 등록
	@Override
	public int auto_Transfer_add(AutoTransferDTO dto) {
		System.out.println(" [ DAO - auto_Transfer_add ] ");
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		
		int insertCnt = dao.auto_Transfer_add(dto);
		
		return insertCnt;
	}
	// 날짜 확인하여 업데이트
	@Override
	public List<AutoTransferDTO> auto_List(int iday) {
		System.out.println(" [ DAO - auto_List ] ");
	
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		
		List<AutoTransferDTO> list = dao.auto_List(iday);
		
		return list;
	}
	// 계좌 금액 입력 - 증가
	@Override
	public int auto_increament(Map<String, Object> map) {
		System.out.println(" [ DAO - auto_increament ] ");
		
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		int insert = dao.auto_increament(map);
		
		return insert; 
	}
	// 계좌 금액 입력 - 감소
	@Override
	public int auto_decreament(Map<String, Object> map) {
		System.out.println(" [ DAO - auto_decreament ] ");
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		
		int decre = dao.auto_decreament(map);
		
		return decre;
		
	}
	// 계좌 금액 입력 - 확인
	@Override
	public int auto_history() {
		System.out.println(" [ DAO - auto_history ] ");
		AutoTransferDAO dao =	sqlSession.getMapper(AutoTransferDAO.class);
		
		int history = dao.auto_history();
		
		return history;
	}
	// 고객 계좌 조회
	@Override
	public List<AccountDTO> customer_Account_Search(String id) {
		System.out.println(" [ DAO - customer_Account_Search ] ");
		
		AutoTransferDAO dao = sqlSession.getMapper(AutoTransferDAO.class);
		
		return dao.customer_Account_Search(id);
	}
	
}
