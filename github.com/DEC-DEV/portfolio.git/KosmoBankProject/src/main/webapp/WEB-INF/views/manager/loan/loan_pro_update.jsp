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

    <title> 대출상품 수정 </title>

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

	   <!-- Begin Page Content -->
       <div class="container-fluid">
       
         <!-- Page Heading -->
         <h1 class="h3 mb-2 text-gray-800">대출상품 수정</h1>
       
				<div class="mt-5">
				<form>
					<div class="form-group row">
				   		<label for="add1" class="col-sm-2 col-form-label">대출 회사명</label>
				    	<div class="col-sm-10">
				      		<input type="email" class="form-control" id="add1">
				    	</div>
					 </div>
						
					<div class="form-group row">
				   		<label for="add2" class="col-sm-2 col-form-label">대출 상품명</label>
				    	<div class="col-sm-10">
				      		<input type="email" class="form-control" id="add2">
				    	</div>
					 </div>
						
						<div class="form-group row">
						    <label for="add3" class="col-sm-2 col-form-label">대출 만기 년수</label>
						    <div class="col-sm-10">
							    <select class="form-control" id="add3">
							      <option>1</option>
							      <option>2</option>
							      <option>3</option>
							      <option>4</option>
							      <option>5</option>
							    </select>
						    </div>
  						</div>
						<div class="form-group row">
						    <label for="add4" class="col-sm-2 col-form-label">특이사항</label>
						    <div class="col-sm-10">
						   		<textarea class="form-control" id="add4" rows="3"></textarea>
						    </div>
						</div>
						<div class="form-group row">
					   		<label for="add4" class="col-sm-2 col-form-label">대출금액</label>
					    	<div class="col-sm-10">
					      		<input type="number" class="form-control" id="add4">
					    	</div>
						</div>
					
						<div class="form-group row">
					   		<label for="add5" class="col-sm-2 col-form-label">횟수</label>
					    	<div class="col-sm-10">
					      		<input type="number" class="form-control" id="add5">
					    	</div>
						</div>
							
						<div class="form-group row">
						    <label for="add6" class="col-sm-2 col-form-label">담당자</label>
						    <div class="col-sm-10">
							    <select class="form-control" id="add6">
							      <option>김</option>
							      <option>2</option>
							      <option>3</option>
							      <option>4</option>
							      <option>5</option>
							    </select>
						    </div>
  						</div>
						<button type="submit" class="btn btn-primary float-right">수정</button>
				</form>
				</div>
			</div>
			</div>
	
	<!--컨텐츠 끝 -->

	<!-- footer 시작 -->
	<%@ include file ="/WEB-INF/views/common/footer.jsp" %>
	<!-- footer 끝 -->


</body>
</html>