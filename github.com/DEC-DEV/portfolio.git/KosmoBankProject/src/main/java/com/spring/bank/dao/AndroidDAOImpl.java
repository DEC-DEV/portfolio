package com.spring.bank.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.FundDTO;


@Repository
public class AndroidDAOImpl implements AndroidDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public String pwdCheck(String Id) {
		System.out.println("AndroidDAO - pwdCheck");
		AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
		return dao.pwdCheck(Id);
	}

	@Override
	public String authorityCheck(String Id) {
		System.out.println("AndroidDAO - authorityCheck");
		AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
		return dao.authorityCheck(Id);
	}

	@Override
	public CustomerDTO getMemberInfo(String id) {
		System.out.println("AndroidDAO - getMemberInfo");
		AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
		CustomerDTO m = dao.getMemberInfo(id);

		System.out.println("dao m : " + m);

		return m;
	}
	
	// 회원가입
	@Override
	public int join(CustomerDTO dto) {
		System.out.println("AndroidDAO - join");
		AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
		return dao.join(dto);
	}
	
   // 
   @Override
   public FundDTO getFundInfo(String id) {
      System.out.println("AndroidDAO - getFundInfo");
      AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
      return dao.getFundInfo(id);
   }

	//
   @Override
   public List<FundDTO> fund_list(String id) {
      System.out.println("AndroidDAO - fund_list");
      AndroidDAO dao = sqlSession.getMapper(AndroidDAO.class);
      return dao.fund_list(id);
   }

}
