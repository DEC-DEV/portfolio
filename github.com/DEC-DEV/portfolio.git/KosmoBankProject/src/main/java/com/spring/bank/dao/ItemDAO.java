package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.DepositDTO;
import com.spring.bank.dto.Deposit_itemDTO;
import com.spring.bank.dto.FundDTO;
import com.spring.bank.dto.FundMemberDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.SavingsDTO;
import com.spring.bank.dto.Savings_itemDTO;
public interface ItemDAO {
	
	// 펀드 목록
	public List<FundDTO> fundlist(Map<String, Object> map);
	
	// 펀드 목록- 카테고리별
	public List<FundDTO> fund_category_list(Map<String, Object> map);
	
	// 펀드 등록
	public int fundinsert(FundDTO dto);
	// 펀드 상세페이지
    public FundDTO getfunddetail(int f_num);
    // 상품 갯수
 	public int fundcnt();
 	
 	// 펀드 구매 name
  	public String name(Map<String, Object> map);
 	
 	// 펀드 멤버 등록
 	public int fundmemberadd(FundMemberDTO dto);
 	
 	// 펀드 멤버참여수
 	public String membertotal(Map<String, Object> map);
 	
 	// 펀드 모인 총액
 	public String totalprice(Map<String, Object> map2);
 	
	// 적금 상품 등록
	public int savings_Add(Savings_itemDTO dto);
	// 적금 상품 수정
	public int savings_Update(Savings_itemDTO dto);
	// 적금 상품 삭제
	public int savings_Delete(int no);
	// 적금 상품 목록 조회
	public List<Savings_itemDTO> savings_List(Map<String, Object> map);
	// 페이징 카운트
	public int savings_item_Count();
	// 적금 상품 상세
	public Savings_itemDTO savings_Detail(int no);
	// 예금 상품 등록
	public int deposit_Add(Deposit_itemDTO dto);
	// 예금 상품 수정
	public int deposit_Update(Deposit_itemDTO dto);
	// 예금 상품 삭제
	public int deposit_Delete(int no);
	// 예금 상품 목록 조회
	public List<Deposit_itemDTO> deposit_List(Map<String, Object> map);
	// 예금_페이징 카운트
	public int deposit_item_Count();
	// 예금 상품 상세
	public Deposit_itemDTO deposit_Detail(int no);
	//예금 상품 신청 계좌 조회 - 고객계좌
	public List<AccountDTO> customer_Account_Search(String id);
	//예금 상품 신청 - 고객
	public int customer_Deposit_Add(DepositDTO dto);
	//예금 상품 신청 고객 계좌 타입 update
	public int deposit_Account_Update(String account_num);
	//예금 상품 신청 고객 계좌 이름 update
	public int deposit_Account_Name(Map<String, Object> map);
	//적금 상품 신청 - 고객
	public int customer_Savings_Add(SavingsDTO dto);
	//적금 상품 신청 고객 계좌 타입 update
	public int savings_Account_Update(String account_num);
	//적금 상품 신청 고객 계좌 명 update
	public int savings_Account_Name(Map<String, Object> map);
	//적금 상품 신청 - 고객
	public int deposit_Account_Money(Map<String, Object> map);
	//적금 상품 신청 - 고객
	
	//안드로이드 적금 조회
	public List<Savings_itemDTO> savings_Item();
	//안드로이드 예금 조회
	public List<Deposit_itemDTO> deposit_Item();
	//안드로이드 대출 조회
	public List<Loans_itemDTO> loans_Item();

	public int savings_Account_Money(Map<String, Object> map);
	
	public String title(Map<String, Object> map2);
}

