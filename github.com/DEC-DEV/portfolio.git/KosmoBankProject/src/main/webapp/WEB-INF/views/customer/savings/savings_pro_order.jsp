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

    <title> 적금상품 상담신청 </title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">

<body>

	<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
	<!-- header 끝 -->
	
	<!-- Page Wrapper -->
    <div id="wrapper">

	 
     <!-- Begin Page Content -->
     	
     <div class="container-fluid align-bottom mt-5" style="padding-top: 5em; padding-bottom: 5em; width: 90%">
     <h3 style="color:#008485">적금상품</h3>
     <h5>적금 신청</h5>
     
	<pre class="card" style="padding: 20px 20px;">
	 고객님의 상담업무를 처리하기 위해서는 개인정보보호법 제15조 1항 및 제24조 1항에 따라 아래의 내용에 대하여 고객님의 동의가 필요합니다 .
	 1. 개인정보의 수집,이용목적
	 상담업무 처리를 위한 본인식별, 본인의사확인 및 상담결과 통보
	 2.수집하는 개인정보의 항목
	 성명, 생년월일, 전화번호
	 3. 개인정보의 보유 및 이용 기간
	 위 개인정보는 수집·이용에 관한 동의일로부터 처리 종료일까지 위 이용목적을 위하여 보유·이용됩니다.
	 단, (금융)거래 종료일 후에는 금융사고 조사, 분쟁해결, 민원처리, 볍령상 의무이행 및 당행의 리스크 관리업무만을 위하여 보유 이용됩니다.
	 4. 고객님은 개인정보 수집 및 이용을 거부할 권리가 있으며 권리행사 시 상담이 거부될 수 있습니다.</pre>
	   <form>
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck">
		      <label class="form-check-label" for="gridCheck">
		       	동의
		      </label>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary" style="position: inherit;">신청</button>
		</form>
      </div>
     <!-- end Page Content -->
    </div>
    <!-- End of Content Wrapper -->

    
    
    <!-- footer 시작 -->
	<%@include file = "/WEB-INF/views/common/customer/footer.jsp" %>
	<!-- footer 끝 -->