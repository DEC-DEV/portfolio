package com.spring.bank.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.bank.dao.AdminFundDAO;
import com.spring.bank.dto.FundDTO;
import com.spring.bank.util.Paging;

@Service
public class AdminFundServiceImpl implements AdminFundService {

	@Autowired
	AdminFundDAO dao;
	
	// 관리자 펀드 목록
	@Override
	public void fund_list(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_list");
		
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);
		
		int total = dao.fund_cnt();
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<FundDTO> list = null;

	    if(total > 0) {
	       Map<String, Object> map = new HashMap<String, Object>();
	       map.put("start", start);
	       map.put("end", end);
	       list = dao.fund_list(map);
	       
		System.out.println("list : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	    }
		
	}

	// 관리자 펀드 승인
	@Override
	public void fund_approve(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_approve");
		
		String[] item = req.getParameterValues("item");
		
		for(int i=0; i < item.length; i ++) {
			int j = 0;
			
			String item1 = item[i];
			String[] item3 = item1.split(",");
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("f_num", item3[j]);	// f_num
			map.put("id", item3[j+1]);	// id
			int updateCnt = dao.fund_approve(map);
			System.out.println("f_num" + item3[j]);
			System.out.println("id" + item3[j+1]);
		
			model.addAttribute("updateCnt", updateCnt);
			System.out.println("updateCnt" + updateCnt);
		}
		
	}

	// 관리자 펀드 거절
	@Override
	public void fund_delete(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_delete");
		
		String[] item = req.getParameterValues("item");
		
		for(int i=0; i < item.length; i ++) {
			int j = 0;
			
			String item1 = item[i];
			String[] item3 = item1.split(",");
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("f_num", item3[j]);	// f_num
			map.put("id", item3[j+1]);	// id
			int deleteCnt = dao.fund_delete(map);
			System.out.println("f_num" + item3[j]);
			System.out.println("id" + item3[j+1]);
		
			model.addAttribute("deleteCnt", deleteCnt);
			System.out.println("deleteCnt" + deleteCnt);
		}
		
	}
	
	// 관리자 펀드 상세
	@Override
	public void fund_detail(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_detail");
		
		int f_num = Integer.parseInt(req.getParameter("f_num"));
	    String pageNum = req.getParameter("pageNum");
	    System.out.println("pageNum : " + pageNum);
	    
	    FundDTO dto = dao.fund_detail(f_num);
	    
	    model.addAttribute("dto", dto);
	    model.addAttribute("pageNum", pageNum);
	}

	// 관리자 펀드 수정
	@Override
	public void fund_update_action(MultipartHttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_update_action");
		
		int hiddenf_num = Integer.parseInt(req.getParameter("hiddenf_num")); // pk 사용
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		String hiddenf_filename = req.getParameter("hiddenf_filename");	// 기존 상품이미지
		System.out.println("hiddenf_num" + hiddenf_num);
		System.out.println("pageNum" + pageNum);
		System.out.println("hiddenf_filename" + hiddenf_filename);
		
		// 추가 시작
		MultipartFile file = req.getFile("f_filename");
		System.out.println("file : " + file);
		
		// 저장경로
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
		System.out.println("saveDir : " + saveDir);
		
	    // 저장경로(jsp의 IMG_UPLOAD_DIR)
	    String realDir = "C:\\Users\\USER\\git\\BankProject\\BankProjectKosmo\\KosmoBankProject\\src\\main\\webapp\\\\resources\\upload";
	    System.out.println("realDir : " + realDir);
	
	    String p_img1 = "";
	  
	    if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	  
	    try {
			    file.transferTo(new File(saveDir + file.getOriginalFilename()));
		
			    FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			    FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
		
			    int data = 0;
		
			    while((data = fis.read()) != -1)  {
				    fos.write(data);
			   }
				  fis.close();
				  fos.close();
		  } catch(IOException e) {
			  e.printStackTrace();
		  }
			  p_img1 = "/bank/resources/upload/" + file.getOriginalFilename();
			  System.out.println("dto.getPdImg() : " + p_img1);
	   } else {
			  // 기존 이미지 사용(이미지 수정 안할 경우)
			  p_img1 = hiddenf_filename;
			  System.out.println("기존 이미지 => : " + p_img1);
	   }
			
		FundDTO dto = new FundDTO();
		String strId = (String)req.getSession().getAttribute("customerID");
		System.out.println(strId);
		dto.setId(strId);
		dto.setF_num(hiddenf_num);
		dto.setF_filename(p_img1);
		dto.setF_category(req.getParameter("f_category"));
		dto.setF_start_date(req.getParameter("f_start_date"));
		dto.setF_end_date(req.getParameter("f_end_date"));
		dto.setF_target_money(Integer.parseInt(req.getParameter("f_target_money")));
		dto.setF_account(req.getParameter("f_account"));
		dto.setF_title(req.getParameter("f_title"));
		dto.setF_content(req.getParameter("f_content"));
		dto.setF_name(req.getParameter("f_name"));
		dto.setF_email(req.getParameter("f_email"));
		dto.setF_phone(req.getParameter("f_phone"));
		System.out.println("dto " + dto);

		int updatecnt = dao.fund_update_action(dto);
		System.out.println("updatecnt : " + updatecnt);  // 정상 : 1
			
		model.addAttribute("updatecnt", updatecnt);
		model.addAttribute("pageNum", pageNum);
	}

	// 관리자 펀드 삭제
	@Override
	public void fund_delete_action(HttpServletRequest req, Model model) {
		System.out.println("서비스 - fund_delete_action");
		
		int f_num = Integer.parseInt(req.getParameter("f_num"));
		String pageNum = req.getParameter("pageNum");
		
		int deleteCnt = dao.fund_delete_action(f_num);

		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		
	}

}
