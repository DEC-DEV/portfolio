package com.example.kosmobank;

import java.io.Serializable;

public class FundListDTO implements Serializable {

    private int f_num; // 펀드번호
    private String id; // 회원아이디
    private String f_title; // 펀드명
    private String f_content; // 펀드내용
    private String f_start_date; // 펀딩시작일
    private String f_end_date; // 편딩종료일
    private int f_target_money; // 목표금액
    private String f_category; // 펀드종목
    private String f_approve; // 펀드승인
    private String f_name; // 등록자 이름
    private String f_phone; // 등록자 연락처
    private String f_email; // 등록자 이메일
    private String f_account; // 모금계좌
    private String f_filename; // 첨부파일

    // 디폴트 생성자
    public FundListDTO() {}

    // 매개변수생성자
    public FundListDTO(int f_num, String id, String f_title, String f_content, String f_start_date, String f_end_date, int f_target_money, String f_category, String f_approve, String f_name, String f_phone, String f_email, String f_account, String f_filename) {
        this.f_num = f_num;
        this.id = id;
        this.f_title = f_title;
        this.f_content = f_content;
        this.f_start_date = f_start_date;
        this.f_end_date = f_end_date;
        this.f_target_money = f_target_money;
        this.f_category = f_category;
        this.f_approve = f_approve;
        this.f_name = f_name;
        this.f_phone = f_phone;
        this.f_email = f_email;
        this.f_account = f_account;
        this.f_filename = f_filename;
    }

    public FundListDTO(int f_num, String f_title, String f_start_date, String f_content) {
    }

    public FundListDTO(String f_title, String f_start_date, String f_content) {
    }

    // setter, getter


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

    public String getF_start_date() {
        return f_start_date;
    }

    public void setF_start_date(String f_start_date) {
        this.f_start_date = f_start_date;
    }

    public String getF_end_date() {
        return f_end_date;
    }

    public void setF_end_date(String f_end_date) {
        this.f_end_date = f_end_date;
    }

    public int getF_target_money() {
        return f_target_money;
    }

    public void setF_target_money(int f_target_money) {
        this.f_target_money = f_target_money;
    }

    public String getF_category() {
        return f_category;
    }

    public void setF_category(String f_category) {
        this.f_category = f_category;
    }

    public String getF_approve() {
        return f_approve;
    }

    public void setF_approve(String f_approve) {
        this.f_approve = f_approve;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_phone() {
        return f_phone;
    }

    public void setF_phone(String f_phone) {
        this.f_phone = f_phone;
    }

    public String getF_email() {
        return f_email;
    }

    public void setF_email(String f_email) {
        this.f_email = f_email;
    }

    public String getF_account() {
        return f_account;
    }

    public void setF_account(String f_account) {
        this.f_account = f_account;
    }

    public String getF_filename() {
        return f_filename;
    }

    public void setF_filename(String f_filename) {
        this.f_filename = f_filename;
    }

    @Override
    public String toString() {
        return "FundListDTO{" +
                "f_num=" + f_num +
                ", id='" + id + '\'' +
                ", f_title='" + f_title + '\'' +
                ", f_content='" + f_content + '\'' +
                ", f_start_date='" + f_start_date + '\'' +
                ", f_end_date='" + f_end_date + '\'' +
                ", f_target_money=" + f_target_money +
                ", f_category='" + f_category + '\'' +
                ", f_approve='" + f_approve + '\'' +
                ", f_name='" + f_name + '\'' +
                ", f_phone='" + f_phone + '\'' +
                ", f_email='" + f_email + '\'' +
                ", f_account='" + f_account + '\'' +
                ", f_filename='" + f_filename + '\'' +
                '}';
    }
}
