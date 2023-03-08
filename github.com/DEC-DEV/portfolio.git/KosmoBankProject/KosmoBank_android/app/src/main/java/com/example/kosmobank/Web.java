package com.example.kosmobank;

/**
 * Created by psn on 2018-01-23.
 */
public class Web {

    // ipconfig 확인 .. 연결이 끊김 으로 되어있으면 연결불가
    public static String ip = "192.168.219.101"; //본인 IP

    //public static String ip = "localhost"; //본인 IP
    // http://본인IP:8081/컨텍스트명(스프링 3번째 패키지)/   ==> 현재 포트번호가 80으로 설정했으므로 포트번호 생략
    public static String servletURL = "http://" + ip + ":8088/bank/android/"; //연결할 JSP URL



}
