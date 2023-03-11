<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 상품등록 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- insertCnt 실패 -->
<c:if test="${deleteCnt == 0}">
	<script type="text/javascript">
		alert("적금 상품 삭제 실패");
	</script>
</c:if>	

<c:if test="${deleteCnt != 0}">
	<script type="text/javascript">
		alert("적금 상품 삭제 성공");
		window.location="${path}/savingsList.ad";
	</script>

</c:if>
<!-- insertCnt 성공 -->	
</body>
</html>