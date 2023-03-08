package com.spring.bank.dao;

import java.util.List;

import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.FundDTO;


public interface AndroidDAO {

  public String authorityCheck(String id);

  public CustomerDTO getMemberInfo(String id);

  public String pwdCheck(String id);
	
  // 회원가입
  public int join(CustomerDTO dto);
  
  // 펀드 리스트
  public List<FundDTO> fund_list(String id);
  // 펀드 상세
  public FundDTO getFundInfo(String id);

}
