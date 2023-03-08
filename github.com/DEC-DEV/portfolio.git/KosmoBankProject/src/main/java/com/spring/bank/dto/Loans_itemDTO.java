package com.spring.bank.dto;


public class Loans_itemDTO {
	// 대출상품명 
    private String d_name;

    // 대출 금리 
    private Double d_interest_rate;

    // 최소 대출 금액 
    private Long d_min_price;

    // 최대 대출 금액 
    private Long d_max_price;

    // 최소 대출 기간 
    private int d_min_date;

    // 최대 대출 기간 
    private int d_max_date;
    
    // 중도 상환 수수료율
    private int d_prepayment_fee;

    // 상품 설명 
    private String d_explanation1;
    
    // 상환방식
    private String d_repay;
    
    // setters, getters


	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public Double getD_interest_rate() {
		return d_interest_rate;
	}

	public void setD_interest_rate(Double d_interest_rate) {
		this.d_interest_rate = d_interest_rate;
	}

	public Long getD_min_price() {
		return d_min_price;
	}

	public void setD_min_price(Long d_min_price) {
		this.d_min_price = d_min_price;
	}

	public Long getD_max_price() {
		return d_max_price;
	}

	public void setD_max_price(Long d_max_price) {
		this.d_max_price = d_max_price;
	}

	public int getD_min_date() {
		return d_min_date;
	}

	public void setD_min_date(int d_min_date) {
		this.d_min_date = d_min_date;
	}

	public int getD_max_date() {
		return d_max_date;
	}

	public void setD_max_date(int d_max_date) {
		this.d_max_date = d_max_date;
	}

	public int getD_prepayment_fee() {
		return d_prepayment_fee;
	}

	public void setD_prepayment_fee(int d_prepayment_fee) {
		this.d_prepayment_fee = d_prepayment_fee;
	}

	public String getD_explanation1() {
		return d_explanation1;
	}

	public void setD_explanation1(String d_explanation1) {
		this.d_explanation1 = d_explanation1;
	}

	public String getD_repay() {
		return d_repay;
	}

	public void setD_repay(String d_repay) {
		this.d_repay = d_repay;
	}

	@Override
	public String toString() {
		return "Loans_itemDTO [d_name=" + d_name + ", d_interest_rate=" + d_interest_rate + ", d_min_price="
				+ d_min_price + ", d_max_price=" + d_max_price + ", d_min_date=" + d_min_date + ", d_max_date="
				+ d_max_date + ", d_prepayment_fee=" + d_prepayment_fee + ", d_explanation1=" + d_explanation1
				+ ", d_repay=" + d_repay + "]";
	}
}
