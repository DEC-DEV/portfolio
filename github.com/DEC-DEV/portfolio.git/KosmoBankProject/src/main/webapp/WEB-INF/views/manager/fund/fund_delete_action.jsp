<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀드 승인거절</title>
</head>
<body>
	<c:if test="${deleteCnt != 0}">
		<script type="text/javascript">
			alert("거절하셨습니다.");
			window.location="${path}/fund_approve.ad";
		</script>
	</c:if>
	
	<c:if test="${deleteCnt == 0}">
		<script type="text/javascript">
			alert("거절실패하셨습니다.");
			window.history.go(-1);
		</script>
	</c:if>
	
	
	</body>
</html>