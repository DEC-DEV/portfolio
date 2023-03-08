package com.spring.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.spring.bank.dao.AdminTotalDAOImpl;
import com.spring.bank.dto.TotalChartDTO;
@Service
public class AdminTotalServiceImpl implements AdminTotalService{
	
	@Autowired
	AdminTotalDAOImpl AdminTotalDAO;

	@Override
	public TotalChartDTO productsignTotal(HttpServletRequest req, Model model) {
		TotalChartDTO dto = AdminTotalDAO.productsignTotal();
		model.addAttribute("dto",dto);
		return dto;
	}

	@Override
	public TotalChartDTO product_blanace(HttpServletRequest req, Model model) {
		System.out.println("product_blanace service start ");
		Map<String,String> map = new HashMap<String,String>();
		map.put("start", "20210101");
		map.put("end", "20211231");
		
		List<TotalChartDTO> deposit_list = AdminTotalDAO.deposit_blanace( map);
		List<TotalChartDTO> saving_list = AdminTotalDAO.saving_blanace( map);
		String deposit = new Gson().toJson(deposit_list);
		String saving =new Gson().toJson(saving_list);
		System.out.println("제이슨 결과2 = " + deposit );
		System.out.println("?? :"+saving);
		model.addAttribute("deposit",deposit);
		model.addAttribute("saving",saving);
		return null;
	}

	@Override
	public TotalChartDTO loans_product_blanace(HttpServletRequest req, Model model) {
		 List<TotalChartDTO> loans_list = AdminTotalDAO.loans_product_blanace();
		 
		 // 값 일치 시킴
		 for( int i = 0; i< loans_list.size(); i++ ) {
			for(TotalChartDTO dtos :  loans_list) {
				if (dtos.getD_name().equals(loans_list.get(i).getD_name())) {
					// 1월 
					if(dtos.getJan()  <= 0) {
						dtos.setJan(dtos.getJan()  + loans_list.get(i).getJan() );
					}
					// 2월
					if(dtos.getFeb()  <= 0) {
						dtos.setFeb(dtos.getFeb()  + loans_list.get(i).getFeb() );
					}
					// 3월
					if(dtos.getMar() <= 0) {
						dtos.setMar(dtos.getMar()  + loans_list.get(i).getMar() );
					}
					// 4월
					if(dtos.getApr()  <= 0) {
						dtos.setApr(dtos.getApr()  + loans_list.get(i).getApr() );
					}
					// 5월
					if(dtos.getMay()  <= 0) {
						dtos.setMay(dtos.getMay()  + loans_list.get(i).getMay() );
					}
					// 6월
					if(dtos.getJun()  <= 0) {
						dtos.setJun(dtos.getJun()  + loans_list.get(i).getJun() );
					}
					// 7월
					if(dtos.getJul()  <= 0) {
						dtos.setJul(dtos.getJul()  + loans_list.get(i).getJul() );
					}
					// 8월
					if(dtos.getAug()  <= 0) {
						dtos.setAug(dtos.getAug()  + loans_list.get(i).getAug() );
					}
					// 9월
					if(dtos.getSep()  <= 0) {
						dtos.setSep(dtos.getSep()  + loans_list.get(i).getSep() );
					}
					// 10월
					if(dtos.getOct()  <= 0) {
						dtos.setOct(dtos.getOct()  + loans_list.get(i).getOct() );
					}
					// 11월
					if(dtos.getNov()  <= 0) {
						dtos.setNov(dtos.getNov()  + loans_list.get(i).getNov() );
					}
					// 12월
					if(dtos.getDec()  <= 0) {
						dtos.setDec(dtos.getDec()  + loans_list.get(i).getDec() );
					}
				}
			}
		 }
		 
		 // 중복 제거
//		 List<TotalChartDTO> list2  = AdminTotalDAO.loans_product_blanace();
//		 for (TotalChartDTO dto : loans_list) {
//			for( int i = 0; i<list2.size(); i++ ) {
//				try {
//					if(dto.getD_name().equals(list2.get(i).getD_name())) {
//						list2.remove(i);
//					}
//				}catch(Exception ex) {
//					ex.printStackTrace();
//				}
//			}
//		 }
//		 System.out.println("중복제거 : "+list2.size());
//		 System.out.println("대출 : "+list2);
		 
		 // json으로 변경
//		 loans_list.remove(6);
		 for(TotalChartDTO dto :loans_list) {
			 System.out.println(dto.toString());
		 }
		 String loans =new Gson().toJson(loans_list);
		 model.addAttribute("loans",loans);
		return null;
	}

	@Override
	public TotalChartDTO fund_product_blanace(HttpServletRequest req, Model model) {
		List<TotalChartDTO> fund_list = AdminTotalDAO.fund_product_blanace();
		 String fund =new Gson().toJson(fund_list);
		 System.out.println("펀드 :"+fund);
		 model.addAttribute("fund",fund);
		return null;
	}

	@Override
	public void loansTotal(HttpServletRequest req, Model model) {
		List<TotalChartDTO> loansTotal = AdminTotalDAO.loansTotal();
		String Total =new Gson().toJson(loansTotal);
		System.out.println(Total.toString());
		model.addAttribute("loan_total",Total);
	}

	@Override
	public void fundTotal(HttpServletRequest req, Model model) {
		List<TotalChartDTO> fundTotal = AdminTotalDAO.fundTotal();
		String Total =new Gson().toJson(fundTotal);
		System.out.println(Total.toString());
		model.addAttribute("fund_total",Total);		
	}
	
	public void loansbarChartTotal(HttpServletRequest req, Model model) {
		List<TotalChartDTO> loansbarChartTotal = AdminTotalDAO.loansbarChartTotal();
		String Total =new Gson().toJson(loansbarChartTotal);
		System.out.println(Total.toString());
		model.addAttribute("loansbar",Total);		
	}
}
