package com.spring.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.bank.dao.CsCenterDAO;
import com.spring.bank.dto.CounselCommentDTO;
import com.spring.bank.dto.CounselDTO;
import com.spring.bank.dto.NoticeDTO;
import com.spring.bank.util.Paging;

@Service
public class CsCenterSerivceImpl implements CsCenterService{

	@Autowired //=@Inject
	CsCenterDAO dao;

	@Autowired
    BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스


	// 상담글 등록 처리
	@Override
	public void counsel_insert_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 등록 처리");
		CounselDTO dto = new CounselDTO();

		dto.setB_name(req.getParameter("writer"));
		dto.setB_title(req.getParameter("title"));
		dto.setB_content(req.getParameter("content"));
		dto.setB_password(req.getParameter("password"));

		int insertCnt = dao.counsel_insert_action(dto);

		model.addAttribute("insertCnt", insertCnt);
	}

	// 상담글 리스트 조회
	@Override
	public void counsel_list_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 리스트 조회");

		String pageNum = req.getParameter("pageNum");

		//페이징 번호 처리
		Paging paging = new Paging(pageNum);

		//전체 상담글 갯수 카운트
		int total = dao.counsel_list_cnt();
		paging.setTotalCount(total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		System.out.println("start : " + start);
		System.out.println("end : " + end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);

		// 상담글 목록
		List<CounselDTO> list = dao.counsel_list_search(map);

		System.out.println("상담글 목록 확인 : " + list);

		if(list == null) {
			System.out.println("list가 null");
		} else if(list.isEmpty()) {
			System.out.println("list가 isEmpty");
		}

		//jsp로 처리 결과 전달
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

	// 상담글 상세 조회
	@Override
	public void counsel_detail_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 상세 조회");

		//화면 입력 받은 값을 받아
		String pageNum = req.getParameter("pageNum");
		int b_num = Integer.parseInt(req.getParameter("num"));

		//상품 정보 조회
		CounselDTO dto = new CounselDTO();
		dto = dao.counsel_detail_search(b_num);

		//jsp로 처리 결과 전달
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto);
	}

	// 상담글 상세조회시 댓글달기
	@Override
	public void counsel_coment_add(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 상세조회시 댓글달기");
		CounselCommentDTO dto = new CounselCommentDTO();
		dto.setB_num(Integer.parseInt(req.getParameter("board_num")));
		dto.setWriter(req.getParameter("writer"));
		dto.setContent(req.getParameter("content"));

		System.out.println("Service - commentInsert 전");
		dao.counsel_coment_add(dto);
		System.out.println("Service - commentInsert 후");
		//실행이 끝나면 board_detailAction.jsp의 comment_add() 콜백함수(success)로 넘어감

	}

	// 상담글 상세조회시 댓글리스트 불러오기
	@Override
	public void counsel_coment_list_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 상세조회시 댓글리스트 불러오기");
		int b_num = Integer.parseInt(req.getParameter("num"));
		System.out.println("Service num : " + b_num);

		//5. 게시글 목록
		List<CounselCommentDTO> list = dao.counsel_coment_list_search(b_num);
		System.out.println("list : " + list);
		//6. jsp로 처리 결과 전달 (request나 session으로 전달)
		model.addAttribute("list", list); // => comment_list()의 콜백함수의 result로 전달됨
	}

	// 상담글 수정/삭제시 비밀번호 체크
	@Override
	public String counsel_update_password_check(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 수정/삭제시 비밀번호 체크");

		//3단계. 화면으로부터 입력받은 값을 받는다
		int num = Integer.parseInt(req.getParameter("boardNum"));
		String password = req.getParameter("password");
		System.out.println("b_num : " + num);
		System.out.println("password : " + password);

		//5단계. 패스워드 일치 확인(비밀번호 인증)
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("b_num", num);
	    map.put("b_password", password);

	    String result = dao.counsel_update_password_check(map);
	    System.out.println("비밀번호 체크 결과 : " + result);

	    return result;
	}

	// 상담글 수정/삭제 페이지
	@Override
	public void counsel_update(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 수정/삭제 페이지");

		//3단계. 화면으로부터 입력받은 값을 받는다
		int b_num = Integer.parseInt(req.getParameter("b_num"));
		String password = req.getParameter("password");
		System.out.println("b_num : " + b_num);
		System.out.println("password : " + password);

		//상품 정보 조회
		CounselDTO dto = new CounselDTO();
		dto = dao.counsel_detail_search(b_num);

		model.addAttribute("dto", dto);
	}

	// 상담글 수정 처리
	@Override
	public void counsel_update_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 수정 처리");
		//3단계. 화면으로부터 입력받은 값을 받는다
		CounselDTO dto = new CounselDTO();

		dto.setB_num(Integer.parseInt(req.getParameter("boardNum")));
		dto.setB_title(req.getParameter("title"));
		dto.setB_content(req.getParameter("content"));
		dto.setB_password(req.getParameter("password"));

		int updateCnt = dao.counsel_update_action(dto);
	}

	// 상담글 삭제 처리
	@Override
	public void counsel_delete_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 상담글 삭제 처리");
		int b_num = Integer.parseInt(req.getParameter("boardNum"));
		dao.counsel_delete_action(b_num);
	}

	// 공지글 리스트 조회
	@Override
	public void notice_list_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 공지글 리스트 조회");

		String pageNum = req.getParameter("pageNum");

		//페이징 번호 처리
		Paging paging = new Paging(pageNum);

		//전체 상담글 갯수 카운트
		int total = dao.notice_list_cnt();
		paging.setTotalCount(total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		System.out.println("start : " + start);
		System.out.println("end : " + end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);

		// 상담글 목록
		List<NoticeDTO> list = dao.notice_list_search(map);

		System.out.println("공지글 목록 확인 : " + list);

		if(list == null) {
			System.out.println("list가 null");
		} else if(list.isEmpty()) {
			System.out.println("list가 isEmpty");
		}

		//jsp로 처리 결과 전달
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

	// 공지글 상세 조회시 조회수 증가
	@Override
	public void notice_detail_view_add(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 공지글 상세 조회시 조회수 증가");

		int n_board_num = Integer.parseInt(req.getParameter("num"));
		dao.notice_detail_view_add(n_board_num);
	}

	// 공지글 상세 조회
	@Override
	public void notice_detail_search(HttpServletRequest req, Model model) {
		System.out.println("서비스 - 공지글 상세 조회");

		//화면 입력 받은 값을 받아
		String pageNum = req.getParameter("pageNum");
		int n_board_num = Integer.parseInt(req.getParameter("num"));

		//상품 정보 조회
		NoticeDTO dto = new NoticeDTO();
		dto = dao.notice_detail_search(n_board_num);

		//jsp로 처리 결과 전달
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto);
	}


/*

	// 회원정보 인증 및 탈퇴
	@Override
	public void deleteCustomerAction(HttpServletRequest req, Model model) {
		System.out.println("서비스 deleteCustomerAction - 회원탈퇴 처리");
		// 3단계. 화면으로부터 입력받은 값을 받아서 dto에 담는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		String strPassword = req.getParameter("password");

		// 5-1단계. 회원탈퇴을 위한 인증처리
		String encryptPassword = dao.pwdCheck(strId);
		int selectCnt = 0;
		int deleteCnt = 0;

		// 입력받은 암호화 DB에 있는 암호화된 암호가 일치하는지 확인
		if(passwordEncoder.matches(strPassword, encryptPassword)) {
			selectCnt = 1;
		}

		System.out.println("서비스 selectCnt : " + selectCnt);

		// 5-2단계. 인증성공시 회원탈퇴진행
		if(selectCnt == 1) {
			deleteCnt = dao.deleteCustomer(strId);
		}

		// 6단계. jsp 결과 처리 전달(request나 session으로 처리 결과를 저장 후에 전달)
		model.addAttribute("deleteCnt", deleteCnt);
	}

	// 회원정보 인증 및 상세페이지
	@Override
	public void modifyDetailAction(HttpServletRequest req, Model model) {
		System.out.println("서비스 modifyDetailAction - 회원정보 인증 및 상세페이지 처리");
		// 3단계. 화면으로부터 입력받은 값을 받아서 dto에 담는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		String strPassword = req.getParameter("password");

		// 5-1단계. 회원수정을 위한 인증처리

		String encryptPassword = dao.pwdCheck(strId);
		int selectCnt = 0;

		// 입력받은 암호화 DB에 있는 암호화된 암호가 일치하는지 확인
		if(passwordEncoder.matches(strPassword, encryptPassword)) {
			selectCnt = 1;
		}

		System.out.println("서비스 selectCnt : " + selectCnt);

		CustomerDTO dto = null;
		// 5-2단계. 인증성공시 상세정보 조회
		if(selectCnt == 1) {
			dto = dao.getCustomerDetail(strId);
		}

		// 6단계. jsp 결과 처리 전달(request나 session으로 처리 결과를 저장 후에 전달)
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("dto", dto);
	}

	// 회원정보 수정 처리
	@Override
	public void modifyCustomerAction(HttpServletRequest req, Model model) {
		System.out.println("서비스 modifyCustomerAction - 회원정보 수정 처리");
		// 3단계. 화면으로부터 입력받은 값을 받아서 dto에 담는다.
		CustomerDTO dto = new CustomerDTO();

		dto.setId((String)req.getSession().getAttribute("customerID"));

		//비밀번호 암호화 - 시큐리티
		String password = req.getParameter("password");
		System.out.println("암호화 전의 비밀번호 : " + password);

		//BCryptPasswordEncoder.encode(): 비밀번호 암호화 메서드
		String encryptPassword = passwordEncoder.encode(password); //암호화
		System.out.println("암호화 후의 비밀번호 : " + encryptPassword);

		dto.setPassword(encryptPassword); //주의: 암호화 후의 비밀번호로 받는다

		dto.setName(req.getParameter("name"));
		String strDate = req.getParameter("birthday");
		dto.setBirthday(Date.valueOf(strDate));
		dto.setAddress(req.getParameter("address"));

		//hp은 필수가 아니므로 null 값이 들어올 수 있으므로 값이 존재할 때만 처리
		String hp = "";
		String strHp1 = req.getParameter("hp1");
		String strHp2 = req.getParameter("hp2");
		String strHp3 = req.getParameter("hp3");
		if(!strHp1.equals("") && !strHp2.equals("") && !strHp3.equals("")) {
			hp = strHp1 + "-" + strHp2 + "-" + strHp3;
		}
		dto.setHp(hp);

		String email = "";
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		email = email1 + "@" + email2;
		dto.setEmail(email);

		// 5-1단계. 회원수정처리
		int updateCnt = dao.updateCustomer(dto);
		// 5-2단계. 인증성공시 상세정보 조회

		// 6단계. jsp 결과 처리 전달(request나 session으로 처리 결과를 저장 후에 전달)
		model.addAttribute("updateCnt", updateCnt);
		System.out.println("서비스 updateCnt : " + updateCnt);
	}


	//상품리스트
	@Override
	public void productList(HttpServletRequest req, Model model) {
		System.out.println("Customer service - productList");
		//화면으로부터 입력값을 받는다.
		//페이지 번호 값
		String pageNum = req.getParameter("pageNum");

		//페이징 번호 처리
		Paging paging = new Paging(pageNum);

		//전체 게시글 갯수 카운트
		int total = dao.productCnt();
		paging.setTotalCount(total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		System.out.println("start : " + start);
		System.out.println("end : " + end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);

		// 게시글 목록
		List<ProductDTO> list = dao.productList(map);

		System.out.println("list 상품리스트 확인 : " + list);

		if(list == null) {
			System.out.println("list가 null");
		} else if(list.isEmpty()) {
			System.out.println("list가 isEmpty");
		}

		//jsp로 처리 결과 전달
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

	//상품상세페이지
	@Override
	public void productInfo(HttpServletRequest req, Model model) {
		System.out.println("product service - productInfo");

		//화면 입력 받은 값을 받아
		String pageNum = req.getParameter("pageNum");
		int pdNo = Integer.parseInt(req.getParameter("pdNo"));

		//상품 정보 조회
		ProductDTO dto = new ProductDTO();
		dto = produtDao.getProductDetail(pdNo);

		//jsp로 처리 결과 전달
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto);
	}

	//장바구니 목록
	@Override
	public void cartList(HttpServletRequest req, Model model) {
		System.out.println("Service - cartList");
		//3단계. 화면으로부터 입력값을 받는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println("customerID : " + strId);
		if(strId != null) {
			System.out.println("if문 안으로 들어옴");

			//5-2. 게시글 목록
			List<CartDTO> list = dao.cartList(strId);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("list", list);
			model.addAttribute("selectCnt", 1);
		} else {
			System.out.println("if문 못탔다");
			model.addAttribute("selectCnt", 0);
		}
	}

	//장바구니 합계
	@Override
	public void cartSum(HttpServletRequest req, Model model) {
		System.out.println("Service - cartSum");
		//3단계. 화면으로부터 입력값을 받는다.
		int sum = Integer.parseInt(req.getParameter("sum"));
		System.out.println("sum : " + sum);
		model.addAttribute("sum", sum);
	}

	//장바구니 추가
	@Override
	public void cartAdd(HttpServletRequest req, Model model) {
		System.out.println("Service - cartAdd");
		String strId = (String)req.getSession().getAttribute("customerID");
		int pdNo = Integer.parseInt(req.getParameter("pdNo"));
		int odQuantity = Integer.parseInt(req.getParameter("odQuantity"));

		CartDTO dto = new CartDTO();
		dto.setId(strId);
		dto.setPdNo(pdNo);
		dto.setOdQuantity(odQuantity);

		if(strId != null) { //로그인 함
			System.out.println("장바구니 추가 - if문 안으로 들어옴");

			//5-2. 장바구니에 해당 상품 추가
			int insertCnt = dao.cartAdd(dto);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("insertCnt", insertCnt);
		} else { //로그인 안함
			System.out.println("장바구니 추가 - if문 못탔다");
			model.addAttribute("insertCnt", 2);
		}

	}

	//장바구니 삭제
	@Override
	public void cartDelete(HttpServletRequest req, Model model) {
		System.out.println("Service - cartDelete");
		String strId = (String)req.getSession().getAttribute("customerID");
		int pdNo = Integer.parseInt(req.getParameter("pdNo"));

		CartDTO dto = new CartDTO();
		dto.setId(strId);
		dto.setPdNo(pdNo);

		if(strId != null) { //로그인 함
			System.out.println("if문 안으로 들어옴");

			//5-2. 장바구니에 해당 상품 추가
			int deleteCnt = dao.cartDelete(dto);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("deleteCnt", deleteCnt);
		} else { //로그인 안함
			System.out.println("if문 못탔다");
			model.addAttribute("deleteCnt", 2);
		}
	}

	// 주문목록
	@Override
	public void orderList(HttpServletRequest req, Model model) {
		System.out.println("Service - orderList");
		//3단계. 화면으로부터 입력값을 받는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println("customerID : " + strId);

		System.out.println("Service - orderList");
		//3단계. 화면으로부터 입력값을 받는다.
		//페이지 번호 클릭
		String pageNum = req.getParameter("pageNum");

		//5-1.
		Paging paging = new Paging(pageNum);

		//전체 게시글 갯수 카운트
		int total = dao.orderCnt(strId);
		paging.setTotalCount(total);
		System.out.println("total : " + total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("strId", strId);
		map.put("start", start);
		map.put("end", end);

		if(strId != null) {
			System.out.println("if문 안으로 들어옴");

			//5-2. 주문 목록
			List<OrderDTO> list = dao.orderList(map);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("list", list);
			model.addAttribute("paging", paging);
			model.addAttribute("selectCnt", 1);
		} else {
			System.out.println("if문 못탔다");
			model.addAttribute("selectCnt", 0);
		}
	}
/*
	// 장바구니에서 주문추가(dao에서 sql문을 for문으로 돌리는 형태 - 안되는듯?)
	@Override
	public void orderAdd(HttpServletRequest req, Model model) {
		System.out.println("Service - orderAdd");
		//3단계. 화면으로부터 입력값을 받는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println("customerID : " + strId);

		String[] arr = req.getParameter("arr").split(",");
		for(int i = 0; i<arr.length; i++) {
			System.out.println("arr["+ i +"] = " + arr[i]);
		}

		if(strId != null) {
			System.out.println("if문 안으로 들어옴");

			//5-2. 게시글 목록
			int insertCnt = dao.orderAdd(strId, arr);
			int deleteCnt = dao.orderDeleteCart(strId, arr);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("insertCnt", insertCnt);
		} else {
			System.out.println("if문 못탔다");
			model.addAttribute("insertCnt", 2);
		}
	}

	// 장바구니에서 주문추가하고 해당 건 장바구니에서 삭제(for문으로 dto 만들어서 dao로 전달하여 여기서 반복문 돌리는 형태)
	@Override
	public void orderAdd(HttpServletRequest req, Model model) {
		System.out.println("Service - orderAdd");
		//3단계. 화면으로부터 입력값을 받는다.
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println("customerID : " + strId);

		String[] arr = req.getParameter("arr").split(",");
		for(int i = 0; i<arr.length; i++) {
			System.out.println("arr["+ i +"] = " + arr[i]);
		}

		if(strId != null) {
			System.out.println("if문 안으로 들어옴");
			int insertCnt = 0;
			int deleteCnt = 0;
			for(int i = 0; i<arr.length; i+=2) {
				OrderDTO orderDto = new OrderDTO();
				orderDto.setPdNo(Integer.parseInt(arr[i]));
				orderDto.setOdQuantity(Integer.parseInt(arr[i+1]));
				orderDto.setId(strId);
				insertCnt = dao.orderAdd(orderDto);

				CartDTO cartDto = new CartDTO();
				cartDto.setPdNo(Integer.parseInt(arr[i]));
				cartDto.setId(strId);
				deleteCnt = dao.orderDeleteCart(cartDto);
			}
			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("insertCnt", insertCnt);
		} else {
			System.out.println("if문 못탔다");
			model.addAttribute("insertCnt", 2);
		}
	}

	//바로 구매
	@Override
	public void orderAddNow(HttpServletRequest req, Model model) {
		System.out.println("Service - orderAddNow");
		String strId = (String)req.getSession().getAttribute("customerID");
		int pdNo = Integer.parseInt(req.getParameter("pdNo"));
		int odQuantity = Integer.parseInt(req.getParameter("odQuantity"));

		OrderDTO dto = new OrderDTO();
		dto.setId(strId);
		dto.setPdNo(pdNo);
		dto.setOdQuantity(odQuantity);


		if(strId != null) { //로그인 함
			System.out.println("orderAddNow if문 안으로 들어옴");

			//5-2. 장바구니에 해당 상품 추가
			int insertCnt = dao.orderAddNow(dto);

			//6. jsp로 처리 결과 전달 (request나 session으로 전달)
			model.addAttribute("insertCnt", insertCnt);
		} else { //로그인 안함
			System.out.println("orderAddNow if문 못탔다");
			model.addAttribute("insertCnt", 2);
		}
	}


	@Override
	public void orderDelete(HttpServletRequest req, Model model) {

	}

	//환불 신청사유 입력
	@Override
	public void inputRefundReq(HttpServletRequest req, Model model) {
		System.out.println("Service - inputRefundReq");
		//화면으로부터 입력값 받기
		int odNo = Integer.parseInt(req.getParameter("odNo"));
		String status = req.getParameter("status");
		String reason = req.getParameter("reason");
		System.out.println("reason : " + reason);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("odNo", odNo);
		map.put("odStatus", status);
		map.put("refundReason", reason);

		//수정처리
		int updateCnt = dao.inputRefundReq(map);

		//jsp로 결과 전달
		model.addAttribute("updateCnt", updateCnt);
	}

	//환불신청사유 보기
	@Override
	public void readRefundReq(HttpServletRequest req, Model model) {
		System.out.println("Service - readRefundReq");
		//화면으로부터 입력값 받기
		int odNo = Integer.parseInt(req.getParameter("odNo"));

		String selectResult = dao.readRefundReq(odNo);

		//jsp로 결과 전달
		model.addAttribute("selectResult", selectResult);
	}

	//주문거절사유 보기
	@Override
	public void readOrderRefuse(HttpServletRequest req, Model model) {
		System.out.println("Service - readRefundReq");
		//화면으로부터 입력값 받기
		int odNo = Integer.parseInt(req.getParameter("odNo"));

		String selectResult = dao.readOrderRefuse(odNo);

		//jsp로 결과 전달
		model.addAttribute("selectResult", selectResult);
	}

	//환불거절사유 보기
	@Override
	public void readRefundRefuse(HttpServletRequest req, Model model) {
		System.out.println("Service - readRefundRefuse");
		//화면으로부터 입력값 받기
		int odNo = Integer.parseInt(req.getParameter("odNo"));

		String selectResult = dao.readRefundRefuse(odNo);

		//jsp로 결과 전달
		model.addAttribute("selectResult", selectResult);
	}



*/
}
