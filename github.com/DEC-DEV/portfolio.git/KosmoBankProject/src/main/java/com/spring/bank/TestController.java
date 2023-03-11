package com.spring.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//테스트용 임시 컨트롤러
@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/*
	 * @RequestMapping("loanList.do") public String loanList() {
	 * logger.info("TestController - 대출상품리스트");
	 * 
	 * return "customer/loan/loan_list"; }
	 * 
	 * @RequestMapping("loan_apply.do") public String register() {
	 * logger.info("TestController - 대출상품리스트");
	 * 
	 * return "customer/loan/loan_apply"; }
	 * 
	 * @RequestMapping("loan_principal_search_paid.do") public String
	 * loan_principal_search_paid() { logger.info("TestController - 대출상품리스트");
	 * 
	 * return "customer/loan/loan_principal_search_paid"; }
	 * 
	 * @RequestMapping("loan_cancel_search.do") public String loan_cancel_search() {
	 * logger.info("TestController - 대출상품리스트");
	 * 
	 * return "customer/loan/loan_cancel_search"; } // 대출 이자 납부
	 * 
	 * @RequestMapping("loan_interest_search_paid.do") public String
	 * loan_interest_search_paid() { return
	 * "customer/loan/loan_interest_search_paid"; } // 대출 이자 조회, 대출 이자 납부
	 * 
	 * 
	 * 
	 * 
	 * //--------------------[상담]--------------------
	 * 
	 * @RequestMapping("counsel_list_search.do") public String loanTermination() {
	 * logger.info("TestController - 상담");
	 * 
	 * return "customer/board/counsel/counsel_list_search"; }
	 * 
	 * @RequestMapping("counsel_detail_search.do") public String
	 * counsel_detail_search() { logger.info("TestController - 상담상세");
	 * 
	 * return "customer/board/counsel/counsel_detail_search"; }
	 * 
	 * @RequestMapping("counsel_update.do") public String counsel_update() {
	 * logger.info("TestController - 상담 업데이트");
	 * 
	 * return "customer/board/counsel/counsel_update"; }
	 * 
	 * 
	 * //--------------------[공지]--------------------
	 * 
	 * @RequestMapping("notice_list_search.do") public String notice_list_search() {
	 * logger.info("TestController - 공지");
	 * 
	 * return "customer/board/notice/notice_list_search"; }
	 * 
	 * @RequestMapping("notice_detail_search.do") public String
	 * notice_detail_search() { logger.info("TestController - 대출상품리스트");
	 * 
	 * return "customer/board/notice/notice_detail_search"; }
	 */
}
