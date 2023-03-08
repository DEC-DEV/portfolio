package com.spring.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.AutoTransferDAO;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.AutoTransferDTO;
import com.spring.bank.dto.AutoTransfer_ListDTO;
import com.spring.bank.util.Sms;


@Service
@EnableScheduling
public class AutotransferServiceImpl implements AutotransferService{
	//LJH, 2022-04-21
	
	@Autowired
	AutoTransferDAO dao;
	
	//캘린더 리스트 조회
	@Override
	public List<AutoTransfer_ListDTO> get_Calender_List() {
		System.out.println("[service - get_Calender_List]");
	
		return dao.calenderList();
		
	}
	//자동 이체 등록
	@Override
	public void auto_add(HttpServletRequest req, Model model) {
		System.out.println("[service - auto_Transfer_add]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		
			AutoTransferDTO dto = new AutoTransferDTO();
			dto.setJd_type(Integer.parseInt(req.getParameter("jd_type"))); 	//약정, 정정
			dto.setAccount_num(req.getParameter("account_num"));	//출금계좌번호
			dto.setJd_out_date(java.sql.Date.valueOf(req.getParameter("jd_out_date")));
			dto.setJd_regist_date(java.sql.Date.valueOf(req.getParameter("jd_regist_date"))); //이체 시작일
			dto.setJd_end_date(java.sql.Date.valueOf(req.getParameter("jd_end_date")));	 //이체 만료일
			dto.setJd_auto_money(Integer.parseInt(req.getParameter("jd_auto_money")));	 //자동 이체 금액
			dto.setJd_bank_name(req.getParameter("jd_bank_name"));	//이체 은행명
			dto.setJd_account(req.getParameter("jd_account"));	 //이체계좌번호
			
			int insertCnt = dao.auto_Transfer_add(dto);
			System.out.println("dto : " + dto);
			model.addAttribute("insertCnt", insertCnt);
	}

	
	@Override
//	@Scheduled(cron = "0/10 * * * * *")
	@Scheduled(cron = "0 0 18 * * *")
	public void auto_List() {
		System.out.println("[service - auto_List]");
		
		//현재 날짜 확인
		SimpleDateFormat format = new SimpleDateFormat("dd");
		Date date = new Date();
		
		String day = format.format(date);
		int iday = Integer.parseInt(day);
		System.out.println("today : " + iday);
		// 필요한 값 꺼내오기		
		String jd_account = "";
		String account = "";
		int money = 0;
		//자동이체 db의 값을 조회
		List<AutoTransferDTO> list = dao.auto_List(iday);
			for(int i = 0; i < list.size(); i++ ) {
				jd_account = list.get(i).getJd_account();
				account = list.get(i).getAccount_num();
				money = list.get(i).getJd_auto_money();
				System.out.println("출금계좌 : " + jd_account + " 입금계좌 : " + account + " 출금금액 : " + money );
				//가지고 온 값을 map에 담아 자동 감소 진행
				int deCnt = 0;	//값 초기화
				int inCnt = 0;	//값 초기화	
			
				Map<String , Object> de_map = new HashMap<String, Object>();
				de_map.put("jd_account", jd_account);
				de_map.put("money", money);
				deCnt = dao.auto_decreament(de_map); 	//자동 감소
				System.out.println("감소 확인 : " + deCnt);
			
			//가지고 온 값을 map에 담아 자동 증가 진행
				Map<String , Object> in_map = new HashMap<String, Object>();
				in_map.put("account_num", account);
				in_map.put("money", money);
				inCnt = dao.auto_increament(in_map); 	//자동 증가
				System.out.println("증가 확인 : " + inCnt);
				
				if(inCnt == 1) { 	
				int history = dao.auto_history(); 		//db 인서트
				System.out.println("DB 인서트 : " + history);
			}
				   //sms
	         //   HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	         //   String id = (String)req.getSession().getAttribute("customerID");
	            String phone = "01066039907";
	            Sms sms= new Sms(); 
	            sms.sendSMS(jd_account, account, money, phone );
		}
	}
	@Override
	//고객 계좌 조회
	public void customer_Account_Search(HttpServletRequest req, Model model) {
		System.out.println("[service - customer_Account_Search]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		
		List<AccountDTO> list =	dao.customer_Account_Search(id);
		
		for(AccountDTO dto : list) {
			System.out.println("dto : " + dto);
		}
		System.out.println("id" + id );
		
		model.addAttribute("list", list);
		
	}
	
}
