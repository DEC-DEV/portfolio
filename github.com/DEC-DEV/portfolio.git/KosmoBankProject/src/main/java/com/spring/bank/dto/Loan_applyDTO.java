package com.spring.bank.dto;

public class Loan_applyDTO {

	private String id;
	private String d_name;
	private String name;
	private String d_repay;
	private double d_interest_rate;
	private double d_prepayment_fee;
	private String account_num;
	private String account_password;
	
	// setters, getters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_repay() {
		return d_repay;
	}
	public void setD_repay(String d_repay) {
		this.d_repay = d_repay;
	}
	public double getD_prepayment_fee() {
		return d_prepayment_fee;
	}
	public void setD_prepayment_fee(double d_prepayment_fee) {
		this.d_prepayment_fee = d_prepayment_fee;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getAccount_password() {
		return account_password;
	}
	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getD_interest_rate() {
		return d_interest_rate;
	}
	public void setD_interest_rate(double d_interest_rate) {
		this.d_interest_rate = d_interest_rate;
	}
	@Override
	public String toString() {
		return "Loan_applyDTO [id=" + id + ", d_name=" + d_name + ", name=" + name + ", d_repay=" + d_repay
				+ ", d_interest_rate=" + d_interest_rate + ", d_prepayment_fee=" + d_prepayment_fee + ", account_num="
				+ account_num + ", account_password=" + account_password + "]";
	}
	
}
