package com.spring.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.TransferDAOImpl;
import com.spring.bank.controller.CustomerController;
import com.spring.bank.dao.AccountDAOImpl;
import com.spring.bank.dao.TransferDAO;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.Savings_itemDTO;
import com.spring.bank.dto.TransferDTO;
import com.spring.bank.dto.auto_transferDTO;
import com.spring.bank.util.Sms;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {

	
	@Autowired
	TransferDAO dao;
	
	@Autowired
	AccountDAOImpl AccountDAO;
	
	
	// 계좌이체/ 적금추가납입 전 인증처리
	@Override
	public String account_transfer_check(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 계좌이체 전 인증");
		// 화면받는값
		String account_num = req.getParameter("account_num");
		String account_password = req.getParameter("account_password");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account_num", account_num);
		map.put("account_password", account_password);
		 
		// dao 호출( 아이디-비번 확인)
		int resultCnt = dao.account_transfer_ck(map);
	
		return String.valueOf(resultCnt) ;
	}

	// 이체 전 정보 불러오기 1-1 (계좌)
	@Override
	public void call_account_transfer1(HttpServletRequest req, Model model) {
		
		String id = (String)req.getSession().getAttribute("customerID");
		List<AccountDTO> list = dao.call_account_transfer1(id);
		model.addAttribute("list", list);
	}
	
	// 셀렉된 계좌 한도+잔액 불러오기 1-2 
	@Override
	public void call_account_transfer2(HttpServletRequest req, Model model) {
		
		String account_num = req.getParameter("account_num");
		AccountDTO dto = dao.call_account_transfer2(account_num);
		model.addAttribute("dto", dto);
	}
	

	// 계좌이체 처리
	@Override
	public void account_transfer2(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 계좌이체 처리");
		
	    // sms 
	       // 해당id의 폰번호 불러오기
	       
		// 화면 받는값 
		// (출금자)
		String id = (String)req.getSession().getAttribute("customerID"); 
		String account_num = req.getParameter("account_num").trim();	// (이체하는)출금계좌번호	
		String account_num2 = req.getParameter("account_num2").trim();	// (이체하는)입금계좌번호
		int money = Integer.parseInt(req.getParameter("money").trim());	// 이체금액
		String out_comment = req.getParameter("out_comment").trim();	//보낸사람 표시내용
		
		int balance = Integer.parseInt(req.getParameter("balance").trim());   // 잔액
		
		System.out.println("11111 화면에서 받아온 값 : "+balance);
		System.out.println("화면에서 받는값 account_num :"  + account_num);
		
		String phone = dao.select_phone(id);
		System.out.println("phone");
	    Sms sms= new Sms(); 
	    sms.sendSMS(account_num, account_num2, money, phone);
		
		// (입금자되는 자)
		String sender_name = req.getParameter("sender_name");		//예금주
		String in_comment = req.getParameter("in_comment");			//받는사람 표시내용
		
		System.out.println("transferService 받는 사람 : "+in_comment);
		System.out.println("transferService 보내는 사람 : "+out_comment);
		// dto에 담기
		TransferDTO dto = new TransferDTO(); 	//보내는용
		TransferDTO dto2 = new TransferDTO();	// 받는용
	//-------------------------------------------------
		
		dto.setAccount_num(account_num);	 // (transfer_info)출금계좌번호	
		dto.setMoney(money); 				 // 이체금액
		dto.setOut_comment(out_comment);	//보낸사람 표시내용
		dto.setSender_name(sender_name);	//예금주
		dto.setIn_comment(in_comment);		//받는사람 표시내용
	// ---------------------------------------------------------	
		dto2.setAccount_num(account_num2);	 // (transfer_info)입금 계좌번호
		dto2.setMoney(money); 				 // 이체금액
		dto2.setOut_comment(out_comment);	//보낸사람 표시내용
		dto2.setSender_name(sender_name);	//예금주
		dto2.setIn_comment(in_comment);		//받는사람 표시내용
		
		System.out.println(dto.toString());
		//int balance = Integer.parseInt(req.getParameter("balance"));
		//---------------------------------------------------	 
		
		 // (보낸사람) 이체시 -된 계좌의 잔액 
		  balance = balance - money;
		  // (보낸사람) 이체시 -된 계좌의 잔액 - 이체 내역에 저장하기 위해 dto에 set
		  dto.setTransfer_balance(balance);
		  // (보낸사람) 이체시 -된 계좌의 잔액 
		  System.out.println("transferService : 이체 후 잔액"+balance);
		  System.out.println("dto2 확인 : "+dto2.toString());
		 
		 // map에 출금자 (잔액 + 출금계좌번호) 담음
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("balance", balance);
		 map.put("account_num", account_num);
		 
		 System.out.println("========= 확인1");
		 // dao 호출
		 int result = dao.account_transfer_send(map);
		 System.out.println("result : " + result);
	//-----------------------------------------------------------------

	 // 입금되는자 잔액 불러오기
		 int balance2 = dao.call_balance(account_num2);
		 
		 System.out.println("balance2 불러온값 :" +balance2);
	//-------------------------------------------------------------------	 
	// (받는사람) 이체시 + 된 계좌의 잔액 
		 balance2 = balance2 + money;
		 dto2.setTransfer_balance(balance2);
		 // dto에 담기
		// Adto2.setBalance(balance2);
		 
		 
		 // map에 입금자 잔액 + 계좌번호 담음
		 Map<String, Object> map2 = new HashMap<String, Object>();
		 map2.put("balance2", balance2);
		 map2.put("account_num2", account_num2);
		 System.out.println(account_num2+", balance2 연산 후 값 :"+balance2);

		 // dao 호출
		 int result1 = dao.accoount_transfer_receive(map2);  
		 System.out.println("result1 : " +result1);
		 
	//---------------------------------------------------------------------
		 
		// 이체정보 transfer_info에 내역저장 
		 
		 //보내는 사람 (map 없애고 바로 dto넘겨보자 좀이따)
		 // map에 dto가 두개 담아지나?? 담아도 매퍼에서 받아쓸떄 불가능한듯
		 // map에 dto에 든거를 하나하나 풀어서 직접 담는다. 
		 Map<String, Object> map3 = new HashMap<String, Object>();
		 map3.put("account_num", dto.getAccount_num());
	//	 map3.put("account_num2", dto2.getAccount_num());
		 map3.put("money", dto.getMoney());
		 map3.put("out_comment", dto.getOut_comment());
		 map3.put("in_comment", dto.getIn_comment());
		 map3.put("sender_name", dto.getSender_name());
		 map3.put("id", id);
		 // 이체시 잔액 저장
		 map3.put("transfer_balance", dto.getTransfer_balance());
		 System.out.println("map3 :" + map3);
		 //dao 호출
		 int result2 = dao.t_send_saving(map3);
		 System.out.println("result2 : " + result2);
		 
		 //받는 사람 dao 호출
		 int result3 = dao.t_receive_saving(dto2); 
		 System.out.println("dto2 :" + dto2);
		 System.out.println("result3 : " + result3);
		
	}
	
//--적금=====================================================================	

	// 적금 추가납입 전 정보 불러오기 1
	@Override
	public void call_add_paid_1(HttpServletRequest req, Model model) {
		
		String id = (String)req.getSession().getAttribute("customerID");
		
		List<Savings_itemDTO> list = dao.call_savings_transfer_1(id);
		
		model.addAttribute("list", list);
	}
	
	// 적금 추가납입 전 정보 불러오기  2
	@Override
	public void call_add_paid_2(HttpServletRequest req, Model model) {
		
		//String id = (String)req.getSession().getAttribute("customerID");
		String account_num = req.getParameter("account_num");
		
		List<Savings_itemDTO> list = dao.call_savings_transfer_2(account_num);
		
		model.addAttribute("list", list);
	}

	// 적금 추가 납입 처리
	@Override
	public void add_paid(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 적금 추가 납입");
		
		// 화면값 받기
		String account_num = req.getParameter("account_num");
		int addMoney = Integer.parseInt(req.getParameter("addMoney")); //맵에추가해서 DB에 컬럼하나추가해?
		int i_balance = Integer.parseInt(req.getParameter("i_balance"));
		
		System.out.println("addMondey  : "+addMoney);
		System.out.println("i_balance : "+i_balance);
		
		//최종납부액  = 현재총납부액(잔액) + 추가납입금
		i_balance = i_balance + addMoney;
		System.out.println("적금 추가 확인 : "+i_balance);
		System.out.println("account_num : "+account_num);
		
		// dao 호출
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account_num", account_num);
		map.put("i_balance", i_balance);
		
		int result = dao.savings_add_paid(map);
		System.out.println("서비스 - 적금 추가 납입 - dao결과 :" + result);
		
		
		// dao 호출 
		//이체정보 transfer_info에 저장 
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("account_num", account_num);
		map2.put("addMoney", addMoney);
		
		int result2 = dao.t_add_paid_saving(map2);
		
	}

	// 자동이체 조회 1
	@Override
	public void auto_search(HttpServletRequest req, Model model) {
		System.out.println("auto_search타냐!!!!!>>>???");
		
		// 1.로그인 id의 (자동이체DB의 )모든 계좌
		String id = (String)req.getSession().getAttribute("customerID");
		
		// 1.dao 호출 - 해당id의 모든 출금 계좌번호 불러오기
 		List<auto_transferDTO> list =  dao.auto_search_1(id);
 		
 		model.addAttribute("list", list);
 	//-------------------------------------------------------------
	}	
	// 조회 2
	@Override
	public void auto_search_2(HttpServletRequest req, Model model) {
 		System.out.println("조회 버튼 누름");
 		// 2.셀렉 계좌의 자동이체 정보불러오기
 		String account_num = req.getParameter("account_num");
 		
 		// 2.dao 호출
 		List<auto_transferDTO> list2 =  dao.auto_search_2(account_num);
		
 		System.out.println("list2 확인 : " + list2);
		model.addAttribute("list2", list2);
	}

	
	// 자동이체 해지
	@Override
	public void auto_cancel(HttpServletRequest req, Model model) {
		
		
		// forEach문 의 hidden인데 어케받아야대지?
		
		int jd_num = Integer.parseInt(req.getParameter("jd_num"));
		
		
		int result = dao.auto_cancel(jd_num);
		
	}

	//한도변경 신청 - 한도불러오기 
	@Override
	public void limit_call(HttpServletRequest req, Model model) {
		System.out.println("서비스 - limit_call");
		
 		String account_num = req.getParameter("account_num");
 		System.out.println("account_num :" +account_num);
 		
 		// 2.dao 호출 - 한도 불러오기
 		String limit =  dao.select_limit(account_num);
		
 		System.out.println("select_limit dao확인 : " + limit);
		model.addAttribute("limit", limit);
		
	}
	
	// 한도변경 신청 처리
	@Override
	public void limit_apply(HttpServletRequest req, Model model) {
		System.out.println("서비스 - limit_apply");
		
		String account_num = req.getParameter("account_num");
 		System.out.println("account_num :" +account_num);
 		String number = req.getParameter("number");
 		System.out.println("신청한도number :" +number);
 	

 		Map<String,Object> accountMap = new HashMap<String,Object>();
 		accountMap.put("account_num", account_num);
 		accountMap.put("limit_recent", number);
 		AccountDAO.account_limit_update(accountMap);
 		
	}
}
