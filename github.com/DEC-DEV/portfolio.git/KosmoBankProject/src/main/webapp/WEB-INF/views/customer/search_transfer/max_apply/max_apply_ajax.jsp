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
	<br>
	<table id="callMoney" align="center" width="50%">
		<tr>
			<th width="300px"> 이체한도 금액</th>
			<td> 
				최대 <fmt:formatNumber value="${limit}" pattern="#,###원"/> 가능합니다.
				<input type="hidden" id="limit2" value="${limit}">
			</td>
		</tr>
	</table>
	
</body>
</html>