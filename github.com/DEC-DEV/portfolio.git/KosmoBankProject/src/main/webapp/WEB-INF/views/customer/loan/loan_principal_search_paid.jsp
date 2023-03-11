<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>SEO Master - SEO Agency Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

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

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
    
    <script type="text/javascript">
    	$(function() {
    		
    		// ajax로 위쪽 상환원금 입력 후 조회 클릭시 아래의 상환원금에 뿌리는 기능
    		$("#search").click(function(){
    			principal_search();
    		});
    	});
    	function principal_search() {
    		var param = {
    			"account_num" : $('#selectAccount').val(),
    			"pay_amount" : $('#input_payAmount').val()
    		};
    		$.ajax({
    			type: "post",
    			url: "${path}/loan_principal_search.do?${_csrf.parameterName}=${_csrf.token}",
    			data: param,
    			success: function(result) { // callback
    				$('#loan_principal_paid').html(result);
    			},
    			error: function(){
    				alert("상환원금 불러오기 실패!");
    			"d_account_type" : $('#selectAccount').val(),
    			"d_his_account" : $('#input_payAmount').val()
    		};
    		$.ajax({
    			type: "post",
    			url: "${path}/loan_principal_search.do",
    			data: param,
    			success: function(result) { // callback
    				$('#loan_principal_paid').html(result);
    			},
    			error: function(){
    				alert("상환원금 불러오기 실패!");
    			  success: function(result) {
    				principal_pay();
    			},
    			error: function(){
    				alert("상환원금 insert 실패!");
    			}
    		});
    	};
    
    	// 대출원금상환 form 새로고침 메서드
    	function principal_pay(){
    		$.ajax({
    			type: "post",
    			url: "${path}/loan_principal_pay.do",
    			data: $('#selectAccount').val(),
    			success: function(result) {
    				$('#loan_principal_paid').html(result);
    			},
    			error: function(){

    				alert("상환원금 insert 실패!");

    			}
    		});
    	};
   
    </script>
</head>

<body>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
		<!-- header 끝 -->


        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(29, 29, 39, 0.7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-light p-3" placeholder="Type search keyword">
                            <button class="btn btn-light px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Full Screen Search End -->


        <!-- Contact Start -->
        <div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7" style="padding-top:80">
                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
                            <h2 class="mt-2">대출원금조회</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form name="search_form">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                              <div class="form-group">
							    <label for="selectAccount">조회계좌</label>
							    <select class="form-control" id="selectAccount" name="selectAccount" style="background-color:white">
							      <option value="111-111-1111">111-111-1111</option>
							      <option value="222-222-2222">222-222-2222</option>
							      <option value="333-333-3333">333-333-3333</option>
							      <option value="444-444-4444">444-444-4444</option>
							    </select>
							  </div>
							  <div class="form-group">
							    <label for="payMethod">상환방법</label>
							    <select class="form-control" id="payMethod" name="payMethod" style="background-color:white">
							    	<option value="중도상환">중도상환</option>
							    	<option value="만기상환">만기상환</option>
							    </select>
							  </div>
							  <div class="form-group">
							    <label for="input_payAmount">상환원금(원)</label>
							    <input type="number" class="form-control" id="input_payAmount">
							  </div>
							  
							  <div class="form-group">
							    <label for="payNumber">원금실행번호</label>
							    <input type="number" class="form-control" id="payNumber" value="1" readonly>
							  </div>
							  <div style="text-align:center; padding:20 0 20 0">
							  <button type="button" id="search" name="search" class="btn btn-primary">조회</button>
							  </div>
							</form>
							
							<div id="loan_principal_paid">
								please click button "조회"
							</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->

        <!-- Footer Start -->
        <%@ include file ="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Footer End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
    

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${path }/resources/customer/lib/wow/wow.min.js"></script>
    <script src="${path }/resources/customer/lib/easing/easing.min.js"></script>
    <script src="${path }/resources/customer/lib/waypoints/waypoints.min.js"></script>
    <script src="${path }/resources/customer/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${path }/resources/customer/lib/isotope/isotope.pkgd.min.js"></script>
    <script src="${path }/resources/customer/lib/lightbox/js/lightbox.min.js"></script>

    <!-- Template Javascript -->
    <script src="${path }/resources/customer/js/main.js"></script>
</body>

</html>