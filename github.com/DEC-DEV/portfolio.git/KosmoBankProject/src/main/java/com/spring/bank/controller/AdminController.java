package com.spring.bank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.bank.dto.TotalChartDTO;
import com.spring.bank.service.AdminCsCenterServiceImpl;
import com.spring.bank.service.AdminCustomerService;
import com.spring.bank.service.AdminFundServiceImpl;
import com.spring.bank.service.AdminItemServiceImpl;
import com.spring.bank.service.AdminTotalServiceImpl;
import com.spring.bank.service.ItemService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 관리자 고객센터 관리

	// 관리자 고객 관리

	// 관리자 - 펀드

	// 관리자 - 예금, 적금, 대출, 등

	@Autowired
	AdminCustomerService ACservice;
	@Autowired
	ItemService service;
	@Autowired
	AdminItemServiceImpl adminItemService;
	@Autowired
	AdminCsCenterServiceImpl adminCsCenterService;
	@Autowired
	AdminFundServiceImpl adminFundService;
	@Autowired
	AdminTotalServiceImpl adminTotalService;
	
	

	// ======================= 메인화면 ===========================
	@RequestMapping("/*.ad")
	public String admin_all(HttpServletRequest req, Model model) {
		logger.info("[url ==> admin.ad]");
		adminTotalService.productsignTotal(req, model);
		return "manager/admin";
	}
	@RequestMapping("admin.ad")
	public String admin_ad(HttpServletRequest req, Model model) {
		// 차트1 - 상품등록 사람 조회
		TotalChartDTO dto = adminTotalService.productsignTotal(req, model);
		// 차트2 - 예적금 상품 조회
		adminTotalService.product_blanace(req, model);
		// 차트3
		adminTotalService.loans_product_blanace(req, model);
		// 차트4
		adminTotalService.fund_product_blanace(req, model);
		// 차트5
		adminTotalService.fundTotal(req, model);
		// 차트 6
		adminTotalService.loansTotal(req, model);
		
		// 대출 bar 차트 호출
		adminTotalService.loansbarChartTotal(req, model);
		
		return "manager/admin";
	}
	

	// ============================ 대출 ===================================

	// 대출리스트 - 신청자 리스트
	@RequestMapping("/loan_list.ad")
	public String loan(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_list.ad]");
		adminItemService.loan_pro_detail_list(req, model);
		return "manager/loan/loan_list";
	}
	
	// 대출리스트 - 신청자 리스트
	@RequestMapping("/loan_list_detail.ad")
	public String loan_list_detail(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_list_detail.ad]");
		adminItemService.loan_detail_list(req, model);
		return "manager/loan/loan_list_detail";
	}
	
	// 대출리스트 - 신청자 리스트 수정버튼 클릭
	@RequestMapping("/loan_list_update.ad")
	public String loan_list_update(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_list_update.ad]");
		adminItemService.loan_update_detail_list(req, model);
		return "manager/loan/loan_update_action";
	}
	
	// 대출리스트 - 신청자 리스트 삭제버튼 클릭
	@RequestMapping("/loan_list_delete.ad")
	public String loan_list_delete(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_list_delete.ad]");
		adminItemService.loan_delete_detail_list(req, model);
		return "manager/loan/loan_delete_action";
	}
	
	// 대출리스트 - 신청자 리스트 승인버튼 클릭
	@RequestMapping("/loan_approve_action.ad")
	public String loan_approve_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_approve_action.ad]");
		adminItemService.loan_approve(req, model);
		return "manager/loan/loan_approve_action";
	}
	
	// 대출리스트 - 신청자 리스트 거절버튼 클릭
	@RequestMapping("/loan_delete_action.ad")
	public String loan_delete_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_delete_action.ad]");
		adminItemService.loan_deny(req, model);
		return "manager/loan/loan_deny_action";
	}
	
	
// =============================================================================
	// 대출 상품 리스트
	@RequestMapping("/loan_pro_list_2.ad")
	public String loan_pro_list_2(HttpServletRequest req, Model model) {
		logger.info("url ==> loan_pro_list_2.ad");
		adminItemService.loan_pro_list(req, model);
		return "manager/loan/loan_pro_list_2";
	}

	// 대출 상품 상세
	@RequestMapping("/loan_pro_detail.ad")
	public String loan_pro_detail(HttpServletRequest req, Model model) {
		logger.info("url ==> loan_pro_detail.ad");

		adminItemService.loan_pro_detail(req, model);
		return "manager/loan/loan_pro_detail";
	}

	// 대출 상품 등록 페이지
	@RequestMapping("/loan_pro_add.ad")
	public String loan_pro_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_pro_add.ad]");

		return "manager/loan/loan_pro_add";
	}

	// 대출 상품 등록 버튼 클릭
	@RequestMapping("/loan_pro_add_action.ad")
	public String loan_pro_add_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_pro_add_action.ad]");

		adminItemService.loan_pro_add(req, model);

		return "manager/loan/loan_pro_add_action";
	}

	// 대출 상세 삭제버튼 클릭
	@RequestMapping("/loan_pro_delete_action.ad")
	public String loan_Pro_Delete(HttpServletRequest req, Model model) {
		logger.info("[url ==> loan_Pro_Delete.ad]");
		adminItemService.loan_pro_delete(req, model);

		return "manager/loan/loan_pro_delete_action";
	}

	// 대출 상세 수정버튼 클릭
	@RequestMapping("/loan_pro_update_action.ad")
	public String loan_pro_update_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> manager/loan/loan_pro_update_action.ad]");
		adminItemService.loan_pro_update(req, model);
		return "manager/loan/loan_pro_update_action";
	}
	// ============================ 관리자 대출 끝 ===================================

	/*
	 * 대출계좌 상세조회
	 */
	@RequestMapping("loan_account_detail.ad")
	public String loan_Account_Detail() {
		logger.info("[Manager Controller ==> loan_account_detail]");

		return "customer/loan/loan_account_detail";
	}

	/*
	 * 대출이자 조회
	 */
	@RequestMapping("loan_interest_search.ad")
	public String loan_Rate_Search() {
		logger.info("[Manager Controller ==> loan_interest_search]");

		return "customer/loan/loan_interest_search";
	}

	/*
	 * @RequestMapping("/loan_Pro_List.ad") public String loan_Pro_List() {
	 * logger.info("[url ==> loan_Pro_List.ad]"); return
	 * "manager/loan/loan_Pro_List"; }
	 */
	// ============================== 적금 ======================================
	// 적금 상품 등록 ( 관리자 )
	@RequestMapping("savings_add.ad")
	public String savings_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_add.ad]");

		return "manager/savings/savings_add";
	}
	// 적금 상품 등록 처리 ( 관리자 )
	@RequestMapping("savings_add_action.ad")
	public String savings_add_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_add_action.ad]");

		service.savings_Add_Action(req, model);

		return "manager/savings/savings_add_action";
	}

	// 적금 상품 상세
	@RequestMapping("savings_Item.ad")
	public String savings_Item(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_Item.ad]");

		service.savings_Detail_Action(req, model);

		return "manager/savings/savings_Item";
	}

	// 적금 상품 리스트
	@RequestMapping("savingsList.ad")
	public String savingsList(HttpServletRequest req, Model model) {
		logger.info("[url ==> savingsList.ad]");

		service.savings_List_Search(req, model);

		return "manager/savings/savingsList";
	}
	// 적금 상품 삭제
	@RequestMapping("savings_delete.ad")
	public String savings_Delete(HttpServletRequest req, Model model) {
		logger.info("[url ==> savings_delete.ad]");

		service.savings_Delete_Action(req, model);

		return "manager/savings/savings_delete_action";
	}
	// 적금 상품 수정( 관리자 )
	@RequestMapping("savings_update.ad")
	public String savings_update(HttpServletRequest req, Model model) {
		logger.info("savings_update.ad");

		service.savings_Detail_Action(req, model);

		return "manager/savings/savings_update";
	}

	// 적금 상품 수정 처리( 관리자 )
	@RequestMapping("savings_update_action.ad")
	public String savings_update_action(HttpServletRequest req, Model model) {
		logger.info("savings_update_action.ad");

		service.savings_Update_Action(req, model);

		return "manager/savings/savings_update_action";
	}

	// ======================================= 관리자 펀드 ===========================

	// 관리자 펀드승인목록
	@RequestMapping("/fund_approve.ad")
	public String fund_approve(HttpServletRequest req, Model model) {
		logger.info("[url ==> fund_approve.ad]");

		adminFundService.fund_list(req, model);

		return "manager/fund/fund_approve";
	}

	// 관리자 펀드승인
	@RequestMapping("/fund_approve_action.ad")
	public String fund_approve_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> fund_approve_action.ad]");

		adminFundService.fund_approve(req, model);

		return "manager/fund/fund_approve_action";
	}

	// 관리자 펀드거절
	@RequestMapping("/fund_delete_action.ad")
	public String fund_delete_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> fund_delete_action.ad]");

		adminFundService.fund_delete(req, model);

		return "manager/fund/fund_delete_action";
	}

	// 관리자 펀드상세정보
	@RequestMapping("/fund_detail.ad")
	public String fund_detail(HttpServletRequest req, Model model) {
		logger.info("[url ==> fund_detail.ad]");

		adminFundService.fund_detail(req, model);
		return "manager/fund/fund_detail";
	}

	// 관리자 펀드수정
	@RequestMapping("fund_update_action.ad")
	public String fund_update_action(MultipartHttpServletRequest req, Model model) throws IOException {

		logger.info("[url ==> fund_update_action.ad]");
		adminFundService.fund_update_action(req, model);

		return "manager/fund/fund_update_action";
	}

	// 관리자 펀드삭제
	@RequestMapping("fund_delete.ad")
	public String fund_delete(HttpServletRequest req, Model model) {

		logger.info("[url ==> fund_delete.ad]");
		adminFundService.fund_delete_action(req, model);

		return "manager/fund/fund_delete";
	}

	// ======================= ?? ( 계좌 조회 ) ================================

	/*
	 * 입출금 계좌
	 */

	@RequestMapping("cu_account_Check.ad")
	public String cu_account_Check() {
		logger.info("[Manager Controller ==> account_Check_dw]");

		return "customer/account_serach/account_search_cw";
	}

	/*
	 * 전체 계좌
	 */
	@RequestMapping("account_search_account.ad")
	public String account_Check_allAccount() {
		logger.info("[Manager Controller ==> account_Check_allAccount]");

		return "customer/account_serach/account_search_account";
	}

	/*
	 * 예금 계좌
	 */
	@RequestMapping("account_search_deposit.ad")
	public String account_Check_Deposit() {
		logger.info("[Manager Controller ==> account_Check_Deposit]");

		return "customer/account_serach/account_search_deposit";
	}

	/*
	 * 휴면 계좌
	 */
	@RequestMapping("account_search_dormancy.ad")
	public String account_Check_dormancy() {
		logger.info("[Manager Controller ==> account_Check_dormancy]");

		return "customer/account_serach/account_search_dormancy";
	}

	/*
	 * 대출 계좌
	 */
	@RequestMapping("account_search_loan.ad")
	public String account_Check_loan() {
		logger.info("[Manager Controller ==> account_Check_loan]");

		return "customer/account_serach/account_search_loan";
	}

	/*
	 * 적금 계좌
	 */
	@RequestMapping("account_search_savings.ad")
	public String account_Check_Savings() {
		logger.info("[Manager Controller ==> account_Check_Savings]");

		return "customer/account_serach/account_search_savings";
	}

	// ========================= 예금 ============================== 
	/*
	 * 매니저 - 예금 목록
	 */
	@RequestMapping("deposit_list.ad")
	public String deposit_list(HttpServletRequest req, Model model) {
		logger.info("[Manager Controller ==> deposit_list]");

		service.deposit_List_Search(req, model);

		return "manager/deposit/deposit_list";
	}

	/*
	 * 매니저 - 예금 등록
	 */
	@RequestMapping("deposit_add.ad")
	public String deposit_add(HttpServletRequest req, Model model) {
		logger.info("[Manager Controller ==> deposit_add]");
		System.out.println("관리자 예금 등록 ");

		return "manager/deposit/deposit_add";
	}

	/*
	 * 매니저 - 예금 등록 처리
	 */
	@RequestMapping("deposit_add_action.ad")
	public String deposit_add_action(HttpServletRequest req, Model model) {
		logger.info("[Manager Controller ==> deposit_add_action]");

		service.deposit_Add_Action(req, model);

		return "manager/deposit/deposit_add_action";
	}

	/*
	 * 매니저 - 예금상품 수정
	 */
	@RequestMapping("deposit_update.ad")
	public String deposit_update(HttpServletRequest req, Model model) {
		logger.info("[Manager Controller ==> deposit_update]");

		service.deposit_Detail_Action(req, model);

		return "manager/deposit/deposit_update";
	}

	 @RequestMapping("deposit_update_action.ad")
	 public String deposit_update_action(HttpServletRequest req, Model model) {
	 logger.info("[Manager Controller ==> deposit_update_action]");

	 service.deposit_Update_Action(req, model);

	 return "manager/deposit/deposit_update_action";
	 }

	 @RequestMapping("deposit_delete.ad")
	 public String deposit_delete_action(HttpServletRequest req, Model model) {
	 logger.info("[Manager Controller ==> deposit_delete_action]");

	 service.deposit_Delete_Action(req, model);

	 return "manager/deposit/deposit_delete_action";
	 }

	// 04-21 conflict 해결 중 모르겠어서 주석으로 처리했음
	// 주석 해제 후 확인 부탁드립니다
	/*
	 * // =================== 적금 ======================
	 *
	 * 매니저 - 적금상품 목록
	 *
	 * //@RequestMapping("savings_list.ad") //public String savings_list() {
	 * //logger.info("[Manager Controller ==> savings_list]");
	 *
	 *
	 * //return "manager/savings/savings_list"; //}
	 *
	 *
	 * 매니저 - 적금상품 등록
	 *
	 * //@RequestMapping("savings_add.ad") //public String savings_add() {
	 * //logger.info("[Manager Controller ==> savings_add]");
	 *
	 * //return "manager/savings/savings_add"; //}
	 *
	 *
	 * 매니저 - 적금상품 수정
	 *
	 * //@RequestMapping("savings_update.ad") //public String savings_update() {
	 * //logger.info("[Manager Controller ==> savings_update]");
	 *
	 *
	 * //return "manager/savings/savings_update"; //=======
	 *
	 * 매니저 - 예금상품 수정 처리
	 *
	 * //@RequestMapping("deposit_update_action.ad") //public String
	 * deposit_update_action(HttpServletRequest req, Model model) { //
	 * logger.info("[Manager Controller ==> deposit_update_action]");
	 *
	 * // service.deposit_Update_Action(req, model);
	 *
	 * //return "manager/deposit/deposit_update_action"; //}
	 *
	 * 매니저 - 예금상품 삭제 처리
	 *
	 * //@RequestMapping("deposit_delete.ad") //public String
	 * deposit_delete_action(HttpServletRequest req, Model model) {
	 * //logger.info("[Manager Controller ==> deposit_delete_action]");
	 *
	 * //service.deposit_Delete_Action(req, model);
	 *
	 * // return "manager/deposit/deposit_delete_action"; //}
	 *
	 * 매니저 - 예금상품 상세 처리
	 *
	 * // @RequestMapping("deposit_Item.ad") // public String
	 * deposit_Item(HttpServletRequest req, Model model) { //
	 * logger.info("[Manager Controller ==> deposit_Item]");
	 *
	 * // service.deposit_Detail_Action(req, model);
	 *
	 * // return "manager/deposit/deposit_Item"; // } // ==================== 펀드
	 * ============================== // 펀드 // @RequestMapping("/fund.ad") // public
	 * String fund() { // logger.info("[url ==> fund.ad]"); // return
	 * "manager/fund/fund"; //>>>>>>> master // }
	 */

	// ======================================= 고객 센터 ===========================

	// 상담글 리스트 조회
	@RequestMapping("counsel_list_search.ad")
	public String loanTermination(HttpServletRequest req, Model model) {
		logger.info("[url ==> counsel_list_search.ad]");
		adminCsCenterService.counsel_list_search(req, model);
		return "manager/csCenter/counsel_list_search";
	}

	// 상담글 상세조회
	@RequestMapping("counsel_detail_search.ad")
	public String counsel_detail_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> counsel_detail_search.ad]");
		adminCsCenterService.counsel_detail_search(req, model);
		return "manager/csCenter/counsel_detail_search";
	}

	// 상담글 상세조회시 댓글리스트 불러오기
	@RequestMapping("counsel_coment_list_search.ad")
	public String counsel_coment_list_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> counsel_coment_list_search.ad]");
		adminCsCenterService.counsel_coment_list_search(req, model);
		return "manager/csCenter/counsel_coment_list_search";
	}

	// 상담글 상세조회시 댓글 달기
	@RequestMapping("counsel_coment_add.ad")
	public String counsel_coment_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> counsel_coment_add.ad]");
		adminCsCenterService.counsel_coment_add(req, model);
		return "manager/csCenter/counsel_coment_list_search";
	}

	// 상담글 삭제처리
	@RequestMapping("counsel_delete_action.ad")
	public String counsel_delete_action(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("[url ==> counsel_delete_action.ad]");
		adminCsCenterService.counsel_delete_action(req, model);
		return "redirect:counsel_list_search.ad";
	}

	// 공지글 등록 페이지
	@RequestMapping("notice_insert.ad")
	public String service_center_add(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_insert.ad]");
		return "manager/csCenter/notice_insert";
	}

	// 공지글 등록 처리
	@RequestMapping("notice_insert_action.ad")
	public String notice_insert_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_insert_action.ad]");
		adminCsCenterService.notice_insert_action(req, model);
		return "redirect:notice_list_search.ad";
	}

	// 공지글 리스트 조회
	@RequestMapping("notice_list_search.ad")
	public String notice_list_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_list_search.ad]");
		adminCsCenterService.notice_list_search(req, model);
		return "manager/csCenter/notice_list_search";
	}

	// 공지글 상세보기
	@RequestMapping("notice_detail_search.ad")
	public String notice_detail_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_detail_search.ad]");
		adminCsCenterService.notice_detail_search(req, model);
		return "manager/csCenter/notice_detail_search";
	}

	// 공지글 삭제
	@RequestMapping("notice_delete.ad")
	public String service_center_delete(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_delete.ad]");
		return "manager/csCenter/notice_delete";
	}

	// 공지글 수정/삭제 페이지
	@RequestMapping("notice_update.ad")
	public String service_center_update(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_update.ad]");
		adminCsCenterService.notice_update(req, model);
		return "manager/csCenter/notice_update";
	}

	// 공지글 수정처리
	@RequestMapping("notice_update_action.ad")
	public String notice_update_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_update_action.ad]");
		int num = Integer.parseInt(req.getParameter("boardNum"));
		adminCsCenterService.notice_update_action(req, model);
		return "redirect:notice_update.ad?boardNum=" + num;
	}

	// 공지글 삭제처리
	@RequestMapping("notice_delete_action.ad")
	public String notice_delete_action(HttpServletRequest req, Model model) {
		logger.info("[url ==> notice_delete_action.ad]");
		adminCsCenterService.notice_delete_action(req, model);
		return "redirect:notice_list_search.ad";
	}

	// ============ ㄴ계좌 관리 =================
//	@RequestMapping("account_transfer_history.ad")
//	public String account_transfer_history() {
//		logger.info("이체 내역 조회");
//		return "manager/management/account_transfer_history";
//	}

	// -------------------계좌정보--------------------
	// 회원별 계좌 관리
	@RequestMapping("account_info.ad")
	public String account_info(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_info.ad]");
		ACservice.account_info(req, model);
		return "manager/management/account_info";
	}
	
	String viewPage = "";

	// 관리자 - 회원 계좌 비밀번호 변경
	@RequestMapping("account_password_update.ad")
	public void account_password_update(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("[url ==> account_password_update.ad]");
		ACservice.account_password_update(req, model);
		viewPage = req.getContextPath() + "/account_info.ad";
		res.sendRedirect(viewPage);
	}

	// 관리자 - 회원 계좌 상태 변경
	@RequestMapping("account_state.ad")
	public void account_state(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("[url ==> account_state.ad]");
		ACservice.account_state(req, model);
		viewPage = req.getContextPath() + "/account_info.ad";
		res.sendRedirect(viewPage);
	}


	// 관리자 - 한도변경 - 승인
	@RequestMapping("account_limit_ok.ad")
	public void account_limit_ok(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
		logger.info("[url ==> account_limit_ok.ad]");
		ACservice.account_limit_ok(req, model);
		viewPage = req.getContextPath() + "/account_info.ad";
		res.sendRedirect(viewPage);
	}

	
	// 관리자 - 회원 계좌이체 내역 목록
	@RequestMapping("account_transfer_history.ad")
	public String account_transfer_history(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_transfer_history.ad]");
		ACservice.account_transfer_history(req, model);
		return "manager/management/account_transfer_history";
	}

	// 관리자 - 한도변경 - 거절
	@RequestMapping("account_max_no.ad")
	public String account_max_no() {
		logger.info("[url ==> account_max_no.ad]");
		return "manager/management/account_max_no";
	}
	
	// 관리자 - 계좌정보 검색
	@RequestMapping("account_search.ad")
	public String account_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_search.ad]");
		ACservice.account_search(req, model);
		return "manager/management/account_info_search";
	}
	
	// 관리자 - 계좌이체 내역 검색
	@RequestMapping("account_transfer_history_search.ad")
	public String account_transfer_history_search(HttpServletRequest req, Model model) {
		logger.info("[url ==> account_transfer_history_search.ad]");
		ACservice.account_transfer_history_search(req, model);
		return "manager/management/account_transfer_history_search";
	}
	

	// ----------------------------------------------------------

	// 채팅테스트
	@RequestMapping("chat.ad")
	public String chat(HttpServletRequest req, Model model) {
		logger.info("[url ==> chat.ad]");
		return "manager/csCenter/admin";
	}
	
}
