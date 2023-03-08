package com.spring.bank.dto;

import java.sql.Timestamp;

public class DepositDTO {
	
	private int y_num;				//예금번호
	private String y_name;			//예금명
	private String account_num;		//예금계좌명
	private Timestamp y_join_date;	//가입일
	private int y_state;			//예금 상태
	private double y_interest_rate;			//예금 적용금리
	private int y_type;				//예금 종류
	private int y_balance;			//예금 금액
	private String y_end_date;	//예금 만기일
	
	public int getY_num() {
		return y_num;
	}
	public void setY_num(int y_num) {
		this.y_num = y_num;
	}
	public String getY_name() {
		return y_name;
	}
	public void setY_name(String y_name) {
		this.y_name = y_name;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public Timestamp getY_join_date() {
		return y_join_date;
	}
	public void setY_join_date(Timestamp y_join_date) {
		this.y_join_date = y_join_date;
	}
	public int getY_state() {
		return y_state;
	}
	public void setY_state(int y_state) {
		this.y_state = y_state;
	}
	public int getY_type() {
		return y_type;
	}
	public void setY_type(int y_type) {
		this.y_type = y_type;
	}
	public String getY_end_date() {
		return y_end_date;
	}
	public void setY_end_date(String y_end_date) {
		this.y_end_date = y_end_date;
	}
	public DepositDTO() {
		super();
	}
	public int getY_balance() {
		return y_balance;
	}
	public void setY_balance(int y_balance) {
		this.y_balance = y_balance;
	}
	public double getY_interest_rate() {
		return y_interest_rate;
	}
	public void setY_interest_rate(double y_interest_rate) {
		this.y_interest_rate = y_interest_rate;
	}
	@Override
	public String toString() {
		return "DepositDTO [y_num=" + y_num + ", y_name=" + y_name + ", account_num=" + account_num + ", y_join_date="
				+ y_join_date + ", y_state=" + y_state + ", y_interest_rate=" + y_interest_rate + ", y_type=" + y_type
				+ ", y_balance=" + y_balance + ", y_end_date=" + y_end_date + "]";
	}
	public DepositDTO(int y_num, String y_name, String account_num, Timestamp y_join_date, int y_state,
			double y_interest_rate, int y_type, int y_balance, String y_end_date) {
		super();
		this.y_num = y_num;
		this.y_name = y_name;
		this.account_num = account_num;
		this.y_join_date = y_join_date;
		this.y_state = y_state;
		this.y_interest_rate = y_interest_rate;
		this.y_type = y_type;
		this.y_balance = y_balance;
		this.y_end_date = y_end_date;
	}
	
	
	
}
