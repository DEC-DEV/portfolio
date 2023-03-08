package com.spring.bank.dto;

import java.sql.Date;

public class Loans_paidDTO {
	public int index;	// 회차
	public int totalRepay;	// 총상환금
	public int OriginRepay;	// 원금 상환
	public int interestRepay; // 이자 상환
	public int remainAmount; // 총 남은 금액(전체)
	public String returnDate; // 납부 예정일
	public int d_count; // 대출 회차
	public Date planDate; // 대출 납부일
	public String id;
	public String account_num;
	public int d_num;
	public String d_repay;
	public String recipient;
	public String in_out;
	
	
	
	// setters, getters
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotalRepay() {
		return totalRepay;
	}
	public void setTotalRepay(int totalRepay) {
		this.totalRepay = totalRepay;
	}
	public int getOriginRepay() {
		return OriginRepay;
	}
	public void setOriginRepay(int originRepay) {
		OriginRepay = originRepay;
	}
	public int getInterestRepay() {
		return interestRepay;
	}
	public void setInterestRepay(int interestRepay) {
		this.interestRepay = interestRepay;
	}
	public int getRemainAmount() {
		return remainAmount;
	}
	public void setRemainAmount(int remainAmount) {
		this.remainAmount = remainAmount;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getD_count() {
		return d_count;
	}
	public void setD_count(int d_count) {
		this.d_count = d_count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getD_repay() {
		return d_repay;
	}
	public void setD_repay(String d_repay) {
		this.d_repay = d_repay;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	
	
	
}
