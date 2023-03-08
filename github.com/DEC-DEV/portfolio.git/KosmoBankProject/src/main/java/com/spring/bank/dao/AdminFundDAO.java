package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import com.spring.bank.dto.FundDTO;

public interface AdminFundDAO {

	// 관리자 펀드목록
	public List<FundDTO> fund_list(Map<String, Object> map);
	
	// 상품 갯수
	public int fund_cnt();
	
	// 관리자 펀드승인
	public int fund_approve(Map<String, Object> map);
	
	// 관리자 펀드 거절
	public int fund_delete(Map<String, Object> map);
	
	// 관리자 펀드상세페이지
	public FundDTO fund_detail(int f_num);
	
	// 관리자 펀드 수정처리
    public int fund_update_action(FundDTO dto);
    
    // 관리자 펀드 삭제처리
    public int fund_delete_action(int f_num);
   
}
