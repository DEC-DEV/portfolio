<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 예금상품 리스트 </title>

    <!-- Custom fonts for this template-->
     <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet"> 
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Libraries Stylesheet -->
    <link href="customerlib/animate/animate.min.css" rel="stylesheet">
    <link href="${path}/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path}/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path}/resources/customer/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="${path}/resources/customer/css/style.css" rel="stylesheet">
    <!-- select Stylesheet -->
    <link href="${path}/resources/customer/css/join.css" rel="stylesheet">
    <script src="https://unpkg.com/dayjs@1.8.21/dayjs.min.js"></script>	
<body>
	<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
	<!-- header 끝 -->
	<!-- Page Wrapper -->
    <div id="wrapper">
     <!-- Begin Page Content -->
     <div class="container-fluid align-bottom mt-5 pl-5 pr-5" style="padding-top: 4em; width:70%" >
	     <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
              <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
              <h2 class="mt-2">예금 상품 리스트</h2>
          </div>
	    <ul class="card list-group list-group-flush">
	    <c:forEach items="${list}" var="dto">
		  <li class="list-group-item" style="padding:25px;">  
		  	<h4 class="mb-1" style="color:#008485">${dto.y_name}</h4>
			<h5>${dto.y_summary}</h5>
			<br><strong> ${dto.y_interest_rate}%</strong> 
		   	<div class="float-right" style="padding-bottom: 1em">
		   		<button type="button" class="btn btn-primary bi bi-cart-dash-fill" id="btn_deposit" onclick="location.href='${path}/deposit_order_add.do?y_no=${dto.y_no}&y_name=${dto.y_name}'"></button>
		    </div>	
		 </li>    
		</c:forEach> 			
		</ul>
      </div>
      <div>
         <!-- 페이징 처리 -->
        <!-- 이전 버튼 활성화 여부 -->
        <c:if test="${paging.startPage > 10}">
           <a href="${path}/deposit_pro_list.do?pageNum=${paging.prev}" style="color: black">[이전]</a>
        </c:if> 
        <!-- 페이지번호 처리 -->
        <c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
           <a href="${path}/deposit_pro_list.do?pageNum=${num}"  style="color: black">${num}</a>
        </c:forEach>
        <!-- 다음 버튼 활성화 여부 -->
        <c:if test="${paging.endPage < paging.pageCount}">
           <a href="${path}/deposit_pro_list.do?pageNum=${paging.next}"  style="color: black">[다음]</a>
        </c:if>
    </div>
    <!-- end Page Content -->
    </div>
    <!-- End of Content Wrapper -->
    <!-- footer 시작 -->
	<%@include file = "/WEB-INF/views/common/customer/footer.jsp" %>
	<!-- footer 끝 -->