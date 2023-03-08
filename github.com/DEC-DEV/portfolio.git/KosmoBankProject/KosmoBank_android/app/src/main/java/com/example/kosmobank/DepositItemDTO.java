package com.example.kosmobank;

import java.sql.Timestamp;

public class DepositItemDTO {


    private String y_name; 	//예금 상품명

    private String y_summary; //예금 상품 요약

    private Timestamp y_date; //예금 등록일

    private Double y_interest_rate; //예금 적용 금리

    private int y_type; //예금 종류

    private int y_start_date; //예금 시작일

    private int y_end_date; //예금 해지일

    private int y_min_price; //최소 예금액

    private String y_notice; //유의 사항

    private int y_no; //예금 상품 번호

    public String getY_name() {
        return y_name;
    }

    public void setY_name(String y_name) {
        this.y_name = y_name;
    }

    public String getY_summary() {
        return y_summary;
    }

    public void setY_summary(String y_summary) {
        this.y_summary = y_summary;
    }

    public Timestamp getY_date() {
        return y_date;
    }

    public void setY_date(Timestamp y_date) {
        this.y_date = y_date;
    }

    public Double getY_interest_rate() {
        return y_interest_rate;
    }

    public void setY_interest_rate(Double y_interest_rate) {
        this.y_interest_rate = y_interest_rate;
    }

    public int getY_type() {
        return y_type;
    }

    public void setY_type(int y_type) {
        this.y_type = y_type;
    }

    public int getY_start_date() {
        return y_start_date;
    }

    public void setY_start_date(int y_start_date) {
        this.y_start_date = y_start_date;
    }

    public int getY_end_date() {
        return y_end_date;
    }

    public void setY_end_date(int y_end_date) {
        this.y_end_date = y_end_date;
    }

    public int getY_min_price() {
        return y_min_price;
    }

    public void setY_min_price(int y_min_price) {
        this.y_min_price = y_min_price;
    }

    public String getY_notice() {
        return y_notice;
    }

    public void setY_notice(String y_notice) {
        this.y_notice = y_notice;
    }

    public int getY_no() {
        return y_no;
    }

    public void setY_no(int y_no) {
        this.y_no = y_no;
    }

    public DepositItemDTO(String y_name, String y_summary, Timestamp y_date, Double y_interest_rate, int y_type, int y_start_date, int y_end_date, int y_min_price, String y_notice, int y_no) {
        this.y_name = y_name;
        this.y_summary = y_summary;
        this.y_date = y_date;
        this.y_interest_rate = y_interest_rate;
        this.y_type = y_type;
        this.y_start_date = y_start_date;
        this.y_end_date = y_end_date;
        this.y_min_price = y_min_price;
        this.y_notice = y_notice;
        this.y_no = y_no;
    }
    public DepositItemDTO() {
    }
    @Override
    public String toString() {
        return "DepositItemDTO{" +
                "y_name='" + y_name + '\'' +
                ", y_summary='" + y_summary + '\'' +
                ", y_date=" + y_date +
                ", y_interest_rate=" + y_interest_rate +
                ", y_type=" + y_type +
                ", y_start_date=" + y_start_date +
                ", y_end_date=" + y_end_date +
                ", y_min_price=" + y_min_price +
                ", y_notice='" + y_notice + '\'' +
                ", y_no=" + y_no +
                '}';
    }
}
