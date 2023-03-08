package com.spring.bank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.api.client.json.Json;
import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.AutoTransfer_ListDTO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.TotalChartDTO;
import com.spring.bank.dto.TransferDTO;
import com.spring.bank.service.AccountServiceImpl;
import com.spring.bank.service.AccountTransferServiceImpl;
import com.spring.bank.service.AdminCsCenterServiceImpl;
import com.spring.bank.service.AdminCustomerService;
import com.spring.bank.service.AdminTotalServiceImpl;
import com.spring.bank.service.AutotransferServiceImpl;
import com.spring.bank.service.CsCenterSerivceImpl;
import com.spring.bank.service.CustomerServiceImpl;
import com.spring.bank.service.FundBoardServiceImpl;
import com.spring.bank.service.ItemServiceImpl;
import com.spring.bank.service.LoanServiceImpl;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	// ===== 사용자 ======
	// 회원 관리
	@Autowired
	CustomerServiceImpl customerService;
	// 계좌 관리, 조회, 등록,해지

	@Autowired
	AccountServiceImpl accountService;
	
	// 환율 관리
	@Autowired
	AdminCustomerService ACservice;
	
	// 고객 관리
	@Autowired
	CsCenterSerivceImpl csCenterService;

	// 상품 관리 ( 예금,적금,펀드 등)
	@Autowired
	ItemServiceImpl itemService;

	@Autowired
	AdminCsCenterServiceImpl adminCsCenterService;

	// 대출 관리
	@Autowired
	LoanServiceImpl loanService;

	// 04-21 최웅 conlict로 주석처리 -> AdminCsCenterServiceImpl adminCsCenterService;
	// private CsCenterSerivceImpl adminCsCenterService;

	// 이체 관리
	@Autowired
	AccountTransferServiceImpl TransferService;

	@Autowired
	AutotransferServiceImpl autoService;

	// 펀드게시판
	@Autowired
	FundBoardServiceImpl FundBoardService;
	
	// TEST
	@Autowired
	AdminTotalServiceImpl adminTotalService;
	
	@RequestMapping("/")
	public String main_root() {
		logger.info("[url ==> index.do]");
		return "index";
	}

	// 메인화면
	@RequestMapping("/*.do")
	public String main() {
		logger.info("[url ==> index.do]");
		return "index";
	}
	// index.jsp
	@RequestMapping("index.do")
	public String index() {
		logger.info("[url ==> index.do]");
		return "index";
	}

	// 로그인 화면
	@RequestMapping("login.do")
	public String loginSign(HttpServletRequest req, Model model) {
		logger.info("[url ==> login.do]");
		String strId = (String) req.getSession().getAttribute("customerID");
		System.out.println("strId : " + strId);
		if (strId != null) {
			return "";
		} else {
			return "customer/login/login";
		}
	}

	// 로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest req, Model model) {
		logger.info("[url ==> logout.do]");
		customerService.update_login_history(req, model);
		req.getSession().invalidate();

		return "index";
	}

	// 중복확인 처리
	@RequestMapping("confirmIdAction.do")
	public String confirmIdAction(HttpServletRequest req, Model model) {
		logger.info("[url ==> confirmIdAction.do]");
		customerService.confirmIdAction(req, model);
		return "customer/login/confirmIdAction";
	}
	
	// 이미지 인식 처리
	@RequestMapping("idCardOcr.do")
	public String idCardOcr(MultipartHttpServletRequest reqs, HttpServletRequest req, Model model) throws IOException {
		logger.info("[url ==> idCardOcr.do]");
		customerService.readIdCard(req, model, reqs);
		
		return "customer/login/join";
	}

	// 회원가입처리 - 시큐리티(비밀번호 암호화)
	@RequestMapping("joinAction.do")
	public String joinAction(HttpServletRequest req, Model model) {
		logger.info("[url ==> joinAction.do]");
		customerService.joinAction(req, model);
		return "customer/login/joinAction";
	}

	// 시큐리티 - 가입성공시 이메일인증을 위해 이메일 전송
	// CustomerDAOImpl의 sendEmail(String email, String key)에서 호출
	@RequestMapping("emailChk.do")
	public String emailChk(HttpServletRequest req, Model model) {
		logger.info("[url ==> emailChk.do]");
		customerService.emailChkAction(req, model);
		System.out.println("emailChk 호출 확인 : ");
		return "customer/login/emailChkAction";
	}

	// 회원가입 성공
	@RequestMapping("mainSuccess.do")
	public String mainSuccess(HttpServletRequest req, Model model) {
		logger.info("[url ==> mainSuccess.do]");
		int cnt = Integer.parseInt(req.getParameter("insertCnt"));
		model.addAttribute("selectCnt", cnt);
		return "customer/login/login";
	}

	// 회원가입화면
	@RequestMapping("join.do")
	public String join() {
		logger.info("[url ==> join.do]");
		return "customer/login/join";
	}

	/*
	 * ------------------- 대출 -------------------
	 */
	// 대출 계좌 리스트
	@RequestMapping("loan_account_search.do")
	public String loan_account_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출계좌리스트");
		
		// 로그인 안되어있을 시 로그인 화면으로 이동
		String id = (String)req.getSession().getAttribute("customerID");
		if(id != null) {
			loanService.loan_account_search(req, model);
			return "customer/loan/loan_account_search";
		} else {
			return "customer/login/login";
		}
		
		
	}
	// 대출 상품 리스트 (현우 )

	@RequestMapping("loan_pro_list.do")
	public String loan_pro_list(HttpServletRequest req, Model model) {

		loanService.loan_pro_list(req, model);
		return "customer/loan/loan_pro_list";
	}

	// 대출 상품 상세, 현우
	@RequestMapping("loan_pro_detail.do")
	public String loan_pro_detail() {
		return "customer/loan/loan_pro_detail";
	}

	// ----------------------- [ 대출 등록 ] ----------------------
	// 대출 신청
	@RequestMapping("loan_apply.do")
	public String register(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출 신규 신청");

		// 로그인 안되어 있으면 로그인 화면으로 ㄱ.ㄱ
		String id = (String)req.getSession().getAttribute("customerID");
		if(id != null) {
			loanService.loan_apply(req, model);
			return "customer/loan/loan_apply";
		} else {
			return "redirect:login.do?loginError=1";
		}
	}

	// 대출 신청 상환액 계산
	@RequestMapping("loan_apply_calculate.do")
	public String loan_apply_calculate(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출 신규 신청 상환액 계산");

		loanService.loan_apply_calculate(req, model);
		return "customer/loan/loan_apply_calculate";
	}

	// 대출 신청 비밀번호 체크
	@ResponseBody
	@RequestMapping("loan_password_check.do")
	public String loan_password_check(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출 신청 비밀번호 체크");

		String result = loanService.loan_apply_password_check(req, model);
		System.out.println("컨트롤러 result : " + result);
		String data = null;
		if (result != null) {
			data = "correct";
		} else {
			data = "incorrect";
		}
		System.out.println("컨트롤러 data : " + data);
		System.out.println("----------------------");
		return data;
	}

	// 대출 신청 insert
	@RequestMapping("loan_apply_insert.do")
	public String loan_apply_insert(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출 신청 insert");

		loanService.loan_apply_insert(req, model);
		return "redirect:loan_account_search.do";
	}

	// 대출 원금 조회 / 납부 페이지
	@RequestMapping("loan_principal_search_paid.do")
	public String loan_principal_search_paid() {
		logger.info("CustomerController - 대출상품리스트");

		return "customer/loan/loan_principal_search_paid";
	}

	// 대출 원금 조회
	@RequestMapping("loan_principal_search.do")
	public String loan_principal_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 대출상품리스트");
		loanService.loan_principal_search(req, model);

		return "customer/loan/loan_principal_search";
	}

	// 대출 상환 예정표
	@RequestMapping("loan_paid_plan.do")
	public String loan_paid_plan(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_paid_plan.do]");

		loanService.loan_paid_plan(req, model);
		return "customer/loan/loan_paid_plan";
	}
	
	// 대출 상환 페이지
	@RequestMapping("loan_paid_detail.do")
	public String loan_paid_detail(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_paid_detail.do]");
		
		loanService.loan_paid_detail(req, model);
		return "customer/loan/loan_paid_detail";
	}
	
	// 대출 상환 
	@RequestMapping("loan_paid.do")
	public String loan_paid(HttpServletRequest req, Model model, HttpServletResponse res) {
		logger.info("[url ==> loan_paid.do]");
		
		loanService.loan_paid(req, model, res);
		return "customer/loan/loan_paid_action";
	}
	
	// 대출 상환 내역 조회
	@RequestMapping("loan_paid_history.do")
	public String loan_paid_history(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_paid_history.do]");
		
		loanService.loan_paid_history(req, model);
		return "customer/loan/loan_paid_history";
	}
	
	// 대출 해지하기
	@RequestMapping("loan_cancel.do")
	public String loan_cancel(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_cancel.do]");
		
		loanService.loan_cancel(req, model);
		return "customer/loan/loan_cancel_action";
	}
	
	// 대출 해지 현황 조회
	@RequestMapping("loan_cancel_search.do")
	public String loan_cancel_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_cancel_search.do]");
		
		loanService.loan_cancel_search(req, model);
		return "customer/loan/loan_cancel_search";
	}

	// ------------------------ 상담 -------------------------

	// 상담글 등록 페이지
	@RequestMapping("counsel_insert.do")
	public String counsel_insert(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 등록");
		return "customer/board/counsel/counsel_insert";
	}

	// 상담글 등록 처리
	@RequestMapping("counsel_insert_action.do")
	public String counsel_insert_action(HttpServletRequest req, HttpServletResponse res, Model model)
			throws IOException {
		logger.info("CustomerController - 상담글 등록 처리");
		csCenterService.counsel_insert_action(req, model);
		return "redirect:counsel_list_search.do";
	}

	// 상담글 리스트 조회
	@RequestMapping("counsel_list_search.do")
	public String loanTermination(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 리스트 조회");
		csCenterService.counsel_list_search(req, model);
		return "customer/board/counsel/counsel_list_search";
	}

	// 상담글 상세조회
	@RequestMapping("counsel_detail_search.do")
	public String counsel_detail_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 상세조회");
		csCenterService.counsel_detail_search(req, model);
		return "customer/board/counsel/counsel_detail_search";
	}

	// 상담글 상세조회시 댓글리스트 불러오기
	@RequestMapping("counsel_coment_list_search.do")
	public String counsel_coment_list_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 상세조회시 댓글리스트 불러오기");
		csCenterService.counsel_coment_list_search(req, model);
		return "customer/board/counsel/counsel_coment_list_search";
	}

	// 상담글 상세조회시 댓글 달기
	@RequestMapping("counsel_coment_add.do")
	public String counsel_coment_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> .do");
		csCenterService.counsel_coment_add(req, model);
		return "customer/board/counsel/counsel_coment_list_search";
	}

	// 상담글 수정,삭제시 비밀번호 체크
	@RequestMapping("counsel_update_password_check.do")
	public String counsel_update_password_check(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 수정,삭제시 비밀번호 체크");
		String result = csCenterService.counsel_update_password_check(req, model);
		int num = Integer.parseInt(req.getParameter("boardNum"));

		// 비밀번호가 맞으면 수정화면으로 이동
		if (result != null) {
			// CounselDTO dto = boardDao.getQnaDetail(num);
			// 6단계. jsp로 처리 결과 전달(request나 session으로 처리 결과를 저장 후 전달)
			model.addAttribute("b_num", num);
			return "redirect:counsel_update.do";

		} else { // 비밀번호가 틀리면 되돌아감
			// 6단계. jsp로 처리 결과 전달(request나 session으로 처리 결과를 저장 후 전달)
			return "redirect:counsel_detail_search.do?num=" + num + "&message=error";
		}
	}

	// 상담글 수정/삭제 페이지
	@RequestMapping("counsel_update.do")
	public String counsel_update(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 상담글 수정/삭제 페이지");
		// int b_num = Integer.parseInt(req.getParameter("b_num"));
		csCenterService.counsel_update(req, model);
		return "customer/board/counsel/counsel_update";
	}

	// 상담글 수정처리
	@RequestMapping("counsel_update_action.do")
	public String counsel_update_action(HttpServletRequest req, HttpServletResponse res, Model model)
			throws IOException {
		logger.info("CustomerController - 상담글 수정처리");
		int num = Integer.parseInt(req.getParameter("boardNum"));
		csCenterService.counsel_update_action(req, model);
		return "redirect:counsel_update.do?b_num=" + num;
	}

	// 상담글 삭제처리
	@RequestMapping("counsel_delete_action.do")
	public String counsel_delete_action(HttpServletRequest req, HttpServletResponse res, Model model)
			throws IOException {
		logger.info("CustomerController - 상담글 삭제처리");
		csCenterService.counsel_delete_action(req, model);
		return "redirect:counsel_list_search.do";
	}

//  ======================================= 고객 센터 ===========================

	// 공지글 등록
	@RequestMapping("notice_insert.do")
	public String service_center_add(HttpServletRequest req, Model model) {

		logger.info("[url ==> notice_insert.do]");
		return "customer/board/notice/notice_insert";
	}

	// 공지글 리스트 조회
	@RequestMapping("notice_list_search.do")
	public String notice_list_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_list_search.do]");
		csCenterService.notice_list_search(req, model);
		return "customer/board/notice/notice_list_search";
	}

	// 공지글 상세보기
	@RequestMapping("notice_detail_search.do")
	public String notice_detail_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_detail_search.do]");
		csCenterService.notice_detail_view_add(req, model);
		csCenterService.notice_detail_search(req, model);
		return "customer/board/notice/notice_detail_search";
	}

	// ----------------------- [ 계좌 조회 ] ----------------------

	// 내 보유 계좌 조회 (select),ung
	@RequestMapping("my_account.do")
	public String myAccount(HttpServletRequest req, Model model) {
		logger.info("my_account.do");
		String id = (String) req.getSession().getAttribute("customerID");
		if(id == null) {
			return "redirect:login.do?loginError=1";
		}
		accountService.my_account(req, model);
		return "customer/user_account/my_account";
	}

	// 내 거래 내역 계좌 조회 (select),ung
	@RequestMapping("my_trade_history.do")
	public String myDealingRecord(HttpServletRequest req, Model model) {
		logger.info("my_trade_history.do");
		accountService.my_trade_history(req, model);

		return "customer/user_account/my_trade_history";
	}
	@RequestMapping("select_trade_history.do")
	public String select_trade_history(HttpServletRequest req, Model model) {
		logger.info("select_trade_history.do");
		List<TransferDTO> list = accountService.select_trade_history(req, model);
		model.addAttribute("list",list);
		return "customer/user_account/my_trade_history_term"; 
	}

	// 내 계좌 조회(select) [예/적금, 입출금, 해지,휴면,정지]
	//AJAX
	@RequestMapping("account_type.do")
	public String myColsedAccount(HttpServletRequest req, Model model) {
		logger.info("account_type.do");
		String account_type = req.getParameter("account_type");
		System.out.println(account_type);
		if (account_type == null) {
			return "redirect:my_account.do";
		}else {
			List<AccountDTO> list = accountService.account_type_change(req, model);
			model.addAttribute("list",list);
		}
		return "customer/user_account/account_type_change";
	}
	@RequestMapping("my_account_sorting.do")
	public String my_account_sorting(HttpServletRequest req, Model model) {
		logger.info("my_account_sorting");
		List<AccountDTO> list = accountService.my_account_sorting(req,model);
		model.addAttribute("list",list);
		return "customer/user_account/my_account_sorting";
	}
	@RequestMapping("select_account_history.do")
	@ResponseBody
	public Map<String,String> select_account_history(HttpServletRequest req, Model model) {
		logger.info("select_account_history");
		List<AccountDTO> list = accountService.select_account_history(req, model);
		Map<String,String> map = new HashMap<String,String>();
		map.put("in_out_date", list.get(0).getIN_OUT_DATE());
		map.put("account_state", list.get(0).getAccount_state());
		map.put("history", list.get(0).getHistory());
		
		return map;
	}

	// ----------------------- [ 계좌 등록 , 해지 ] ----------------------
	@RequestMapping("account_add.do")
	public String account_Add(HttpServletRequest req, Model model) {
		String id = (String) req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}
		CustomerDTO dto = accountService.my_select_info(req, model);
		model.addAttribute("dto", dto);
		return "customer/account_manage/account_add";
	}

	// 계좌 등록 Action
	@RequestMapping("account_addAction.do")
	public String accountAction(HttpServletRequest req, Model model) {
		Map<String,Object> map = accountService.account_add(req, model);
		String account_num = (String)map.get("account_num");
		model.addAttribute("account_num",account_num);
		return "customer/account_manage/account_manage_menu";
	}
	// 계좌 메뉴로 이동
	@RequestMapping("account_add_menu.do")
	public String account_add_menu(HttpServletRequest req, Model model) {		
		return "customer/account_manage/account_manage_menu";
	}
	// 입출금 계좌로 변경
	@RequestMapping("account_type_default.do")
	public String account_type_change(HttpServletRequest req, Model model) {
		int updateChk = accountService.account_type_default(req, model);
		System.out.println("chck : "+updateChk);
		if(updateChk <=0) {
			System.out.println("등록 실패");
			return "redirect:my_account.do?updateError=입출금계좌 등록 실패 고객센터에 문의하세요";
		}else {
			return "redirect:my_account.do";
		}
	}

	// 계좌 등록 - 상품 금리 호출
	@RequestMapping("account_add_manage.do")
	public String account_add_managementAction(HttpServletRequest req, Model model) {
		System.out.println("[ url ] account_add_manage ");
		return "customer/account_manage/account_popup1";
	}

	// 계좌 등록 -거래 상품 약관 호출
	@RequestMapping("account_product_manage.do")
	public String account_product_manage(HttpServletRequest req, Model model) {
		return "customer/account_manage/account_popup2";
	}

	// 계좌 해지,ung
	@RequestMapping("account_cancel.do")
	public String account_cancel(HttpServletRequest req, Model model) {
		logger.info("account_cancel");
		String id = (String) req.getSession().getAttribute("customerID");
		if(id == null) {
			return "redirect:login.do?loginError=1";
		}
		// 계좌 정보 조회  >> 계좌 해지 페이지에서 계좌 정보를 가져오기 위해 값으 ㄹ가져옴
		accountService.account_info_cancel(req, model);
		return "customer/account_manage/account_cancel";
	}
	// AJax 계좌 해지 페이지에서 계좌번호 클릭시 잔액정보를 가져옴
	@RequestMapping("account_cancel_balance.do")
	@ResponseBody
	public int account_cancel_balance(HttpServletRequest req, Model model ) {
		AccountDTO AccountDto = accountService.account_selected_info(req, model);
		System.out.println(AccountDto.getBalance());
		return AccountDto.getBalance();
	}
	// 계좌 해지 Action
	@RequestMapping("account_cancelAction.do")
	public String account_cancel_pwd(HttpServletRequest req, Model model ) {
		int pwdchk = accountService.account_pwd_chk(req, model);
		System.out.println("pwdChk : "+pwdchk);
		if(pwdchk<= 0) {
			System.out.println("비밀번호 틀림");
			return "redirect:account_cancel.do?pwdError=1";
		}else {
			// 계좌 상태를 [ 해지]로 변경
			int sleep =accountService.my_sleep_account(req, model);
			return "redirect:my_account.do?account_sleep="+sleep;
		}
	}
	// 펀드 리스트, ung 규호수정
	@RequestMapping("fund_list.do")
	public String fund_list(HttpServletRequest req, Model model) {
		logger.info("fund_list");
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			itemService.fundlist(req, model);
			return "customer/fund/fund_list";
		}

	}

	// 펀드 리스트 - ALL
	@RequestMapping("fund_all_list.do")
	public String fund_all_list(HttpServletRequest req, Model model) {
		logger.info("fund_all_list");
		itemService.fundlist(req, model);

		return "customer/fund/fund_all_list";
	}
	
	// 펀드 리스트 - 건강
	@RequestMapping("fund_health_list.do")
	public String fund_health_list(HttpServletRequest req, Model model) {
		logger.info("fund_health_list");
		itemService.fund_category_list(req, model);

		return "customer/fund/fund_health_list";
	}

	 // 펀드 리스트 - 테크/가전
	 @RequestMapping("fund_tech_list.do")
	 public String fund_tech_list(HttpServletRequest req, Model model) {
		 logger.info("fund_tech_list"); itemService.fundlist(req, model);
		 itemService.fund_category_list(req, model);
		 return "customer/fund/fund_tech_list";
	}

	 // 펀드 리스트 - 패션잡화
	 @RequestMapping("fund_fashion_list.do")
	 public String fund_fashion_list(HttpServletRequest req, Model model) {
		 logger.info("fund_fashion_list"); itemService.fundlist(req, model);
		 itemService.fund_category_list(req, model);
		 return "customer/fund/fund_fashion_list";
	 }

	  // 펀드 리스트 - 푸드
	  @RequestMapping("fund_food_list.do")
	  public String fund_food_list(HttpServletRequest req, Model model) {
		  logger.info("fund_food_list"); itemService.fundlist(req, model);
		  itemService.fund_category_list(req, model);
		  return "customer/fund/fund_food_list";
	  }

	  // 펀드 리스트 - 홈리빙
	  @RequestMapping("fund_home_list.do")
	  public String fund_home_list(HttpServletRequest req, Model model) {
		  logger.info("fund_home_list"); itemService.fundlist(req, model);
		  itemService.fund_category_list(req, model);
		  return "customer/fund/fund_home_list";
	  }


	// 펀드 상세 페이지, ung
	@RequestMapping("fund_detail.do")
	public String fund_detail(HttpServletRequest req, Model model) {
		logger.info("fund_detail");
		itemService.funddetail(req, model);

		return "customer/fund/fund_detail";
	}

	// 펀드 구매 페이지, ung
	@RequestMapping("fund_buy.do")
	public String fund_buy(HttpServletRequest req, Model model) {
		logger.info("fund_buy");
		itemService.fundbuy(req, model);

		return "customer/fund/fund_buy";
	}

	// 펀드 구매 페이지, ung
	@RequestMapping("fund_buyaction.do")
	public String fund_buyaction(HttpServletRequest req, Model model) {
		logger.info("fund_buyaction");
		int f_num = Integer.parseInt(req.getParameter("f_num"));
		itemService.fundmemberadd(req, model);

		return "redirect:fund_detail.do?f_num="+f_num;
	}
	// =========================== 펀드 ======================

	// 펀드 등록화면, ung 규호수정
	@RequestMapping("fund_add.do")
	public String fund_add(HttpServletRequest req, Model model) {
		logger.info("fund_add");

		return "customer/fund/fund_add";
	}

	// 펀드 등록, ung 규호수정
	@RequestMapping("fund_addaction.do")
	public String fund_addaction(MultipartHttpServletRequest req, Model model) throws IOException {
		logger.info("fund_addaction");

		itemService.fundadd(req, model);
		return "customer/fund/fund_addaction";
	}

	// 펀드 결제 페이지 ( 카카오페이지 ) - jsp 미구현
	@RequestMapping("fund_pay.do")
	public String fund_pay(HttpServletRequest req, Model model) {
		logger.info("fund_pay");

		return "customer/fund/fund_pay";
	}
	
 // --------------펀드 게시판--------------------------------	
	
	
	// 펀드 등록 페이지
	@RequestMapping("fund_insert.do")
	public String fund_insert(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드 등록");
		return "customer/fund_board/fund_insert";
	}

	// 펀드 등록 처리
	@RequestMapping("fund_insert_action.do")
	public String fund_insert_action(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("CustomerController - 펀드 등록 처리");
		FundBoardService.fund_insert_action(req, model);
		return "redirect:fund_list_search.do";
	}

	// 펀드 리스트 조회
	@RequestMapping("fund_list_search.do")
	public String fund_list_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드 리스트 조회");
		FundBoardService.fund_list_search(req, model);
		return "customer/fund_board/fund_list_search";
	}

	// 펀드 상세조회
	@RequestMapping("fund_detail_search.do")
	public String fund_detail_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드 상세조회");
		FundBoardService.fund_detail_search(req, model);
		return "customer/fund_board/fund_detail_search";
	}
	
	// 펀드리스트 상세조회시 댓글리스트 불러오기
	@RequestMapping("fund_coment_list_search.do")
	public String fund_coment_list_search(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드리스트 상세조회시 댓글리스트 불러오기");
		FundBoardService.fund_coment_list_search(req, model);
		return "customer/fund_board/fund_coment_list_search";
	}

	// 펀드리스 상세조회시 댓글 달기
	@RequestMapping("fund_coment_add.do")
	public String fund_coment_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> .do");
		FundBoardService.fund_coment_add(req, model);
		return "customer/fund_board/fund_coment_list_search";
	}

	// 펀드 수정,삭제시 비밀번호 체크
	@RequestMapping("fund_update_password_check.do")
	public String fund_update_password_check(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드 수정,삭제시 비밀번호 체크");
		String result = FundBoardService.fund_update_password_check(req, model);
	    int num = Integer.parseInt(req.getParameter("boardNum"));

	    // 비밀번호가 맞으면 수정화면으로 이동
	    if(result != null) {
	       //6단계. jsp로 처리 결과 전달(request나 session으로 처리 결과를 저장 후 전달)
	       model.addAttribute("f_num", num);
	       return "redirect:fund_update.do";

	    } else {  // 비밀번호가 틀리면 되돌아감
	       // 6단계. jsp로 처리 결과 전달(request나 session으로 처리 결과를 저장 후 전달)
	       return "redirect:fund_detail_search.do?num=" + num + "&message=error";
	    }
	}

	// 펀드 수정/삭제 페이지
	@RequestMapping("fund_update.do")
	public String fund_update(HttpServletRequest req, Model model) {
		logger.info("CustomerController - 펀드 수정/삭제 페이지");
		FundBoardService.fund_update(req, model);
		return "customer/fund_board/fund_update";
	}

	// 펀드 수정처리
	@RequestMapping("fund_update_action.do")
	public String fund_update_action(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("CustomerController - 펀드s 수정처리");
		int num = Integer.parseInt(req.getParameter("boardNum"));
		FundBoardService.fund_update_action(req, model);
		return "redirect:fund_update.do?f_num=" + num;
	}

	// 펀드 삭제처리
	@RequestMapping("fund_delete_action.do")
	public String fund_delete_action(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("CustomerController - 펀드 삭제처리");
		FundBoardService.fund_delete_action(req, model);
		return "redirect:fund_list_search.do";
	}

	// -------------- 이체 --------------
	// 계좌이체 화면 1-1
	@RequestMapping("account_transfer1.do")
	public String account_transfer1(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_transfer.do]");	
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			TransferService.call_account_transfer1(req, model);				
			return "customer/search_transfer/transfer/account_transfer";
		}
	}
	// 계좌이체 화면 1-2
	@RequestMapping("account_transfer2.do")
	public String account_transfer2(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_transfer.do]");
		TransferService.call_account_transfer2(req, model);
		return "customer/search_transfer/transfer/account_transferAjax";
	}
	// 계좌이체시 문자서비스
	@RequestMapping("transfer_message.do")
	public String transfer_message() {
		logger.info("[url ==> transfer_message.do]");
		return "customer/search_transfer/transfer/transfer_message";
	}

	// 비번성공여부에 따라 페이지이동 나눔
	// 계좌이체 처리
	@RequestMapping("account_transferAciton.do")
	public String account_transferAciton(HttpServletRequest req, HttpServletResponse res, Model model)
			throws IOException {
		logger.info("[url ==> account_transferAciton.do]");

		// 비번성공여부서비스 호출
		String result = TransferService.account_transfer_check(req, model);
		System.out.println("transAction service : "+result);
		
		// 이체시 계좌 비번 맞으면 
		String account_num = req.getParameter("account_num");

		if (result != null) {

			// 아래 이체처리 서비스 호출
			TransferService.account_transfer2(req, model);

			// 내계좌내역 조회 컨트롤러
			return "redirect:my_trade_history.do?account_num=" + account_num;

			// 비번 틀리면 다시화면으로 이동
		} else {
			return "customer/account_search/account_search_account";
		}		
	}
	// ======================== 적금 ========================== 
	// 적금추가납입 화면 1 (계좌)
	@RequestMapping("savings_add_paid1.do")
	public String savings_add_paid1(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_add_paid1.do]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			TransferService.call_add_paid_1(req, model);
			return "customer/search_transfer/transfer/savings_add_paid";
		}
	}
	
	// 적금추가납입 화면 2 (한도+잔액)

	@RequestMapping("savings_add_paid2.do")
	public String savings_add_paid2(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_add_paid2.do]");
	
		TransferService.call_add_paid_2(req, model);
		
		return "customer/search_transfer/transfer/savings_add_paidAjax";
		
	}
	// 적금 추가 납입 처리
	@RequestMapping("savings_add_paidAction.do")
	public String savings_add_paidAction(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_add_paid.do]");
		// 비번확인 서비스
		String result = TransferService.account_transfer_check(req, model);
		System.out.println("savings_add_paidAction : account_transfer_check : "+result);
		
		//비번 일치 시
		String account_num = req.getParameter("account_num");
		
		if(result != null) {
			// 적금추가납입서비스 
			 TransferService.add_paid(req, model);
			 
			 return "redirect:my_trade_history.do?account_num="+account_num;
		} else {

			return "customer/search_transfer/transfer/savings_add_paid";
		}

	}

	// 적금 상품 리스트, 현우 - LJH
	@RequestMapping("savings_pro_list.do")
	public String savings_pro_list(HttpServletRequest req, Model model) {

		itemService.savings_List_Search(req, model);

		return "customer/savings/savings_pro_list";
	}

	// 적금 신청 하기, 현우 - LJH
	@RequestMapping("savings_order_add.do")
	public String savings_pro_order(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			itemService.savings_Detail_Action(req, model);		
			return "customer/savings/savings_order_add";
		}
	}
	// ======================== 예금 ========================== 
	
	// 예금 상품 ( 고객 ),
	@RequestMapping("deposit_pro_list.do")
	public String account_Pro_List(HttpServletRequest req, Model model) {
		Log.info("[ Controller - account_Pro_List ]");
		itemService.deposit_List_Search(req, model);	
		
	return "customer/deposit/deposit_pro_list";
	}
	// 예금 상품 상세 ( 고객 ) ,
	@RequestMapping("deposit_pro_detail.do")
	public String deposit_pro_detail(HttpServletRequest req, Model model) {
		Log.info("[ Controller - deposit_pro_order ]");
		itemService.deposit_Detail_Action(req, model);
		return "customer/deposit/deposit_pro_order";
	}
	//예금 상품 신청 화면 , LJH 2022-04-24
	@RequestMapping("deposit_order_add.do")
	public String deposit_order_add(HttpServletRequest req, Model model) {
		
		//itemService.customer_deposit_search(req, model);
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			itemService.deposit_Detail_Action(req, model);
			return "customer/deposit/deposit_order_add";
		}
	}

	// 기간
	@RequestMapping("term.do")
	public String term() {
		return "customer/deposit/term";
	}

	// ======================== 환율 ===========================

	// 환율 정보,동한
	@RequestMapping("exchange_detail.do")
	public String exchange_detail(HttpServletRequest req, Model model) {
		logger.info("exchange_detail");
		ACservice.exchange_detail(req, model);
	return "customer/exchange/exchange_detail";
	}	
	
	// 환율 계산기,동한
	@RequestMapping("exchange_calculator.do")
	public String exchange_calculator(HttpServletRequest req, Model model) {
		logger.info("exchange_calculator");
		return "customer/exchange/exchange_calculator";
	}

	// -------------- 자동 이체 --------------

	// 자동이체 DB 계좌조회 1
	@RequestMapping("auto_search.do")
	public String auto_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> auto_search.do]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			TransferService.auto_search(req, model);
			return "customer/search_transfer/auto_transfer/search_cancel";
		}
	}
	
	// 셀렉트된 조회 2
	@RequestMapping("auto_search2.do")
	public String auto_search2(HttpServletRequest req, Model model) {
		logger.info("[url ==> auto_search2.do]");
		
		TransferService.auto_search_2(req, model);
		
		return "customer/search_transfer/auto_transfer/search_cancel_ajax";
	}
	
	// 해지
	@RequestMapping("auto_cancel.do")
	public String auto_cancel(HttpServletRequest req, Model model) {
		logger.info("[url ==> auto_cancel.do]");
		
		TransferService.auto_cancel(req, model);
		
		return "customer/search_transfer/auto_transfer/search_cancel_ajax";
	}

	// 자동이체 신청 //LJH, 2022-04-21
	@RequestMapping("auto_transfer_apply.do")
	public String auto_transfer_apply(HttpServletRequest req, Model model) {
		logger.info("[url ==> auto_transfer_apply.do]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			autoService.customer_Account_Search(req, model);
			return "customer/search_transfer/auto_transfer/auto_transfer_apply";
		}
	}

	// 이체 예약 //LJH, 2022-04-21

	//이체 내역 ===================================================================
	@RequestMapping("auto_transfer_add.do")
	public String auto_transfer_add(HttpServletRequest req, Model model) {
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			autoService.auto_add(req, model);
			return "redirect:auto_search.do";
		}
	}
	//이체 확인 //LJH, 2022-04-21

	@RequestMapping("transfer_reservation.do")
	public String transfer_reservation(HttpServletRequest req, Model model) {
		logger.info("[url ==> transfer_reservation.do]");
		
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			autoService.get_Calender_List();
			return "customer/search_transfer/auto_transfer/transfer_reservation";
		}
	}

	// 자동이체시 문자서비스
	@RequestMapping("auto_transfer_message.do")
	public String auto_transfer_message() {
		logger.info("[url ==> auto_transfer_message.do]");
		return "customer/search_transfer/auto_transfer/auto_transfer_message";
	}

	// -------------- 한도 변경 --------------
	// 한도 변경 신청 1 (성주) 
	@RequestMapping("max_apply.do")
	public String max_apply_1(HttpServletRequest req, Model model) {
		logger.info("[url ==> max_apply.do]");
		String id = (String)req.getSession().getAttribute("customerID");
		if (id == null) {
			return "redirect:login.do?loginError=1";
		}else {
			// id -계좌리스트 불러와
			TransferService.call_account_transfer1(req, model);
			return "customer/search_transfer/max_apply/max_apply";
		}
	}
	
	// 한도 변경 신청2 - 한도불러오기 (성주) 
	@RequestMapping("max_apply_call.do")
	public String max_apply_2(HttpServletRequest req, Model model) {
		logger.info("[url ==> max_apply_call.do]");
		
		TransferService.limit_call(req, model);
		return "customer/search_transfer/max_apply/max_apply_ajax";
	}
	
	// 한도 변경 신청 처리 + 비번체크 (성주) 
	@RequestMapping("max_apply_ck.do")
	public String max_apply_ck(HttpServletRequest req, Model model) {
		logger.info("[url ==> max_apply_ck.do]");
		// 비번확인 서비스
		String result = TransferService.account_transfer_check(req, model);
		
		//비번 일치 시
		String account_num = req.getParameter("account_num");
		
		if(result != null) {
			//서비스 
			 TransferService.limit_apply(req, model);
			 
			 //내 계좌내역 페이지로 이동
			 return "redirect:my_account.do";
			
		} else {
			
			return "customer/search_transfer/max_apply/max_apply";
		}
	}
	

	// 한도 변경
	@RequestMapping("calender_list.do")
	public String calender_list() {
		logger.info("[url ==> calender_list.do]");
		return "customer/search_transfer/max_apply/max_apply";
	}
	// -------------- 고객 예금 신청 --------------
	// 고객 예금 신청
	@RequestMapping("deposit_application.do")
	public String deposit_application(HttpServletRequest req, Model model) {
		System.out.println("예금 신청 ");
		itemService.customer_deposit_add(req, model);	
	return "redirect:deposit_pro_list.do";
	}
	//고객 적금 신청
	@RequestMapping("savings_application.do")
	public String savings_application(HttpServletRequest req, Model model) {
		
		itemService.customer_savings_add(req, model);
		
	return "redirect:savings_pro_list.do";
	}
	

	// ------------------------------------
	// 채팅테스트
	@RequestMapping("chat.do")
	public String chat(HttpServletRequest req, Model model) {
		logger.info("[url ==> chat.do]");
		return "customer/board/chat_counsel/customer";
	}
	
   @ResponseBody
   @RequestMapping(value = "trasnfer_ajax.do")
   public List<Map<String, Object>> transfer_ajax(Model model) {
      logger.info("[url ==> trasnfer_ajax.do]");
      List<AutoTransfer_ListDTO> list = autoService.get_Calender_List();

      JSONArray jsonArr = new JSONArray();
      JSONObject jsonObj = new JSONObject();
      
      Map<String,Object> map = new HashMap<String, Object>(); 
      
      for(int i=0;i<list.size();i++) {
    	 map.put("title", list.get(i).getJd_success());
    	 map.put("start", list.get(i).getJd_date());
    	 map.put("id", list.get(i).getJd_num());
    	 
    	 jsonObj = new JSONObject(map); 
    	 jsonArr.add(jsonObj);
      
    	 logger.info("jsonArr : " + jsonArr);
      }
      //Json값 전송
      return jsonArr;
   }	
   
}
