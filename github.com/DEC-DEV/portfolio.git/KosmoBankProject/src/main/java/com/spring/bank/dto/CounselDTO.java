package com.spring.bank.dto;

import java.sql.Timestamp;

public class CounselDTO {

	private int b_num;
	private String id;
	private String b_title;
	private String b_content;
	private Timestamp b_date;
	private String b_name;
	private String b_password;
	private int b_state;
	private int b_comment_count;

	// 디폴트 생성자
	public CounselDTO() {
	}


	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Timestamp getB_date() {
		return b_date;
	}

	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public int getB_state() {
		return b_state;
	}

	public void setB_state(int b_state) {
		this.b_state = b_state;
	}

	public int getB_comment_count() {
		return b_comment_count;
	}

	public void setB_comment_count(int b_comment_count) {
		this.b_comment_count = b_comment_count;
	}

	@Override
	public String toString() {
		return "CounselDTO [b_num=" + b_num + ", id=" + id + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_date=" + b_date + ", b_name=" + b_name + ", b_password=" + b_password + ", b_state=" + b_state
				+ "]";
	}




}
