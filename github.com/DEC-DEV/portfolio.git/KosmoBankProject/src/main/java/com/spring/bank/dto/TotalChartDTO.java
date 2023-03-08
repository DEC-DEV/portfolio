package com.spring.bank.dto;

public class TotalChartDTO {
	
	/* 차트1 */
	// 예금 가입자수
	public int depositCnt;
	// 적금 가입자수
	public int savingCnt;
	// 대출 가입자수
	public int laonsCnt;
	
	/*차트 2*/
	// 월별 예금 가입자수 
	//depositCnt
	// 월별 적금 가입자수
	//depositCnt
	
	// 년월 월별
	public String yymm;
	// 예금 금액
	public int depoistBalance;
	// 적금 금액
	public int savingBalance;
	
	/* 차트 3*/
	// 대출 총합
	public int loans_sum;
	// 대출 상품 이름
	public String d_name;
	//대출 시작 시간
	public String d_start_date;
	
	/* 차트 4 */
	// 펀드 총합
	public int fund_sum;
	// 펀드 상품 이름
	public String f_name;
	// 펀드 시작 시간
	public String f_start_date;
	
	// 전체 통계
	public int total;

	// 개월
	// 1월
	public int Jan;
	// 2월
	public int Feb;
	// 3월
	public int Mar;
	// 4월
	public int Apr;
	// 5월
	public int May;
	// 6월
	public int Jun;
	// 7월
	public int Jul;
	// 8월
	public int Aug;
	// 9월
	public int Sep;
	// 10월
	public int Oct;
	// 11월
	public int Nov;
	// 12월
	public int Dec;
	
	
	
	public int getDepositCnt() {
		return depositCnt;
	}
	public void setDepositCnt(int depositCnt) {
		this.depositCnt = depositCnt;
	}
	public int getSavingCnt() {
		return savingCnt;
	}
	public void setSavingCnt(int savingCnt) {
		this.savingCnt = savingCnt;
	}
	public int getLaonsCnt() {
		return laonsCnt;
	}
	public void setLaonsCnt(int laonsCnt) {
		this.laonsCnt = laonsCnt;
	}
	public String getYymm() {
		return yymm;
	}
	public void setYymm(String yymm) {
		this.yymm = yymm;
	}
	public int getDepoistBalance() {
		return depoistBalance;
	}
	public void setDepoistBalance(int depoistBalance) {
		this.depoistBalance = depoistBalance;
	}
	public int getSavingBalance() {
		return savingBalance;
	}
	public void setSavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}
	public int getLoans_sum() {
		return loans_sum;
	}
	public void setLoans_sum(int loans_sum) {
		this.loans_sum = loans_sum;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_start_date() {
		return d_start_date;
	}
	public void setD_start_date(String d_start_date) {
		this.d_start_date = d_start_date;
	}
	public int getFund_sum() {
		return fund_sum;
	}
	public void setFund_sum(int fund_sum) {
		this.fund_sum = fund_sum;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_start_date() {
		return f_start_date;
	}
	public void setF_start_date(String f_start_date) {
		this.f_start_date = f_start_date;
	}
	public int getJan() {
		return Jan;
	}
	public void setJan(int jan) {
		Jan = jan;
	}
	public int getFeb() {
		return Feb;
	}
	public void setFeb(int feb) {
		Feb = feb;
	}
	public int getMar() {
		return Mar;
	}
	public void setMar(int mar) {
		Mar = mar;
	}
	public int getApr() {
		return Apr;
	}
	public void setApr(int apr) {
		Apr = apr;
	}
	public int getMay() {
		return May;
	}
	public void setMay(int may) {
		May = may;
	}
	public int getJun() {
		return Jun;
	}
	public void setJun(int jun) {
		Jun = jun;
	}
	public int getJul() {
		return Jul;
	}
	public void setJul(int jul) {
		Jul = jul;
	}
	public int getAug() {
		return Aug;
	}
	public void setAug(int aug) {
		Aug = aug;
	}
	public int getSep() {
		return Sep;
	}
	public void setSep(int sep) {
		Sep = sep;
	}
	public int getOct() {
		return Oct;
	}
	public void setOct(int oct) {
		Oct = oct;
	}
	public int getNov() {
		return Nov;
	}
	public void setNov(int nov) {
		Nov = nov;
	}
	public int getDec() {
		return Dec;
	}
	public void setDec(int dec) {
		Dec = dec;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "TotalChartDTO [depositCnt=" + depositCnt + ", savingCnt=" + savingCnt + ", laonsCnt=" + laonsCnt
				+ ", yymm=" + yymm + ", depoistBalance=" + depoistBalance + ", savingBalance=" + savingBalance
				+ ", loans_sum=" + loans_sum + ", d_name=" + d_name + ", d_start_date=" + d_start_date + ", fund_sum="
				+ fund_sum + ", f_name=" + f_name + ", f_start_date=" + f_start_date + ", Jan=" + Jan + ", Feb=" + Feb
				+ ", Mar=" + Mar + ", Apr=" + Apr + ", May=" + May + ", Jun=" + Jun + ", Jul=" + Jul + ", Aug=" + Aug
				+ ", Sep=" + Sep + ", Oct=" + Oct + ", Nov=" + Nov + ", Dec=" + Dec + "]";
	}
	
	
}
