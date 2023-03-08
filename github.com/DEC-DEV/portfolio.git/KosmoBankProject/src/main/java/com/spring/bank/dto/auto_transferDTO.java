package com.spring.bank.dto;


import java.sql.Timestamp;

public class auto_transferDTO {
	
	private int jd_num;
	
	private String jd_account;
	
	private Timestamp jd_out_date;
	
	private int jd_auto_money;
	
	private Timestamp jd_regist_date;
	
	private Timestamp jd_end_date;
	
	private Timestamp jd_close_date;
	
	private String jd_bank_name;
	
	private String jd_transfer_type;
	
	private Timestamp jd_autotransfer_date;
	
	private String account_num;
	
	private String show;
	
	
	
	public auto_transferDTO(){}



	public auto_transferDTO(int jd_num, String jd_account, Timestamp jd_out_date, int jd_auto_money,
			Timestamp jd_regist_date, Timestamp jd_end_date, Timestamp jd_close_date, String jd_bank_name,
			String jd_transfer_type, Timestamp jd_autotransfer_date, String account_num, String show) {
		super();
		this.jd_num = jd_num;
		this.jd_account = jd_account;
		this.jd_out_date = jd_out_date;
		this.jd_auto_money = jd_auto_money;
		this.jd_regist_date = jd_regist_date;
		this.jd_end_date = jd_end_date;
		this.jd_close_date = jd_close_date;
		this.jd_bank_name = jd_bank_name;
		this.jd_transfer_type = jd_transfer_type;
		this.jd_autotransfer_date = jd_autotransfer_date;
		this.account_num = account_num;
		this.show = show;
	}



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



	public Timestamp getJd_out_date() {
		return jd_out_date;
	}



	public void setJd_out_date(Timestamp jd_out_date) {
		this.jd_out_date = jd_out_date;
	}



	public int getJd_auto_money() {
		return jd_auto_money;
	}



	public void setJd_auto_money(int jd_auto_money) {
		this.jd_auto_money = jd_auto_money;
	}



	public Timestamp getJd_regist_date() {
		return jd_regist_date;
	}



	public void setJd_regist_date(Timestamp jd_regist_date) {
		this.jd_regist_date = jd_regist_date;
	}



	public Timestamp getJd_end_date() {
		return jd_end_date;
	}



	public void setJd_end_date(Timestamp jd_end_date) {
		this.jd_end_date = jd_end_date;
	}



	public Timestamp getJd_close_date() {
		return jd_close_date;
	}



	public void setJd_close_date(Timestamp jd_close_date) {
		this.jd_close_date = jd_close_date;
	}



	public String getJd_bank_name() {
		return jd_bank_name;
	}



	public void setJd_bank_name(String jd_bank_name) {
		this.jd_bank_name = jd_bank_name;
	}



	public String getJd_transfer_type() {
		return jd_transfer_type;
	}



	public void setJd_transfer_type(String jd_transfer_type) {
		this.jd_transfer_type = jd_transfer_type;
	}



	public Timestamp getJd_autotransfer_date() {
		return jd_autotransfer_date;
	}



	public void setJd_autotransfer_date(Timestamp jd_autotransfer_date) {
		this.jd_autotransfer_date = jd_autotransfer_date;
	}



	public String getAccount_num() {
		return account_num;
	}



	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}



	public String getShow() {
		return show;
	}



	public void setShow(String show) {
		this.show = show;
	}



	@Override
	public String toString() {
		return "auto_transferDTO [jd_num=" + jd_num + ", jd_account=" + jd_account + ", jd_out_date=" + jd_out_date
				+ ", jd_auto_money=" + jd_auto_money + ", jd_regist_date=" + jd_regist_date + ", jd_end_date="
				+ jd_end_date + ", jd_close_date=" + jd_close_date + ", jd_bank_name=" + jd_bank_name
				+ ", jd_transfer_type=" + jd_transfer_type + ", jd_autotransfer_date=" + jd_autotransfer_date
				+ ", account_num=" + account_num + ", show=" + show + "]";
	}
	
	
	
	
	
}
