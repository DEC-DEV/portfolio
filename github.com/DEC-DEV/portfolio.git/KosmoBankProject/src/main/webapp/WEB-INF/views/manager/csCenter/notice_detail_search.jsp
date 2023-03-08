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
	<script>
	$(function () { // 페이지가 로드되면
		//목록으로 이동
		$('#btnList').click(function () {
			location.href="${path}/notice_list_search.ad?${_csrf.parameterName}=${_csrf.token}"
		});
		
		//수정/삭제화면으로 이동
		$('#btnEdit').click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
			/* alert("btnEdit"); */
			document.notice_update.action="${path}/notice_update.ad?${_csrf.parameterName}=${_csrf.token}"
			document.notice_update.submit();
		});
	});
	</script>
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
			       	<h1 class="h3 mb-2 text-gray-800" style="padding-top: 50">고객센터 글 상세보기</h1>
		       		
					<!-- DataTales Example -->
	              	<div class="card shadow mb-4">
	              		<div class="card-header py-3">
	                    	<h6 class="m-0 font-weight-bold text-primary">고객센터 글 상세보기</h6>
						</div>
	                  	<div class="card-body">
	                      	<div class="table-responsive">
	                        	<form name="notice_update" action="${path}/notice_update.ad" method="post">
	                        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                        		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                        			<tr>
	                        				<th>게시글 제목</th>
	                        				<td>${dto.n_title}</td>
	                        			</tr>
	                        			<tr>
	                        				<th>내용</th>
	                        				<td><textarea class="form" id="content" name="content" rows="10" cols="100" style="border-radius: 5px; resize:none;" readonly="readonly">${dto.n_content}</textarea></td>
	                        			</tr>
	                        			<tr>
	                        				<th>작성자</th>
	                        				<td>${dto.n_writer}</td>	                        			
	                        			</tr>
	                        			<tr>
	                        				<th>등록일</th>
	                        				<td>${dto.n_date}</td>	                        			
	                        			</tr>
	                        			<tr align="center">
	                        				<th colspan="2">
	                        					<a href="${path}/notice_list_search.ad"><input type="button" id="btnList" class="btn btn-primary btn-icon-split btn-sm" value="목록"></a>
	                        					<input type="button" id="btnEdit" class="btn btn-primary btn-icon-split btn-sm" value="수정/삭제">
	                        					<input type="reset" class="btn btn-primary btn-icon-split btn-sm" value="취소">
	                        					<input type="hidden" name="boardNum" id="boardNum" value="${dto.n_board_num}">
	                        				</th>
	                        			</tr>
	                        		</table>
	     						</form>
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