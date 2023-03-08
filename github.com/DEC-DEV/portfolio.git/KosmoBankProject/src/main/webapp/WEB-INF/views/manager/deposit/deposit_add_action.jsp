<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!-- LJH, 2022-04-19  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예금 상품등록 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- insertCnt 실패 -->
<c:if test="${insertCnt == 0}">
	<script type="text/javascript">
		alert("예금 상품 등록 실패");
		window.location="${path}/deposit_list.ad";
	</script>
</c:if>	

<c:if test="${insertCnt != 0}">
	<script type="text/javascript">
		alert("예금 상품 등록 성공");
		window.location="${path}/deposit_list.ad";
	</script>

</c:if>
<!-- insertCnt 성공 -->	
</body>
</html>