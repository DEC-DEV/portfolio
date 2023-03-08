<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀드 수정 처리 페이지</title>
</head>
<body>

<!-- insert 실패 -->
<c:if test="${updatecnt == 0}">
   <script type="text/javascript">
      alert("펀드상품 수정실패");
   </script>
</c:if>

<c:if test="${updatecnt != 0}">
   <script type="text/javascript">
      alert("펀드상품 수정완료");
      window.location="${path}/fund_approve.ad?pageNum=${pageNum}";
   </script>
</c:if>

</body>
</html>