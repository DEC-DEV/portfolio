package com.spring.bank.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class LoansDTO {
	// 회원 아이디
	private String id;

	// 대출번호 
    private int d_num;

    // 대출상품명 
    private String d_name;

    // 연결 계좌번호 
    private String account_num;

    // 대출 상태 
    private Integer d_state;

    // 대출 실행일 
    private Date d_start_date;

    // 대출 만기일 
    private Date d_end_date;

    // 대출 기간 
    private int d_month;

    // 상환 방법 
    private String d_repay;

    // 대출 금리 
    private double d_rate;

    // 대출 원금 
    private int d_amount;

    // 대출 잔액 
    private int d_balance;

    // 대출 이자 잔액 
    private int d_balance_rate;

    // 납입 금액 
    private int d_loan_balance;

    // 납입 이자 금액 
    private int d_loan_rate;

    // 이체 원금 
    private int d_principal;

    // 이체 이자 
    private int d_principal_rate;

    // 이체 실행번호 
    private int d_transfernum;

    // 중도상환 수수료율 
    private double d_prepayment_fee;

    // 대출 회차 
    private int d_count;

    // Field2 
    private String field2;
    
    // setters, getters


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Integer getD_state() {
		return d_state;
	}

	public void setD_state(Integer d_state) {
		this.d_state = d_state;
	}

	public int getD_month() {
		return d_month;
	}

	public void setD_month(int d_month) {
		this.d_month = d_month;
	}

	public String getD_repay() {
		return d_repay;
	}

	public void setD_repay(String d_repay) {
		this.d_repay = d_repay;
	}

	public int getD_amount() {
		return d_amount;
	}

	public void setD_amount(int d_amount) {
		this.d_amount = d_amount;
	}

	public int getD_balance() {
		return d_balance;
	}

	public void setD_balance(int d_balance) {
		this.d_balance = d_balance;
	}

	public int getD_balance_rate() {
		return d_balance_rate;
	}

	public void setD_balance_rate(int d_balance_rate) {
		this.d_balance_rate = d_balance_rate;
	}

	public int getD_loan_balance() {
		return d_loan_balance;
	}

	public void setD_loan_balance(int d_loan_balance) {
		this.d_loan_balance = d_loan_balance;
	}

	public int getD_loan_rate() {
		return d_loan_rate;
	}

	public void setD_loan_rate(int d_loan_rate) {
		this.d_loan_rate = d_loan_rate;
	}

	public int getD_principal() {
		return d_principal;
	}


	public int getD_transfernum() {
		return d_transfernum;
	}

	public void setD_transfernum(int d_transfernum) {
		this.d_transfernum = d_transfernum;
	}

	public double getD_prepayment_fee() {
		return d_prepayment_fee;
	}

	public void setD_prepayment_fee(double d_prepayment_fee) {
		this.d_prepayment_fee = d_prepayment_fee;
	}

	public void setD_principal(int d_principal) {
		this.d_principal = d_principal;
	}

	public int getD_count() {
		return d_count;
	}

	public void setD_count(int d_count) {
		this.d_count = d_count;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}


	public Date getD_start_date() {
		return d_start_date;
	}

	public void setD_start_date(Date d_start_date) {
		this.d_start_date = d_start_date;
	}

	public Date getD_end_date() {
		return d_end_date;
	}

	public void setD_end_date(Date d_end_date) {
		this.d_end_date = d_end_date;
	}

	public double getD_rate() {
		return d_rate;
	}

	public void setD_rate(double d_rate) {
		this.d_rate = d_rate;
	}

	public int getD_principal_rate() {
		return d_principal_rate;
	}

	public void setD_principal_rate(int d_principal_rate) {
		this.d_principal_rate = d_principal_rate;
	}
    
    	

}
