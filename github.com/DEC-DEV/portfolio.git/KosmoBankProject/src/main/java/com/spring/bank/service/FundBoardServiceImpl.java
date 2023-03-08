package com.spring.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.spring.bank.dao.FundBoardDAO;
import com.spring.bank.dto.Fund_boardDTO;
import com.spring.bank.dto.Fund_board_commentDTO;
import com.spring.bank.util.Paging;

@Service
public class FundBoardServiceImpl implements FundBoardService{

	@Autowired 
	FundBoardDAO dao;

	@Autowired
    BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스


	// 펀드글 등록 처리
	@Override
	public void fund_insert_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 펀드글 등록 처리");
		Fund_boardDTO dto = new Fund_boardDTO();

		dto.setF_name(req.getParameter("writer"));
		dto.setF_title(req.getParameter("title"));
		dto.setF_content(req.getParameter("content"));
		dto.setF_password(req.getParameter("password"));

		int insertCnt = dao.fund_insert_action(dto);

		model.addAttribute("insertCnt", insertCnt);
	}

	// 펀드글 리스트 조회
	@Override
	public void fund_list_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_list_search");

		String pageNum = req.getParameter("pageNum");

		//페이징 번호 처리
		Paging paging = new Paging(pageNum);

		//전체 펀드글 갯수 카운트
		int total = dao.fund_list_cnt();
		paging.setTotalCount(total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		System.out.println("start : " + start);
		System.out.println("end : " + end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);

		// 펀드글 목록
		List<Fund_boardDTO> list = dao.fund_list_search(map);

		System.out.println("펀드글 목록 확인 : " + list);

		if(list == null) {
			System.out.println("list가 null");
		} else if(list.isEmpty()) {
			System.out.println("list가 isEmpty");
		}

		//jsp로 처리 결과 전달
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

	// 펀드글 상세 조회
	@Override
	public void fund_detail_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_detail_search");

		//화면 입력 받은 값을 받아
		String pageNum = req.getParameter("pageNum");
		int f_num = Integer.parseInt(req.getParameter("num"));

		//게시글 정보 조회

		Fund_boardDTO dto = new Fund_boardDTO();
		dto = dao.fund_detail_search(f_num);

		//jsp로 처리 결과 전달
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto);
	}

	// 펀드리스트 상세조회시 댓글 달기
	@Override
	public void fund_coment_add(HttpServletRequest req, Model model) {
		Fund_board_commentDTO dto = new Fund_board_commentDTO();
		
		dto.setF_num(Integer.parseInt(req.getParameter("board_num")));
		dto.setWriter(req.getParameter("writer"));
		dto.setContent(req.getParameter("content"));

		System.out.println("Service - commentInsert 전");
		dao.fund_coment_add(dto);
		System.out.println("Service - commentInsert 후");
		//실행이 끝나면 board_detailAction.jsp의 comment_add() 콜백함수(success)로 넘어감

		
	}

	// 펀드리스트 상세조회시 댓글리스트 불러오기
	@Override
	public void fund_coment_list_search(HttpServletRequest req, Model model) {
		int f_num = Integer.parseInt(req.getParameter("num"));
		System.out.println("Service num : " + f_num);

		//5. 게시글 목록
		List<Fund_board_commentDTO> list = dao.fund_coment_list_search(f_num);
		System.out.println("list : " + list);
		//6. jsp로 처리 결과 전달 (request나 session으로 전달)
		model.addAttribute("list", list); // => comment_list()의 콜백함수의 result로 전
		
	}


	// 펀드글 수정/삭제시 비밀번호 체크
	@Override
	public String fund_update_password_check(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 펀드글 수정/삭제시 비밀번호 체크");

		//3단계. 화면으로부터 입력받은 값을 받는다
		int num = Integer.parseInt(req.getParameter("boardNum"));
		String password = req.getParameter("password");
		System.out.println("f_num : " + num);
		System.out.println("password : " + password);

		//5단계. 패스워드 일치 확인(비밀번호 인증)
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("f_num", num);
	    map.put("f_password", password);

	    String result = dao.fund_update_password_check(map);
	    System.out.println("비밀번호 체크 결과 : " + result);

	    return result;
	}

	// 펀드글 수정/삭제 페이지
	@Override
	public void fund_update(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 펀드글 수정/삭제 페이지");

		//3단계. 화면으로부터 입력받은 값을 받는다
		int f_num = Integer.parseInt(req.getParameter("f_num"));
		String password = req.getParameter("password");
		System.out.println("f_num : " + f_num);
		System.out.println("password : " + password);

		//게시글 정보 조회

		Fund_boardDTO dto = new Fund_boardDTO();
		dto = dao.fund_detail_search(f_num);

		model.addAttribute("dto", dto);
	}

	// 펀드글 수정 처리
	@Override
	public void fund_update_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 펀드글 수정 처리");
		//3단계. 화면으로부터 입력받은 값을 받는다
		Fund_boardDTO dto = new Fund_boardDTO();

		dto.setF_num(Integer.parseInt(req.getParameter("boardNum")));
		dto.setF_title(req.getParameter("title"));
		dto.setF_content(req.getParameter("content"));
		dto.setF_password(req.getParameter("password"));

		int updateCnt = dao.fund_update_action(dto);
	}

	// 펀드글 삭제 처리
	@Override
	public void fund_delete_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 펀드글 삭제 처리");
		int f_num = Integer.parseInt(req.getParameter("boardNum"));
		dao.fund_delete_action(f_num);
	}

}
