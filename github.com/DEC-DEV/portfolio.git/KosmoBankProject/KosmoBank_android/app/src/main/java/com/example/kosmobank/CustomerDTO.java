package com.example.kosmobank;

import java.sql.Timestamp;

public class CustomerDTO {

    private String id;
    private String password;
    private String name;
    private String zipcode;
    private String address;
    private String address_detail;
    private String phone;
    private String email;
    private String grade;
    private String status;
    private Timestamp reg_date;

    // 추가 - 시큐리티
    private String key;   // 이메일인증
    private String authority;  // 권한등급 : ROLE_USER:customer, ROLE_ADMIN:관리자
    private String enabled;  // 계정사용 가능여부(1:사용가능, 0:사용불가) : 이메일인증시 1로 update


    // 디폴트 생성자
    public CustomerDTO() {
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getZipcode() {
        return zipcode;
    }


    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getAddress_detail() {
        return address_detail;
    }


    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getGrade() {
        return grade;
    }


    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Timestamp getReg_date() {
        return reg_date;
    }


    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }


    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }


    public String getAuthority() {
        return authority;
    }


    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public String getEnabled() {
        return enabled;
    }


    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", password=" + password + ", name=" + name + ", zipcode=" + zipcode
                + ", address=" + address + ", address_detail=" + address_detail + ", phone=" + phone + ", email="
                + email + ", grade=" + grade + ", status=" + status + ", reg_date=" + reg_date + ", key=" + key
                + ", authority=" + authority + ", enabled=" + enabled + "]";
    }





}