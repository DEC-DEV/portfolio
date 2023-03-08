package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.CounselCommentDTO;
import com.spring.bank.dto.CounselDTO;
import com.spring.bank.dto.NoticeDTO;


@Repository
public class CsCenterDAOImpl implements CsCenterDAO{

	// SqlSession
	@Autowired
	private SqlSession sqlSession;

	// 상담글 등록 처리
	@Override
	public int counsel_insert_action(CounselDTO dto) {
		System.out.println("CsCenter DAO - 상담글 등록 처리");
		System.out.println("dto 확인 : " + dto);
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_insert_action(dto);
	}

	// 상담글 리스트 갯수
	@Override
	public int counsel_list_cnt() {
		System.out.println("CsCenter DAO - 상담글 리스트 갯수");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_list_cnt();
	}

	// 상담글 리스트 조회
	@Override
	public List<CounselDTO> counsel_list_search(Map<String, Object> map) {
		System.out.println("CsCenter DAO - 상담글 리스트 조회");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_list_search(map);
	}

	// 상담글 상세 조회
	@Override
	public CounselDTO counsel_detail_search(int b_num) {
		System.out.println("CsCenter DAO - 상담글 상세 조회");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_detail_search(b_num);
	}

	// 공지글 리스트 갯수
	@Override
	public int notice_list_cnt() {
		System.out.println("CsCenter DAO - 공지글 리스트 갯수");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.notice_list_cnt();
	}

	// 상담글 상세조회시 댓글달기
	@Override
	public int counsel_coment_add(CounselCommentDTO dto) {
		System.out.println("CsCenter DAO - 상담글 상세조회시 댓글리스트 불러오기");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_coment_add(dto);
	}

	// 상담글 상세조회시 댓글리스트 불러오기
	@Override
	public List<CounselCommentDTO> counsel_coment_list_search(int b_num) {
		System.out.println("CsCenter DAO - 상담글 상세조회시 댓글리스트 불러오기");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_coment_list_search(b_num);
	}

	// 상담글 수정/삭제시 비밀번호 체크
	@Override
	public String counsel_update_password_check(Map<String, Object> map) {
		System.out.println("CsCenter DAO - 상담글 수정/삭제시 비밀번호 체크");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_update_password_check(map);
	}

	// 상담글 수정 처리
	@Override
	public int counsel_update_action(CounselDTO dto) {
		System.out.println("CsCenter DAO - 상담글 수정 처리");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_update_action(dto);
	}

	// 상담글 삭제 처리
	@Override
	public int counsel_delete_action(int b_num) {
		System.out.println("CsCenter DAO - 상담글 삭제 처리");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.counsel_delete_action(b_num);
	}

	// 공지글 리스트 조회
	@Override
	public List<NoticeDTO> notice_list_search(Map<String, Object> map) {
		System.out.println("CsCenter DAO - 공지글 리스트 조회");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.notice_list_search(map);
	}

	// 공지글 상세 조회
	@Override
	public NoticeDTO notice_detail_search(int n_board_num) {
		System.out.println("CsCenter DAO - 공지글 상세 조회");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.notice_detail_search(n_board_num);
	}

	// 공지글 상세 조회시 조회수 증가
	@Override
	public int notice_detail_view_add(int n_board_num) {
		System.out.println("CsCenter DAO - 공지글 상세 조회시 조회수 증가");
		CsCenterDAO dao = sqlSession.getMapper(CsCenterDAO.class);
		return dao.notice_detail_view_add(n_board_num);
	}
}
