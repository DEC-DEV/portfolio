package com.spring.bank.dao;

import java.util.Map;

import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.LoansDTO;


public interface CustomerDAO {

		// ID 중복확인 처리
		public int idCheck(String strId);

		// 회원가입처리
		public int insertCustomer(CustomerDTO dto);

		// 로그인 처리
		public int idPasswordChk(Map<String,Object> map);

		// 회원 정보 인증 및 탈퇴
		public int deleteCustomer(String strId);

		// 회원 인증 및 상세 페이지
		public CustomerDTO getCustomerDetail(String strId);

		// 회원 정보 수정처리
		public int updateCustomer(CustomerDTO dto);

		// 시큐리티 -> 이메일 보내기
		public void sendEmail(String email, String key);

		// 시큐리티 - selectKey
		public int selectKey(String key);

		// 시큐리티
		public int updateGrade(String key);

	    // 시큐리티
		public String pwdCheck(String strId);
		
		// 로그인 접속 이력 확인 -2022-04/23( 최웅 )
		public void update_login_history(String id);

}
