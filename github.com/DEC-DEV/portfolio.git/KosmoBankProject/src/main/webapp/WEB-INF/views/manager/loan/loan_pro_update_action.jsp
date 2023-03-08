<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출상세 수정 처리 페이지</title>
</head>
<body>

<!-- insert 실패 -->
<c:if test="${updateCnt == 0}">
   <script type="text/javascript">
      alert("수정실패");
   </script>
</c:if>

<c:if test="${updateCnt != 0}">
   <script type="text/javascript">
      alert("수정완료");
      window.location="${path}/loan_pro_list_2.ad?${_csrf.parameterName}=${_csrf.token}";
   </script>
</c:if>

</body>
</html>