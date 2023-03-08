package com.spring.bank.dto;

import java.sql.Timestamp;

public class AutoTransfer_ListDTO {
	//자동 이체 번호
    private int jd_num;
    //이체일
    private Timestamp jd_date;
    //이체 성공 상태
    private String jd_success;
    //보여주기
    private String show;
	@Override
	public String toString() {
		return "AutoTransfer_ListDTO [jd_num=" + jd_num + ", jd_date=" + jd_date + ", jd_success=" + jd_success
				+ ", show=" + show + "]";
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public AutoTransfer_ListDTO(int jd_num, Timestamp jd_date, String jd_success, String show) {
		super();
		this.jd_num = jd_num;
		this.jd_date = jd_date;
		this.jd_success = jd_success;
		this.show = show;
	}
	public int getJd_num() {
		return jd_num;
	}
	public void setJd_num(int jd_num) {
		this.jd_num = jd_num;
	}
	public Timestamp getJd_date() {
		return jd_date;
	}
	public void setJd_date(Timestamp jd_date) {
		this.jd_date = jd_date;
	}
	public String getJd_success() {
		return jd_success;
	}
	public void setJd_success(String jd_success) {
		this.jd_success = jd_success;
	}
	public AutoTransfer_ListDTO() {
		super();
	}
    
}
