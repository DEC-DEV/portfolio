package com.spring.bank.dao;

import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.util.SettingValues;


@Repository
public class CustomerDAOImpl implements CustomerDAO{

	// SqlSession
	@Autowired
	private SqlSession sqlSession;

	// 아이디 중복 확인 처리
	@Override
	public int idCheck(String strId)   {
		System.out.println("Customer DAO - ID 중복확인 처리");
		return sqlSession.selectOne("com.spring.bank.dao.CustomerDAO.idCheck",strId);
	}

	// pwdCheck
	@Override
	public String pwdCheck(String strId) {
		System.out.println("Customer DAO - pwdCheck");
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		return dao.pwdCheck(strId);
	}

	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("dao 가입처리");
		int insertCnt = 0;
		try {
			insertCnt =
				sqlSession.insert("com.spring.bank.dao.CustomerDAO.insertCustomer",dto);
		}catch(Exception ex) {
			System.out.println("insertCustomer Error");
			ex.printStackTrace();
		}
		return insertCnt;
	}

	// 로그인 처리, 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(Map<String,Object> map) {

		int selectCnt = 0;
		try {
			selectCnt = sqlSession.selectOne("com.spring.bank.dao.CustomerDAO.idPasswordChk",map);
		}catch(Exception ex) {
			System.out.println("mapper error");
			ex.printStackTrace();
		}
		System.out.println("selectCnt : "+selectCnt);
	return selectCnt;
	}

	// 회원정보 인증 및 상세페이지
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		CustomerDTO dto = sqlSession.selectOne("com.spring.bank.dao.CustomerDAO.getCustomerDetail", strId);
		return dto;
	}

	// 회원정보 수정 처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		System.out.println("updateCustomer"+dto.toString());
		int updateCnt = 0;

		try {
			updateCnt = sqlSession.update("com.spring.bank.dao.CustomerDAO.updateCustomer",dto);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return updateCnt;
	}

	// 회원정보 인증 및 탈퇴처리
	@Override
	public int deleteCustomer(String strId) {
		int deleteChk = 0;
		try {
			deleteChk =sqlSession.delete("com.spring.bank.dao.CustomerDAO.deleteCustomer",strId);
		}catch(Exception ex) {
			System.out.println();
			ex.printStackTrace();
		}
		return deleteChk;
	}

	//시큐리티 -가입성공 시 이메일 인증을 위해 이메일 전송
	@Override
	public void sendEmail(String email, String key) {

		final String username = SettingValues.admin;      // 본인 이메일
	    final String password = SettingValues.pw;      // 본인 비밀번호
	    final String host = "smtp.gmail.com";

	    // SMTP(메일 서버) 설정

	    // 아래 import는 pom.xml에 mail API를 설정해야 가능
	    // import java.util.Properties;
	    Properties props = new Properties();
	    props.put("mail.smtp.user", username);         // SMTP에서 사용할 메일 주소
	    props.put("mail.smtp.password", password);      // 비밀번호
	    props.put("mail.smtp.host", host);            // host 서버 : gmail로 설정
	    props.put("mail.smtp.port", "25");            // 25번 포트 사용
	    props.put("mail.debug", "true");            // 디버그 설정
	    props.put("mail.smtp.auth", "true");         // 인증 : true
	    props.put("mail.smtp.starttls.enable", "true");   // tls 사용 허용
	    props.put("mail.smtp.ssl.enable", "true");      // ssl 허용
	    props.put("mail.smtp.ssl.trust", host);         // ssl 신뢰 가능으로 설정(보안레벨)
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

	    // propert값 설정
	    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.setProperty("mail.smtp.socketFactory.fallback", "false");
	    props.setProperty("mail.smtp.port", "465");
	    props.setProperty("mail.smtp.socketFactory.port", "465");

	    // import javax.mail.Session;
	    // import javax.mail.Authenticator
	    // import javax.mail.PasswordAuthentication
	    Session session = Session.getInstance(props, new Authenticator() {
	    	@Override
			protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });

	    // import javax.mail.Message
	    // import javax.mail.internet.MimeMessage;
	    // import javax.mail.internet.InternetAddress;
	    // import javax.mail.Transport
        // emailCheck.do를 컨트롤러에 작성해야함

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("choeung2@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	        // 링크를 클릭해서 이메일 인증 성공 -> endabled 를 1로 업데이트
	        String content ="회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
	                     + "<a href='http://localhost/bank/emailChk.do?key=" + key + "'>링크</a>";
	        // 발표자 링크주소로 변경
	        content = "회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
                    + "<a href='http://localhost:8088/bank/emailChk.do?key=" + key + "'>링크</a>";
	        message.setSubject("회원가입 인증 메일");
	        message.setContent(content, "text/html; charset=utf-8");

	        System.out.println("send");
	        Transport.send(message);
	        System.out.println("SEND");
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}

	// 시큐리티 : 로그인 전 이메일 인증을 해야 한다.
	@Override
	public int selectKey(String key) {
		return sqlSession.getMapper(CustomerDAO.class).selectKey(key);
	}

	// 시큐리티 : 로그인 전 이메일 인증을 해야 하며, 1로 수정
	@Override
	public int updateGrade(String key) {
		return sqlSession.getMapper(CustomerDAO.class).updateGrade(key);
	}

	@Override
	public void update_login_history(String id) {
		sqlSession.getMapper(CustomerDAO.class).update_login_history(id);
	}
}
