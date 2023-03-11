package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.Loan_applyDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_hisDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.Loans_paidDTO;
@Repository
public class LoanDAOImpl implements LoanDAO{
	
	// SqlSession
	@Autowired
	private SqlSession sqlSession;
	
	// 대출 원금 조회 / 납부 메서드(중도상환수수료 포함)
	@Override
	public LoansDTO loan_principal_search(String account_num) {
		System.out.println("LoanDAOImpl - 대출원금조회");
		
		return sqlSession.getMapper(LoanDAO.class).loan_principal_search(account_num);
	}

	
	// 대출 신규 신청(계좌정보)
	@Override
	public List<Loan_applyDTO> loan_apply_account_info(String customerID) {
		System.out.println("LoanDAOImpl - 대출 신규 신청(계좌정보)");
		
		return sqlSession.getMapper(LoanDAO.class).loan_apply_account_info(customerID);
	}

	// 대출 신규 신청(상품정보)
	@Override
	public Loan_applyDTO loan_apply_product_info(String d_name) {
		System.out.println("LoanDAOImpl - 대출 신규 신청(상품정보)");
		
		return sqlSession.getMapper(LoanDAO.class).loan_apply_product_info(d_name);
	}

	// 대출 신규 신청(비번체크)
	@Override
	public String loan_apply_password_check(Map<String, Object> map) {
		System.out.println("LoanDAOImpl - 대출 신규 신청(비번체크)");
		
		return sqlSession.getMapper(LoanDAO.class).loan_apply_password_check(map);
	}

	// 대출 신규 신청(insert)
	@Override
	public int loan_apply_insert(LoansDTO dto) {
		System.out.println("LoanDAOImpl - 대출 신규 신청(insert)");
		
		return sqlSession.getMapper(LoanDAO.class).loan_apply_insert(dto);
	}


	// 대출 게좌 조회
	@Override
	public List<LoansDTO> loan_account_search(String id) {
		System.out.println("LoanDAOImpl - 대출 계좌 조회");
		
		return sqlSession.getMapper(LoanDAO.class).loan_account_search(id);
	}
	// 대출 상품 목록
	@Override
	public List<Loans_itemDTO> loan_pro_list() {
		System.out.println("LoanDAOImpl - 대출 상품 목록");
		return sqlSession.getMapper(LoanDAO.class).loan_pro_list();
	}


	// 대출 계좌 조회 카운트
	@Override
	public int loan_account_search_count(String id) {
		System.out.println("LoanDAOImpl - 대출 계좌 조회 카운트");
	return sqlSession.getMapper(LoanDAO.class).loan_account_search_count(id);
	}

	
	// 대출 상환 결제 계좌 조회
	@Override
	public List<Loan_applyDTO> account_search(String id) {
		System.out.println("LoanDAOImpl - account_search");
		
		return sqlSession.getMapper(LoanDAO.class).account_search(id);
	}
	
	//------------ 대출 상환 -------------------
	// 대출금 상환
	@Override
	public int loan_paid(Loans_paidDTO loansdto) {
		System.out.println("LoanDAOImpl - loan_paid");
		
		return sqlSession.getMapper(LoanDAO.class).loan_paid(loansdto);
	}

	// transfer_info 테이블 insert 
	@Override
	public int loan_transfer_info_insert(Loans_paidDTO transdto) {
		System.out.println("LoanDAOImpl - loan_transfer_info_insert");
		return sqlSession.getMapper(LoanDAO.class).loan_transfer_info_insert(transdto);
	}

	// loan_history 테이블 insert
	@Override
	public int loan_history_insert(Loans_paidDTO hisdto) {
		System.out.println("LoanDAOImpl - loan_history_insert");
		return sqlSession.getMapper(LoanDAO.class).loan_history_insert(hisdto);
	}

	// account_info 테이블 update
	@Override
	public int loan_account_info_update(Loans_paidDTO accountdto) {
		System.out.println("LoanDAOImpl - loan_account_info_update");
		return sqlSession.getMapper(LoanDAO.class).loan_account_info_update(accountdto);
	}

	// 대출 상환 내역 조회
	@Override
	public List<Loans_hisDTO> loan_paid_history(int d_num) {
		System.out.println("LoanDAOImpl - loan_paid_history");
		
		return sqlSession.getMapper(LoanDAO.class).loan_paid_history(d_num);
	}

	// 대출 상환 - 출금 계좌 잔고 조회
	@Override
	public int loan_account_info_search(String account_num) {
		System.out.println("LoanDAOImpl - loan_account_info_search");
		
		return sqlSession.getMapper(LoanDAO.class).loan_account_info_search(account_num);
	}

	// 대출 해지 - 대출 잔금 조회
	@Override
	public int loan_cancel_money_search(int d_num) {
		System.out.println("LoanDAOImpl - loan_cancel_search");
		
		return sqlSession.getMapper(LoanDAO.class).loan_cancel_money_search(d_num);
	}

	// 대출 해지
	@Override
	public int loan_cancel(int d_num) {
		System.out.println("LoanDAOImpl - loan_cancel");
		
		return sqlSession.getMapper(LoanDAO.class).loan_cancel(d_num);
	}

	// 대출 해지 조회
	@Override
	public List<LoansDTO> loan_cancel_search(String id) {
		System.out.println("LoanDAOImpl - loan_cancel_search");
		
		return sqlSession.getMapper(LoanDAO.class).loan_cancel_search(id);
	}

	public void loans_accuont_update(Map<String,String> map) {
		sqlSession.getMapper(LoanDAO.class).loans_accuont_update(map);
	}


	/* 
	 * @Override <<<<<<< HEAD public void loans_accuont_update(Map<String, String>
	 * map) { sqlSession.getMapper(LoanDAO.class).loans_accuont_update(map);
	 * 
	 * ======= public int loan_account_search_count(String id) {
	 * System.out.println("LoanDAOImpl - 대출 계좌 조회 카운트");
	 * 
	 * return sqlSession.getMapper(LoanDAO.class).loan_account_search_count(id);
	 * >>>>>>> origin/new_hyunoo }
	 */

}
