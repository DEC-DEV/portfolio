<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <style>
 #callMoney th,
 #callMoney td {
 		color: #4087f9;
 		font-weight: bold;
 	} 
 #callMoney td {
 	letter-spacing: 0.5px;
 }	
 </style>
</head>
<body>
	<hr id="hr" width="80%" style="color:#ccc7c7;"/>
	<table id="callMoney" align="center" width="50%">
	 	<tr>
			<th width="300px">잔액</th>
			<td> 
				<fmt:formatNumber value="${dto.balance}" pattern="#,###원"/>
				<input type="hidden" name="balance" id="balance" value="${dto.balance}">
			</td>
		</tr>
		<tr>
			<th width="300px">이체한도</th>
			<td>
				<fmt:formatNumber value="${dto.account_limit}" pattern="#,###원"/>
				<input type="hidden" name="account_limit" id="account_limit" value="${dto.account_limit}">
			</td>
		</tr> 
   </table>
   <hr id="hr" width="80%" />
</body>
</html>