package com.spring.bank.dto;

import java.sql.Timestamp;

public class Savings_itemDTO {
	
	//적금 상품 번호
	private int i_no;

	// 적금 상품명 
    private String i_name;
    
    // 적금 계좌번호
    private String account_num;
    
    //총 납부액
    private int i_balance;
    
    // 회원아이디 
    private String id;

	// 적금 상품요약 
    private String i_summary;

    // 적금 등록일 
    private Timestamp i_date;

    // 적금 적용 금리 
    private Double i_rate;

    // 적용 금리 종류  0 단리 1 복리
    private Integer i_type;

    // 최소 적금 기간 
    private Integer i_min_date;

    // 최대 적금 기간 
    private Integer i_max_date;

    // 유의사항 
    private String i_notice;

    // 자동이체일 
    private String i_auto_date;

    public int getI_no() {
		return i_no;
	}

	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
    
	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public String getI_summary() {
		return i_summary;
	}

	public void setI_summary(String i_summary) {
		this.i_summary = i_summary;
	}

	public Timestamp getI_date() {
		return i_date;
	}

	public void setI_date(Timestamp i_date) {
		this.i_date = i_date;
	}

	public Double getI_rate() {
		return i_rate;
	}

	public void setI_rate(Double i_rate) {
		this.i_rate = i_rate;
	}

	public Integer getI_type() {
		return i_type;
	}

	public void setI_type(Integer i_type) {
		this.i_type = i_type;
	}

	public Integer getI_min_date() {
		return i_min_date;
	}

	public void setI_min_date(Integer i_min_date) {
		this.i_min_date = i_min_date;
	}

	public Integer getI_max_date() {
		return i_max_date;
	}

	public void setI_max_date(Integer i_max_date) {
		this.i_max_date = i_max_date;
	}

	public String getI_notice() {
		return i_notice;
	}

	public void setI_notice(String i_notice) {
		this.i_notice = i_notice;
	}

	public String getI_auto_date() {
		return i_auto_date;
	}

	public void setI_auto_date(String i_auto_date) {
		this.i_auto_date = i_auto_date;
	}

	public Savings_itemDTO() {
	}

	
	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public int getI_balance() {
		return i_balance;
	}

	public void setI_balance(int i_balance) {
		this.i_balance = i_balance;
	}

	

	@Override
	public String toString() {
		return "Savings_itemDTO [i_no=" + i_no + ", i_name=" + i_name + ", account_num=" + account_num + ", i_balance="
				+ i_balance + ", i_summary=" + i_summary + ", i_date=" + i_date + ", i_rate=" + i_rate + ", i_type="
				+ i_type + ", i_min_date=" + i_min_date + ", i_max_date=" + i_max_date + ", i_notice=" + i_notice
				+ ", i_auto_date=" + i_auto_date + "]";
	}

	public Savings_itemDTO(int i_no, String i_name, String i_summary, Timestamp i_date, Double i_rate, Integer i_type,
			Integer i_min_date, Integer i_max_date, String i_notice, String i_auto_date) {
		this.i_no = i_no;
		this.i_name = i_name;
		this.i_summary = i_summary;
		this.i_date = i_date;
		this.i_rate = i_rate;
		this.i_type = i_type;
		this.i_min_date = i_min_date;
		this.i_max_date = i_max_date;
		this.i_notice = i_notice;
		this.i_auto_date = i_auto_date;
	}
	
	
}
