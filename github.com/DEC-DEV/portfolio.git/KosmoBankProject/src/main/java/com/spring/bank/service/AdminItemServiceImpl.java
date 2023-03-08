package com.spring.bank.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.AdminItemDAO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.util.Paging;

@Service
public class AdminItemServiceImpl implements AdminItemService{
	
	@Autowired
	AdminItemDAO dao;

	//----------------------- [ 대출 ] -----------------------------------
	// 관리자 대출 상품 등록 - 현우
	@Override
	public void loan_pro_add(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_add");
		// 상품명
		String d_name = req.getParameter("d_name");
		// 대출금리
		double d_interest_rate = Double.parseDouble(req.getParameter("d_interest_rate"));
		// 최소대출금액
		long d_min_price = Long.parseLong(req.getParameter("d_min_price"));
		// 최대대출금액
		long d_max_price = Long.parseLong(req.getParameter("d_max_price"));
		// 최소대출기간
		int d_min_date = Integer.parseInt(req.getParameter("d_min_date"));
		// 최대대출기간
		int d_max_date = Integer.parseInt(req.getParameter("d_max_date"));
		// 중도상환수수료율
		int d_prepayment_fee = Integer.parseInt(req.getParameter("d_prepayment_fee"));
		// 상품설명
		String d_explanation1 = req.getParameter("d_explanation1");
		// 상환방법
		String d_repay = req.getParameter("d_repay");
		
		Loans_itemDTO dto = new Loans_itemDTO();
		dto.setD_name(d_name);
		dto.setD_interest_rate(d_interest_rate);
		dto.setD_min_price(d_min_price);
		dto.setD_max_price(d_max_price);
		dto.setD_min_date(d_min_date);
		dto.setD_max_date(d_max_date);
		dto.setD_prepayment_fee(d_prepayment_fee);
		dto.setD_explanation1(d_explanation1);
		dto.setD_repay(d_repay);
		
		int insertCnt = dao.loan_pro_add(dto);
		System.out.println("loan_pro_add의 insertCnt : " + insertCnt);
	}

	// 관리자 대출 상품 목록
	@Override
	public void loan_pro_list(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_list");
		
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);
		
		int total = dao.loan_cnt();
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<Loans_itemDTO> list = null;

	    if(total > 0) {
	       Map<String, Object> map = new HashMap<String, Object>();
	       map.put("start", start);
	       map.put("end", end);
	       list = dao.loan_pro_list(map);
	       
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	    }
	}

	// 관리자 대출상세페이지
	@Override
	public void loan_pro_detail(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_detail");
		
		String d_name = req.getParameter("d_name");
	    String pageNum = req.getParameter("pageNum");
	    System.out.println("pageNum : " + pageNum);
	    
	    Loans_itemDTO dto = dao.loan_pro_detail(d_name);
	    
	    model.addAttribute("dto", dto);
	    model.addAttribute("pageNum", pageNum);
	}

	// 관리자 대출 상품 수정
	@Override
	public void loan_pro_update(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_update");
		
		String hiddend_name = (req.getParameter("hiddend_name"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		try {
			// 상품명
			String d_name = req.getParameter("d_name");
			// 대출금리
			double d_interest_rate = Double.parseDouble(req.getParameter("d_interest_rate"));
			// 최소대출금액
			long d_min_price = Long.parseLong(req.getParameter("d_min_price"));
			// 최대대출금액
			long d_max_price = Long.parseLong(req.getParameter("d_max_price"));
			// 최소대출기간
			int d_min_date = Integer.parseInt(req.getParameter("d_min_date"));
			// 최대대출기간
			int d_max_date = Integer.parseInt(req.getParameter("d_max_date"));
			// 중도상환수수료율
			int d_prepayment_fee = Integer.parseInt(req.getParameter("d_prepayment_fee"));
			// 상품설명
			String d_explanation1 = req.getParameter("d_explanation1");
			// 상환방법
			String d_repay = req.getParameter("d_repay");
			
			Loans_itemDTO dto = new Loans_itemDTO();
			dto.setD_name(d_name);
			dto.setD_interest_rate(d_interest_rate);
			dto.setD_min_price(d_min_price);
			dto.setD_max_price(d_max_price);
			dto.setD_min_date(d_min_date);
			dto.setD_max_date(d_max_date);
			dto.setD_prepayment_fee(d_prepayment_fee);
			dto.setD_explanation1(d_explanation1);
			dto.setD_repay(d_repay);
			System.out.println("dto" + dto);
			
			int updateCnt = dao.loan_pro_update(dto);
			
			model.addAttribute("updateCnt", updateCnt);
			model.addAttribute("hiddend_name", hiddend_name);
			model.addAttribute("pageNum", pageNum);
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 관리자 대출 상품 삭제
	@Override
	public void loan_pro_delete(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_update");
		
		String d_name = req.getParameter("d_name");
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		int deleteCnt = dao.loan_pro_delete(d_name);
		
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		
		
		
	}

	// 관리자 대출 신청자 리스트
	@Override
	public void loan_pro_detail_list(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_pro_detail_list");
		
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);
		
		int total = dao.loan_cnt();
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<LoansDTO> list = null;

	    if(total > 0) {
	       Map<String, Object> map = new HashMap<String, Object>();
	       map.put("start", start);
	       map.put("end", end);
	       list = dao.loan_pro_detail_list(map);
	       
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	    }
	
	}

	// 관리자 대출 승인
	@Override
	public void loan_approve(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_approve");
		
		String[] item = req.getParameterValues("item");
		
		for(int i=0; i < item.length; i ++) {
			int j = 0;
			
			String item1 = item[i];
			String[] item3 = item1.split(",");
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("d_num", item3[j]);	// d_num
			map.put("d_name", item3[j+1]);	// d_name
			int updateCnt = dao.loan_approve(map);
			System.out.println("f_num" + item3[j]);
			System.out.println("id" + item3[j+1]);
		
			model.addAttribute("updateCnt", updateCnt);
			System.out.println("updateCnt" + updateCnt);
		}
	}

	// 관리자 대출 거절
	@Override
	public void loan_deny(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_deny");
		
		String[] item = req.getParameterValues("item");
		
		for(int i=0; i < item.length; i ++) {
			int j = 0;
			
			String item1 = item[i];
			String[] item3 = item1.split(",");
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("d_num", item3[j]);	
			map.put("d_name", item3[j+1]);	
			int deleteCnt = dao.loan_delete(map);
			System.out.println("f_num" + item3[j]);
			System.out.println("id" + item3[j+1]);
		
			model.addAttribute("deleteCnt", deleteCnt);
			System.out.println("deleteCnt" + deleteCnt);
		}
	}

	// 관리자 대출 상세페이지
	@Override
	public void loan_detail_list(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_detail_list");
		
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		String pageNum = req.getParameter("pageNum");
		
		LoansDTO dto = dao.loan_detail(d_num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
	}

	// 관리자 대출 수정페이지
	@Override
	public void loan_update_detail_list(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_update_detail_list");
		
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		LoansDTO dto = new LoansDTO();
		dto.setD_num(Integer.parseInt(req.getParameter("d_num")));
		dto.setD_name(req.getParameter("d_name"));
		dto.setAccount_num(req.getParameter("account_num"));
		
		String strDate = req.getParameter("d_start_date");
		Date date = Date.valueOf(strDate);
		dto.setD_start_date(date);
		
		String strDate2 = req.getParameter("d_end_date");
		Date date2 = Date.valueOf(strDate2);
		dto.setD_end_date(date2);
		
		dto.setD_month(Integer.parseInt(req.getParameter("d_month")));
		dto.setD_repay(req.getParameter("d_repay"));
		dto.setD_rate(Integer.parseInt(req.getParameter("d_rate")));
		System.out.println("dto " + dto);
		int updatecnt = dao.loan_update_action(dto);
		System.out.println("updatecnt " + updatecnt);
		model.addAttribute("updatecnt", updatecnt);
		model.addAttribute("pageNum", pageNum);
		
		
	}

	// 관리자 대출 삭제페이지
	@Override
	public void loan_delete_detail_list(HttpServletRequest req, Model model) {
		System.out.println("adminItemServiceImpl - loan_delete_detail_list");
		
		int d_num = Integer.parseInt(req.getParameter("d_num"));
		String pageNum = req.getParameter("pageNum");
		
		int deleteCnt = dao.loan_delete_action(d_num);

		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
	}
}
