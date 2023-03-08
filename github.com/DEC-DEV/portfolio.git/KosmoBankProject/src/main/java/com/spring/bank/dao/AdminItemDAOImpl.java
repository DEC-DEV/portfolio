package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_itemDTO;

@Repository
public class AdminItemDAOImpl implements AdminItemDAO{
	
	@Autowired
	SqlSession sqlSession;

	// ------------------------- [ 대출 ] --------------------------------
	// 관리자 상품 등록
	@Override
	public int loan_pro_add(Loans_itemDTO dto) {
		System.out.println("AdminItemDAOImpl - loan_pro_add");
		
		return sqlSession.getMapper(AdminItemDAO.class).loan_pro_add(dto);
	}

	// 관리자 상품 목록
	@Override
	public List<Loans_itemDTO> loan_pro_list(Map<String, Object> map) {
		System.out.println("AdminItemDAOImpl - loan_pro_add");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_pro_list(map);
	}
	
	// 상품갯수
	@Override
	public int loan_cnt() {
		System.out.println("AdminItemDAOImpl - loan_pro_add");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_cnt();
	}

	// 관리자 대출 상품 상세
	@Override
	public Loans_itemDTO loan_pro_detail(String d_name) {
		System.out.println("AdminItemDAOImpl - loan_pro_detail");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_pro_detail(d_name);
	}

	// 관리자 대출 상품 수정
	@Override
	public int loan_pro_update(Loans_itemDTO dto) {
		System.out.println("AdminItemDAOImpl - loan_pro_update");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_pro_update(dto);
	}

	// 관리자 대출 상품 삭제
	@Override
	public int loan_pro_delete(String d_name) {
		System.out.println("AdminItemDAOImpl - loan_pro_delete");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_pro_delete(d_name);
	}
// =====================================================================
	// 관리자 대출 신청 목록
	@Override
	public List<LoansDTO> loan_pro_detail_list(Map<String, Object> map) {
		System.out.println("AdminItemDAOImpl - loan_pro_detail_list");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_pro_detail_list(map);
	}

	// 관리자 대출 신청 목록 상세
	@Override
	public LoansDTO loan_detail(int d_num) {
		System.out.println("AdminItemDAOImpl - loan_detail");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_detail(d_num);
	}

	// 관리자 대출 신청 목록 승인
	@Override
	public int loan_approve(Map<String, Object> map) {
		System.out.println("AdminItemDAOImpl - loan_approve");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_approve(map);
	}

	// 관리자 대출 신청 목록 거절
	@Override
	public int loan_delete(Map<String, Object> map) {
		System.out.println("AdminItemDAOImpl - loan_delete");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_delete(map);
	}

	// 관리자 대출 신청 목록 수정
	@Override
	public int loan_update_action(LoansDTO dto) {
		System.out.println("AdminItemDAOImpl - loan_update_action");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_update_action(dto);
	}

	// 관리자 대출 신청 목록 삭제
	@Override
	public int loan_delete_action(int d_num) {
		System.out.println("AdminItemDAOImpl - loan_delete_action");
		AdminItemDAO dao = sqlSession.getMapper(AdminItemDAO.class);
		return dao.loan_delete_action(d_num);
	}

	

}
