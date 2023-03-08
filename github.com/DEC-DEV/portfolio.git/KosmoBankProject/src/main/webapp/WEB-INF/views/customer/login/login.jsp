<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank</title>
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
    
    <!-- select Stylesheet -->
    <link href="${path }/resources/customer/css/join.css" rel="stylesheet">
    <!--  아이디 없이 서비스 접근이 alert 발생 -->
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


        <!-- Navbar & Hero Start -->
        <div class="container-xxl py-5">
        	<%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
			<!-- header에 container 색이 들어가지 않도록 class name 수정 container-xxl bg-primary py-5 hero-header mb-5 에서 container-xxl py-5 hero-header mb-5 [ung] -->
	        <!-- Navbar & Hero End -->
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
	        
	       	<!-- UserLoginFailureHandler 에서 msg 넘김 -->
			<c:if test="${errorMsg != null}">
				<script type="text/javascript">
					alert("${errorMsg}");
				</script>
			</c:if>
	
			<!-- 로그인 컨텐츠 시작 -->
			<div class="container-xxl py-5">
	            <div class="container px-lg-5">
	                <div class="row justify-content-center">
	                    <div class="col-lg-7" style="padding-top:120">
	                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
	                        	<h6 class="position-relative d-inline text-primary ps-4">KosmosBank</h6>
	                            <h2 class="mt-2">환영합니다</h2>
	                        </div>
	                        <div class="wow fadeInUp" data-wow-delay="0.3s">
	                            <form name="loginform" action="${path}/login_check.do" method="post">
	                            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                                <div class="row g-3">
	                                    <div class="col-12">
	                                        <div class="form-floating">
	                                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디"  autocomplete="false">
	                                            <label for="id">ID</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-12">
	                                        <div class="form-floating">
	                                            <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호"  autocomplete="false">
	                                            <label for="password">Password</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-md-6">
	                                        <button class="btn btn-primary w-100 py-3" type="submit">로그인</button>
	                                    </div>
	                                    <div class="col-md-6">
	                                        <button class="btn btn-primary w-100 py-3" type="button" onclick="window.location='join.do?${_csrf.parameterName}=${_csrf.token}'">회원가입</button>
	                                    </div>
	                                </div>
	                            </form>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
	        <!-- Back to Top -->
	            <script type="text/javascript">
			    	if(${param.loginError eq 1 } ){
			    		swal("로그인 후 이용 부탁드립니다", {
			    			icon: "warning"
			    		});
			    	}
			    </script>
	        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
	    </div>
	</div>	    
</body>
</html>