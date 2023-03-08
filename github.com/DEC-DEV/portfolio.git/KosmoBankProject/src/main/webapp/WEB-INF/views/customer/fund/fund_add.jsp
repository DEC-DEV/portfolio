<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<!-- 김현우 -->
<head>
    <meta charset="utf-8">
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
	
	var sel_flie;
	
	$(document).ready(function(){
	   $("#f_filename").on("change",handleImgFileSelect);
	});
	
	function handleImgFileSelect(e){
	   var files = e.target.files;
	   var filesArr = Array.prototype.slice.call(files);
	   
	   filesArr.forEach(function(f){
	
	   sel_file = f;
	   
	   var reader = new FileReader();
	   reader.onload = function(e) {
	      $("#f_filename").attr("src",e.target.result);
	      }
	   reader.readAsDataURL(f);
	   });
	   
	}
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
                            <h2 class="mt-2">펀드등록</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form name="form1" action="${path}/fund_addaction.do?${_csrf.parameterName}=${_csrf.token}" method="post"" enctype="multipart/form-data">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            
                              <div class="form-group">
							    <label for="f_title">펀드명</label>
							     <input type="text" class="form-control" id="f_title" name="f_title">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_filename">펀드이미지</label>
							     <input type="file" class="form-control" id="f_filename" name="f_filename" accept="image/*">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_content">펀드내용</label>
							    <!-- <input type="text" class="form-control" id="f_content" name="f_content"> -->
							    <textarea rows="5" cols="20" class="form-control" id="f_content" name="f_content"></textarea>
							  </div>
							  
							  <div class="form-group">
							    <label for="f_start_date">펀딩시작일</label>
							    <input type="date" class="form-control" id="f_start_date" name="f_start_date">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_end_date">펀딩종료일</label>
							    <input type="date" class="form-control" id="f_end_date" name="f_end_date">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_category">펀드종목</label>
							    <select class="form-control" id="f_category" name="f_category" style="background-color:white">
							    	<option value="건강">건강</option>
							    	<option value="테크/가전">테크/가전</option>
							    	<option value="패션/잡화">패션/잡화</option>
							    	<option value="푸드">푸드</option>
							    	<option value="홈리빙">홈리빙</option>
							    </select>
							  </div>
							  
							  <div class="form-group">
							    <label for="f_target_money">목표금액</label>
							    <input type="text" class="form-control" id="f_target_money" name="f_target_money">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_name">등록자이름</label>
							    <input type="text" class="form-control" id="f_name" name="f_name">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_phone">등록자연락처</label>
							    <input type="text" class="form-control" id="f_phone" name="f_phone">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_email">등록자이메일</label>
							    <input type="text" class="form-control" id="f_email" name="f_email">
							  </div>
							  
							  <div class="form-group">
							    <label for="f_account">모금계좌</label>
							    <input type="number" class="form-control" id="f_account" name="f_account">
							  </div>
							  
							  <div style="text-align:center; padding:20 0 20 0">
							  <input type="submit" id="fundadd" class="btn btn-primary" value="등록">
							  <input type="hidden" name="f_num" value="${f_num}">
							 	<input type="hidden" name="펀드명" value="${title}">
							  </div>
							</form>
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