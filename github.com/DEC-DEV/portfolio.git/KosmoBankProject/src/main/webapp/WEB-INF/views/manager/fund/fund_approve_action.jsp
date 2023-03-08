<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀드 승인/거절</title>
</head>
<body>
	<c:if test="${updateCnt == 1}">
		<script type="text/javascript">
			window.location="${path}/fund_approve.ad";
		</script>
	</c:if>
	
	<c:if test="${updateCnt == 0}">
		<script type="text/javascript">
			alert("주문승인에 실패하셨습니다.");
			window.history.go(-1);
		</script>
	</c:if>
</body>
</html>