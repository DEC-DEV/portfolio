<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<title>kosmosBank</title>
<!-- Favicon -->
    <link href="${path }/resources/customer/img/favicon.ico" rel="icon">
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${path }/resources/customer/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
<nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
    <a href="${path}/index.do" class="navbar-brand p-0">
        <h1><span class="fs-customer-5">KOSMOS_BANK</span></h1>
        <!-- <img src="img/logo.png" alt="Logo"> -->
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="fa fa-bars"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse" >
        <div class="navbar-nav ms-auto py-0">
        	<c:if test="${sessionScope.customerID == null}">
        		<a href="${path}/login.do" class="nav-item nav-link">?????????</a>
           		<a href="${path}/join.do" class="nav-item nav-link" style="color: white">????????????</a>
        	</c:if>
        	<c:if test="${sessionScope.customerID != null}">
        		<a class="nav-item nav-link"><strong>${sessionScope.customerID}</strong>??? ???????????????.</a>
        		<a href="${path}/logout.do" class="nav-item nav-link">????????????</a>
        	</c:if>
            <div class="nav-item dropdown">
                <a href="${path}/account_add.do" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">????????????</a>
                <div class="dropdown-menu m-0">
                    <a href="${path}/account_add.do" class="nav-item nav-link">????????????</a>
                    <a href="${path}/account_cancel.do" class="nav-item nav-link">????????????</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">??????/??????</a>
                <div class="dropdown-menu m-0">
                    <a href="${path}/my_account.do" class="nav-item nav-link">????????????</a>
                    <a href="${path}/account_transfer1.do" class="nav-item nav-link">??????</a>
                    <a href="${path}/savings_add_paid1.do" class="nav-item nav-link">??????????????????</a>
                    <a href="${path}/auto_transfer_apply.do" class="nav-item nav-link">???????????? ??????</a>
                    <a href="${path}/transfer_reservation.do" class="nav-item nav-link">???????????? ??????</a>
                      <a href="${path}/auto_search.do" class="nav-item nav-link">???????????? ??????/??????</a>
                    <a href="${path}/max_apply.do" class="nav-item nav-link">????????????</a>

                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">????????????</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/loan_account_search.do" class="nav-item nav-link">??????????????????</a>
                    <%-- 
                    <a href="${path }/" class="nav-item nav-link">???????????? ????????????</a>
                     --%>
                    <a href="${path }/loan_cancel_search.do" class="nav-item nav-link">???????????? ?????? ??????</a>
                    <!--  
                    	<a href="${path }/notice_list_search.lo" class="nav-item nav-link">???????????? ?????? ????????????</a>
                    -->
                    <a href="${path }/loan_pro_list.do" class="nav-item nav-link">????????????</a>
                </div>
            </div>            
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">??????</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/exchange_detail.do" class="nav-item nav-link">????????????</a>
                    <a href="${path }/exchange_calculator.do" class="nav-item nav-link">???????????????</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">????????????</a>
                <div class="dropdown-menu m-0">
                     <a href="${path}/deposit_pro_list.do" class="nav-item nav-link">?????? ??????</a>
                    <a href="${path}/loan_pro_list.do" class="nav-item nav-link">?????? ??????</a>
                    <a href="${path}/savings_pro_list.do" class="nav-item nav-link">?????? ??????</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">??????</a>
                <div class="dropdown-menu m-0">
                    <a href="fund_list.do" class="nav-item nav-link">?????? ??????</a>
                    <a href="fund_add.do" class="nav-item nav-link">?????? ??????</a>
                	<a href="fund_list_search.do" class="nav-item nav-link">?????? ?????????</a>
                </div>
            </div>
 			<div class="nav-item dropdown">
                <a href="${path }/counsel_list_search.do" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">????????????</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/chat.do" class="nav-item nav-link">????????????</a>
                    <%-- <a href="${path }/counsel_list_search.do" class="nav-item nav-link">????????????</a> --%>
                    <a href="${path }/notice_list_search.do" class="nav-item nav-link">????????????</a>
                </div>
            </div>            
        </div>
    </div>
</nav>
