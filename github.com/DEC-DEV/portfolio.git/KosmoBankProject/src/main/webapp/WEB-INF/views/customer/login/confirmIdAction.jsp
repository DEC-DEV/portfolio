<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>중복확인 페이지</title>

<link rel="stylesheet" href="${path}/resources/customer/css/confirmIdAction.css">


<!-- 인증 -->
<script src="https://kit.fontawesome.com/f07d2e0c9f.js" crossorigin="anonymous"></script>

<script src="${path}/resources/customer/js/join.js" crossorigin="anonymous"></script>
</head>
<body onload="confirmIdFocus();">
<h2> 중복확인 </h2>

<form action="${path}/confirmIdAction.do?${_csrf.parameterName}=${_csrf.token}" method="post" name="confirmform"
	 onsubmit="return confirmIdChk();">
	
	<!-- id 중복일때 -->
	<c:if test="${selectCnt == 1}">
		<table>
			<tr>
				<th colspan="2">
					<span>${id}</span>는 사용할 수 없습니다.
				</th>
			</tr>
			<tr>
				<th> 아이디 : </th>
				<td>
					<input class="input" type="text" name="id" maxlength="20"
						style="width: 150px" autofocus required>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputButton" type="submit" value="확인">
					<input class="inputButton" type="reset" value="취소" onclick="self.close();">
				</th>
			</tr>
		</table>	
	</c:if>
	<!-- id 중복이 아닐때 -->
	
	<c:if test="${selectCnt != 1}">
	<table>
		<tr>
			<td align="center">
			<span>${id}</span>는 사용할 수 있습니다.
		</tr>
		<tr>
			<th>
				<input class="inputButton" type="button" value="확인" onclick="setId('${id}');"> <!-- setId(id); 자식창에서 부모창으로 id값 전달 -->
			</th>
		</tr>
	</table>
	</c:if>
	
</form>

</body>
</html>