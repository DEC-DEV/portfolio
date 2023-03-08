<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<!-- JQUERY -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<script href=""></script>
<meta charset="UTF-8">
<title>은행여신거래기본약관</title>
</head>
<body>
<div id="example1" ></div>
<script src="${path }/resources/customer/js/pdfobject.js"></script>
<script>PDFObject.embed("${path}/resources/customer/pdf/bank_.pdf", "#example1");</script>
</body>
</html>
