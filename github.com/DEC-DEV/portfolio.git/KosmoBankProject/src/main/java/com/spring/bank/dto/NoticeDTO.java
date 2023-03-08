package com.spring.bank.dto;

import java.sql.Timestamp;

public class NoticeDTO {

	private int n_board_num;
	private String n_title;
	private String n_content;
	private String n_writer;
	private Timestamp n_date;
	private String n_views;

	// 디폴트 생성자
	public NoticeDTO() {
	}

	public int getN_board_num() {
		return n_board_num;
	}

	public void setN_board_num(int n_board_num) {
		this.n_board_num = n_board_num;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}

	public Timestamp getN_date() {
		return n_date;
	}

	public void setN_date(Timestamp n_date) {
		this.n_date = n_date;
	}

	public String getN_views() {
		return n_views;
	}

	public void setN_views(String n_views) {
		this.n_views = n_views;
	}

	@Override
	public String toString() {
		return "NoticeDTO [n_board_num=" + n_board_num + ", n_title=" + n_title + ", n_content=" + n_content
				+ ", n_writer=" + n_writer + ", n_date=" + n_date + ", n_views=" + n_views + "]";
	}

}
