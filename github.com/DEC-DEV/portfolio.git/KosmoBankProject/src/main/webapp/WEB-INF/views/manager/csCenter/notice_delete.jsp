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
	                    	<h6 class="m-0 font-weight-bold text-primary">공지사항 삭제</h6>
						</div>
	                  	<div class="card-body">
	                      	<div class="table-responsive">
						        <form>
							    	<div class="mb-3" >
									  <label for="formGroupExampleInput" class="form-label" style="font-size: 20px; padding-right: 0.9em;">게시글 제목</label>
									  <input type="text" class="form" id="title" size="20" style="border-radius: 5px;"> 
									</div>
									<div class="mb-3">
									  <label for="formGroupExampleInput2" class="form-label" style="font-size: 20px; padding-right: 2em;">비밀번호</label>
									  <input type="password" class="form" id="password" size="20" style="border-radius: 5px;" >
									</div>  
									<div class="mb-3">
									  <label for="formGroupExampleInput2" class="form-label" style="font-size: 20px; padding-right: 4em;">내용</label>
									  <textarea class="form" id="content" rows="5" cols="100" style="border-radius: 5px; resize:none;" ></textarea>
									</div> 
									<div class="mb-3">
									  <label for="formGroupExampleInput2" class="form-label" style="font-size: 20px; padding-right: 3em;">작성일</label>
									  <input type="date" class="form" id="date" size="20" style="border-radius: 5px;">
									</div> 
						     	</form>
					 			<div class="btn" style="position: inherit; transform: translateX(150%);">
					         		<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" style="padding-right: 1em;">글 수정</a>
					         		<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">글 삭제</a>
							    </div>
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