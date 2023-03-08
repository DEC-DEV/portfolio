<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loan_paid_action</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			 swal("정상적으로 해지되었습니다.", {
		       icon: "success" 
		     })
		     .then((willDelete) => {
		       window.location="${path}/index.do";
		     });
		</script>
	</c:if>
	
	<c:if test="${result == 0}">
		<script type="text/javascript">
			 swal("뭔가 잘못됐어 개발자", {
		       icon: "error" 
		     })
		     .then((willDelete) => {
		       window.location="${path}/index.do";
		     });
		</script>
	</c:if>
	
	<c:if test="${result == 2}">
		<script type="text/javascript">
			 swal("대출 잔액이 남아있습니다.", {
		       icon: "error" 
		     })
		     .then((willDelete) => {
		       window.location="${path}/index.do";
		     });
		</script>
	</c:if>
</body>
</html>