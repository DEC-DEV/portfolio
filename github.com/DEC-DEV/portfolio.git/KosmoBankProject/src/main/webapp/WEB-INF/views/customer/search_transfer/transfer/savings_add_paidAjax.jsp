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
			<th width="300px">총 납부액</th>
			 <td><fmt:formatNumber value="${list.get(0).i_balance}" pattern="#,###원"/>
				<input type="hidden" name="i_balance" value="${list.get(0).i_balance}">
			</td>
		</tr>
		<tr>
			<th width="300px">이체한도</th><!-- a.account_limit i_summary -->
			<td><fmt:formatNumber value="${list.get(0).i_summary }" pattern="#,###원"/>
				<input type="hidden" id="i_summary" value="${list.get(0).i_summary}">
			</td>
		</tr>
		<tr>
			<th width="300px" style="color:#333">적금 상품명</th>
			<td>
				<select name="savings" class="form-select">
				  <c:forEach var="item" items="${list}">
			       	 <option value="saving1">
			    	   ${item.i_name} 
			         </option>
			      </c:forEach>
			    </select> 
			</td>
		</tr>
   </table>
   <hr id="hr" width="80%" />
</body>
</html>