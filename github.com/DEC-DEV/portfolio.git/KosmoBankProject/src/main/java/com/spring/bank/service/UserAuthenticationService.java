package com.spring.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.UserVO;


public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	SqlSessionTemplate sqlSession;

	public UserAuthenticationService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		System.out.println("<<<UserAuthenticationService - loadUserByUsername 진입 >>>");
		CustomerDTO dto = sqlSession.selectOne("com.spring.bank.dao.CustomerDAO.selectCustomer", id);
		System.out.println("로그인 체크 ==> " + dto);

		if(dto == null) {
			throw new UsernameNotFoundException(id);
		}
		System.out.println("UserAuthenticationService  : "+dto.toString());

		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();

		authority.add(new SimpleGrantedAuthority(dto.getAuthority()));  // default 'ROLE_USER'

		return new UserVO(dto.getId(), dto.getPassword(), dto.getEnabled().equals("1"),
				true, true, true, authority);
	}

}
