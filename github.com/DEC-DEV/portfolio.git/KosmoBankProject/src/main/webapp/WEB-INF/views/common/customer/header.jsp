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
        		<a href="${path}/login.do" class="nav-item nav-link">로그인</a>
           		<a href="${path}/join.do" class="nav-item nav-link" style="color: white">회원가입</a>
        	</c:if>
        	<c:if test="${sessionScope.customerID != null}">
        		<a class="nav-item nav-link"><strong>${sessionScope.customerID}</strong>님 환영합니다.</a>
        		<a href="${path}/logout.do" class="nav-item nav-link">로그아웃</a>
        	</c:if>
            <div class="nav-item dropdown">
                <a href="${path}/account_add.do" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">계좌개설</a>
                <div class="dropdown-menu m-0">
                    <a href="${path}/account_add.do" class="nav-item nav-link">계좌등록</a>
                    <a href="${path}/account_cancel.do" class="nav-item nav-link">계좌해지</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">조회/이체</a>
                <div class="dropdown-menu m-0">
                    <a href="${path}/my_account.do" class="nav-item nav-link">계좌조회</a>
                    <a href="${path}/account_transfer1.do" class="nav-item nav-link">이체</a>
                    <a href="${path}/savings_add_paid1.do" class="nav-item nav-link">적금추가납입</a>
                    <a href="${path}/auto_transfer_apply.do" class="nav-item nav-link">자동이체 신청</a>
                    <a href="${path}/transfer_reservation.do" class="nav-item nav-link">자동이체 확인</a>
                      <a href="${path}/auto_search.do" class="nav-item nav-link">자동이체 조회/해지</a>
                    <a href="${path}/max_apply.do" class="nav-item nav-link">한도변경</a>

                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">대출관리</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/loan_account_search.do" class="nav-item nav-link">대출계좌조회</a>
                    <%-- 
                    <a href="${path }/" class="nav-item nav-link">대출계좌 상세조회</a>
                     --%>
                    <a href="${path }/loan_cancel_search.do" class="nav-item nav-link">대출해지 현황 조회</a>
                    <!--  
                    	<a href="${path }/notice_list_search.lo" class="nav-item nav-link">대출해지 현황 상세조회</a>
                    -->
                    <a href="${path }/loan_pro_list.do" class="nav-item nav-link">신규대출</a>
                </div>
            </div>            
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">환율</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/exchange_detail.do" class="nav-item nav-link">환율정보</a>
                    <a href="${path }/exchange_calculator.do" class="nav-item nav-link">환율계산기</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">금융상품</a>
                <div class="dropdown-menu m-0">
                     <a href="${path}/deposit_pro_list.do" class="nav-item nav-link">예금 상품</a>
                    <a href="${path}/loan_pro_list.do" class="nav-item nav-link">대출 상품</a>
                    <a href="${path}/savings_pro_list.do" class="nav-item nav-link">적금 상품</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">펀드</a>
                <div class="dropdown-menu m-0">
                    <a href="fund_list.do" class="nav-item nav-link">펀드 조회</a>
                    <a href="fund_add.do" class="nav-item nav-link">펀드 등록</a>
                	<a href="fund_list_search.do" class="nav-item nav-link">펀드 게시판</a>
                </div>
            </div>
 			<div class="nav-item dropdown">
                <a href="${path }/counsel_list_search.do" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">고객센터</a>
                <div class="dropdown-menu m-0">
                    <a href="${path }/chat.do" class="nav-item nav-link">채팅상담</a>
                    <a href="${path }/counsel_list_search.do" class="nav-item nav-link">고객상담</a>
                    <a href="${path }/notice_list_search.do" class="nav-item nav-link">공지사항</a>
                </div>
            </div>            
        </div>
    </div>
</nav>
