<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 처리 페이지</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- insert 실패 -->
<c:if test="${insertCnt == 0}">
	<script type="text/javascript">
		swal("상품등록 실패했습니다.!",{
			icon: "error"
		})
		
	</script>
</c:if>

<!-- insert 성공 -->
<c:if test="${insertCnt != 0}">
	<script type="text/javascript">
		swal("상품등록 성공했습니다.!",{
			icon:"success"
		})
		window.location="${path}/fund_list.do"
	</script>
</c:if>
</body>
</html>