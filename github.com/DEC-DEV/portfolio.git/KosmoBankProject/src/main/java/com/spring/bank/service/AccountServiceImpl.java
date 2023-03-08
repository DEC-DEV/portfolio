package com.spring.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.AccountDAOImpl;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.TransferDTO;



@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAOImpl AccountDAO;

	// 나의 보유 계좌 조회
	@Override
	public void my_account(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("아이디 확인 :"+id);
		List<AccountDTO> account_all = AccountDAO.my_account_all(id);
		for( AccountDTO dto : account_all) {
			dto.setId(id);
		}
		System.out.println("계좌 갯수 : "+account_all.size());
		List<AccountDTO> list = AccountDAO.my_account_All_info(id.trim());
		List<AccountDTO> t_list =  AccountDAO.transfer_time_select(id);
		for( AccountDTO dto : list){
			for(AccountDTO dtos : t_list) {
				if(dto.getAccount_num().equals( dtos.getAccount_num())) {
					System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
					dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
					System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
				}
			}
		}
		System.out.println("list_size : "+list.size());
		if( list.size()<=0) {
			AccountDTO dto = new AccountDTO();
			dto.setAccount_state("계좌 정보가 존재하지 않습니다.");
			dto.setIN_OUT_DATE("");
			dto.setHistory("");
			dto.setAccount_num("계좌 정보가 존재하지 않습니다");
			list.add(dto);
		}

		model.addAttribute("list",list);
	}
	@Override
	public String my_trade_history(HttpServletRequest req, Model model) {
		String account_num = req.getParameter("account_num");

		List<TransferDTO> list = AccountDAO.my_trade_history(account_num);
		if( list.size()<=0) {
			TransferDTO dto = new TransferDTO();
			dto.setAccount_num("이체 내역이 존재하지 않습니다");
			dto.setIn_out_date("");
			list.add(dto);
		}
		model.addAttribute("list",list);
		return null;
	}
	// 계좌 정보 조회
	@Override
	public CustomerDTO my_select_info(HttpServletRequest req, Model model) {
		String id =" ";
		CustomerDTO dto = null;
		try {
			id = (String) req.getSession().getAttribute("customerID");
			System.out.println("account_service : id "+ id);
			dto = AccountDAO.my_select_info(id);
			if(dto.getName().isEmpty() ) {
				return null;
			}
		}catch(Exception ex) {
			System.out.println("account_service my_select_info");
		}
		return dto;
	}

	// 계좌 추가하기
	@Override
	public Map<String,Object> account_add(HttpServletRequest req, Model model ) {

		Random ran = new Random();
		AccountDTO dto = new AccountDTO();
		// 등록 아이디
		String id = (String)req.getSession().getAttribute("customerID");

		// 예금주 이름
		String name = req.getParameter("account_name");
		// 계좌 비밀번호
		String account_pwd = req.getParameter("account_password");
		// 은행명
		String bank_name = req.getParameter("bank_name");

		// 계좌 번호
		int account_num1 =(int)(Math.random() * (9999 - 1000 + 1)) + 1000;
		int account_num2 =(int)(Math.random() * (9999 - 1000 + 1)) + 1000;
		System.out.println(account_num1);
		String account_num = account_num1 +"-"+account_num2;
		System.out.println(account_num);

		// dto에 저장
		dto.setId(id); // 아이디 저장
		dto.setName(name); // 이름 저장
		dto.setBank_name(bank_name);
		dto.setAccount_password(account_pwd); // 비밀번호 저장
		dto.setAccount_num(account_num); // 계좌번호 난수 저장

		int insertCnt = AccountDAO.Account_add( dto );
		Map<String,Object> map = new HashMap<String,Object>();
		account_num = AccountDAO.account_recent_select(id);
		map.put("insertCnt", insertCnt);
		map.put("account_num", account_num);
		return map;
	}

	// 입출금으로 변경 ( 계좌 개설 후 입출금 계좌로 변경 )
	@Override
	public int account_type_default(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("customerID");
		String account_num = AccountDAO.account_recent_select(id);
		System.out.println("계좌번호 확인 : "+account_num);
		return AccountDAO.account_type_default(account_num.trim());
	}
	// 계좌 해지 페이지로 이동
	@Override
	public  void account_info_cancel(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("customerID");
		// 아이디에서 보유중인 계좌 정보 조회
		List<AccountDTO> list = AccountDAO.my_account_All_info(id.trim());
		//  list 값 확인
		System.out.println(list.get(0).getAccount_num());
		model.addAttribute("list",list);
	}

	// 계좌 비밀번호 체크 ( 해지 )
	// 계좌 해지 전 비밀번호 체크
	@Override
	public int account_pwd_chk(HttpServletRequest req, Model model) {

		Map<String,String> map = new HashMap<String,String>();
		// 계좌번호
		String account_num = req.getParameter("account_num");
		// 비밀번호
		String account_pwd = req.getParameter("account_pwd");
		map.put("account_num", account_num);
		map.put("account_pwd", account_pwd);
		return AccountDAO.account_pwd_chk(map);
	}
	// 계좌 해지 상태로 변경
	@Override
	public int my_sleep_account(HttpServletRequest req, Model model) {
		String account_num = req.getParameter("account_num");
		System.out.println("account_num : "+account_num);
		return AccountDAO.my_sleep_account(account_num);
	}

	// 계좌 조회 타입 변경 ( 안드   x)
	@Override
	public List<AccountDTO> account_type_change(HttpServletRequest req, Model model) {
		String account_type = req.getParameter("account_type");
		System.out.println("account_type : "+account_type);
		String id = (String)req.getSession().getAttribute("customerID");
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("account_type", account_type);
		List<AccountDTO> account_all = AccountDAO.my_account_all(id);
		List<AccountDTO> t_list = AccountDAO.transfer_time_select(id); 
		switch(account_type) {
			case "입/출금" :
				System.out.println("--service : 입/출금");
				list =AccountDAO.account_type_change(map);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
							System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				break;
			case "대출" :
				System.out.println("대출");
				list =AccountDAO.account_type_change(map);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
							System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				break;
			case "적금" :
				System.out.println("적금");
				list= AccountDAO.account_type_change(map);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
							System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				break;
			case "예금" :
				System.out.println("예금");
				list = AccountDAO.account_type_change(map);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				break;
			case "정지/휴면/해지" :
				System.out.println("정지/휴면/해지");
				list = AccountDAO.account_selected_state(map);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
							System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				System.out.println("정치휴면 :"+list.size());
				break;
			case "전체계좌" :
				list =AccountDAO.my_account_All_info(id);
				for( AccountDTO dto : account_all) {
					dto.setId(id);
				}
				System.out.println("계좌 갯수 : "+account_all.size());
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
							System.out.println("거래내역 시간 : "+dtos.getIN_OUT_DATE());
						}
					}
				}
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
				break;
		}
		return list;
	}
	// 계좌 정보 조회( 안드 x )
	@Override
	public AccountDTO account_selected_info(HttpServletRequest req, Model model) {
		String account_num = req.getParameter("account_num");
		System.out.println(account_num);
		return AccountDAO.account_info_selected(account_num);

	}
 // 사용 안함(xx)
	@Override
	public String my_cancel_account(HttpServletRequest req, Model model) {
		return null;
	}

	// 거래내역 조회()
	@Override
	public List<TransferDTO> select_trade_history(HttpServletRequest req, Model model) {
		String date_start = req.getParameter("date_start");
		String date_end = req.getParameter("date_end");
		String account_num = req.getParameter("account_num");
		Map<String, String> map = new HashMap<String,String>();
		map.put("date_start", date_start);
		map.put("date_end", date_end);
		map.put("account_num", account_num);
		System.out.println("account_num "+map.get("account_num"));
		System.out.println("date_start : "+map.get("date_start"));
		System.out.println("date_end : "+map.get("date_end"));
		List<TransferDTO> list = AccountDAO.select_trade_history(map);
		if( list.size()<=0) {
			TransferDTO dto = new TransferDTO();
			dto.setAccount_num("이체 내역이 존재하지 않습니다");
			dto.setIn_out_date("");
			list.add(dto);
		}
		System.out.println("사이즈 : "+list.size());
		return list;
	}
	// 거래내역 시간 조회( 개설, 해지에서 사용 x) 거래내역조회에서 사용
	@Override
	public List<AccountDTO> select_account_history(HttpServletRequest req, Model model) {
		System.out.println("service");
		String id = (String)req.getSession().getAttribute("customerID");
		String account_num = req.getParameter("account_num").trim();
		System.out.println("account_num : "+account_num);
		System.out.println("id : "+id);
		Map<String, String> map = new HashMap<String,String>();
		map.put("account_num",account_num );
		map.put("id",id );
		return AccountDAO.select_account_history(map);
	}
	@Override
	public List<AccountDTO> my_account_sorting(HttpServletRequest req, Model model) {
		String type = req.getParameter("type");
		System.out.println("service sorting Type : "+type);
		String id = (String)req.getSession().getAttribute("customerID");
		List<AccountDTO> list = null;
		if(type.equals("거래내역")) {
			// 거래내역으로 정렬
		list = AccountDAO.my_account_sorting_history(id);
		
		// 거래내역을 보유계좌 정보와 비교해서 저장
		List<AccountDTO> t_list = AccountDAO.transfer_time_select(id);
			for( AccountDTO dto : list){
				for(AccountDTO dtos : t_list) {
					if(dto.getAccount_num().equals( dtos.getAccount_num())) {
						dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
					}
				}
			}
	
			for(int i =0; i<list.size(); i++) {
				try {
					list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
				}catch(Exception ex) {}
			}
		}else {
			// 생성일 기준으로 정렬
			System.out.println("생성일 기준으로 sorting");
			list = AccountDAO.my_account_sorting_newdate(id);
			// 거래내역을 보유계좌 정보와 비교해서 저장
			List<AccountDTO> t_list = AccountDAO.transfer_time_select(id);
				for( AccountDTO dto : list){
					for(AccountDTO dtos : t_list) {
						if(dto.getAccount_num().equals( dtos.getAccount_num())) {
							System.out.println(dto.getAccount_num() + "dtos "+dto.getAccount_num());
							dto.setIN_OUT_DATE(dtos.getIN_OUT_DATE());
						}
					}
				}
		
				for(int i =0; i<list.size(); i++) {
					try {
						list.get(i).setIN_OUT_DATE(t_list.get(i).getIN_OUT_DATE());
					}catch(Exception ex) {}
				}
		}
		return list;
	}


}
