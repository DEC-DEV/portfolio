package com.spring.bank.dto;



public class TransferDTO {

	private int transfer_num;		//이체번호
	private String account_num;		//계좌번호	
	private String recipient_name;	//받는계좌주
	private int money; 				//금액
	private String in_out; 			//입출금	
	private String in_out_date;		//입출금날짜
	private String out_comment;		//보낸사람 표시내용
	private String in_comment;		//받는사람 표시내용
	private String sender_name;		//예금주
	private String id; 				 //회원아이디
	
	// 거래내역 조회 - 년/원/일
	private String transfer_date;
	// 거래내역 조회 - 시/분/초
	private String transfer_time;
	// 거래내역 조회 - 잔액
	private int transfer_balance;
	// 거래내역 조회 - 총 입금 건수
	private int i_cnt;
	// 거래내역 조회 - 총 출금 건수
	private int t_cnt;

	// 디폴트 생성자
	public TransferDTO() {
	}

	
	//게터.세터
	public int getTransfer_num() {
		return transfer_num;
	}

	public void setTransfer_num(int transfer_num) {
		this.transfer_num = transfer_num;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getIn_out() {
		return in_out;
	}

	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}

	public String getIn_out_date() {
		return in_out_date;
	}

	public void setIn_out_date(String in_out_date) {
		this.in_out_date = in_out_date;
	}

	public String getOut_comment() {
		return out_comment;
	}

	public void setOut_comment(String out_comment) {
		this.out_comment = out_comment;
	}

	public String getIn_comment() {
		return in_comment;
	}

	public void setIn_comment(String in_comment) {
		this.in_comment = in_comment;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransfer_date() {
		return transfer_date;
	}


	public void setTransfer_date(String transfer_date) {
		this.transfer_date = transfer_date;
	}


	public String getTransfer_time() {
		return transfer_time;
	}


	public void setTransfer_time(String transfer_time) {
		this.transfer_time = transfer_time;
	}
	
	public int getTransfer_balance() {
		return transfer_balance;
	}
	public void setTransfer_balance(int transfer_balance) {
		this.transfer_balance = transfer_balance;
	}
	
	public int getT_cnt() {
		return t_cnt;
	}
	public int getI_cnt() {
		return i_cnt;
	}
	public void setT_cnt(int t_cnt) {
		this.t_cnt = t_cnt;
	}
	public void setI_cnt(int i_cnt) {
		this.i_cnt = i_cnt;
	}

	@Override
	public String toString() {
		return "TransferDTO [transfer_num=" + transfer_num + ", account_num=" + account_num + ", recipient_name="
				+ recipient_name + ", money=" + money + ", in_out=" + in_out + ", in_out_date=" + in_out_date
				+ ", out_comment=" + out_comment + ", in_comment=" + in_comment + ", sender_name=" + sender_name
				+ ", id=" + id + "]";
	}

	

}
