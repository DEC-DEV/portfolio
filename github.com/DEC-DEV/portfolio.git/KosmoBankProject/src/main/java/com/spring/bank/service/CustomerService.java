package com.spring.bank.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface CustomerService {

	// 중복환인 처리
	public void confirmIdAction(HttpServletRequest req, Model model);
	
	// 신분증 인식
	public void readIdCard(HttpServletRequest req, Model model, MultipartHttpServletRequest reqs) throws IOException;

	// 회원가입 처리
	public void joinAction(HttpServletRequest req, Model model);

	// 이메일 인증
	public void emailChkAction(HttpServletRequest req, Model model);

	// 로그인 처리
	public void loginAction(HttpServletRequest req, Model model);
	
	// 로그인,로그아웃 접속 이력 update
	public void update_login_history(HttpServletRequest req, Model model);
}
