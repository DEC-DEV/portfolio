<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>대출상품</title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${path }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
<script>
$(document).ready(function(){
    //체크박스 전체 선택&해제
    $('#ck_all').click(function(){
         if($("#ck_all").prop("checked")){	// #ck_all 체크하면
            $("input[type=checkbox]").prop("checked",true); // 모두 체크
        }else{
            $("input[type=checkbox]").prop("checked",false); // 체크 x
        }
    });
});

</script>

<script>
$(function() { // 페이지가 로딩되면
	$("#btnok").click(function() {
		if(confirm("승인하시겠습니까?")){
			document.form1.action="${path}/fund_approve_action.ad?${_csrf.parameterName}=${_csrf.token}";
			document.form1.submit();
		}
	});
	
	$("#btnno").click(function() {
		if(confirm("거절하시겠습니까?")) {
			document.form1.action="${path}/fund_delete_action.ad?${_csrf.parameterName}=${_csrf.token}";
			document.form1.submit();
		}
	});
});
</script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
    <div id="wrapper">	
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    
    
	 <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

		
		
			<!-- Begin Page Content -->
          <div class="container-fluid"  style="padding-left:150; padding-right:150">

              <!-- Page Heading -->
              <div style="padding-top:50">
                  <h1 class="h3 mb-2 text-gray-800">대출상품목록</h1>
              </div>
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">대출상품목록</h6>
                        </div>
              <div class="savings">
				<div class="card-body">
	               <div class="table-responsive">
	               <form name="form1" method="post">
   					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                           	   <th>대출상품명</th>
                               <th>대출 금리</th>
                               <th>대출상환방법</th>
                               <th>최소대출금액</th>
                               <th>최대대출금액</th>
                               <th>최소대출기간(년)</th>
                               <th>최대대출기간(년)</th>
                               <th>중도상환수수료율(%)</th>
                               <th>상품 설명</th>
                           </tr>
                           <c:forEach var="dto" items="${list}">
                           <tr>
                           	   <td><a href="${path}/loan_pro_detail.ad?d_name=${dto.d_name}&pageNum=${paging.pageNum}">${dto.d_name}</a></td>
                               <td>${dto.d_interest_rate}</td>
                               <td>${dto.d_repay}</td>
                               <td>${dto.d_min_price}</td>
                               <td>${dto.d_max_price}</td>
                               <td>${dto.d_min_date}</td>
                               <td>${dto.d_max_date}</td>
                               <td>${dto.d_prepayment_fee}</td>
                               <td>${dto.d_explanation1}</td>
                           </tr>
                            </c:forEach>
	                   </table>
	                   </form>
	               </div>
	           </div>
	         </div>
	       </div>
		</div>
		</div>
			<!-- Footer -->
	       <%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
	</div>
</body>
</html>