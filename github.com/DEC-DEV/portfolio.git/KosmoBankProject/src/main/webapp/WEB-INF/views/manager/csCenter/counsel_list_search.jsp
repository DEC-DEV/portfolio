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

    <title>고객센터</title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
    
</head>

<body id="page-top">

	<!-- sub_menu_admin 시작 -->
	<!-- sub_menu_admin 끝 -->
	
	<!-- Page Wrapper -->
    <div id="wrapper">
	<!-- header 시작 -->
	<%@ include file ="/WEB-INF/views/common/header.jsp" %>
	<!-- header 끝 -->
	
		<!-- Content Wrapper -->
	   	<div id="content-wrapper" class="d-flex flex-column">	
	   	
	   		<!-- Main Content -->
	    	<div id="content">							
	
			    <!-- Begin Page Content -->
		        <div class="container-fluid" style="padding-left:150; padding-right:150">
		       
			        <!-- Page Heading -->
			       	<h1 class="h3 mb-2 text-gray-800" style="padding-top: 50">고객센터</h1>
		       		
					<!-- DataTales Example -->
	              	<div class="card shadow mb-4">
	              		<div class="card-header py-3">
	                    	<h6 class="m-0 font-weight-bold text-primary">상담게시판</h6>
						</div>
	                  	<div class="card-body">
	                      	<div class="table-responsive">
	                          	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
									<thead>
									    <tr>
									      <th scope="col" style="width:10%">글번호</th>
									      <th scope="col" style="width:50%">글제목</th>
									      <th scope="col" style="width:20%">작성자</th>
									      <th scope="col" style="width:20%">작성일</th>
									    </tr>
								  	</thead>
								  	<tbody>
									  	<!-- 게시글이 있으면 -->
									  	<c:forEach var="dto" items="${list}">
									  	  	<tr>
										 	  	<td scope="row">${dto.b_num}</td>
										 	  	<td>
											 	  	<a href="${path}/counsel_detail_search.ad?num=${dto.b_num}&${_csrf.parameterName}=${_csrf.token}">${dto.b_title}</a>
											 	  	&nbsp;
										 		  	<c:if test="${dto.b_comment_count > 0}">
										 			  	[ ${dto.b_comment_count} ]
										 		  	</c:if> 
										 	  	</td>
										 	  	<td>${dto.b_name}</td>
										 	  	<td>${dto.b_date}</td>
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
														<a href="${path}/counsel_list_search.ad?pageNum=${paging.prev}&${_csrf.parameterName}=${_csrf.token}">[이전]</a>
													</c:if>
													<!-- 페이징 번호처리 -->
													<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
														<a href="${path}/counsel_list_search.ad?pageNum=${num}&${_csrf.parameterName}=${_csrf.token}">${num}</a>
													</c:forEach>
													<!-- 다음버튼 활성화 여부 -->
													<c:if test="${paging.endPage < paging.pageCount}">
														<a href="${path}/counsel_list_search.ad?pageNum=${paging.next}&${_csrf.parameterName}=${_csrf.token}">[다음]</a>
													</c:if>
												</div>
											</td>
										</tr>
									</tfoot>
								</table>
	              			</div>
	                    </div>
					</div>
				</div>
			<!-- /.container-fluid -->
			</div>
		<!--컨텐츠 끝 -->
		</div>
	</div>
	<!-- footer 시작 -->
	<%@ include file ="/WEB-INF/views/common/footer.jsp" %>
	<!-- footer 끝 -->


</body>
</html>