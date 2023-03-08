package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.FundDTO;

@Repository
public class AdminFundDAOImpl implements AdminFundDAO {

	@Autowired
	SqlSession sqlSession;
	
	// 관리자 펀드목록
	@Override
	public List<FundDTO> fund_list(Map<String, Object> map) {
		System.out.println("dao - fund_list");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_list(map);
	}

	// 관리자 펀드 갯수
	@Override
	public int fund_cnt() {
		System.out.println("dao - fund_cnt");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_cnt();
	}

	// 관리자 펀드상세페이지
	@Override
	public FundDTO fund_detail(int f_num) {
		System.out.println("dao - fund_cnt");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_detail(f_num);
	}

	// 관리자 펀드 승인
	@Override
	public int fund_approve(Map<String, Object> map) {
		System.out.println("dao - fund_approve");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_approve(map);
	}

	// 관리자 펀드 거절
	// 관리자 승인목록에서 주문거절
	@Override
	public int fund_delete(Map<String, Object> map) {
		System.out.println("dao - fund_delete");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_delete(map);
	}

	// 관리자 펀드수정
	@Override
	public int fund_update_action(FundDTO dto) {
		System.out.println("dao - fund_update_action");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_update_action(dto);
	}

	// 관리자 펀드삭제
	// 펀드상세페이지에서 아예 삭제
	@Override
	public int fund_delete_action(int f_num) {
		System.out.println("dao - fund_delete_action");
		AdminFundDAO dao = sqlSession.getMapper(AdminFundDAO.class);
		return dao.fund_delete_action(f_num);
	}

}
