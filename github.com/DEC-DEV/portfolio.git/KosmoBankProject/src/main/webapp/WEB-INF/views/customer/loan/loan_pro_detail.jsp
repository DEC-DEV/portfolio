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

    <title> 정기예금 설명 </title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path }/css/sb-admin-2.min.css" rel="stylesheet">

<body>

	<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
	<!-- header 끝 -->
	<!-- Page Wrapper -->
    <div id="wrapper" style="margin-top: 50px;">

	 
     <!-- Begin Page Content -->
     <div class="container-fluid align-bottom mt-5 pl-5 pr-5">
      <h1 class="h3 mb-2" style="color:#f25871; padding:100 0 0 400">코스모 전세대출</h1>
		<dl class="row" style="width:2000; padding-left:400">
		  <dt class="col-sm-3 mt-3">상품특징</dt>
		  <dd class="col-sm-9 mt-3">계약기간 및 가입금액이 자유롭고 자동재예치를 통해 자금관리가 가능한 하나원큐 전용 코스모 대출.</dd>
		
		  <dt class="col-sm-3">가입대상</dt>
		  <dd class="col-sm-9">
		    <p>실명의 개인 또는 개인사업자.</p>
		  </dd>
		
		  <dt class="col-sm-3">대출종류</dt>
		  <dd class="col-sm-9">코스모 대출.</dd>
		
		  <dt class="col-sm-3 text-truncate">가입기간</dt>
		  <dd class="col-sm-9">1개월 이상 ~ 5년 이내 일단위.</dd>
		
		  <dt class="col-sm-3">이자지급방법</dt>
		  <dd class="col-sm-9">만기일시지급식 : 만기(후) 해지시 원금과 함께 지급</dd>
	      <dt class="col-sm-3 mt-3">기본금리</dt>
	      <dd class="col-sm-8">
	      	<table class="table  mt-3">
			  <caption>기준일자 : 2022-04-17</caption>
			  <thead>
			    <tr>
			      <th scope="col">기간</th>
			      <th scope="col">First</th>
			      <th scope="col">Last</th>
			      <th scope="col">Handle</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">3개월(중도해지)</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">6개월(중도해지)</th>
			      <td>Jacob</td>
			      <td>Thornton</td>
			      <td>@fat</td>
			    </tr>
			    <tr>
			      <th scope="row">9개월(중도해지)</th>
			      <td>Larry</td>
			      <td>the Bird</td>
			      <td>@twitter</td>
			    </tr>
			  </tbody>
			</table>
		  </dd>
		  <dt class="col-sm-3">유의사항</dt>
		  <dd class="col-sm-9">이사 전 최소 10영업일 전에 대출신청을 하셔야 합니다.</dd>
		  <dt class="col-sm-3"></dt>
		  <dd class="col-sm-9">손님의 신용도에 따라 대출한도와 대출금리가 차등 적용되며, 주택보유수, 고가주택 보유여부, 규제대상 주택 취득 등</dd>
		  <dt class="col-sm-3"></dt>
		  <dd class="col-sm-9">주택도시보증공사 보증규정에 부적합하거나 은행에서 정한 부적격자에 대하여 대출 취급이 제한될 수 있습니다.</dd>
		  <dt class="col-sm-3"></dt>
		  <dd class="col-sm-9">주택도시보증공사의 보증업무 지침 위반시 기한의 이익 상실 등 손님께 불이익이 발생할 수 있으니 주의하시기 바랍니다.</dd>
		  <dt class="col-sm-3"></dt>
		  <dd class="col-sm-9">※ 자세한 사항은 상품설명서를 참조하시거나, 하나은행 고객센터(1599-2222) 또는 영업점에 문의하시기 바랍니다.</dd>
		</dl>
      </div>
     <!-- end Page Content -->
    </div>
    <!-- End of Content Wrapper -->
	
    
    
    <!-- footer 시작 -->
	<%@include file = "/WEB-INF/views/common/customer/footer.jsp" %>
	<!-- footer 끝 -->