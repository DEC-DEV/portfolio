@ -1,112 +1,166 @@
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<!-- 김현우 -->
<head>
    <meta charset="utf-8">
    <title>상담글 수정</title>
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
	<script>
		$(function () {
			//목록으로 이동
			$("#btnList").click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
				location.href="${path}/counsel_list_search.do?${_csrf.parameterName}=${_csrf.token}"
			});
			
			// 수정 버튼 클릭
			$("#btnUpdate").click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
				
				var password = $("#password").val();
				var title = $("#title").val();
				var content = $("#content").val();
				
				if(password == "") {
					alert("패스워드 입력해라");
					$("#password").focus();
					return false;
				}
				
				if(title == "") {
					alert("제목 입력해라");
					$("#title").focus();
					return false;
				}
				
				if(content == "") {
					alert("내용 입력해라");
					$("#content").focus();
					return false;
				}
				
				
				document.form1.action="${path}/counsel_update_action.do?${_csrf.parameterName}=${_csrf.token}"
				document.form1.submit();
			});
			
			//삭제 버튼 클릭 btnDelete
			$("#btnDelete").click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
				if(confirm("삭제하시겠습니까?")) {
					document.form1.action="${path}/counsel_delete_action.do?${_csrf.parameterName}=${_csrf.token}"
					document.form1.submit();
				}
			});
		});
		
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
            <div class="container px-lg-5" style="max-width:100%">
                <div class="row justify-content-center">
                    <div class="col-lg-7" style="padding-top:80">
                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmo Bank</h6>
                            <h2 class="mt-2">상담글 수정/삭제</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form action="" name="form1">
	                            <table class="table table-hover">
								  <thead>
								    <tr>
									    <th scope="col">작성자</th>
									    <td>${dto.b_name}</td>
									    <th scope="col">작성일</th>
									    <td>${dto.b_date}</td>
								    </tr>
								    <tr>
								    	<th class="col-md-1">글제목</th>
								    	<td class="col-md-1"><input type="text" id="title" name="title" value="${dto.b_title}"></td>
								    	<th class="col-md-1">비밀번호</th>
								    	<td class="col-md-1">
								    		<input id="password" name="password" type="password" value="${dto.b_password}">
								    	</td>
								    </tr>
								  </thead>
								  <tbody>
								    <tr>
								    	<td colspan="5"><textarea id="content" name="content" cols="125" rows="10" style="border:none">${dto.b_content}</textarea></td>
								    </tr>
								    <tr>
								    	<td colspan="5" style="text-align:center">
								    		<input type="hidden" name="boardNum" id="boardNum" value="${dto.b_num}">
								    		<input type="button" class="btn btn-primary" value="수정" id="btnUpdate">
								    		<input type="button" class="btn btn-primary" value="삭제" id="btnDelete">
								    		<input type="button" class="btn btn-primary" value="목록" id="btnList">
								    	</td>
								    </tr>
								  </tbody>
								</table>
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