<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${path}/resources/css/customerCss/confirmIdAction.css">
<script src="${path}/resources/js/customerJS/errorMsg.js" crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${insertCnt == 0}">
		<script type="text/javascript">
			errorAlert("이메일 인증 실패!!");
		</script>
	</c:if>
	<c:if test="${insertCnt != 0}">
		<script type="text/javascript">
			errorAlert("이메일 인증 성공!!");
			window.location="login.do";
		</script>
	</c:if>
</body>
</html>