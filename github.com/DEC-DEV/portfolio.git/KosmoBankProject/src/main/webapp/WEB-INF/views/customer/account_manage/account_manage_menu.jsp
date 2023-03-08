<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설 </title>
</head>
<body>

        <!-- Navbar & Hero Start -->
       	 <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

        <!-- Service Start -->
        <div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                    <h6 class="position-relative d-inline text-primary ps-4"> 계좌 관리 </h6>
                    <h2 class="mt-2">  계좌 개설 </h2>
                </div>
                <div class="row g-4">
                    <div class="col-lg-4 col-md-6 wow zoomIn" data-wow-delay="0.1s">
                        <div class="service-item-menu d-flex flex-column justify-content-center text-center rounded">
                            <div class="service-icon-menu flex-shrink-0">
                                <img src="${path }/resources/img/account/default.png" style="width:100%">
                            </div>
                            <a class="btn px-3 mt-auto mx-auto" href="${path }/account_type_default.do?account_num=${account_num}">입출금</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow zoomIn" data-wow-delay="0.3s">
                        <div class="service-item-menu d-flex flex-column justify-content-center text-center rounded">
                            <div class="service-icon-menu flex-shrink-0">
                                <img style="width:100%" src="${path }/resources/img/account/deposit2.png"/>
                            </div>
                            <a class="btn px-3 mt-auto mx-auto" href="${path }/deposit_pro_list.do?account_num=${account_num}">예금</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow zoomIn" data-wow-delay="0.6s">
                        <div class="service-item-menu d-flex flex-column justify-content-center text-center rounded">
                            <div class="service-icon-menu flex-shrink-0" >
								<img style="width:100%" src="${path }/resources/img/account/saving2.png"/>
                            </div>
                            <a class="btn px-3 mt-auto mx-auto" href="${path }/savings_pro_list.do?account_num=${account_num}">적금</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow zoomIn" data-wow-delay="0.1s">
                        <div class="service-item-menu d-flex flex-column justify-content-center text-center rounded">
                            <div class="service-icon-menu flex-shrink-0">
                                <img style="width:100%" src="${path }/resources/img/account/loans.png"/>
                            </div>
                            <a class="btn px-3 mt-auto mx-auto" href="${path }/loan_pro_list.do?account_num=${account_num}">대출</a>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        </div>
     </div>
        <!-- Service End -->
</body>
</html>