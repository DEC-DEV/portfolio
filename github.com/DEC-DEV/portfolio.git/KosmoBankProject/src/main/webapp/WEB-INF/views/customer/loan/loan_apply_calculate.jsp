<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html lang="en">
<!-- 김현우 -->
<head>
<meta charset="UTF-8">
<title>loan_principal_search</title>
</head>
<body>
	<div style="width: 25%" class="form-check form-check-inline"> 
		<label for="OriginalAmount" style="padding-left: 25">1차
			남입원금</label> <input type="number" class="form-control"
			id="OriginalAmount" value="${origin_amount}" readonly>
	</div>
	+
	<div style="width: 25%" class="form-check form-check-inline">
		<label for="Interest" style="padding-left: 25">1차 납입이자</label>
		<input type="number" class="form-control" id="Interest"
			value="${interest_amount}" readonly>
	</div>
	=
	<div style="width: 25%" class="form-check form-check-inline">
		<label for="returnAmount" style="padding-left: 25">1차
			상환액</label> <input type="number" class="form-control"
			id="returnAmount" value="${total_amount}" readonly>
	</div>
</body>
</html>