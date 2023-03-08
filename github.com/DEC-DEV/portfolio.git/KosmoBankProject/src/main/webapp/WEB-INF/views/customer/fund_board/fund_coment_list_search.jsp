<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
</head>
<body>
	<!-- <table border="1" width="700px"> -->
	<table border="1">
		<c:if test="${not empty list}">
		<tr>
			<th style="width:20%"> 작성자 </th>
			<th style="width:50%"> 내용 </th>
			<th style="width:30%"> 등록일 </th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>
					${i.writer}
				</td>
				<td>
					${i.content}
				</td>
				<td>
					<fmt:formatDate value="${i.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
					
				</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>

</body>
</html>