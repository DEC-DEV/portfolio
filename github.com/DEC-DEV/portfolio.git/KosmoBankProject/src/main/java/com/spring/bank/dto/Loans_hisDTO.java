package com.spring.bank.dto;

import java.sql.Timestamp;

public class Loans_hisDTO {
	public int d_his_num;
	public int d_num;
	public Timestamp d_his_date;
	public String d_his_type;
	public int d_his_amount;
	public int d_his_balance;
	public int transfer_num;
	public String d_account_type;
	
	
	
	// setters, getters
	public int getD_his_num() {
		return d_his_num;
	}
	public void setD_his_num(int d_his_num) {
		this.d_his_num = d_his_num;
	}
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	public Timestamp getD_his_date() {
		return d_his_date;
	}
	public void setD_his_date(Timestamp d_his_date) {
		this.d_his_date = d_his_date;
	}
	public String getD_his_type() {
		return d_his_type;
	}
	public void setD_his_type(String d_his_type) {
		this.d_his_type = d_his_type;
	}
	public int getD_his_amount() {
		return d_his_amount;
	}
	public void setD_his_amount(int d_his_amount) {
		this.d_his_amount = d_his_amount;
	}
	public int getD_his_balance() {
		return d_his_balance;
	}
	public void setD_his_balance(int d_his_balance) {
		this.d_his_balance = d_his_balance;
	}
	public int getTransfer_num() {
		return transfer_num;
	}
	public void setTransfer_num(int transfer_num) {
		this.transfer_num = transfer_num;
	}
	public String getD_account_type() {
		return d_account_type;
	}
	public void setD_account_type(String d_account_type) {
		this.d_account_type = d_account_type;
	}
	
	
}
