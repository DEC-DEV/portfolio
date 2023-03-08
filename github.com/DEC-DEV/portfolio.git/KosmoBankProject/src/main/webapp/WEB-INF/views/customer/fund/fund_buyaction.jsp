<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> KosmoBank</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- insert 실패 -->
<c:if test="${insertCnt == 0}">
	<script type="text/javascript">
		swal("펀드후원 실패했습니다.!",{
			icon: "error"
		})
		
	</script>
</c:if>

<!-- insert 성공 -->
<c:if test="${insertCnt != 0}">
	<script type="text/javascript">
		swal("펀드후원 성공했습니다.!",{
			icon: "success"
		})
		window.location="${path}/fund_list.do?${_csrf.parameterName}=${_csrf.token}"
	</script>
</c:if>
</body>
</html>