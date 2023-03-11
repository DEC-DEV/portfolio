
package com.spring.bank.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.AccountDAOImpl;
import com.spring.bank.dao.AdminCustomerDAO;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.TransferDTO;
import com.spring.bank.util.Paging;

@Service
public class AdminCustomerServiceImpl implements AdminCustomerService {
	@Autowired
	AdminCustomerDAO ACdao;
	@Autowired
	AccountDAOImpl AccountDAO;

	// 회원별 계좌 관리
	@Override
	public void account_info(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_info");

		// 페이지
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);

		// account 카운트
		int total = ACdao.accountCnt(); // 회원수 카운트
		paging.setTotalCount(total);
		System.out.println("total =>" + total);

		int start = paging.getStartRow(); // 페이지별 시작번호
		int end = paging.getEndRow(); // 페이지별 끝번호
		System.out.println("start => " + start);
		System.out.println("end => " + end);

		// map에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);

		List<AccountDTO> list = ACdao.account_info(map);
		System.out.println("list =>" + list);

		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

	}

	// 관리자 - 회원 계좌 비밀번호 변경처리
	@Override
	public void account_password_update(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_password_update");
		String account_num = req.getParameter("account_num");
		System.out.println("account_num : " + account_num);
		String id = req.getParameter("id");
		System.out.println("id : " + id);

		String account_password = req.getParameter("account_password");
		System.out.println("account_password : " + account_password);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account_num", account_num);
		map.put("id", id);
		map.put("account_password", account_password);

		/*
		 * AccountDTO dto = new AccountDTO();
		 * 
		 * dto.setAccount_num(account_num); dto.setAccount_password(account_password);
		 */

		int passwordCnt = ACdao.account_password_update(map);
		model.addAttribute("passwordCnt", passwordCnt);

	}

	// 관리자 - 회원 계좌 상태 변경
	@Override
	public void account_state(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_state");
		String account_num = req.getParameter("account_num");
		System.out.println("account_num : " + account_num);
		String account_state = req.getParameter("account_state");
		System.out.println("account_state : " + account_state);

		AccountDTO dto = new AccountDTO();
		dto.setAccount_num(account_num);
		dto.setAccount_state(account_state);

		int stateCnt = ACdao.account_state(dto);
		model.addAttribute("stateCnt", stateCnt);
	}

	// 관리자 - 회원 계좌이체 내역 리스트
	@Override
	public void account_transfer_history(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_transfer_history");

		// 페이지
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);

		// 계좌이체 내역수 카운트
		int total = ACdao.historyCnt(); // 회원수 카운트
		paging.setTotalCount(total);
		System.out.println("total =>" + total);

		int start = paging.getStartRow(); // 페이지별 시작번호
		int end = paging.getEndRow(); // 페이지별 끝번호
		System.out.println("start => " + start);
		System.out.println("end => " + end);

		// map에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);

		List<TransferDTO> list = ACdao.account_transfer_history(map);
		System.out.println("list =>" + list);

		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

	}

	// 관리자 - 회원 한도변경 승인
	@Override
	public void account_limit_ok(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_limit_ok");

		String account_num = req.getParameter("account_num");
		System.out.println("account_num : " + account_num);
		int account_limit = Integer.parseInt(req.getParameter("account_limit"));
		System.out.println("account_limit : " + account_limit);

		AccountDTO dto = new AccountDTO();
		dto.setAccount_num(account_num);
		dto.setAccount_limit(String.valueOf(account_limit));
		int limitCnt = ACdao.account_limit_ok(dto);
		
		AccountDAO.account_limit_approve(account_num);

		model.addAttribute("limitCnt", limitCnt);

	}

	// 환율 정보
	@Override
	public void exchange_detail(HttpServletRequest req, Model model) {
		System.out.println("서비스 => exchange_detail");
		// 자바 엑셀 읽어오기 https://crosstheline.tistory.com/93 참조
		// pom.xml -> Apache POI 확인 버전 중요!

		int rowIndex = 0;
		int columnIndex = 0;

		List<Map<String, Object>> exchangeList = new ArrayList<Map<String, Object>>();

		try { //        
			FileInputStream file =  new FileInputStream("/var/app/current/resources/customer/excel/exchange.xlsx");
			
			// xlsx 파일 사용 시(2007 이상 버전) 일때 사용
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// 0번째 시트를 가져온다
			// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			XSSFSheet sheet = workbook.getSheetAt(0); // 시트 수 (첫번째에만 존재하므로 0을 준다)

			// 행의 수
			// 만약 시트가 여러개 인 경우 for 문을 이용하여 각각의 시트를 가져온다.
			int rows = sheet.getPhysicalNumberOfRows(); // 시용자가 입력한 엑셀 Row수를 가져온다.
			for (rowIndex = 1; rowIndex < rows; rowIndex++) { // rowIndex = 1; 부터 시작하는 이유는 엑셀표에 1번째가 0이기때문이다
				// 행을읽는다
				XSSFRow row = sheet.getRow(rowIndex);

				Map<String, Object> exMap = new LinkedHashMap<String, Object>();

				if (row != null) { // 행이 널이 아니면 포문을 돌아
					// 셀의 수
					int i = 1;
					int cells = row.getPhysicalNumberOfCells(); // 해당 Row에 사용자가 입력한 셀의 수를 가져온디.
					for (columnIndex = 0; columnIndex <= cells; columnIndex++) {
						// 셀값을 읽는다
						XSSFCell cell = row.getCell(columnIndex); // 셀의 값을 가져온다.
						String value = ""; // 엑셀에 있는 데이터를 스트링으로 변환(?) 숫자도 문자로 변환?
						// 셀이 빈값일경우를 위한 널체크
						if (cell == null) {
							continue;
						} else {
							// 타입별로 내용 읽기
							switch (cell.getCellType()) { // 각셀의 데이터 값을 가져올때 맞는 데이터형으로 분류한다.

							// FORMULA(수식)
							// Apache POI-> 제공하는 HSSFCell 에는 모두 6가지의 Cell Type이 있다.
							case XSSFCell.CELL_TYPE_FORMULA: // 수식 자체를 가져올 때
								value = cell.getCellFormula();
								break;
							case XSSFCell.CELL_TYPE_NUMERIC: // 데이터 타입이 숫자일 때
								value = cell.getNumericCellValue() + "";
								break;
							case XSSFCell.CELL_TYPE_STRING: // 수식 반환값이 문자 일 때
								value = cell.getStringCellValue() + "";
								exMap.put("column" + i, value); // 셀 값을 하나씩 읽어서 맵에 담는다.
								break;
							case XSSFCell.CELL_TYPE_BLANK:// 빈칸
								value = cell.getBooleanCellValue() + "";
								break;
							case XSSFCell.CELL_TYPE_ERROR: // 에러
								value = cell.getErrorCellValue() + "";
								break;
							}
							i++; // 포문
						}
					}
					exchangeList.add(exMap); // 한 나라의 정보가 담긴 맵을 리스트에 담는다.
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("exchangeList", exchangeList); // 키값 전달
	}

	
	 
	 // 계좌 정보 검색
	 
	 @Override 
	 public void account_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_search");
		// 화면에서 입력받은 값
		String col = req.getParameter("col");
		String keyword = req.getParameter("keyword");
		keyword = "%" + keyword + "%";
		System.out.println("col : " + col);
		System.out.println("keyword : " + keyword);
	
	
		// map에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("col", col);
		map.put("keyword", keyword);
	
		List<AccountDTO> list = ACdao.account_search(map);
		System.out.println("list =>" + list);
	
		model.addAttribute("list", list);
		 
		 
		 }
	 
	
	// 계좌이체 검색
	@Override
	public void account_transfer_history_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 => account_transfer_history_search");

		// 화면에서 입력받은 값
		String col = req.getParameter("col");
		String keyword = req.getParameter("keyword");
		keyword = "%" + keyword + "%";
		System.out.println("col : " + col);
		System.out.println("keyword : " + keyword);
//
//		// 페이지
//		String pageNum = req.getParameter("pageNum");
//		Paging paging = new Paging(pageNum);
//
//		int start = paging.getStartPage(); // 페이지별 시작번호
//		int end = paging.getEndRow(); // 페이지별 끝번호
//		System.out.println("start => " + start);
//		System.out.println("end => " + end);

		// map에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("col", col);
		map.put("keyword", keyword);
//		map.put("start", start);
//		map.put("end", end);

//		// transfer_history_search 카운트
//		Map<String, Object> searchMap = new HashMap<String, Object>();
//		searchMap.put("col", col);
//		searchMap.put("keyword", keyword);
//
//		int total = ACdao.historySearchCnt(searchMap); // 계좌이체 검색수 카운트
//		paging.setTotalCount(total);
//		System.out.println("total =>" + total);

		List<TransferDTO> list = ACdao.account_transfer_history_search(map);
		System.out.println("list =>" + list);

		model.addAttribute("list", list);
//		model.addAttribute("paging", paging);

	}

}
