<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출상품 등록 페이지</title>
</head>
<body>

<!-- insert 실패 -->
<c:if test="${insertCnt == 0}">
   <script type="text/javascript">
      alert("등록실패");
   </script>
</c:if>

<c:if test="${insertCnt != 0}">
   <script type="text/javascript">
      alert("등록완료");
      window.location="${path}/loan_pro_list_2.ad?${_csrf.parameterName}=${_csrf.token}";
   </script>
</c:if>

</body>
</html>