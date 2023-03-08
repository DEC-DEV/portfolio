<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loan_principal_paid</title>
</head>
<body>
	<form>
	  <div class="form-group">
	    <label for="loanOriginalAmount">대출원금(원)</label>
	    <input type="number" class="form-control" id="loanOriginalAmount" value="100000000" readonly>
	  </div>
	  <div class="form-group">
	    <label for="payAmount">상환원금(원)</label>
	    <input type="number" class="form-control" id="output_payAmount" value="12342" readonly>
	  </div>
	  <div class="form-group">
	    <label for="commission">중도상환수수료(원)</label>
	    <input type="number" class="form-control" id="commission" value="0" readonly>
	  </div>
	  <div class="form-group">
	    <label for="remainingLoan">거래 후 대출잔액(원)</label>
	    <input type="number" class="form-control" id="remainingLoan" value="99987658" readonly>
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