package com.spring.bank.dto;

import java.sql.Timestamp;

// 펀드게시판
public class Fund_boardDTO {

	private int f_num;
	private String id;
	private String f_title;
	private String f_content;
	private Timestamp f_date;
	private String f_name;
	private String f_password;
	private int f_state;
	private int f_comment_count;


	// 디폴트 생성자
	public Fund_boardDTO() {
	}


	public int getF_num() {
		return f_num;
	}


	public void setF_num(int f_num) {
		this.f_num = f_num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getF_title() {
		return f_title;
	}


	public void setF_title(String f_title) {
		this.f_title = f_title;
	}


	public String getF_content() {
		return f_content;
	}


	public void setF_content(String f_content) {
		this.f_content = f_content;
	}


	public Timestamp getF_date() {
		return f_date;
	}


	public void setF_date(Timestamp f_date) {
		this.f_date = f_date;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getF_password() {
		return f_password;
	}


	public void setF_password(String f_password) {
		this.f_password = f_password;
	}


	public int getF_state() {
		return f_state;
	}


	public void setF_state(int f_state) {
		this.f_state = f_state;
	}
	public int getF_comment_count() {
		return f_comment_count;
	}


	public void setF_comment_count(int f_comment_count) {
		this.f_comment_count = f_comment_count;
	}


	@Override
	public String toString() {
		return "Fund_boardDTO [f_num=" + f_num + ", id=" + id + ", f_title=" + f_title + ", f_content=" + f_content
				+ ", f_date=" + f_date + ", f_name=" + f_name + ", f_password=" + f_password + ", f_state=" + f_state
				+ ", f_comment_count=" + f_comment_count + "]";
	}
}

