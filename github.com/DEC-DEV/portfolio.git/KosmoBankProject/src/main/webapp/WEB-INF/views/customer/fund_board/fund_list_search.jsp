<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>펀드이야기 조회</title>
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
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
                            <h2 class="mt-2">펀드이야기 리스트 조회</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <table class="table table-hover">
							  <thead style="background-color:#1c1f96; color:#fff;">
							    <tr>
							      <th scope="col">글번호</th>
							      <th scope="col">글제목</th>
							      <th scope="col">작성자</th>
							      <th scope="col">작성일</th>
							    </tr>
							  </thead>
							  <tbody>
								  <!-- 게시글이 있으면 -->
								  <c:forEach var="dto" items="${list}">
								  	  <tr>
									 	  <td scope="row">${dto.f_num}</td>
									 	  <td>
										 	  <a href="${path}/fund_detail_search.do?num=${dto.f_num}&${_csrf.parameterName}=${_csrf.token}">${dto.f_title}</a>

										 	   &nbsp;
										 	   <c:if test="${dto.f_comment_count > 0}">
									 			  [ ${dto.f_comment_count} ]
									 		  </c:if> 
									 	  </td>
									 	  <td>${dto.f_name}</td>
									 	  <td>${dto.f_date}</td>
									  </tr>
								  </c:forEach>							  
							  </tbody>
							  <tfoot>
									<tr>
										<td colspan="4" align="center">
											<div class="links">
												<!-- 페이징 처리 -->
												<!-- 이전버튼 활성화 여부 -->
												<c:if test="${paging.startPage > 10}">
													<a href="${path}/fund_list_search.do?pageNum=${paging.prev}&${_csrf.parameterName}=${_csrf.token}">[이전]</a>
												</c:if>
												<!-- 페이징 번호처리 -->
												<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
													<a href="${path}/fund_list_search.do?pageNum=${num}&${_csrf.parameterName}=${_csrf.token}">${num}</a>
												</c:forEach>
												<!-- 다음버튼 활성화 여부 -->
												<c:if test="${paging.endPage < paging.pageCount}">
													<a href="${path}/fund_list_search.do?pageNum=${paging.next}&${_csrf.parameterName}=${_csrf.token}">[다음]</a>
												</c:if>
											</div>
										</td>
									</tr>
								</tfoot>
							</table>
							<div>
								<button class="btn btn-primary w-10 py-3" type="button" onclick="window.location='fund_insert.do?${_csrf.parameterName}=${_csrf.token}'">글쓰기</button>
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