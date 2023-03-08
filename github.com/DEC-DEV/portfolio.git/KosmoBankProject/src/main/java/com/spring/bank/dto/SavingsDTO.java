package com.spring.bank.dto;

import java.sql.Timestamp;

public class SavingsDTO {
	
	private int i_num;					//적금번호
	private String i_name;				//적금명 ㅇ
	private Timestamp i_join_date;		//적금가입일  sysdate
	private int i_state;				//적금 상태  0 이면 휴면 1 이면 동작중
	private double i_rate;				//적금 적용 금리 ㅇ
	private int i_money;				//적금 자동 이체 금액 ㅇ
	private int i_type;					//적금 금리 종류 0 단리 1 복리 ㅇ
	private int i_balance;				//적금 납입 금액 ㅇ 
	private int i_method;				//적금 방법 0 자유적금, 1 정기 적금
	private String i_end_date;		//적금 만기일 d
	private int i_auto_date;			//자동 이체일 d
	private String account_num;		    //적금 계좌명 d
	
	
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public SavingsDTO() {
		super();
	}
	public SavingsDTO(int i_num, String i_name, Timestamp i_join_date, int i_state, double i_rate, int i_money,
			int i_type, int i_balance, int i_method, String i_end_date, int i_auto_date) {
		super();
		this.i_num = i_num;
		this.i_name = i_name;
		this.i_join_date = i_join_date;
		this.i_state = i_state;
		this.i_rate = i_rate;
		this.i_money = i_money;
		this.i_type = i_type;
		this.i_balance = i_balance;
		this.i_method = i_method;
		this.i_end_date = i_end_date;
		this.i_auto_date = i_auto_date;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public Timestamp getI_join_date() {
		return i_join_date;
	}
	public void setI_join_date(Timestamp i_join_date) {
		this.i_join_date = i_join_date;
	}
	public int getI_state() {
		return i_state;
	}
	public void setI_state(int i_state) {
		this.i_state = i_state;
	}
	public double getI_rate() {
		return i_rate;
	}
	public void setI_rate(double i_rate) {
		this.i_rate = i_rate;
	}
	public int getI_money() {
		return i_money;
	}
	public void setI_money(int i_money) {
		this.i_money = i_money;
	}
	public int getI_type() {
		return i_type;
	}
	public void setI_type(int i_type) {
		this.i_type = i_type;
	}
	public int getI_balance() {
		return i_balance;
	}
	public void setI_balance(int i_balance) {
		this.i_balance = i_balance;
	}
	public int getI_method() {
		return i_method;
	}
	public void setI_method(int i_method) {
		this.i_method = i_method;
	}
	public String getI_end_date() {
		return i_end_date;
	}
	public void setI_end_date(String i_end_date) {
		this.i_end_date = i_end_date;
	}
	public int getI_auto_date() {
		return i_auto_date;
	}
	public void setI_auto_date(int i_auto_date) {
		this.i_auto_date = i_auto_date;
	}
	@Override
	public String toString() {
		return "SavingsDTO [i_num=" + i_num + ", i_name=" + i_name + ", i_join_date=" + i_join_date + ", i_state="
				+ i_state + ", i_rate=" + i_rate + ", i_money=" + i_money + ", i_type=" + i_type + ", i_balance="
				+ i_balance + ", i_method=" + i_method + ", i_end_date=" + i_end_date + ", i_auto_date=" + i_auto_date
				+ ", account_num=" + account_num + "]";
	}

	

}
