<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loan_principal_search</title>
</head>
<body>
	<form>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	  <div class="form-group">
	    <label for="loanOriginalAmount">대출원금(원)</label>
	    <input type="number" class="form-control" id="loanOriginalAmount" value="${d_balance}" readonly>
	  </div>
	  <div class="form-group">
	    <label for="output_payAmount">상환원금(원)</label>
	    <input type="number" class="form-control" id="output_payAmount" value="${pay_amount}" readonly>
	  </div>
	  <div class="form-group">
	    <label for="commission">중도상환수수료(원)</label>
	    <input type="number" class="form-control" id="commission" value="${d_prepayment_fee}" readonly>
	  </div>
	  <div class="form-group">
	    <label for="commission">총 납부하실 금액(상환원금+중도상환수수료)</label>
	    <input type="number" class="form-control" id="final_pay_amount" value="${final_pay_amount}" readonly>
	  </div>
	  <div class="form-group">
	    <label for="remainingLoan">거래 후 대출잔액(대출원금-상환원금)</label>
	    <input type="number" class="form-control" id="remainingLoan" value="${afterPay}" readonly>
	  </div>
	  <div class="form-group">
	    <label for="password">계좌 비밀번호</label>
	    <input type="password" class="form-control" id="password">
	  </div>
	  <div style="text-align:center; padding:20 0 20 0">
	  <button type="button" class="btn btn-primary">상환하기</button>
	  </div>
	</form>
</body>
</html>