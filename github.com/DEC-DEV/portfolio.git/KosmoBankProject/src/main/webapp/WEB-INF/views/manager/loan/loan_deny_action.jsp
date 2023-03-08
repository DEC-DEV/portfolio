<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출상품 삭제</title>
</head>
<body>
	<c:if test="${deleteCnt != 0}">
		<script type="text/javascript">
			alert("승인거절 되었습니다.");
			window.location="${path}/loan_list.ad?${_csrf.parameterName}=${_csrf.token}";
		</script>
	</c:if>
	
	<c:if test="${deleteCnt == 0}">
		<script type="text/javascript">
			alert("승인거절 실패하셨습니다.");
			window.history.go(-1);
		</script>
	</c:if>
	
	
	</body>
</html>