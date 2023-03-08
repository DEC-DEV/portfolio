package com.spring.bank.dto;

import java.sql.Date;

public class AutoTransferDTO {
	// 자동이체 거래번호 NVL 1
	private int jd_num;
	// 입금계좌번호
	private String jd_account;
	// 이체구분
	private int jd_type;
	// 출금일자
	private Date jd_out_date;
	// 자동이체금액
	private int jd_auto_money;
	// 이체 시작일
	private Date jd_regist_date;
	// 이제 마지막
	private Date jd_end_date;
	// 이체해지일
	private Date jd_close_date;
	// 이체은행명
	private String jd_bank_name;
	// 자동이체 상태 이체, 중단
	private String jd_transfertype;
	// 마지막 이체일
	private Date jd_autotransfer_date;
	// 출금계좌번호
	private String account_num;
	public int getJd_num() {
		return jd_num;
	}
	public void setJd_num(int jd_num) {
		this.jd_num = jd_num;
	}
	public String getJd_account() {
		return jd_account;
	}
	public void setJd_account(String jd_account) {
		this.jd_account = jd_account;
	}
	public int getJd_type() {
		return jd_type;
	}
	public void setJd_type(int jd_type) {
		this.jd_type = jd_type;
	}
	public Date getJd_out_date() {
		return jd_out_date;
	}
	public void setJd_out_date(Date jd_out_date) {
		this.jd_out_date = jd_out_date;
	}
	public int getJd_auto_money() {
		return jd_auto_money;
	}
	public void setJd_auto_money(int jd_auto_money) {
		this.jd_auto_money = jd_auto_money;
	}
	public Date getJd_regist_date() {
		return jd_regist_date;
	}
	public void setJd_regist_date(Date jd_regist_date) {
		this.jd_regist_date = jd_regist_date;
	}
	public Date getJd_end_date() {
		return jd_end_date;
	}
	public void setJd_end_date(Date jd_end_date) {
		this.jd_end_date = jd_end_date;
	}
	public Date getJd_close_date() {
		return jd_close_date;
	}
	public void setJd_close_date(Date jd_close_date) {
		this.jd_close_date = jd_close_date;
	}
	public String getJd_bank_name() {
		return jd_bank_name;
	}
	public void setJd_bank_name(String jd_bank_name) {
		this.jd_bank_name = jd_bank_name;
	}
	public String getJd_transfertype() {
		return jd_transfertype;
	}
	public void setJd_transfertype(String jd_transfertype) {
		this.jd_transfertype = jd_transfertype;
	}
	public Date getJd_autotransfer_date() {
		return jd_autotransfer_date;
	}
	public void setJd_autotransfer_date(Date jd_autotransfer_date) {
		this.jd_autotransfer_date = jd_autotransfer_date;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	@Override
	public String toString() {
		return "AutoTransferDTO [jd_num=" + jd_num + ", jd_account=" + jd_account + ", jd_type=" + jd_type
				+ ", jd_out_date=" + jd_out_date + ", jd_auto_money=" + jd_auto_money + ", jd_regist_date=" 
				+ jd_regist_date + ", jd_end_date=" + jd_end_date + ", jd_close_date="
				+ jd_close_date + ", jd_bank_name=" + jd_bank_name + ", jd_transfertype=" + jd_transfertype
				+ ", jd_autotransfer_date=" + jd_autotransfer_date + ", account_num=" + account_num + "]";
	}
	public AutoTransferDTO(int jd_num, String jd_account, int jd_type, Date jd_out_date, int jd_auto_money,
			Date jd_regist_date, Date jd_end_date, Date jd_close_date, String jd_bank_name,
			String jd_transfertype, Date jd_autotransfer_date, String account_num) {
		super();
		this.jd_num = jd_num;
		this.jd_account = jd_account;
		this.jd_type = jd_type;
		this.jd_out_date = jd_out_date;
		this.jd_auto_money = jd_auto_money;
		this.jd_regist_date = jd_regist_date;
		this.jd_end_date = jd_end_date;
		this.jd_close_date = jd_close_date;
		this.jd_bank_name = jd_bank_name;
		this.jd_transfertype = jd_transfertype;
		this.jd_autotransfer_date = jd_autotransfer_date;
		this.account_num = account_num;
	}
	public AutoTransferDTO() {
		super();
	}

	
	
}
