package com.spring.bank.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.DepositDTO;
import com.spring.bank.dto.Deposit_itemDTO;
import com.spring.bank.dto.FundDTO;
import com.spring.bank.dto.FundMemberDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.SavingsDTO;
import com.spring.bank.dto.Savings_itemDTO;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	ItemDAO dao;
	
	
	// 적금 상품 등록
	// 펀드 등록
	@Override
	public int fundinsert(FundDTO dto) {
		System.out.println("dao - fundinsert");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
	    int insertcnt = dao.fundinsert(dto);
		return insertcnt;
	}

	// 펀드목록
	@Override
	public List<FundDTO> fundlist(Map<String, Object> map) {
		System.out.println("dao - fundlist");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.fundlist(map);
	}
	
	// 펀드 카테고리 목록
	@Override
	public List<FundDTO> fund_category_list(Map<String, Object> map) {
		System.out.println("dao - fund_category_list");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.fund_category_list(map);
	}

	// 펀드상세페이지
	@Override
	public FundDTO getfunddetail(int f_num) {
		System.out.println("dao - funddetail");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.getfunddetail(f_num);
	}

	// 펀드 상품갯수
	@Override
	public int fundcnt() {
		System.out.println("dao - fundcnt");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.fundcnt();
	}
	
	// 펀드 구매
	@Override
	public String name(Map<String, Object> map) {
		System.out.println("dao - name");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.name(map);
	}
	
	// 펀드 멤버등록
	@Override
	public int fundmemberadd(FundMemberDTO dto) {
		System.out.println("dao - fundmemberadd");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.fundmemberadd(dto);
	}
	
	// 펀드멤버참여수
	@Override
	public String membertotal(Map<String, Object> map) {
		System.out.println("dao - membertotal");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.membertotal(map);
	}
	
	// 펀드 총 모인 금액
	@Override
	public String totalprice(Map<String, Object> map2) {
		System.out.println("dao - totalprice");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.totalprice(map2);
	}
	

	@Override
	public int savings_Add(Savings_itemDTO dto) {
		System.out.println("[DAO - savings_Add]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		int insertCnt = dao.savings_Add(dto);
		return insertCnt;
	}
	// 적금 상품 페이징 카운트
	@Override
	public int savings_item_Count() {
		System.out.println("[DAO - savings_item_Count]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		int selectCnt =	dao.savings_item_Count();
		return selectCnt;
	}
	
	// 적금 상품 조회
	@Override
	public List<Savings_itemDTO> savings_List(Map<String, Object> map) {
		System.out.println("[DAO - savings_List]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		List<Savings_itemDTO> list = dao.savings_List(map);
		return list;
	}
	// 적금 상품 수정
	@Override
	public int savings_Update(Savings_itemDTO dto) {
		System.out.println("[DAO - savings_Update]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		int updateCnt =	dao.savings_Update(dto);
		return updateCnt;
	}
	// 적금 상품 삭제
	@Override
	public int savings_Delete(int no) {
		System.out.println("[DAO - savings_Delete]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		int deleteCnt = dao.savings_Delete(no);
		return deleteCnt;
	}
	// 적금 상품 상세
	@Override
	public Savings_itemDTO savings_Detail(int no) {
		System.out.println("[DAO - savings_Detail]");
		ItemDAO  dao = sqlSession.getMapper(ItemDAO.class);
		Savings_itemDTO dto =  dao.savings_Detail(no);
		return dto;
	}
	
	// 예금 상품 추가
	@Override
	public int deposit_Add(Deposit_itemDTO dto) {
		System.out.println("[DAO - deposit_Add]");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		int insertCnt = dao.deposit_Add(dto);
		
		return insertCnt;
	}
	// 예금 상품 수정
	@Override
	public int deposit_Update(Deposit_itemDTO dto) {
		System.out.println("[DAO - deposit_Update]");
			
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);		
		
		int updateCnt = dao.deposit_Update(dto);
		
		return updateCnt;
	}
	// 예금 상품 삭제
	@Override
	public int deposit_Delete(int no) {
		System.out.println("[DAO - deposit_Delete]");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		int deleteCnt = dao.deposit_Delete(no);
		
		return deleteCnt;
	}
	// 예금 상품 조회
	@Override
	public List<Deposit_itemDTO> deposit_List(Map<String, Object> map) {
		System.out.println("[DAO - deposit_List]");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		List<Deposit_itemDTO> list = dao.deposit_List(map);
		
		return list;
	}
	// 예금 상품 페이징 카운트
	@Override
	public int deposit_item_Count() {
		System.out.println("[DAO - deposit_item_Count]");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		int selectCnt = dao.deposit_item_Count();
		
		return selectCnt;
	}
	// 예금 상품 상세
	@Override
	public Deposit_itemDTO deposit_Detail(int no) {
		System.out.println("[DAO - deposit_Detail]");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		
		Deposit_itemDTO dto = dao.deposit_Detail(no);
		
		return dto;
	}

	// 예금 상품 신청 - 고객
	@Override
	public int customer_Deposit_Add(DepositDTO dto) {
		System.out.println("[DAO - customer_deposit]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return 	 dao.customer_Deposit_Add(dto);
	}
	// 예금 상품 상세 - 고객
	@Override
	public List<AccountDTO> customer_Account_Search(String id) {
		System.out.println("[DAO - customer_Account_Search]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		List<AccountDTO> list = dao.customer_Account_Search(id);
		return list;
	}
	// 예금 계좌 상태 업데이트 - 고객
	@Override
	public int deposit_Account_Update(String account_num) {
		System.out.println("[DAO - deposit_Account_Update]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.deposit_Account_Update(account_num);
	}

	@Override
	public int savings_Account_Name(Map<String, Object> map) {

		System.out.println("[DAO - savings_Account_Name]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.savings_Account_Name(map);
	}

	@Override

	public int deposit_Account_Money(Map<String, Object> map) {
		System.out.println("[DAO - deposit_Account_Money]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.deposit_Account_Money(map);
	}
	// 적금 계좌 금액업데이트  - 고객
	@Override
	public int savings_Account_Money(Map<String, Object> map) {
		System.out.println("[DAO - savings_Account_Update]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.savings_Account_Money(map);

	}

	// 예금 계좌명 업데이트 - 고객
	@Override
	public int deposit_Account_Name(Map<String, Object> map) {
		System.out.println("[DAO - deposit_Account_Name]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.deposit_Account_Name(map);
	}

	// 적금 상품 신청 - 고객
	@Override
	public int customer_Savings_Add(SavingsDTO dto) {
		System.out.println("[DAO - customer_Savings_Add]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.customer_Savings_Add(dto);
	}
	// 적금 계좌 상태 업데이트 - 고객
	@Override
	public int savings_Account_Update(String account_num) {
		System.out.println("[DAO - savings_Account_Update]");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.savings_Account_Update(account_num);
	}

	public String title(Map<String, Object> map2) {
		System.out.println("dao - title");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		return dao.title(map2);
	}

	//안드로이드 상품 조회 - 적금
	@Override
	public List<Savings_itemDTO> savings_Item() {
		System.out.println("dao - savings_Item");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		List<Savings_itemDTO> list = dao.savings_Item();
		return list;
	}
	//안드로이드 상품 조회 - 예금
	@Override
	public List<Deposit_itemDTO> deposit_Item() {
		System.out.println("dao - savings_Item");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		List<Deposit_itemDTO> list = dao.deposit_Item();
		return list;
	}
	 //대출 상품 조회

	@Override
	public List<Loans_itemDTO> loans_Item() {
		System.out.println("dao - loans_Item");
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		List<Loans_itemDTO> list = dao.loans_Item();
		return list;
	}
  


}
