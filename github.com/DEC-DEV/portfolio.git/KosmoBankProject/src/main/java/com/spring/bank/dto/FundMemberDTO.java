package com.spring.bank.dto;

import java.sql.Timestamp;

public class FundMemberDTO {

	private int f_num;
	private String id;
	private String f_account;
	private int f_money;
	private Timestamp f_date;
	
	// 디폴트생성자
	public FundMemberDTO() {}

	// getter, setter
	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getF_account() {
		return f_account;
	}

	public void setF_account(String f_account) {
		this.f_account = f_account;
	}

	public int getF_money() {
		return f_money;
	}

	public void setF_money(int f_money) {
		this.f_money = f_money;
	}

	public Timestamp getF_date() {
		return f_date;
	}

	public void setF_date(Timestamp f_date) {
		this.f_date = f_date;
	}

	@Override
	public String toString() {
		return "FundMemberDTO [f_num=" + f_num + ", id=" + id + ", f_account=" + f_account + ", f_money=" + f_money
				+ ", f_date=" + f_date + "]";
	}
	
	
	
	
}
