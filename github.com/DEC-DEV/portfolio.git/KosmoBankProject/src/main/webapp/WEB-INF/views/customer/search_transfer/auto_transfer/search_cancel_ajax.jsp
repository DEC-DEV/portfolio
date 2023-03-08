<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
	#auto_delete td {
		text-align: center;
		color: #5a5555;
	}
	#auto_delete .line {
		border-bottom: 1px solid #000;
	}
</style>
</head>
<body>
	<div id="title2">자동이체 현황</div>
	<hr id="hr" width="80%" />
		<table id="auto_delete" align="center" class="table" style="width:80%;">
			<thead class="table-light">
				<tr class="line" align="center">
					<th>출금 계좌번호</th>
					<th>이체일</th>
					<th>이체금액</th>
					<th>이체기관명</th>
					<th>입금 계좌번호</th>
					<th>자동이체 해지</th>
				</tr>
			</thead>
			<c:forEach var="dto" items="${list2}"> 
			  <tr>
				<td>${dto.account_num }</td>
				<td>${dto.jd_out_date }</td>
				<td><fmt:formatNumber value="${dto.jd_auto_money}" pattern="#,###원"/> </td>
				<td>${dto.jd_bank_name }</td>
				<td>${dto.jd_account }</td>
	  			<td>
	  				<input type="button" value="해지" onclick="del_list(${dto.jd_num});" class="btn fw-bold" style="background:#ecd8d6;color:#e90101;">
	  				<%-- <input type="hidden" value="${dto.jd_num}"> --%>
	  			</td>
	  		  </tr>	
	   		</c:forEach>
		</table>
</body>
</html>