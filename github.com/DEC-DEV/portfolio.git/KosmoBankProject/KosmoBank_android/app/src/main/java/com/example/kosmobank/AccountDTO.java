package com.example.kosmobank;

import android.widget.TextView;

import java.io.Serializable;
import java.security.Timestamp;

public class AccountDTO implements Serializable {

    // 계좌 번호
    private String account_num;
    // 비밀번호
    private String account_password;
    // 계좌 이름
    private String account_name;
    // 회원 이름
    private String name;
    // 회원 아이디
    private String id;
    // 계좌 타입 [ 예금, 적금, 펀드, 대출 ]
    private String account_type;
    // 잔액
    private int balance;
    // 신규 신청일
    private String new_date;
    // 휴면 변경일
    private Timestamp sleep_date;
    // 계좌 해지일
    private Timestamp  delete_date;
    // 계좌 상태 ( 휴면,해지,사용 )
    private String account_state;
    // 일일 이체 한도
    private String account_limit;
    // 기록
    private String history;


    // 디폴트 생성자
    public AccountDTO(){}

    // getter and setter

    // 은행명
    private String bank_name;

    // 계좌 조회 정보 (transfer_info join)
    private String IN_OUT_DATE;

    public String getIN_OUT_DATE() {
        return IN_OUT_DATE;
    }
    public void setIN_OUT_DATE(String iN_OUT_DATE) {
        IN_OUT_DATE = iN_OUT_DATE;
    }
    public String getNew_date() {
        return new_date;
    }
    public void setNew_date(String new_date) {
        this.new_date = new_date;
    }
    public String getBank_name() {
        return bank_name;
    }
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_num() {
        return account_num;
    }


    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }


    public String getAccount_password() {
        return account_password;
    }


    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getAccount_type() {
        return account_type;
    }


    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }


    public int getBalance() {
        return balance;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Timestamp getSleep_date() {
        return sleep_date;
    }


    public void setSleep_date(Timestamp sleep_date) {
        this.sleep_date = sleep_date;
    }


    public Timestamp getDelete_date() {
        return delete_date;
    }


    public void setDelete_date(Timestamp delete_date) {
        this.delete_date = delete_date;
    }


    public String getAccount_state() {
        return account_state;
    }


    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }
    public String getAccount_limit() {
        return account_limit;
    }
    public void setAccount_limit(String account_limit) {

        this.account_limit = account_limit;
    }

    public String getHistory() {
        return history;
    }


    public void setHistory(String history) {
        this.history = history;
    }
    // 계좌 이름
    public String getAccount_name() {
        return account_name;
    }
    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    @Override
    public String toString() {
        return "AccountDTO [account_num=" + account_num + ", account_password=" + account_password + ", name="
                + name + ", id=" + id + ", account_type=" + account_type + ", balance=" + balance + ", new_date="
                + new_date + ", sleep_date=" + sleep_date + ", delete_date=" + delete_date + ", account_state="
                + account_state + ", account_limit=" + account_limit + ", history=" + history + "]";
    }




}