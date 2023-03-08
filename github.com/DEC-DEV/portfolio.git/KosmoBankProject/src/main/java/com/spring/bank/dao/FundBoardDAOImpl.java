package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.bank.dto.Fund_boardDTO;
import com.spring.bank.dto.Fund_board_commentDTO;


@Repository
public class FundBoardDAOImpl implements FundBoardDAO{

	// SqlSession
	@Autowired
	private SqlSession sqlSession;

	// 펀드글 등록 처리
	@Override
	public int fund_insert_action(Fund_boardDTO dto) {
		System.out.println("fundBoard DAO - 펀드글 등록 처리");
		System.out.println("dto 확인 : " + dto);
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_insert_action(dto);
	}

	// 펀드글 리스트 갯수
	@Override
	public int fund_list_cnt() {
		System.out.println("fundBoard DAO - 펀드글 리스트 갯수");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_list_cnt();
	}

	// 펀드글 리스트 조회
	@Override
	public List<Fund_boardDTO> fund_list_search(Map<String, Object> map) {
		System.out.println("fundBoard DAO - 펀드글 리스트 조회");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_list_search(map);
	}

	// 펀드글 상세 조회
	@Override
	public Fund_boardDTO fund_detail_search(int f_num) {
		System.out.println("fundBoard DAO - 펀드글 상세 조회");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_detail_search(f_num);
	}


	// 펀드글 상세조회시 댓글달기
	@Override
	public int fund_coment_add(Fund_board_commentDTO dto) {
		System.out.println("fundBoard DAO - 펀드글 상세조회시 댓글리스트 불러오기");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_coment_add(dto);
	}

	// 펀드글 상세조회시 댓글리스트 불러오기
	@Override
	public List<Fund_board_commentDTO> fund_coment_list_search(int f_num) {
		System.out.println("fundBoard DAO - 펀드글 상세조회시 댓글리스트 불러오기");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_coment_list_search(f_num);
	}


	// 펀드글 수정/삭제시 비밀번호 체크
	@Override
	public String fund_update_password_check(Map<String, Object> map) {
		System.out.println("fundBoard DAO - 펀드글 수정/삭제시 비밀번호 체크");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_update_password_check(map);
	}

	// 펀드글 수정 처리
	@Override
	public int fund_update_action(Fund_boardDTO dto) {
		System.out.println("fundBoard DAO - 펀드글 수정 처리");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_update_action(dto);
	}

	// 펀드글 삭제 처리
	@Override
	public int fund_delete_action(int f_num) {
		System.out.println("fundBoard DAO - 펀드글 삭제 처리");
		FundBoardDAO dao = sqlSession.getMapper(FundBoardDAO.class);
		return dao.fund_delete_action(f_num);
	}

}
