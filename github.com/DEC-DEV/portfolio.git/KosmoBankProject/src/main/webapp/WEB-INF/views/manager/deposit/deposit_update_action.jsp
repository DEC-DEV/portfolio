<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
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
<c:if test="${updateCnt == 0}">
	<script type="text/javascript">
		alert("예금 상품 수정 실패");
		window.location="${path}/deposit_list.ad";
	</script>
</c:if>	

<c:if test="${updateCnt != 0}">
	<script type="text/javascript">
		alert("예금 상품 수정 성공");
		window.location="${path}/deposit_list.ad";
	</script>

</c:if>
<!-- insertCnt 성공 -->	
</body>
</html>