package com.spring.bank.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.bank.dao.ItemDAO;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.DepositDTO;
import com.spring.bank.dto.Deposit_itemDTO;
import com.spring.bank.dao.ItemDAOImpl;
import com.spring.bank.dto.FundDTO;
import com.spring.bank.dto.FundMemberDTO;
import com.spring.bank.dto.SavingsDTO;
import com.spring.bank.dto.Savings_itemDTO;
import com.spring.bank.util.Paging;
//LJH, 2022-04-18
//LJH, 2022-04-20
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAOImpl dao;

	// 펀드 등록
	@Override
	public void fundadd(MultipartHttpServletRequest req, Model model) throws IOException {
		System.out.println("서비스 fundadd - 펀드등록");
		
	  // 추가 시작
      MultipartFile file = req.getFile("f_filename");
      System.out.println("file : " + file);

      // 저장경로
      String saveDir = req.getSession().getServletContext().getRealPath("/resources/img/fund/");
      
      // 발표자 경로
      //String saveDir = req.getSession().getServletContext().getRealPath("/resources/img/fund/");
      System.out.println("saveDir : " + saveDir);

      // 저장경로(jsp의 IMG_UPLOAD_DIR)
//      String realDir = "C:\\Users\\USER\\git\\BankProject\\BankProjectKosmo\\KosmoBankProject\\src\\main\\webapp\\resources\\img";
      
      // 발표자 경로
      String realDir ="C:\\Users\\웅\\git\\BankProjectKosmo\\KosmoBankProject\\src\\main\\webapp\\resources\\img";
      System.out.println("realDir : " + realDir);

      try {
    	  file.transferTo(new File(saveDir + file.getOriginalFilename()));

    	  FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
    	  FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());

    	  int data = 0;

    	  while((data = fis.read()) != -1)  {
    		  fos.write(data);
    	  }
    	  fis.close();
    	  fos.close();

    	  // 추가 끝 ---------------------------------------------------
		
		FundDTO dto = new FundDTO();
		
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println(strId);
		dto.setId(strId);
		// 수정 S ---------------------------------------------------
	    String p_img1 = "/bank/resources/img/fund/" + file.getOriginalFilename();  // 플젝명/경로
	    System.out.println("dto.getPdImg() : " + p_img1);
	    // 수정 E ---------------------------------------------------

	    dto.setF_filename(p_img1);
		dto.setF_category(req.getParameter("f_category"));
		dto.setF_start_date(req.getParameter("f_start_date"));
		dto.setF_end_date(req.getParameter("f_end_date"));
		dto.setF_target_money(Integer.parseInt(req.getParameter("f_target_money")));
		dto.setF_account(req.getParameter("f_account"));
		dto.setF_title(req.getParameter("f_title"));
		dto.setF_content(req.getParameter("f_content"));
		dto.setF_name(req.getParameter("f_name"));
		dto.setF_email(req.getParameter("f_email"));
		dto.setF_phone(req.getParameter("f_phone"));
		System.out.println("dto " + dto);
		int insertCnt = dao.fundinsert(dto);
	    System.out.println("insertCnt : " + insertCnt);  // 정상 : 1
		
	   model.addAttribute("insertCnt", insertCnt);
      	} catch(IOException e) {
	    	  e.printStackTrace();
	      }

      }
	// 펀드목록
	@Override
	public void fundlist(HttpServletRequest req, Model model) {
		System.out.println("서비스 fundlist - 펀드목록");
		
		String pageNum = req.getParameter("pageNum");
		//4단계
		//5-1단계
		Paging page = new Paging(pageNum);
		int total = dao.fundcnt();
		//페이지 카운트
		page.setTotalCount(total);
		//페이지 별 시작번호
		int start = page.getStartRow();
		//페이지 별 끝 번호
		int end = page.getEndRow();
		Paging paging = new Paging(pageNum);
		
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		
		List<FundDTO> list = null;

	    if(total > 0) {
	       Map<String, Object> map = new HashMap<String, Object>();
	       map.put("start", start);
	       map.put("end", end);
	       list = dao.fundlist(map);
	       
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	    }
		
	}
	
	// 펀드목록 카테고리 별
	@Override
	public void fund_category_list(HttpServletRequest req, Model model) {
		System.out.println("서비스 fund_category_list - 펀드목록");
		
		String pageNum = req.getParameter("pageNum");
		//4단계
		//5-1단계
		Paging page = new Paging(pageNum);
		int total = dao.fundcnt();
		//페이지 카운트
		page.setTotalCount(total);
		//페이지 별 시작번호
		int start = page.getStartRow();
		//페이지 별 끝 번호
		int end = page.getEndRow();
		Paging paging = new Paging(pageNum);
		
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		// 카테고리
		String f_category = req.getParameter("f_category");
		System.out.println("f_category gfdgdfgfdgdfgdggdfgd: " + f_category);
		
		List<FundDTO> list = null;

	    if(total > 0) {
	       Map<String, Object> map = new HashMap<String, Object>();
	       map.put("start", start);
	       map.put("end", end);
	       map.put("f_category", f_category);
	       list = dao.fund_category_list(map);
	       
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	    }
		
	}
	
	
	// 펀드상세
	@Override
	public void funddetail(HttpServletRequest req, Model model) {
		System.out.println("서비스 funddetail - 펀드상세페이지");
		
		String id = (String)req.getSession().getAttribute("customerID");
		int f_num = Integer.parseInt(req.getParameter("f_num"));
	    String pageNum = req.getParameter("pageNum");
	    System.out.println("pageNum : " + pageNum);
	    System.out.println("id : " + id);
	    System.out.println("f_num" + f_num);
	    
	    
	    // 펀드상세
	    FundDTO dto = dao.getfunddetail(f_num);
	    // 펀드참가 멤버 수
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("id", id);
	    map.put("f_num", f_num);
	    String total = dao.membertotal(map);
	    // 모인금액
	    Map<String, Object> map2 = new HashMap<String, Object>();
	    map2.put("id", id);
	    map2.put("f_num", f_num);
	    String price = dao.totalprice(map2);
	    
	    String title = dao.title(map2);
	    
	    model.addAttribute("dto", dto);
	    model.addAttribute("pageNum", pageNum);
	    model.addAttribute("total", total);
	    model.addAttribute("price", price);
	    // 상품명 가져오기
	    model.addAttribute("title", title);	
	}
	
	// 펀드구매
	@Override
	public void fundbuy(HttpServletRequest req, Model model) {
		System.out.println("서비스 funddetail - fundbuy");
		
		String id = (String)req.getSession().getAttribute("customerID");
		int f_num = Integer.parseInt(req.getParameter("f_num"));
		System.out.println("fund_buy : "+f_num);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		// 회원이름
		map.put("f_num", f_num);
		String name = dao.name(map);
		// f_num
		
		// 펀드 제목
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("f_num", f_num);
		map2.put("id", id);
		String title = dao.title(map2);
		System.out.println("title : "+title);
		model.addAttribute("f_num",f_num);
		model.addAttribute("name", name);
		model.addAttribute("title",title);

	}
		
	// 펀드 멤버 등록
	@Override
	public void fundmemberadd(HttpServletRequest req, Model model) {
		System.out.println("서비스 fundmemberadd - 펀드상세페이지");
		
		String id = (String)req.getSession().getAttribute("customerID");
		
		FundMemberDTO dto = new FundMemberDTO();
		
		dto.setF_num(Integer.parseInt(req.getParameter("f_num")));
		dto.setId(id);
		dto.setF_money(Integer.parseInt(req.getParameter("f_money")));
		// dto.setF_account(req.getParameter("f_account")); -- jsp에서 f_account를 넘기는 곳이 없어 주석 임의 값 부여
		dto.setF_account("카카오페이");
		dto.setF_date(new Timestamp(System.currentTimeMillis()));
		System.out.println("dto " + dto);
		int insertCnt = dao.fundmemberadd(dto);
	    System.out.println("insertCnt : " + insertCnt);  // 정상 : 1
		
	    model.addAttribute("id", id);
	    model.addAttribute("insertCnt", insertCnt);
	}
	
	//적금 상품 수정처리
	@Override
	public void savings_Update_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - savings_Update_Action]");
		
		Savings_itemDTO dto = new Savings_itemDTO();
		
		dto.setI_no(Integer.parseInt(req.getParameter("i_no")));
		dto.setI_name(req.getParameter("i_name")); 
		dto.setI_summary(req.getParameter("i_summary")); 
		dto.setI_rate(Double.parseDouble(req.getParameter("i_rate"))); 
		dto.setI_type(Integer.parseInt(req.getParameter("i_type")));
		dto.setI_min_date(Integer.parseInt(req.getParameter("i_min_date")));
		dto.setI_max_date(Integer.parseInt(req.getParameter("i_max_date")));
		dto.setI_auto_date(req.getParameter("i_auto_date"));	
		dto.setI_notice(req.getParameter("i_notice"));
		
		System.out.println("dto : " + dto);
		
		int updateCnt = dao.savings_Update(dto);
		
		model.addAttribute("updateCnt", updateCnt);
		
	}
	//적금 상품 삭제처리
	@Override
	public void savings_Delete_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - savings_Delete_Action]");
		
		int i_no = Integer.parseInt(req.getParameter("i_no"));
		System.out.println("num : " + i_no);
		 
		int deleteCnt = dao.savings_Delete(i_no);
		 
		System.out.println("deleteCNt : " + deleteCnt );
		
		model.addAttribute("deleteCnt", deleteCnt);
		
	}
	//적금 상품 상세
	@Override
	public void savings_Detail_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - savings_Detail_Action]");
		
		int i_no = Integer.parseInt(req.getParameter("i_no"));
		
		Savings_itemDTO dto = new Savings_itemDTO();
		// 계좌 정보 불러오기 추가  2022-05-03 최웅
		String id = (String)req.getSession().getAttribute("customerID");
		List<AccountDTO> list = dao.customer_Account_Search(id);
		// list 등록
		model.addAttribute("list",list);
		dto = dao.savings_Detail(i_no);
		
		
		
		model.addAttribute("dto", dto);
	}

	//----------------------------------예금----------------------------------------

	
	
	//예금 리스트 조회
	@Override
	public void deposit_List_Search(HttpServletRequest req, Model model) {
		System.out.println("[Service - deposit_List_Search]");
		
		String pageNum = req.getParameter("pageNum");
		
		Paging page = new Paging(pageNum);
		int total = dao.deposit_item_Count();
		
		page.setTotalCount(total);
		
		int start = page.getStartRow();
		int end = page.getEndRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<Deposit_itemDTO> list = dao.deposit_List(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", page);
		
	}
	
	//예금 추가 처리
	@Override
	public void deposit_Add_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - deposit_Add_Action]");
		
		Deposit_itemDTO dto = new Deposit_itemDTO();
		
		dto.setY_name(	req.getParameter("y_name"));
		dto.setY_summary(req.getParameter("y_summary"));
		dto.setY_interest_rate(Double.parseDouble(req.getParameter("y_interest_rate")));
		dto.setY_type(Integer.parseInt(req.getParameter("y_type")));
		dto.setY_start_date(Integer.parseInt(req.getParameter("y_start_date")));
		dto.setY_end_date(Integer.parseInt(req.getParameter("y_start_date")));
		dto.setY_min_price(Integer.parseInt(req.getParameter("y_min_price")));
		dto.setY_notice(req.getParameter("y_notice"));
	
		int insertCnt = dao.deposit_Add(dto);
		
		model.addAttribute("insertCnt", insertCnt);
		
	}
	//예금 수정 처리
	@Override
	public void deposit_Update_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - deposit_Update_Action]");
		
		Deposit_itemDTO dto = new Deposit_itemDTO();
		// y_no 값이 dto에 전달되지 않아 추가
		dto.setY_no(Integer.parseInt( req.getParameter("y_no") ));
		
		dto.setY_name(	req.getParameter("y_name"));
		dto.setY_summary(req.getParameter("y_summary"));
		dto.setY_interest_rate(Double.parseDouble(req.getParameter("y_interest_rate")));
		dto.setY_type(Integer.parseInt(req.getParameter("y_type")));
		dto.setY_start_date(Integer.parseInt(req.getParameter("y_start_date")));
		dto.setY_end_date(Integer.parseInt(req.getParameter("y_start_date")));
		dto.setY_min_price(Integer.parseInt(req.getParameter("y_min_price")));
		dto.setY_notice(req.getParameter("y_notice"));
		int updateCnt = dao.deposit_Update(dto);
		
		model.addAttribute("updateCnt", updateCnt);
		
	}
	//예금 삭제 처리
	@Override
	public void deposit_Delete_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - deposit_Delete_Action]");
		
		int y_no = Integer.parseInt(req.getParameter("y_no"));
		
		int deleteCnt =	dao.deposit_Delete(y_no);
		model.addAttribute("deleteCnt", deleteCnt);
	}	
		//예금 상세
		@Override
		public void deposit_Detail_Action(HttpServletRequest req, Model model) {
		System.out.println("[Service - deposit_Detail_Action]");
		
		int y_no = Integer.parseInt(req.getParameter("y_no"));
		
		Deposit_itemDTO  dto = new Deposit_itemDTO();
		
		// 계좌 정보 불러오기 추가  2022-05-03 최웅
		String id = (String)req.getSession().getAttribute("customerID");
		List<AccountDTO> list = dao.customer_Account_Search(id);
		// list 등록
		model.addAttribute("list",list);
		dto = dao.deposit_Detail(y_no);
		
		model.addAttribute("dto", dto);
		
		}
		// 커밋된 버전
		@Override
		public void savings_Add_Action(HttpServletRequest req, Model model) {
			System.out.println("[Service - savings_Add_Action]");
			//적금 상품 등록 처리
			Savings_itemDTO dto = new Savings_itemDTO();
			
			dto.setI_name(req.getParameter("i_name")); 
			dto.setI_summary(req.getParameter("i_summary")); 
			dto.setI_rate(Double.parseDouble(req.getParameter("i_rate"))); 
			dto.setI_type(Integer.parseInt(req.getParameter("i_type")));
			dto.setI_min_date(Integer.parseInt(req.getParameter("i_min_date")));
			dto.setI_max_date(Integer.parseInt(req.getParameter("i_max_date")));
			dto.setI_auto_date(req.getParameter("i_auto_date"));	
			dto.setI_notice(req.getParameter("i_notice"));
			
			System.out.println("dto : " + dto);
			int insertCnt = dao.savings_Add(dto);
			
			model.addAttribute("insertCnt", insertCnt);
		}
		//적금 상품 조회
		@Override
		public void savings_List_Search(HttpServletRequest req, Model model) {
			System.out.println("[Service - savings_List_Search]");
		
		// 페이징
		String pageNum = req.getParameter("pageNum");
		//4단계
		//5-1단계
		Paging page = new Paging(pageNum);
		int total = dao.savings_item_Count();
		System.out.println("total: " + total);
		//페이지 카운트
		page.setTotalCount(total);
		//페이지 별 시작번호
		int start = page.getStartRow();
		//페이지 별 끝 번호
		int end = page.getEndRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<Savings_itemDTO> list = dao.savings_List(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", page);	
		

	}
	//예금 상품 신청 - 고객
	@Override
	public void customer_deposit_add(HttpServletRequest req, Model model) {
		System.out.println("[Service - customer_deposit_add]");
		
		DepositDTO dto = new DepositDTO();
		
		String id = (String)req.getSession().getAttribute("customerID");
		String account_num = req.getParameter("account_num");
		String account_name = req.getParameter("y_name");
		int balance = Integer.parseInt(req.getParameter("y_balance"));
		String date = req.getParameter("y_end_date");
		
		dto.setY_name(account_name); 	 	//상품 이름
		dto.setAccount_num(account_num);	//계좌 번호
		dto.setY_end_date(date);			//만기일
		dto.setY_balance(balance);			//예치금액
		dto.setY_interest_rate(Double.parseDouble(req.getParameter("y_interest_rate")));
		dto.setY_type(Integer.parseInt(req.getParameter("y_type")));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("y_name", account_name);
		map.put("account_num", account_num);
		
		dao.customer_Deposit_Add(dto);
		System.out.println("dto : " + dto);
		int update_Num = dao.deposit_Account_Update(account_num);
		System.out.println("updateMoney : " + update_Num);
		int update_Name = dao.deposit_Account_Name(map);
		System.out.println("updateNum : " + update_Name  );
		
		//금액 업데이트		
		Map<String, Object> updateMoney = new HashMap<String, Object>();
		updateMoney.put("y_balance", balance);
		updateMoney.put("account_num", account_num);
		int update_Money = dao.deposit_Account_Money(updateMoney);
		System.out.println("updateName : " + update_Money );
		
	}
	//예금 상품 조회 - 고객 test고객의 account_type이 미정인 사람만 출력
	@Override
	public void customer_deposit_search(HttpServletRequest req, Model model) {
		System.out.println("[Service - customer_deposit_search]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		int y_no = Integer.parseInt(req.getParameter("y_no"));
		
		System.out.println("id : " + id);
		
		List<AccountDTO> list = dao.customer_Account_Search(id);
		
		Deposit_itemDTO dto = dao.deposit_Detail(y_no);
		
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
	}
	@Override
	public void customer_savings_add(HttpServletRequest req, Model model) {
		System.out.println("[Service - customer_savings_add]");
		
		SavingsDTO dto = new SavingsDTO();
		String id = (String)req.getSession().getAttribute("customerID");
		
		String i_name = req.getParameter("i_name");
		String account_num = req.getParameter("account_num");
		String end_date = req.getParameter("i_end_date");
		int i_balance = Integer.parseInt(req.getParameter("balance"));

		dto.setAccount_num(account_num);
		dto.setI_name(i_name);
		dto.setI_balance(i_balance);	
		dto.setI_rate(Double.parseDouble(req.getParameter("i_rate"))); 
		dto.setI_type(Integer.parseInt(req.getParameter("i_type")));
		dto.setI_method(Integer.parseInt(req.getParameter("i_method")));
		dto.setI_money(Integer.parseInt(req.getParameter("i_money")));
		dto.setI_auto_date(Integer.parseInt(req.getParameter("i_auto_date")));
		dto.setI_end_date(end_date);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("i_name", i_name);
		map.put("account_num", account_num);
		
		int insertCnt = dao.customer_Savings_Add(dto);
		int update_Account = dao.savings_Account_Update(account_num);
		int update_Name = dao.savings_Account_Name(map);
		//금액 업데이트		
		Map<String, Object> updateMoney = new HashMap<String, Object>();
		updateMoney.put("balance", i_balance);
		updateMoney.put("account_num", account_num);
		
		int money = dao.savings_Account_Money(updateMoney);
		
		System.out.println("dto : " + dto);
		System.out.println("money : " + money);
		System.out.println("update_Account : " + update_Account);
		System.out.println("update_Name : " + update_Name);
		System.out.println("insertCnt : " + insertCnt);
	}
	@Override
	public void customer_savings_search(HttpServletRequest req, Model model) {
		System.out.println("[Service - customer_savings_search]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		int i_no = Integer.parseInt(req.getParameter("i_no"));
		System.out.println("customerId : " + id);
		
		List<AccountDTO> list = dao.customer_Account_Search(id);
		Savings_itemDTO dto = dao.savings_Detail(i_no);
		
		model.addAttribute("dto", dto);
		model.addAttribute("list" , list);
	}

}
