package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.NoticeDTO;


@Repository
public class AdminCsCenterDAOImpl implements AdminCsCenterDAO{

	// SqlSession
	@Autowired
	private SqlSession sqlSession;

	// 공지글 리스트 갯수
	@Override
	public int notice_list_cnt() {
		System.out.println("AdminCsCenterDAO DAO - 공지글 리스트 갯수");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_list_cnt();
	}

	// 공지글 리스트 조회
	@Override
	public List<NoticeDTO> notice_list_search(Map<String, Object> map) {
		System.out.println("AdminCsCenterDAO DAO - 공지글 리스트 조회");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_list_search(map);
	}

	// 공지글 상세 조회
	@Override
	public NoticeDTO notice_detail_search(int n_board_num) {
		System.out.println("AdminCsCenterDAO DAO - 공지글 상세 조회");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_detail_search(n_board_num);
	}

	// 공지글 등록 처리
	@Override
	public int notice_insert_action(NoticeDTO dto) {
		System.out.println("AdminCsCenterDAO DAO - 공지글 등록 처리");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_insert_action(dto);
	}

	// 공지글 수정 처리
	@Override
	public int notice_update_action(NoticeDTO dto) {
		System.out.println("AdminCsCenterDAO DAO - 공지글 수정 처리");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_update_action(dto);
	}

	// 공지글 삭제 처리
	@Override
	public int notice_delete_action(int n_board_num) {
		System.out.println("AdminCsCenterDAO DAO - 공지글 수정 처리");
		AdminCsCenterDAO dao = sqlSession.getMapper(AdminCsCenterDAO.class);
		return dao.notice_delete_action(n_board_num);
	}
}
