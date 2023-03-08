package com.spring.bank.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.LoanDAO;
import com.spring.bank.dto.Loan_applyDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_hisDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.Loans_paidDTO;



@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired //=@Inject
	LoanDAO dao;

	// 대출 원금 조회 / 납부 메서드(중도상환수수료 포함)
		@Override
		public void loan_principal_search(HttpServletRequest req, Model model) {
			System.out.println("LoanServiceImpl - loan_principal_search");
			// 조회 계좌번호
			String account_num = req.getParameter("account_num");
			// 고객이 input에서 입력한 상환할 금액
			int pay_amount = Integer.parseInt(req.getParameter("pay_amount"));
			// 대출 잔액
			LoansDTO dto = dao.loan_principal_search(account_num);
			int d_balance = dto.getD_balance();
			// 중도 상환 수수료율
			double d_prepayment_fee_rate = dto.getD_prepayment_fee();
			// 실제 중도 상환 수수료
			int d_prepayment_fee = (int) ((pay_amount/100) * d_prepayment_fee_rate);
			// 실제 납부하게 될 금액
			int final_pay_amount = pay_amount + d_prepayment_fee;
			// 납부 후 잔액
			int afterPay = d_balance - pay_amount;
			
			model.addAttribute("pay_amount", pay_amount);
			model.addAttribute("d_balance", d_balance);
			model.addAttribute("d_prepayment_fee", d_prepayment_fee);
			model.addAttribute("afterPay", afterPay);
			model.addAttribute("final_pay_amount", final_pay_amount);
			
		}

	// 원금 납부
	@Override
	public void loan_principal_paid(HttpServletRequest req, Model model) {
		// TODO Auto-generated method stub
		
	}

	// 대출 신규 신청
	@Override
	public void loan_apply(HttpServletRequest req, Model model) {
		System.out.println("loanService - 대출 신규 신청");
		// 세션에서 받아온 고객 아이디
		String customerID = (String)req.getSession().getAttribute("customerID");
		System.out.println("customerID : " + customerID);
		String d_name = req.getParameter("d_name");
		System.out.println("d_name : " + d_name);
		
		List<Loan_applyDTO> account_list;
		// dto에 담은 고객 계좌 정보
		account_list = dao.loan_apply_account_info(customerID);
		System.out.println("account_list : " + account_list);
		
		// dto에 담은 상품 정보
		Loan_applyDTO product_dto = dao.loan_apply_product_info(d_name);
		System.out.println("product_dto : " + product_dto);
		System.out.println("dtdttdt : " + product_dto.getName());
		
		model.addAttribute("account_list", account_list);
		model.addAttribute("product_dto", product_dto);
	}

	@Override
	public void loan_apply_calculate(HttpServletRequest req, Model model) {
		System.out.println("loanService - 대출 신규 신청 상환액 계산");
		
		// ajax에서 param으로 보낸 값 받기
		// 대출 받을 금액
		int loanOriginAmount = Integer.parseInt(req.getParameter("loanOriginAmount"));
		System.out.println("loanOriginAmount : " + loanOriginAmount);
		// 대출 받을 기간
		int loanPeriod = Integer.parseInt(req.getParameter("loanPeriod"));
		System.out.println("loanPeriod : " + loanPeriod);
		// 대출 금리
		double loanInterestRate = Double.parseDouble(req.getParameter("loanInterestRate"));
		System.out.println("loanInterestRate : " + loanInterestRate);
		// 상환 방법
		String returnMethod = req.getParameter("returnMethod");
		System.out.println("returnMethod : " + returnMethod);
		
		int origin_amount;
		int interest_amount;
		double calc = (loanInterestRate / 12) / 100;
		System.out.println("calc : " + calc);
		int total_amount;
		if(returnMethod.equals("원금균등상환")) {
			System.out.println("원금균등상환 여기 탔음");
			// 첫달 갚을 원금
			origin_amount = Math.round(loanOriginAmount / loanPeriod); // 소수점 반올림 후 정수 반환
			System.out.println("origin_amount : " + origin_amount);
			// 첫달 갚을 이자
			System.out.println("asdasd : " + loanOriginAmount + ", " + loanInterestRate);
			interest_amount = (int)Math.round(loanOriginAmount * calc);
			System.out.println("interest_amount : " + interest_amount);
			// 첫달 총 상환액
			total_amount = origin_amount + interest_amount;
			System.out.println("total_amount : " + total_amount);
		} else {
			// 첫달 갚을 원금
			origin_amount = 0;
			// 첫달 갚을 이자
			interest_amount = (int)Math.round(loanOriginAmount * calc);
			// 첫달 총 상환액
			total_amount = interest_amount;
		}
		
		
		
		model.addAttribute("origin_amount", origin_amount);
		model.addAttribute("interest_amount", interest_amount);
		model.addAttribute("total_amount", total_amount);
		
	}

	// 대출 신규 신청 계좌 비밀번호 확인
	@Override
	public String loan_apply_password_check(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_apply_password_check");
		
		String password = req.getParameter("accountPassword");
		System.out.println("password : " + password);
		String account_num = req.getParameter("selectAccount");
		System.out.println("account_num : " + account_num);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("password", password);
		map.put("account_num", account_num);
		
		String result = dao.loan_apply_password_check(map);
		System.out.println("result : " + result);
		
		return result;
	}

	// 대출 신규 신청 insert
	@Override
	public void loan_apply_insert(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_apply_insert");
		
		// id
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("id : " + id);
		// 상품명
		String d_name = req.getParameter("productName");
		System.out.println("productName : " + d_name);
		// 연결 계좌번호
		String account_num = req.getParameter("selectAccount");
		System.out.println("account_num : " + account_num);
		// 대출 실행일
		String time1 = req.getParameter("loanActivationDate");
		System.out.println("time1 : " + time1);
		Date d_start_date = Date.valueOf(time1);
		System.out.println("loanActivationDate : " + d_start_date);
		// 대출 만기일
		String time2 = req.getParameter("loanExpirationDate");
		Date d_end_date = Date.valueOf(time2);
		System.out.println("loanExpirationDate : " + d_end_date);
		// 대출 기간
		int d_month = Integer.parseInt(req.getParameter("loanPeriod"));
		System.out.println("loanPeriod : " + d_month);
		// 상환 방법
		String d_repay = req.getParameter("returnMethod");
		System.out.println("returnMethod : " + d_repay);
		// 대출 금리
		double d_rate = Double.parseDouble(req.getParameter("loanInterestRate"));
		System.out.println("loanInterestRate : " + d_rate);
		// 대출 원금
		int d_amount = Integer.parseInt(req.getParameter("loanOriginAmount"));
		System.out.println("loanOriginAmount : " + d_amount);
		// 중도 상환 수수료율
		double d_prepayment_fee = Double.parseDouble(req.getParameter("redemptionRate"));
		System.out.println("redemptionRate : " + d_prepayment_fee);
		// 대출 원금 잔액(d_balance)
		int d_balance = d_amount;
		System.out.println("d_balance : " + d_balance);
		// 대출 이자 잔액(d_balance_rate)
		
		
		LoansDTO dto = new LoansDTO();
		dto.setId(id);
		dto.setD_name(d_name);
		dto.setAccount_num(account_num);
		dto.setD_start_date(d_start_date);
		dto.setD_end_date(d_end_date);
		dto.setD_month(d_month);
		dto.setD_repay(d_repay);
		dto.setD_rate(d_rate);
		dto.setD_amount(d_amount);
		dto.setD_prepayment_fee(d_prepayment_fee);
		
		int insertCnt = dao.loan_apply_insert(dto);
		System.out.println("?? 대출 계좌 등록 ");
		// 계좌정보 update
		Map map = new HashMap<String,String>();
		map.put("account_num", dto.getAccount_num());
		map.put("account_name", dto.getD_name());
		map.put("balance", dto.getD_amount());
		System.out.println("dto 확인 "+dto.getD_name() );
		System.out.println(map.get("account_name"));
		dao.loans_accuont_update(map);
		
		model.addAttribute("insertCnt", insertCnt);
	}

	@Override
	public void loan_account_search(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_account_search");
		
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("id : " + id);
		
		List<LoansDTO> list = dao.loan_account_search(id);
		
		int count = dao.loan_account_search_count(id);
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
	}

	@Override
	public void loan_pro_list(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_pro_list");
		
		List<Loans_itemDTO> list = dao.loan_pro_list();
		
		model.addAttribute("list", list);
	}

	// 대출 상환 예정표
	@Override
	public void loan_paid_plan(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_paid_plan");
		
		// 대출 번호
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		System.out.println("d_num" + d_num);
		// 대출 회차
		int d_count = Integer.parseInt(req.getParameter("d_count"));
		System.out.println("d_count : " + d_count);
		// 대출 시작일
		String startDate = req.getParameter("d_start_date");
		System.out.println("startDate : " + startDate); // 2022-04-22...
		
		int yyyy = Integer.parseInt(startDate.substring(0, 4));
		int mm = Integer.parseInt(startDate.substring(5, 7));
		int dd = Integer.parseInt(startDate.substring(8, 10));
		System.out.println("year numbers : " + yyyy + ", " + mm + ", " + dd);
		// 대출 상품명
		String d_name = req.getParameter("d_name");
		System.out.println("d_name : " + d_name);
		// 대출 원금
		int d_amount = Integer.parseInt(req.getParameter("d_amount"));
		System.out.println("d_amount : " + d_amount);
		// 대출 금리
		double d_rate = Double.parseDouble(req.getParameter("d_rate"));
		System.out.println("d_rate : " + d_rate);
		d_rate /= 100; // 금리가 10 이런식이니까 100으로 나눠주고
		d_rate /= 12; // 연금리니까 12개월로 나눠준다
		System.out.println("final d_rate : " + d_rate);
		// 대출 기간
		int d_month = Integer.parseInt(req.getParameter("d_month"));
		System.out.println("d_month : " + d_month);
		// 상환 방법
		String d_repay = req.getParameter("d_repay");
		System.out.println("d_repay : " + d_repay);
		// 상환금 선언
		int repayMonth;
		
		// ------원금 계산--------
		// 원리금균등상환 계산식
		// 한달원금상환액 = ((원금 * 연금리/100->백분율/12->1년12개월 * Math.pow((1 + 연금리/100/12), 대출기간)) / (Math.pow->제곱((1 + 연금리/100->백분율/12), 대출기간) -1));
		// repayMonth = (int)((d_amount * d_rate * Math.pow((1 + d_rate), d_month)) / (Math.pow((1 + d_rate), d_month) -1));
		if(d_repay.equals("원리금균등상환")) {
			repayMonth = (int)((d_amount * d_rate * Math.pow((1 + d_rate), d_month)) / (Math.pow((1 + d_rate), d_month) -1));
			System.out.println("repayMonth 계산 : " + repayMonth);
		// 원금균등상환/만기일시상환 계산식
		} else {
			repayMonth = d_amount / d_month;
		} 
		
		List<Loans_paidDTO> list = new ArrayList<Loans_paidDTO>();
		int remainAmount = d_amount; // 잔액
		for(int i=0; i<d_month; i++) {
			Loans_paidDTO dto = new Loans_paidDTO();
			// 회차
			dto.setIndex(i+1);
			// 월 이자 상환액 (잔금 * 월금리)
			dto.setInterestRepay((int)(remainAmount * d_rate));
			System.out.println("1. " + dto.getInterestRepay());
			// 상환예정일 달 ++
			if(mm >= 12) {
				yyyy++;
				mm = 1;
			} else {
				mm++;
			}
			
			if(d_repay.equals("원리금균등상환")) {
				// 월 총 상환액
				dto.setTotalRepay(repayMonth);
				System.out.println("3. " + dto.getTotalRepay());
				// 월 원금 상환액
				dto.setOriginRepay(dto.getTotalRepay() - dto.getInterestRepay());
				System.out.println("4. " + dto.getOriginRepay());
			} else if(d_repay.equals("원금균등상환")){
				System.out.println("if문 원금균등상환 탔음");
				// 월 원금 상환액
				dto.setOriginRepay(repayMonth);
				// 월 총 상환액
				dto.setTotalRepay(dto.getOriginRepay() + dto.getInterestRepay());
				System.out.println("2. " + dto.getTotalRepay());
			} else { // 만기시 상환
				// 월 원금 상환액
				dto.setOriginRepay(0);
				// 월 총 상환액
				dto.setTotalRepay(dto.getInterestRepay());
				
				// 만기시 상환은 마지막에 모든 원금을 한번에 갚기 때문에 for문의 마지막 cycle에 원금을 모두 적용
				if(i == d_month - 1) {
					dto.setOriginRepay(d_amount);
					dto.setTotalRepay(dto.getInterestRepay() + d_amount);
				}
			}
			// 잔금 --
			remainAmount -= dto.getOriginRepay();
			System.out.println("remainAmount : " + remainAmount);
			// 잔금 set
			dto.setRemainAmount(remainAmount);
			System.out.println("5. " + dto.getRemainAmount());
			// 상환 예정일 합치기
			String returnDate;
			if(mm < 10) {
				returnDate = yyyy + "-" + 0 + mm + "-" + dd;
			} else {
				returnDate = yyyy + "-" + mm + "-" + dd;
			}
			
			dto.setReturnDate(returnDate);
			dto.setD_count(d_count);
			System.out.println("returnDate : " + returnDate);
			list.add(dto);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("d_name", d_name);
		model.addAttribute("d_num", d_num);
		model.addAttribute("d_repay", d_repay);
	}
	// 대출 상환 페이지
	@Override
	public void loan_paid_detail(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_paid_detail");
		
		// 상환방법
		String d_repay = req.getParameter("d_repay");
		System.out.println("d_repay : " + d_repay);
		// 상품번호
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		System.out.println("d_num : " + d_num);
		// 상품명
		String d_name = req.getParameter("d_name");
		System.out.println("d_name : " + d_name);
		// 회차
		int d_count = Integer.parseInt(req.getParameter("index"));
		System.out.println("d_count : " + d_count);
		// 월납입원금
		int originRepay = Integer.parseInt(req.getParameter("monthlyOrigin"));
		System.out.println("OriginRepay : " + originRepay);
		// 월납입이자
		int interestRepay = Integer.parseInt(req.getParameter("monthlyInterest"));
		System.out.println("interestRepay : " + interestRepay);
		// 월총상환금
		int totalRepay = Integer.parseInt(req.getParameter("monthlyTotal"));
		System.out.println("totalRepay : " + totalRepay);
		// 대출잔액
		int remainAmount = Integer.parseInt(req.getParameter("remaining"));
		System.out.println("remainAmount : " + remainAmount);
		// 상환예정일
		String returnDate = req.getParameter("planDate");
		System.out.println("returnDate : " + returnDate);
		// 아이디
		String id = (String)req.getSession().getAttribute("customerID");
		
		List<Loan_applyDTO> dto = new ArrayList<Loan_applyDTO>();
		dto = dao.account_search(id);		
		
		model.addAttribute("d_num", d_num);
		model.addAttribute("d_name", d_name);
		model.addAttribute("d_count", d_count);
		model.addAttribute("originRepay", originRepay);
		model.addAttribute("interestRepay", interestRepay);
		model.addAttribute("totalRepay", totalRepay);
		model.addAttribute("remainAmount", remainAmount);
		model.addAttribute("returnDate", returnDate);
		model.addAttribute("dto", dto);
		model.addAttribute("d_repay", d_repay);
		
	}

	// 대출 상환
	@Override
	public void loan_paid(HttpServletRequest req, Model model, HttpServletResponse res) {
		System.out.println("LoanServiceImpl - loan_paid");
		
		// id
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("id : " + id);
		// 출금 계좌번호
		String account_num = req.getParameter("account_num");
		System.out.println("account_num : " + account_num);
		// 대출 번호
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		System.out.println("d_num : " + d_num);
		// 상환방법
		String d_repay = req.getParameter("d_repay");
		System.out.println("d_repay : " + d_repay);
		// 회차
		int d_count = Integer.parseInt(req.getParameter("d_count"));
		System.out.println("d_count : " + d_count);
		// 월납입원금
		int originRepay = Integer.parseInt(req.getParameter("OriginalAmount"));
		System.out.println("OriginRepay : " + originRepay);
		// 월납입이자
		int interestRepay = Integer.parseInt(req.getParameter("Interest"));
		System.out.println("interestRepay : " + interestRepay);
		// 월총상환금
		int totalRepay = Integer.parseInt(req.getParameter("returnAmount"));
		System.out.println("totalRepay : " + totalRepay);
		// 대출잔액
		int remainAmount = Integer.parseInt(req.getParameter("remaining"));
		System.out.println("remainAmount : " + remainAmount);
		
		
		// 계좌 잔고 조회 - 상환 전 잔고 먼저 봐야함 -> 잔고가 내야할 금액보다 적으면 메서드 탈출 failure로 이동
		int balance = dao.loan_account_info_search(account_num);
		System.out.println("balance : " + balance);
			if(balance < totalRepay) {
				System.out.println("잔액 부족");
				model.addAttribute("updateCnt", 2);
			}else {
				System.out.println("잔액 충분");
				// ---------account_info 테이블 update-----------
				Loans_paidDTO accountdto = new Loans_paidDTO();
				accountdto.setAccount_num(account_num); // key
				System.out.println("set 결과 : " + accountdto.getAccount_num());
				accountdto.setTotalRepay(totalRepay); // balance - this
				int updateCnt4 = dao.loan_account_info_update(accountdto);
				System.out.println("updateCnt4 : " + updateCnt4);
				
				// ---------loans 테이블 update-----------------
				Loans_paidDTO loansdto = new Loans_paidDTO();
				loansdto.setOriginRepay(originRepay);
				loansdto.setTotalRepay(totalRepay);
				loansdto.setInterestRepay(interestRepay);
				loansdto.setAccount_num(account_num);
				loansdto.setD_num(d_num);
				int updateCnt1 = dao.loan_paid(loansdto);
				System.out.println("updateCnt1 : " + updateCnt1);
				
				// ---------transfer_info 테이블 insert----------
				String recipient = "코스모뱅크";
				String in_out = "출금";
				Loans_paidDTO transdto = new Loans_paidDTO();
				transdto.setAccount_num(account_num);
				transdto.setRecipient(recipient);
				transdto.setTotalRepay(totalRepay);
				transdto.setIn_out(in_out);
				transdto.setId(id);
				int updateCnt2 = dao.loan_transfer_info_insert(transdto);
				System.out.println("updateCnt2 : " + updateCnt2);
				
				// ---------loan_history 테이블 insert-----------
				Loans_paidDTO hisdto = new Loans_paidDTO();
				hisdto.setD_num(d_num);
				hisdto.setAccount_num(account_num);
				hisdto.setD_repay(d_repay);
				hisdto.setOriginRepay(originRepay);
				hisdto.setRemainAmount(remainAmount);
				int updateCnt3 = dao.loan_history_insert(hisdto);
				// transfer_num은 transfer_info 테이블의 max값 select(nvl) 처리로 가져감
				System.out.println("updateCnt3 : " + updateCnt3);
				
				model.addAttribute("updateCnt", updateCnt3);
			}
	}

	// 대출 상환 내역 조회
	@Override
	public void loan_paid_history(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_paid_history");
		
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		
		List<Loans_hisDTO> list = dao.loan_paid_history(d_num);
		
		model.addAttribute("list", list);
	}

	// 대출 해지
	@Override
	public void loan_cancel(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_cancel");
		
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		System.out.println("d_num : " + d_num);
		
		// 대출계좌 잔금 조회
		int d_balance = dao.loan_cancel_money_search(d_num);
		System.out.println("d_balance : " + d_balance);
		
		if(d_balance > 1000) {
			System.out.println("잔금 남아있음");
			model.addAttribute("result", 2);
		} else {
			int result = dao.loan_cancel(d_num);
			System.out.println("result : " + result);
			model.addAttribute("result", result);
		}
		
	}

	// 대출 해지 현황 조회
	@Override
	public void loan_cancel_search(HttpServletRequest req, Model model) {
		System.out.println("LoanServiceImpl - loan_cancel_search");
		
		// id
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("id : " + id);
		
		List<LoansDTO> list = dao.loan_cancel_search(id);
		
		model.addAttribute("list", list);
	}

}
