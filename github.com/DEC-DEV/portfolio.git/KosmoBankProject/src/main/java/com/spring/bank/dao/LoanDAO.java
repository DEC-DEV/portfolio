package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.Loan_applyDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_hisDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.Loans_paidDTO;

public interface LoanDAO {
	
	// 대출 원금 조회
	public LoansDTO loan_principal_search(String account_num);
	
	
	// 대출 신규 신청(계좌정보)
	public List<Loan_applyDTO> loan_apply_account_info(String customerID);
	// 대출 신규 신청(상품정보)
	public Loan_applyDTO loan_apply_product_info(String d_name);
	// 대출 신규 신청(비번체크)
	public String loan_apply_password_check(Map<String,Object> map);
	// 대출 신규 신청(insert)
	public int loan_apply_insert(LoansDTO dto);
	// 대출 계좌 조회
	public List<LoansDTO> loan_account_search(String id);
	// 대출 계좌 건수 조회
	public int loan_account_search_count(String id);
	// 대출 상품 목록
	public List<Loans_itemDTO> loan_pro_list();
	// 대출 상환 결제 계좌 조회
	public List<Loan_applyDTO> account_search(String id);
	
	//------------ 대출 상환 -------------------
	// account_info 테이블 잔고조회
	public int loan_account_info_search(String account_num);
	// loans 테이블 상환 update
	public int loan_paid(Loans_paidDTO loansdto);
	// transfer_info 테이블 insert 
	public int loan_transfer_info_insert(Loans_paidDTO transdto);
	// loan_history 테이블 insert
	public int loan_history_insert(Loans_paidDTO hisdto);
	// account_info 테이블 update
	public int loan_account_info_update(Loans_paidDTO accountdto);
	//------------ 대출 상환 끝 -------------------
	
	// 대출 상환 내역 조회
	public List<Loans_hisDTO> loan_paid_history(int d_num);
	
	// 대출 해지 - 대출잔금조회
	public int loan_cancel_money_search(int d_num);
	// 대출 해지
	public int loan_cancel(int d_num);
	// 대출 해지 현황 조회
	public List<LoansDTO> loan_cancel_search(String id);


	// 계좌 정보 업데이트
	public void loans_accuont_update(Map<String,String> map);


}
